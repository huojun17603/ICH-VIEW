package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.view.pojo.ViewPostion;

import java.util.List;

public interface ViewPostionService {

    public HttpResponse addOrEditPostion(ViewPostion postion);

    public List<ViewPostion> findAll();

    public List<ViewPostion> findByClasses(Integer classes);

}
