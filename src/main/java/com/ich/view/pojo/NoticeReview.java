package com.ich.view.pojo;

import java.util.Date;

/**
 * 类似于百度贴吧的回复型结构
 * */
public class NoticeReview {

    //`id` varchar(32) NOT NULL COMMENT 'ID',
    private String id;
    //`userid` varchar(32) NOT NULL COMMENT '用户ID',
    private String userid;
    //`content` varchar(255) DEFAULT NULL COMMENT '内容，字符',
    private String content;
    //`createTime` datetime NOT NULL COMMENT '评论时间',
    private Date createtime;
    //`source` int(11) DEFAULT NULL COMMENT '来源：自定义类别；用于支持扩展',
    private Integer source;
    //`sourceid` varchar(32) DEFAULT NULL COMMENT '来源对应ID',
    private String sourceid;
    //`replynum` int(11) DEFAULT NULL COMMENT '回复数量',
    private Integer replynum;
    //`replytime` datetime DEFAULT NULL COMMENT '最新回复时间',
    private Date replytime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Integer getReplynum() {
        return replynum;
    }

    public void setReplynum(Integer replynum) {
        this.replynum = replynum;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}
