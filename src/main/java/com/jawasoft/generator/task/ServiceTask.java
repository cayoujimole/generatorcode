package com.jawasoft.generator.task;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.ServiceHandler;
import com.jawasoft.generator.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ServiceTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String SERVICE_FTL = "template/Service.ftl";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成service。。。");

        List<ServiceInfo> serviceInfos = (List<ServiceInfo>) context.getAttribute("serviceInfos");

        BaseHandler<ServiceInfo> baseHandler = null;
        for (ServiceInfo serviceInfo : serviceInfos) {
            baseHandler = new ServiceHandler(SERVICE_FTL, serviceInfo);
            baseHandler.execute(context);
        }

        logger.info("结束生成service。。。");
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        List<ServiceInfo> serviceInfos = (List<ServiceInfo>) context.getAttribute("serviceInfos");
        List<EntityInfo> entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");
        List<DaoInfo> daoInfos = (List<DaoInfo>) context.getAttribute("daoList");

        List<ServiceImplInfo> serviceImplInfos = new ArrayList<ServiceImplInfo>();
        List<ServiceTestInfo> serviceTestInfos = new ArrayList<ServiceTestInfo>();
        ServiceImplInfo serviceImplInfo = null;
        ServiceTestInfo serviceTestInfo = null;
        for (int i = 0; i < serviceInfos.size(); i++) {
            ServiceInfo serviceInfo = serviceInfos.get(i);
            EntityInfo entityInfo = entityInfos.get(i);
            DaoInfo daoInfo = daoInfos.get(i);
            serviceImplInfo = new ServiceImplInfo();
            serviceTestInfo = new ServiceTestInfo();

            serviceImplInfo.setClassName(entityInfo.getEntityName() + Constants.SERVICE_IMPL_SUFFIX);
            serviceImplInfo.setEntityType(entityInfo.getPackageClassName());
            serviceImplInfo.setEntityDesc(entityInfo.getEntityDesc());
            serviceImplInfo.setEntityName(entityInfo.getEntityName());
            serviceImplInfo.setLowerEntityName(entityInfo.getEntityName().substring(0, 1).toLowerCase() + entityInfo.getEntityName().substring(1));
            serviceImplInfo.setDaoType(daoInfo.getPackageStr() + Constants.CHARACTER_POINT + daoInfo.getClassName());
            serviceImplInfo.setPackageStr(Configuration.getString("serviceImpl.package"));
            serviceImplInfo.setServiceType(serviceInfo.getPackageStr() + Constants.CHARACTER_POINT + serviceInfo.getClassName());
            serviceImplInfo.setPkName(serviceInfo.getPkName());
            serviceImplInfo.setPkType(serviceInfo.getPkType());
            serviceTestInfo.setClassName(entityInfo.getEntityName() + Constants.SERVICE_TEST_SUFFIX);
            serviceTestInfo.setPackageStr(Configuration.getString("serviceTest.package"));
            serviceTestInfo.setServiceImplInfo(serviceImplInfo);
            serviceImplInfos.add(serviceImplInfo);
            serviceTestInfos.add(serviceTestInfo);
        }
        context.setAttribute("serviceImplInfos", serviceImplInfos);
        context.setAttribute("serviceTestInfos", serviceTestInfos);
    }

}
