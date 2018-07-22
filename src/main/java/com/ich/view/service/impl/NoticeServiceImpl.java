package com.ich.view.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.dao.NoticeClassMapper;
import com.ich.view.dao.NoticeMapper;
import com.ich.view.dao.ViewPostionMapper;
import com.ich.view.dao.ViewTagMapper;
import com.ich.view.pojo.Notice;
import com.ich.view.pojo.NoticeClass;
import com.ich.view.pojo.ViewPostion;
import com.ich.view.pojo.ViewTag;
import com.ich.view.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private ViewTagMapper tagMapper;
    @Autowired
    private ViewPostionMapper postionMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeClassMapper noticeClassMapper;

    @Override
    public HttpResponse addOrEditNotice(Notice notice) {
        if(ObjectHelper.isEmpty(notice.getClassid())) return new HttpResponse(HttpResponse.HTTP_ERROR,"请选择文章类别！");
        NoticeClass noticeClass = noticeClassMapper.selectByPrimaryKey(notice.getClassid());
        if(ObjectHelper.isEmpty(noticeClass)) return new HttpResponse(HttpResponse.HTTP_ERROR,"无效的文章类别！");
        if(ObjectHelper.isNotEmpty(notice.getPostion())) {
            List<String> postionids = Arrays.asList(notice.getPostion().split(","));
            List<ViewPostion> postions = postionMapper.selectNames(postionids);
            String posionname = "";
            for (ViewPostion postion : postions) posionname += postion.getName() + ",";
            if (ObjectHelper.isNotEmpty(posionname)) posionname = posionname.substring(0, posionname.length()-1);
            notice.setPostionname(posionname);
        }
        if(ObjectHelper.isNotEmpty(notice.getTag())) {
            List<String> tagids = Arrays.asList(notice.getTag().split(","));
            List<ViewTag> tags = tagMapper.selectNames(tagids);
            String tagname = "";
            for (ViewTag tag : tags) tagname += tag.getName() + ",";
            if (ObjectHelper.isNotEmpty(tagname)) tagname = tagname.substring(0, tagname.length()-1);
            notice.setTagname(tagname);
        }
        notice.setCreatetime(new Date());
        notice.setStatus(0);
        notice.setClassid(noticeClass.getId());
        notice.setClassname(noticeClass.getName());
        if(ObjectHelper.isEmpty(notice.getId())){
            noticeMapper.insert(notice);//insert
        }else{
            noticeMapper.update(notice);//修改
        }
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK,notice);
    }

    @Override
    public HttpResponse editNoticeStatus(Long id, Integer status) {
        int result = noticeMapper.updateStatus(id,status);
        return result==1?(new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK)):(new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR));
    }

    @Override
    public HttpResponse deleteNotice(Long id) {
        int result = noticeMapper.delete(id);
        return result==1?(new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK)):(new HttpResponse(HttpResponse.HTTP_ERROR,HttpResponse.HTTP_MSG_ERROR));
    }

    @Override
    public HttpResponse editBatchClassid(Long oid, Long nid) {
        noticeMapper.updateBatchClassid(oid,nid);
        return new HttpResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
    }

    @Override
    public Notice findById(Long id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Notice findOfUser(Long id) {
        noticeMapper.updateReadnum(id);
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> findByClassid(Long classid) {
        return noticeMapper.selectByClassid(classid);
    }

    @Override
    public List<Notice> queryByPostion(PageView view, String postion) {
        PageHelper.startPage(view.getPage(),view.getRows());
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("postion",postion);
        List<Notice> result = noticeMapper.selectByEffectiveList(paraMap);
        PageInfo<Notice> pageInfo = new PageInfo<>(result);
        view.setRowCount(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<Notice> queryByCondition(PageView view, Long classid, String keyword,String postion,String author,String searchkey) {
        PageHelper.startPage(view.getPage(),view.getRows());
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("classid",classid);
        paraMap.put("keyword",keyword);
        paraMap.put("postion",postion);
        paraMap.put("author",author);
        paraMap.put("searchkey",searchkey);
        List<Notice> result = noticeMapper.selectByEffectiveList(paraMap);
        PageInfo<Notice> pageInfo = new PageInfo<>(result);
        view.setRowCount(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<Notice> queryByAdminCondition(PageView view, Long classid, String keyword, String postion, String author, String searchkey) {
        PageHelper.startPage(view.getPage(),view.getRows());
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("classid",classid);
        paraMap.put("keyword",keyword);
        paraMap.put("postion",postion);
        paraMap.put("author",author);
        paraMap.put("searchkey",searchkey);
        List<Notice> result = noticeMapper.selectByAdminList(paraMap);
        PageInfo<Notice> pageInfo = new PageInfo<>(result);
        view.setRowCount(pageInfo.getTotal());
        return result;
    }
}
