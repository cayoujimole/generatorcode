package com.jawasoft.generator.task;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.EntityHandler;
import com.jawasoft.generator.model.DaoInfo;
import com.jawasoft.generator.model.EntityInfo;
import com.jawasoft.generator.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EntityTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String    ENTITY_FTL = "template/Entity.ftl";

    private List<EntityInfo> entityInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成实体");

        // 获取实体信息
        entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");

        BaseHandler<EntityInfo> handler = null;
        for (EntityInfo entityInfo : entityInfos) {
            handler = new EntityHandler(ENTITY_FTL, entityInfo);
            handler.execute(context);
        }
        logger.info("生成实体类完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        List<DaoInfo> daoList = new ArrayList<DaoInfo>();
        // 组装Dao信息、组装Vo信息
        DaoInfo daoInfo = null;
        for (EntityInfo entityInfo : entityInfos) {
            daoInfo = new DaoInfo();
            daoInfo.setClassName(entityInfo.getEntityName() + Constants.DAO_SUFFIX);
            daoInfo.setEntityInfo(entityInfo);
            daoInfo.setImportStr("import " + entityInfo.getEntityPackage() + Constants.CHARACTER_POINT
                                 + entityInfo.getClassName() + Constants.CHARACTER_SPLIT);
            daoInfo.setPackageStr(Configuration.getString("dao.package"));
            daoInfo.setPkName(entityInfo.getPkName());
            daoInfo.setPkType(entityInfo.getPkType());
            daoList.add(daoInfo);
        }
        context.setAttribute("daoList", daoList);
    }

    public static void main(String[] args) {
        File file = new File(
            "/D:\\devsoftware\\workspace\\winit-java-generator\\target\\classes\\template\\Entity.ftl");
        System.out.println(EntityTask.class.getClassLoader().getResource("").getPath());
        System.out.println(file.exists());

        PropertyUtil.setProperty("name", "qyk1");
        PropertyUtil.setProperty("NAME", "qyk22");
    }

}
