package com.ich.view.dto;

import com.ich.view.pojo.NoticeClass;

import java.util.List;

public class NoticeClassTree extends NoticeClass {

    private String state;

    private List<NoticeClassTree> children;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<NoticeClassTree> getChildren() {
        return children;
    }

    public void setChildren(List<NoticeClassTree> children) {
        this.children = children;
    }
}
