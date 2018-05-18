package com.ich.view.dao;

import com.ich.view.pojo.NoticeZan;
import org.apache.ibatis.annotations.Param;

public interface NoticeZanMapper {

    public int insert(NoticeZan zan);

    public int update(NoticeZan entity);

    public int delete(Long id);

    public void deleteSourceZan(@Param("source")Integer source, @Param("sourceid")String sourceid);

    public NoticeZan selectOfUser(@Param("userid") String userid, @Param("source")Integer source, @Param("sourceid")String sourceid);

    Integer selectCountForMark(@Param("mark")Integer mark, @Param("source")Integer source, @Param("sourceid")String sourceid);

    Integer selectCount(@Param("source")Integer source, @Param("sourceid")String sourceid);
}
