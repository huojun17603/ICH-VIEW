package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dto.NoticeClassTree;
import com.ich.view.pojo.NoticeClass;


import java.util.List;

public interface NoticeClassService {

    /**
     * 新增数据
     * @param noticeClass 数据
     * @return
     */
    public HttpResponse addClass(NoticeClass noticeClass);

    /**
     * 修改数据
     * @param noticeClass 数据
     * @return
     */
    public HttpResponse updateClass(NoticeClass noticeClass);

    /***
     * 用于调整类型的树状结构
     * @param id ID
     * @param pid 修改后的父级ID
     * @return
     */
    public HttpResponse updateClassPid(Long id,Long pid);

    /**
     * 修改基本数据
     * @param id ID
     * @param name 名称
     * @param remark 备注
     * @return
     */
    public HttpResponse updateClassInfo(Long id,String name,String remark);

    /**
     * 删除记录
     * @param id ID
     * @return
     */
    public HttpResponse deleteClass(Long id);

    /**
     * 根据父级ID，查询其下整个子集树
     * @param pid 父级ID
     * @return 整个子集树
     */
    public List<NoticeClassTree> findClassTreeByPid(Long pid);

    /**
     * 根据父级ID，查询其下子集列表
     * @param pid 父级ID
     * @return 子集列表
     */
    public List<NoticeClass> findClassByPid(Long pid);



}
