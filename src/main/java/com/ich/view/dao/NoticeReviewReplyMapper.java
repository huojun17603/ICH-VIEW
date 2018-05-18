package com.ich.view.dao;

import com.ich.view.pojo.NoticeReviewReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeReviewReplyMapper {

    public int insert(NoticeReviewReply reply);

    public int delete(String id);

    public int deleteByReviewId(String reviewId);

    public NoticeReviewReply selectByPrimaryKey(String id);

    public List<NoticeReviewReply> selectByReviewId(String reviewId);

}
