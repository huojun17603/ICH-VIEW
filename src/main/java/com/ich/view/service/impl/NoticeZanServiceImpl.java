package com.ich.view.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dao.NoticeZanMapper;
import com.ich.view.pojo.NoticeZan;
import com.ich.view.service.NoticeZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeZanServiceImpl implements NoticeZanService {

    @Autowired
    private NoticeZanMapper zanMapper;

    @Override
    public HttpResponse addZan(NoticeZan zan) {
        NoticeZan entity = this.zanMapper.selectOfUser(zan.getUserid(),zan.getSource(),zan.getSourceid());
        //同一用户针对同一内容，只允许有一个状态的存在
        if(ObjectHelper.isEmpty(entity)){
            this.zanMapper.insert(zan);
        }else{
            entity.setMark(zan.getMark());
            this.zanMapper.update(entity);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse delZan(Long id) {
        int result = this.zanMapper.delete(id);
        return result==1?(new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK)):(new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR));

    }

    @Override
    public HttpResponse delSourceZan(Integer source, String sourceid) {
        this.zanMapper.deleteSourceZan(source,sourceid);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public NoticeZan findOfUser(String userid, Integer source, String sourceid) {
        return this.zanMapper.selectOfUser(userid,source,sourceid);
    }

    @Override
    public Integer findCount(Integer source, String sourceid) {
        return this.zanMapper.selectCount(source,sourceid);
    }

    @Override
    public Integer findCountForMark(Integer mark, Integer source, String sourceid) {
        return this.zanMapper.selectCountForMark(mark,source,sourceid);
    }

}
