package com.ich.view.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dao.InformMapper;
import com.ich.view.pojo.Inform;
import com.ich.view.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InformServiceImpl implements InformService{

    @Autowired
    private InformMapper informMapper;

    @Override
    public HttpResponse addOrEditInform(Inform inform) {
        Date day = new Date();
        inform.setCreatetime(day);
        if(ObjectHelper.isEmpty(inform.getEndtime())) inform.setEndtime(new Date(day.getTime()+(1000l*60*60*24)));//默认为一天
        if(ObjectHelper.isEmpty(inform.getId())){
            this.informMapper.insert(inform);
        }else{
            this.informMapper.update(inform);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse cancelInform(Long id) {
        this.informMapper.updateToEnd(id);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse deleteInform(Long id) {
        this.informMapper.delete(id);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse deleteInforms(String ids) {
        String id_arr[] = ids.split(",");
        for (String id : id_arr){
            deleteInform(Long.valueOf(id));
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<Inform> findAllInform() {
        return this.informMapper.selectAllInform();
    }

    @Override
    public List<Inform> findEffectiveInform() {
        return this.informMapper.selectEffectiveInform();
    }

    @Override
    public List<Inform> findEffectiveInformBySource(Integer source, String sourceid) {
        return this.informMapper.selectEffectiveInformBySource(source,sourceid);
    }
}
