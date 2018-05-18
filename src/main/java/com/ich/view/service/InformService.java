package com.ich.view.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.view.pojo.Inform;

import java.util.List;

public interface InformService {

    /**
     * 添加通知
     * @param inform 通知数据
     * @return 是否完成
     */
    public HttpResponse addOrEditInform(Inform inform);

    /**
     * 取消通知
     * @param id 通知ID
     * @return 是否完成
     */
    public HttpResponse cancelInform(Long id);

    public HttpResponse deleteInform(Long id);

    public HttpResponse deleteInforms(String ids);

    public List<Inform> findAllInform();
    /**
     * 获取当前有效的通知列表
     * @return 列表
     */
    public List<Inform> findEffectiveInform();

    /**
     * 获取当前有效的通知列表，根据来源
     * @param source
     * @param sourceid
     */
    public List<Inform> findEffectiveInformBySource(Integer source,String sourceid);
}
