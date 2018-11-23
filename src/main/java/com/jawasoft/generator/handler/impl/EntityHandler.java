package com.jawasoft.generator.handler.impl;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.model.EntityInfo;
import com.jawasoft.generator.util.StringUtil;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public class EntityHandler extends BaseHandler<EntityInfo> {

    public EntityHandler(String ftlName, EntityInfo info){
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") + File.separator
                        + Configuration.getString("entity.path") + File.separator + info.getClassName()
                        + Constants.FILE_SUFFIX_JAVA;

    }

    @Override
    public void combileParams(EntityInfo entityInfo) {
        this.param.put("packageStr", entityInfo.getEntityPackage());
        StringBuilder sb = new StringBuilder();
        for (String str : entityInfo.getImports()) {
            sb.append("import ").append(str).append(";\r\n");
        }
        this.param.put("importStr", sb.toString());
        this.param.put("entityDesc", entityInfo.getEntityDesc());
        this.param.put("className", entityInfo.getClassName());

        // 生成属性，getter,setter方法
        sb = new StringBuilder();
        StringBuilder sbMethods = new StringBuilder();

        Map<String, String> propNameColumnNames = entityInfo.getPropNameColumnNames();

        Map<String, String> propRemarks = entityInfo.getPropRemarks();
        for (Entry<String, String> entry : entityInfo.getPropTypes().entrySet()) {
            String propName = entry.getKey();
            String propType = entry.getValue();

            String Column = propNameColumnNames.get(propName).toLowerCase();

            // 注释、类型、名称
            sb.append("    /**")
                .append(propRemarks.get(propName))
                .append("*/\r\n")
                .append("    @Column(name = \"")
                .append(Column)
                .append("\")")
                .append("\r\n")
                .append("    private ")
                .append(propType)
                .append(" ")
                .append(propName)
                .append(";\r\n");

//            sbMethods.append("    public ")
//                .append(propType)
//                .append(" get")
//                .append(propName.substring(0, 1).toUpperCase())
//                .append(propName.substring(1))
//                .append("() {\r\n")
//                .append("        return ")
//                .append(propName)
//                .append(";\r\n")
//                .append("    }\r\n")
//                .append("    public void set")
//                .append(propName.substring(0, 1).toUpperCase())
//                .append(propName.substring(1))
//                .append("(")
//                .append(propType)
//                .append(" ")
//                .append(propName)
//                .append(") {\r\n")
//                .append("        this.")
//                .append(propName)
//                .append(" = ")
//                .append(propName)
//                .append(";\r\n    }\r\n")
//                .append("\r\n");
        }

        this.param.put("tableName", entityInfo.getTableName());
        this.param.put("propertiesStr", sb.toString());
        this.param.put("methodStr", "");
//        this.param.put("methodStr", sbMethods.toString());
        this.param.put("serialVersionNum", StringUtil.generate16LongNum());
    }
}
