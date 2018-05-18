package com.ich.view.pojo;

import java.util.Date;

/**
 * 公告，新闻，资讯，帮助，各种页面
 * 可嵌入，是否有帮助，评论功能
 */
public class Notice {
    /** 主键 */
    private Long id;
    /** 类别ID */
    private Long classid;
    /** 类别名称 */
    private String classname;
    /** 最后修改时间 */
    private Date createtime;
    /** 标题 */
    private String title;
    /** 短标题*/
    private String samlltitle;
    /** 作者 */
    private String author;
    /** 关键字【字符数组格式】：可用于搜索条件，相似推荐*/
    private String keyword;
    /**
     * 标签【字符数组格式】：用于展现顶层标签,或控制标题的加粗加亮等效果；由需求定义
     * 一般用法：写入（精品,热门），可把其标记在标题后，也可根据其字符改变标题颜色，或者做一些其他的样式上的不同
     * */
    private String tag;
    private String tagname;
    /** 位置【字符数组格式】：取于位置编号；可用于查询出特定位置上的文章信息*/
    private String postion;
    private String postionname;
    /** 链接地址 */
    private String http;
    /** 图片*/
    private String img;
    /** 简介*/
    private String info;
    /** HTML页面代码 */
    private String html;
    /** 状态 1：正常；0：不可见*/
    private Integer status;
    /** 访问次数 */
    private Integer readnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSamlltitle() {
        return samlltitle;
    }

    public void setSamlltitle(String samlltitle) {
        this.samlltitle = samlltitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getPostionname() {
        return postionname;
    }

    public void setPostionname(String postionname) {
        this.postionname = postionname;
    }
}
