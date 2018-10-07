package com.jawasoft.generator.task;

import com.jawasoft.generator.Constants;
import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.DaoHandler;
import com.jawasoft.generator.model.DaoInfo;
import com.jawasoft.generator.model.MapperInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DaoTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String DAO_FTL = "template/Dao.ftl";

    private List<DaoInfo> daoInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成dao");

        daoInfos = (List<DaoInfo>) context.getAttribute("daoList");

        BaseHandler<DaoInfo> handler = null;
        for (DaoInfo daoInfo : daoInfos) {
            handler = new DaoHandler(DAO_FTL, daoInfo);
            handler.execute(context);
        }

        logger.info("生成dao完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        List<MapperInfo> mapperInfos = new ArrayList<MapperInfo>();
        MapperInfo mapperInfo = null;
        for (DaoInfo daoInfo : daoInfos) {
            mapperInfo = new MapperInfo();
            mapperInfo.setDaoInfo(daoInfo);
            mapperInfo.setEntityInfo(daoInfo.getEntityInfo());
            mapperInfo.setFileName(daoInfo.getEntityInfo().getEntityName() + Constants.MAPPER_XML_SUFFIX);
            mapperInfo.setNamespace(daoInfo.getPackageStr() + Constants.CHARACTER_POINT + daoInfo.getClassName());
            mapperInfo.setPkName(daoInfo.getPkName());
            mapperInfo.setPkType(daoInfo.getPkType());
            mapperInfos.add(mapperInfo);
        }
        context.setAttribute("mapperInfos", mapperInfos);
    }

}
