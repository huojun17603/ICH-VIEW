package com.ich.view.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.IDUtils;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.dao.NoticeReviewMapper;
import com.ich.view.dao.NoticeReviewReplyMapper;
import com.ich.view.pojo.Notice;
import com.ich.view.pojo.NoticeReview;
import com.ich.view.pojo.NoticeReviewReply;
import com.ich.view.service.NoticeReviewReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeReviewReplyServiceImpl implements NoticeReviewReplyService {

    @Autowired
    private NoticeReviewReplyMapper reviewReplyMapper;
    @Autowired
    private NoticeReviewMapper reviewMapper;

    @Override
    public HttpResponse addReply(NoticeReviewReply reply) {
        if(ObjectHelper.isEmpty(reply.getReviewid())) return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
        NoticeReview review = this.reviewMapper.selectByPrimaryKey(reply.getReviewid());
        if(ObjectHelper.isEmpty(review)) return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
        reply.setId(IDUtils.createUUId());
        reply.setCreatetime(new Date());
        int result = this.reviewReplyMapper.insert(reply);
        if(result == 1){
            this.reviewMapper.updateAddReplyNum(reply.getReviewid());
            return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
        }
        return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
    }

    @Override
    public HttpResponse delReply(String id) {
        NoticeReviewReply reply = this.reviewReplyMapper.selectByPrimaryKey(id);
        if(ObjectHelper.isEmpty(reply)) return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
        this.reviewReplyMapper.delete(id);
        this.reviewMapper.updateMinusReplyNum(reply.getReviewid());
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<NoticeReviewReply> findListByReviewId(String reviewId) {
        return this.reviewReplyMapper.selectByReviewId(reviewId);
    }

    @Override
    public List<NoticeReviewReply> queryListByReviewId(PageView view, String reviewId) {
        PageHelper.startPage(view.getPage(),view.getRows());
        List<NoticeReviewReply> result = reviewReplyMapper.selectByReviewId(reviewId);
        PageInfo<NoticeReviewReply> pageInfo = new PageInfo<>(result);
        view.setRowCount(pageInfo.getTotal());
        return result;
    }
}
