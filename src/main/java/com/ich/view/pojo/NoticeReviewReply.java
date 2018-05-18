package com.ich.view.pojo;

import java.util.Date;

public class NoticeReviewReply {

    //`id` varchar(32) NOT NULL,
    private String id;
    //`reviewId` varchar(32) NOT NULL COMMENT '评论ID',
    private String reviewid;
    //`userid` varchar(32) NOT NULL COMMENT '回复人用户ID',
    private String userid;
    //`content` varchar(255) DEFAULT NULL COMMENT '内容',
    private String content;
    //`createTime` datetime NOT NULL COMMENT '回复时间',
    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewid() {
        return reviewid;
    }

    public void setReviewid(String reviewid) {
        this.reviewid = reviewid;
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
}
