package com.jawasoft.generator.model;

import javax.activation.CommandInfo;

public class ServiceInfo {

    private String packageStr;

    private String getCommandType;

    private String listCommandType;

    private String batchCommandType;

    private String commandType;

    private String queryCommandType;

    private String voType;

    private String entityDesc;

    private String className;

    private String entityName;

    private String voClassName;

    private CommandInfo commandInfo;

    private String entityType;

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

    public String getGetCommandType() {
        return getCommandType;
    }

    public void setGetCommandType(String getCommandType) {
        this.getCommandType = getCommandType;
    }

    public String getListCommandType() {
        return listCommandType;
    }

    public void setListCommandType(String listCommandType) {
        this.listCommandType = listCommandType;
    }

    public String getBatchCommandType() {
        return batchCommandType;
    }

    public void setBatchCommandType(String batchCommandType) {
        this.batchCommandType = batchCommandType;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getQueryCommandType() {
        return queryCommandType;
    }

    public void setQueryCommandType(String queryCommandType) {
        this.queryCommandType = queryCommandType;
    }

    public String getVoType() {
        return voType;
    }

    public void setVoType(String voType) {
        this.voType = voType;
    }

    public String getEntityDesc() {
        return entityDesc;
    }

    public void setEntityDesc(String entityDesc) {
        this.entityDesc = entityDesc;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getVoClassName() {
        return voClassName;
    }

    public void setVoClassName(String voClassName) {
        this.voClassName = voClassName;
    }

    public CommandInfo getCommandInfo() {
        return commandInfo;
    }

    public void setCommandInfo(CommandInfo commandInfo) {
        this.commandInfo = commandInfo;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
