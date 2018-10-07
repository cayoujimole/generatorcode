package com.jawasoft.generator.task;

import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.ServiceImplHandler;
import com.jawasoft.generator.model.ServiceImplInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ServiceImplTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String SERVICEIMPL_FTL = "template/ServiceImpl.ftl";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成serviceImpl...");
        List<ServiceImplInfo> list = (List<ServiceImplInfo>) context.getAttribute("serviceImplInfos");

        BaseHandler<ServiceImplInfo> baseHandler = null;
        for (ServiceImplInfo info : list) {
            baseHandler = new ServiceImplHandler(SERVICEIMPL_FTL, info);
            baseHandler.execute(context);
        }

        logger.info("结束生成serviceImpl。。。");
        return false;
    }

}
