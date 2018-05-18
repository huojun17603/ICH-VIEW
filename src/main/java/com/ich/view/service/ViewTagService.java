package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.view.pojo.ViewPostion;
import com.ich.view.pojo.ViewTag;

import java.util.List;

public interface ViewTagService {

    public HttpResponse addOrEditPostion(ViewTag tag);

    public List<ViewTag> findAll();

}
