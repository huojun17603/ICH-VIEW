package com.ich.view.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dao.ViewTagMapper;
import com.ich.view.pojo.ViewPostion;
import com.ich.view.pojo.ViewTag;
import com.ich.view.service.ViewTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewTagServiceImpl implements ViewTagService {

    @Autowired
    private ViewTagMapper tagMapper;

    @Override
    public HttpResponse addOrEditPostion(ViewTag tag) {
        ViewTag entity = this.tagMapper.selectByPrimaryKey(tag.getCode());
        if(ObjectHelper.isEmpty(entity)){
            this.tagMapper.insert(tag);
        }else{
            this.tagMapper.update(tag);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<ViewTag> findAll() {
        return this.tagMapper.selectAll();
    }
}
