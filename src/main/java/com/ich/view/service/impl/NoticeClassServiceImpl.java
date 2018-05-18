package com.ich.view.service.impl;


import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.view.dao.NoticeClassMapper;
import com.ich.view.dao.NoticeMapper;
import com.ich.view.dto.NoticeClassTree;
import com.ich.view.pojo.Notice;
import com.ich.view.pojo.NoticeClass;
import com.ich.view.service.NoticeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeClassServiceImpl implements NoticeClassService {

    @Autowired
    private NoticeClassMapper noticeClassMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public HttpResponse addClass(NoticeClass noticeClass) {
        noticeClassMapper.insert(noticeClass);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse updateClass(NoticeClass noticeClass) {
        noticeClassMapper.update(noticeClass);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse updateClassPid(Long id, Long pid) {
        NoticeClass noticeClass = noticeClassMapper.selectByPrimaryKey(id);
        noticeClass.setPid(pid);
        noticeClassMapper.update(noticeClass);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse updateClassInfo(Long id,String name,String remark) {
        NoticeClass noticeClass = noticeClassMapper.selectByPrimaryKey(id);
        noticeClass.setName(name);
        noticeClass.setRemark(remark);
        noticeClassMapper.update(noticeClass);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public HttpResponse deleteClass(Long id) {
        List<NoticeClass> list = noticeClassMapper.selectClassByPid(id);
        if(ObjectHelper.isNotEmpty(list)) return new HttpResponse(HttpResponse.HTTP_ERROR,"请先移除其子类别！");
        List<Notice> notices = noticeMapper.selectByClassid(id);
        if(ObjectHelper.isNotEmpty(notices)) return new HttpResponse(HttpResponse.HTTP_ERROR,"请先移除其下文章！");
        noticeClassMapper.deleteById(id);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public List<NoticeClassTree> findClassTreeByPid(Long pid) {
        List<NoticeClass> list = findClassByPid(pid);
        if(ObjectHelper.isEmpty(list)) return null;
        List<NoticeClassTree> trees = new ArrayList<>();
        for (NoticeClass noticeClass : list){
            NoticeClassTree tree = new NoticeClassTree();
            tree.setId(noticeClass.getId());
            tree.setName(noticeClass.getName());
            tree.setPid(noticeClass.getPid());
            tree.setRemark(noticeClass.getRemark());
            tree.setChildren(findClassTreeByPid(tree.getId()));
            if(ObjectHelper.isEmpty(tree.getChildren())) tree.setState("closed");
            trees.add(tree);
        }
        return trees;
    }

    @Override
    public List<NoticeClass> findClassByPid(Long pid) {
        if(ObjectHelper.isEmpty(pid)){
            return noticeClassMapper.selectClassByPidRoot();
        }else{
            return noticeClassMapper.selectClassByPid(pid);
        }
    }
}
