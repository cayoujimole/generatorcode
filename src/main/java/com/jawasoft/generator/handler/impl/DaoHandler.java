package com.jawasoft.generator.handler.impl;

import com.jawasoft.generator.Configuration;
import com.jawasoft.generator.Constants;
import com.jawasoft.generator.handler.BaseHandler;
import com.jawasoft.generator.model.DaoInfo;

import java.io.File;

public class DaoHandler extends BaseHandler<DaoInfo> {

    public DaoHandler(String ftlName, DaoInfo info){
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") + File.separator + Configuration.getString("dao.path")
                        + File.separator + info.getClassName() + Constants.FILE_SUFFIX_JAVA;

    }

    @Override
    public void combileParams(DaoInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("className", info.getClassName());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        this.param.put("pkName", info.getEntityInfo().getPkName());
        this.param.put("pkType", info.getEntityInfo().getPkType());
        this.param.put("lowerEntityName", info.getEntityInfo().getEntityName().substring(0, 1).toLowerCase() + info.getEntityInfo().getEntityName().substring(1));
    }

}
