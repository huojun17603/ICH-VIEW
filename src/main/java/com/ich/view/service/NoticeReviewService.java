package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.pojo.NoticeReview;

import java.util.List;

public interface NoticeReviewService {

    public HttpResponse addReview(NoticeReview review);

    public HttpResponse delReview(String id);

    public HttpResponse delReviewBySource(Integer source,String sourceid);

    public List<NoticeReview> queryReviewList(PageView view,Integer source,String sourceid);
}
