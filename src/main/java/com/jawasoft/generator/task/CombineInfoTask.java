package com.jawasoft.generator.task;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.model.ColumnInfo;
import com.jawasoft.generator.model.EntityInfo;
import com.jawasoft.generator.model.TableInfo;
import com.jawasoft.generator.util.PropertyUtil;
import com.jawasoft.generator.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;

public class CombineInfoTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("组装信息");

        // 获取实体相关的配置
        String packageName = Configuration.getString("entity.package");
        // 存放路径
        String path = Configuration.getString("entity.path");

        logger.info("所有实体的包名为{}， 路径为：{}", packageName, path);

        // 获取表和实体的映射集合
        Map<String, String> table2Entities = (Map<String, String>) context.getAttribute("tableName.to.entityName");
        Map<String, String> entity2Desc = (Map<String, String>) context.getAttribute("entityName.to.desc");
        Map<String, TableInfo> tableInfos = (Map<String, TableInfo>) context.getAttribute("tableInfos");

        List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
        for (Entry<String, String> entry : table2Entities.entrySet()) {
            EntityInfo entityInfo = new EntityInfo();

            // 表名
            String tableName = entry.getKey();
            // 实体名
            String entityName = entry.getValue();
            // 表信息
            TableInfo tableInfo = tableInfos.get(tableName);

            Set<String> imports = new HashSet<String>();
            Map<String, String> propTypes = new LinkedHashMap<String, String>();
            Map<String, String> propRemarks = new LinkedHashMap<String, String>();
            Map<String, String> propJdbcTypes = new LinkedHashMap<String, String>();
            Map<String, String> propName2ColumnNames = new LinkedHashMap<String, String>();

            entityInfo.setTableName(tableName);
            entityInfo.setEntityName(entityName);
            entityInfo.setEntityDesc(entity2Desc.get(entityName));
            entityInfo.setClassName(entityName);//+ Constants.ENTITY_SUFFIX
            entityInfo.setEntityPackage(packageName);
            entityInfo.setPkName(tableInfo.getPkName());
            entityInfo.setPkType(PropertyUtil.getValueByKey(tableInfo.getPkType()));

            // 遍历表字段信息
            List<ColumnInfo> columns = tableInfo.getColumnList();
            for (ColumnInfo columnInfo : columns) {
                String fieldName = columnInfo.getName();
                String fieldType = columnInfo.getType();

                // 通过字段名生成属性名
                String propName = StringUtil.convertFieldName2PropName(fieldName);

                // 这里为了兼容oracle，number类型，如果小数精度为0，则映射成Long类型
                String propType = null;
                if (Constants.DBTYPE_NUMBER.equals(fieldType) && columnInfo.getPrecision() == 0) {
                    propType = Constants.PROPTYPE_LONG;
                } else {
                    propType = PropertyUtil.getValueByKey(fieldType);
                }

                propTypes.put(propName, propType);
                propRemarks.put(propName, columnInfo.getRemark());
                propJdbcTypes.put(propName, PropertyUtil.getValueByKey(Constants.CHARACTER_BOTTOM_LINE + propType));
                propName2ColumnNames.put(propName, columnInfo.getName().toUpperCase());
            }
            logger.info("属性类型：{}", propTypes);
            logger.info("属性jdbcTypes：{}", propJdbcTypes);

            // 获取此实体所有的类型
            Collection<String> types = propTypes.values();

            for (String type : types) {
                if (!StringUtil.isEmpty(PropertyUtil.getValueByKey(type))) {
                    imports.add(PropertyUtil.getValueByKey(type));
                }
            }
            logger.info("imports:{}", imports);
            entityInfo.setPropTypes(propTypes);
            entityInfo.setPropRemarks(propRemarks);
            entityInfo.setPropJdbcTypes(propJdbcTypes);
            entityInfo.setPropNameColumnNames(propName2ColumnNames);
            entityInfo.setImports(imports);
            entityInfo.setPackageClassName( entityInfo.getEntityPackage() + Constants.CHARACTER_POINT + entityInfo.getClassName());
            entityInfos.add(entityInfo);
        }

        context.setAttribute("entityInfos", entityInfos);
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        map1.put("list", list);

        List<Long> list2 = (List<Long>) map1.get("list");
        list2.add(2L);

        System.out.println("list:" + list);
        System.out.println("list:" + map1.get("list"));
    }

}
