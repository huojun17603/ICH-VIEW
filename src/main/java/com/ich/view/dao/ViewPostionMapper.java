package com.ich.view.dao;

import com.ich.view.pojo.ViewPostion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewPostionMapper {

    public int insert(ViewPostion postion);

    public int update(ViewPostion postion);

    public List<ViewPostion> selectAll();

    public ViewPostion selectByPrimaryKey(String code);

    public List<ViewPostion> selectNames(@Param("postionids") List<String> postionids);

    public List<ViewPostion> selectByClasses(Integer classes);
}
