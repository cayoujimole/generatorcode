package com.jawasoft.generator.model;

public class MapperInfo {

    /**
     * XXXMapper.xml
     */
    private String fileName;

    private String namespace;

    private DaoInfo daoInfo;

    private EntityInfo entityInfo;

    /**
     * 主键名称
     */
    private String pkName;

    /**
     * 主键类型
     */
    private String pkType;

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getPkType() {
        return pkType;
    }

    public void setPkType(String pkType) {
        this.pkType = pkType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public DaoInfo getDaoInfo() {
        return daoInfo;
    }

    public void setDaoInfo(DaoInfo daoInfo) {
        this.daoInfo = daoInfo;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }
}
