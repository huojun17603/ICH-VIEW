package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.view.pojo.NoticeZan;

public interface NoticeZanService {

    public HttpResponse addZan(NoticeZan zan);

    public HttpResponse delZan(Long id);

    public HttpResponse delSourceZan(Integer source,String sourceid);

    public NoticeZan findOfUser(String userid,Integer source,String sourceid);

    public Integer findCount(Integer source,String sourceid);

    public Integer findCountForMark(Integer mark,Integer source,String sourceid);

}
