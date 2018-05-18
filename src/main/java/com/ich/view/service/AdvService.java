package com.ich.view.service;

import com.ich.view.pojo.Adv;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;

import java.util.List;

public interface AdvService {

    public HttpResponse addOrEditAdv(Adv adv);

    public HttpResponse deleteAdv(Long id);

    public HttpResponse deleteAdvs(String ids);

    /**
     * 按显示的位置查询广告列表[ONUM排序]
     * @param postion 位置数据
     * @return 广告列表
     */
    public List<Adv> findAdvByPostion(String postion);

    /**
     * 查询所有广告列表
     * @return 广告列表
     */
    public List<Adv> findAllAdv();
}
