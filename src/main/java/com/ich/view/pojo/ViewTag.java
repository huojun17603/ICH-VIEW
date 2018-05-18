package com.ich.view.pojo;

public class ViewTag {

    //`code` varchar(32) NOT NULL COMMENT '编号',
    private String code;
    //`name` varchar(64) DEFAULT NULL COMMENT '名称',
    private String name;
    //`remark` varchar(128) DEFAULT NULL COMMENT '说明',
    private String remark;

    public ViewTag(){}

    public ViewTag(String code,String name,String remark){
        this.code = code;
        this.name = name;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
