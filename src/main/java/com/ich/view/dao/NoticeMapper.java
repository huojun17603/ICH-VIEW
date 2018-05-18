package com.ich.view.dao;

import com.ich.view.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {

    public void insert(Notice notice);

    public int delete(Long id);

    public void update(Notice notice);

    public void updateBatchClassid(@Param("oid") Long oid, @Param("nid") Long nid);

    public Notice selectByPrimaryKey(Long id);

    public int updateStatus(@Param("id")Long id, @Param("status") Integer status);

    public void updateReadnum(Long id);

    public List<Notice> selectByClassid(Long classid);

    public List<Notice> selectByEffectiveList(Map<String,Object> map);

    public List<Notice> selectByAdminList(Map<String, Object> paraMap);
}
