package com.ich.view.pojo;

public class ViewPostion {

    //`code` varchar(32) NOT NULL COMMENT '编号',
    private String code;
    //`classes` varchar(32) NOT NULL COMMENT '位置类别',
    private Integer classes;
    //`name` varchar(64) DEFAULT NULL COMMENT '名称',
    private String name;
    //`remark` varchar(128) DEFAULT NULL COMMENT '说明',
    private String remark;

    public ViewPostion(){}

    public ViewPostion(String code,Integer classes, String name,String remark){
        this.code = code;
        this.classes = classes;
        this.name = name;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
