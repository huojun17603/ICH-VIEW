package com.ich.view.pojo;

public class NoticeZan {

//    `id` bigint(20) NOT NULL COMMENT 'ID',
    private Long id;
//    `userid` varchar(32) NOT NULL COMMENT '用户ID',
    private String userid;
    //`mark` int(11) DEFAULT NULL COMMENT '赞、踩；或者其他扩展',
    private Integer mark;
//    `source` int(11) NOT NULL COMMENT '来源：自定义类别；用于支持扩展',
    private Integer source;
//    `sourceid` varchar(32) NOT NULL COMMENT '来源对应ID',
    private String sourceid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }
}
