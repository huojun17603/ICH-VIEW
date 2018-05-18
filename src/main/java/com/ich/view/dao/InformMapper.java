package com.ich.view.dao;

import com.ich.view.pojo.Inform;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformMapper {

    public int insert(Inform inform);

    public  void delete(Long id);

    public int update(Inform inform);

    public int updateToEnd(Long id);

    public Inform selectByPrimaryKey(Long id);

    public List<Inform> selectEffectiveInform();

    public List<Inform> selectAllInform();

    public List<Inform> selectEffectiveInformBySource(@Param("source") Integer source, @Param("sourceid")String sourceid);
}
