package com.ich.view.service.impl;


import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dao.ViewPostionMapper;
import com.ich.view.pojo.ViewPostion;
import com.ich.view.service.ViewPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewPostionServiceImpl implements ViewPostionService {

    @Autowired
    private ViewPostionMapper postionMapper;

    @Override
    public HttpResponse addOrEditPostion(ViewPostion postion) {
        ViewPostion entity = this.postionMapper.selectByPrimaryKey(postion.getCode());
        if(ObjectHelper.isEmpty(entity)){
            this.postionMapper.insert(postion);
        }else{
            this.postionMapper.update(postion);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<ViewPostion> findAll() {
        return this.postionMapper.selectAll();
    }

    @Override
    public List<ViewPostion> findByClasses(Integer classes) {
        return this.postionMapper.selectByClasses(classes);
    }
}
