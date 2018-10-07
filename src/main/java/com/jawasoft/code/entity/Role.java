package com.jawasoft.code.entity;

import java.util.Date;

public class Role {
    private Integer pid;

    private String name;

    private String remark;

    private Date recordtime;

    private Integer recorduser;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Integer getRecorduser() {
        return recorduser;
    }

    public void setRecorduser(Integer recorduser) {
        this.recorduser = recorduser;
    }
}