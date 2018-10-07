package com.jawasoft.generator.model;

public class DaoInfo {

    /**
     * 包路径
     */
    private String packageStr;

    /**
     * 需要导入的包
     */
    private String importStr;

    /**
     * 类名
     */
    private String className;

    /**
     * 实体信息
     */
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

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getImportStr() {
        return importStr;
    }

    public void setImportStr(String importStr) {
        this.importStr = importStr;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }
}
