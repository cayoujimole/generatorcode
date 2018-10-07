package com.jawasoft.generator.task;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.MapperHandler;
import com.jawasoft.generator.model.EntityInfo;
import com.jawasoft.generator.model.MapperInfo;
import com.jawasoft.generator.model.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MapperTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String MAPPER_FTL = Configuration.getString("base.database")
        .equals(Constants.DB_ORACLE) ? "template/Mapper_oracle.ftl" : "template/Mapper.ftl";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成Mapper");

        List<MapperInfo> list = (List<MapperInfo>) context.getAttribute("mapperInfos");

        BaseHandler<MapperInfo> handler = null;
        for (MapperInfo mapperInfo : list) {
            handler = new MapperHandler(MAPPER_FTL, mapperInfo);
            handler.execute(context);
        }

        logger.info("生成Mapper完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        // 组装Service信息
        List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();
        List<EntityInfo> entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");

        ServiceInfo service = null;
        for (EntityInfo e : entityInfos){
            service = new ServiceInfo();
            service.setClassName(e.getEntityName() + Constants.SERVICE_SUFFIX);
            service.setEntityDesc(e.getEntityDesc());
            service.setEntityName(e.getEntityName());
            service.setPackageStr(Configuration.getString("service.package"));
            service.setEntityType(e.getPackageClassName());
            service.setPkName(e.getPkName());
            service.setPkType(e.getPkType());
            serviceInfos.add(service);
        }
        context.setAttribute("serviceInfos", serviceInfos);
    }
}
