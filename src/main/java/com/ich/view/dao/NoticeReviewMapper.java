package com.ich.view.dao;

import com.ich.view.pojo.NoticeReview;
import com.ich.view.pojo.ViewPostion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeReviewMapper {

    public int insert(NoticeReview review);

    public int delete(String id);

    public int updateAddReplyNum(String id);
    
    public void updateMinusReplyNum(String id);

    public NoticeReview selectByPrimaryKey(String id);

    public List<NoticeReview> selectBySource(@Param("source") Integer source, @Param("sourceid")String sourceid);


}
