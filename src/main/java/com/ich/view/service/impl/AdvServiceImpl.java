package com.ich.view.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.view.dao.AdvMapper;
import com.ich.view.dao.ViewPostionMapper;
import com.ich.view.pojo.Adv;
import com.ich.view.pojo.ViewPostion;
import com.ich.view.service.AdvService;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvServiceImpl implements AdvService {

    @Autowired
    private AdvMapper advMapper;
    @Autowired
    private ViewPostionMapper postionMapper;

    @Override
    public HttpResponse addOrEditAdv(Adv adv) {
        ViewPostion postion = postionMapper.selectByPrimaryKey(adv.getPostion());
        if(ObjectHelper.isEmpty(postion)) return new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR);
        adv.setPostionname(postion.getName());
        if(ObjectHelper.isEmpty(adv.getId())){
            this.advMapper.insert(adv);
        }else{
            this.advMapper.update(adv);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse deleteAdv(Long id) {
        this.advMapper.deleteAdv(id);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse deleteAdvs(String ids) {
        String id_arr[] = ids.split(",");
        for (String id : id_arr){
            deleteAdv(Long.valueOf(id));
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<Adv> findAdvByPostion(String postion) {
        return this.advMapper.selectAdvByPostion(postion);
    }

    @Override
    public List<Adv> findAllAdv() {
        return this.advMapper.selectAllAdv();
    }
}
