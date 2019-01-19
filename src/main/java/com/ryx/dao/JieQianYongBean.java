package com.ryx.dao;

public class JieQianYongBean {
    private String id;
    private String phone;
    private String sex;
    private String devid;
    private String phoneType;
    private String regtime;
    private String lastlogintime;

    public JieQianYongBean(String id, String phone, String sex, String devid, String phoneType, String regtime, String lastlogintime) {
        this.id = id;
        this.phone = phone;
        this.sex = sex;
        this.devid = devid;
        this.phoneType = phoneType;
        this.regtime = regtime;
        this.lastlogintime = lastlogintime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
}
