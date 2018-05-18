package com.ich.view.dao;

import com.ich.view.pojo.ViewPostion;
import com.ich.view.pojo.ViewTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewTagMapper {

    public int insert(ViewTag tag);

    public int update(ViewTag tag);

    public List<ViewTag> selectAll();

    public ViewTag selectByPrimaryKey(String code);

    public List<ViewTag> selectNames(@Param("tagids") List<String> tagids);
}
