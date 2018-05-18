package com.ich.view.pojo;

import java.util.Date;

/**
 * 通知
 * 在一定时间段内，用于即时通知用户系统当前信息；一般与公告类文章一并创建，其他通知公告信息的作用
 */
public class Inform {

    //`id` bigint(20) NOT NULL COMMENT 'ID',
    private Long id;
    //`info` varchar(255) DEFAULT NULL COMMENT '内容',
    private String info;
    //`source` int(11) DEFAULT NULL COMMENT '来源：自定义类别；用于支持扩展',
    private Integer source;
    //`sourceid` varchar(32) DEFAULT NULL COMMENT '来源对应ID',
    private String sourceid;
    //`createtime` datetime DEFAULT NULL COMMENT '创建时间',
    private Date createtime;
    //`endtime` datetime DEFAULT NULL COMMENT '结束时间',
    private Date endtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
