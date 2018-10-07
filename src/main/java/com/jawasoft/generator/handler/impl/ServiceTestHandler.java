package com.jawasoft.generator.handler.impl;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.model.ServiceImplInfo;
import com.jawasoft.generator.model.ServiceTestInfo;

import java.io.File;

public class ServiceTestHandler extends BaseHandler<ServiceTestInfo> {

    public ServiceTestHandler(String ftlName, ServiceTestInfo info){
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") + File.separator
                        + Configuration.getString("serviceTest.path") + File.separator + info.getClassName()
                        + Constants.FILE_SUFFIX_JAVA;
    }

    @Override
    public void combileParams(ServiceTestInfo serviceTestInfo) {
        ServiceImplInfo info = serviceTestInfo.getServiceImplInfo();
        this.param.put("packageStr", serviceTestInfo.getPackageStr());
        this.param.put("serviceType", info.getServiceType());
        this.param.put("getCommandType", info.getGetCommandType());
        this.param.put("listCommandType", info.getListCommandType());
        this.param.put("batchCommandType", info.getBatchCommandType());
        this.param.put("commandType", info.getCommandType());
        this.param.put("queryCommand", info.getQueryCommand());
        this.param.put("voType", info.getVoType());
        this.param.put("entityDesc", info.getEntityDesc());
        this.param.put("lowerEntityName", info.getLowerEntityName());
        this.param.put("entityName", info.getEntityName());
    }

}
