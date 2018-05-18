package com.ich.view.dao;

import com.ich.view.pojo.NoticeClass;

import java.util.List;

public interface NoticeClassMapper {

    public void insert(NoticeClass noticeClass);

    public void update(NoticeClass noticeClass);

    public void deleteById(Long id);

    public NoticeClass selectByPrimaryKey(Long classid);

    public List<NoticeClass> selectClassByPid(Long id);

    public List<NoticeClass> selectClassByPidRoot();


}
