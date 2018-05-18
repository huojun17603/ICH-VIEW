package com.ich.view.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.IDUtils;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.dao.NoticeReviewMapper;
import com.ich.view.dao.NoticeReviewReplyMapper;
import com.ich.view.pojo.NoticeReview;
import com.ich.view.pojo.NoticeReviewReply;
import com.ich.view.service.NoticeReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeReviewServiceImpl implements NoticeReviewService {

    @Autowired
    private NoticeReviewMapper reviewMapper;
    @Autowired
    private NoticeReviewReplyMapper reviewReplyMapper;

    @Override
    public HttpResponse addReview(NoticeReview review) {
        review.setId(IDUtils.createUUId());
        review.setCreatetime(new Date());
        review.setReplynum(0);
        review.setReplytime(null);
        int result =  this.reviewMapper.insert(review);
        return result==1?(new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK)):(new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR));

    }

    @Override
    public HttpResponse delReview(String id) {
        int result = this.reviewMapper.delete(id);
        if(result == 1){
            reviewReplyMapper.deleteByReviewId(id);
            return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
        }
        return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
    }

    @Override
    public HttpResponse delReviewBySource(Integer source, String sourceid) {
        List<NoticeReview> result = reviewMapper.selectBySource(source,sourceid);
        for(NoticeReview review : result){
            delReview(review.getId());
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<NoticeReview> queryReviewList(PageView view, Integer source, String sourceid) {
        PageHelper.startPage(view.getPage(),view.getRows());
        List<NoticeReview> result = reviewMapper.selectBySource(source,sourceid);
        PageInfo<NoticeReview> pageInfo = new PageInfo<>(result);
        view.setRowCount(pageInfo.getTotal());
        return result;
    }

}
