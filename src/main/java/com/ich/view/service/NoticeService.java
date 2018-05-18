package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.pojo.Notice;

import java.util.List;

public interface NoticeService {

    public HttpResponse addOrEditNotice(Notice notice);

    /**
     * 修改文章状态
     * @param id
     * @param status
     * @return
     */
    public HttpResponse editNoticeStatus(Long id,Integer status);

    /**
     * 删除文章
     * @param id
     * @return
     */
    public HttpResponse deleteNotice(Long id);
    /**
     * 批量修改对应类别文章的类别
     * @param oid 旧类别ID
     * @param nid 新类别ID
     * @return
     */
    public HttpResponse editBatchClassid(Long oid,Long nid);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Notice findById(Long id);

    /**
     * 用户查看文章，访问次数加一
     * @param id 文章ID
     * @return 文章内容
     */
    public Notice findOfUser(Long id);

    /**
     * 根据类别查询文章列表
     * @param classid 类别ID
     * @return 列表
     */
    public List<Notice> findByClassid(Long classid);

    /**
     * 按显示的位置查询文章列表[有效状态，时间倒序]
     * @param view 分页数据，包含总记录数的返回
     * @param postion 位置数据
     * @return 文章列表
     */
    public List<Notice> queryByPostion(PageView view, String postion);

    /**
     * 按以下条件查询文章列表[有效状态，时间倒序]
     * [类别，关键字，位置，作者，模糊搜索]
     * @param view 分页数据，包含总记录数的返回
     * @return 文章列表
     */
    public List<Notice> queryByCondition(PageView view, Long classid, String keyword,String postion,String author,String searchkey);

    /**
     * 按以下条件查询文章列表[全部状态，时间倒序]
     * [类别，关键字，位置，作者，模糊搜索]
     * @param view 分页数据，包含总记录数的返回
     * @return 文章列表
     */
    public List<Notice> queryByAdminCondition(PageView view, Long classid, String keyword,String postion,String author,String searchkey);

}
