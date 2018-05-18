package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.pojo.NoticeReviewReply;

import java.util.List;

public interface NoticeReviewReplyService {

    /**
     * 添加回复
     * @param reply 回复数据
     * @return 是否成功
     */
    public HttpResponse addReply(NoticeReviewReply reply);

    /**
     * 删除回复，主要用于删除无用的回复数据
     * @param id ID
     * @return 是否成功
     */
    public HttpResponse delReply(String id);

    /**
     * 查询评论下的回复内容[按时间排序]
     * @param reviewId 评论ID
     * @return 列表
     */
    public List<NoticeReviewReply> findListByReviewId(String reviewId);

    /**
     * 分页查询评论下的回复内容[按时间排序]
     * @param view 分页数据
     * @param reviewId 评论ID
     * @return 列表
     */
    public List<NoticeReviewReply> queryListByReviewId(PageView view,String reviewId);

}
