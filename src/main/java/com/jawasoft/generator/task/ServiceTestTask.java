package com.jawasoft.generator.task;

import com.jawasoft.generator.application.AbstractApplicationTask;
import com.jawasoft.generator.application.context.ApplicationContext;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.handler.impl.ServiceTestHandler;
import com.jawasoft.generator.model.ServiceTestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ServiceTestTask extends AbstractApplicationTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String SERVICETEST_FTL = "template/ServiceTest.ftl";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成service单元测试类。。。");

        List<ServiceTestInfo> list = (List<ServiceTestInfo>) context.getAttribute("serviceTestInfos");

        BaseHandler<ServiceTestInfo> baseHandler = null;
        for (ServiceTestInfo serviceTestInfo : list) {
            baseHandler = new ServiceTestHandler(SERVICETEST_FTL, serviceTestInfo);
            baseHandler.execute(context);
        }

        logger.info("生成service单元测试类完成。。。");
        return false;
    }

}
