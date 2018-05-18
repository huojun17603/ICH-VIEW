package com.ich.view.dao;

import com.ich.view.pojo.Adv;

import java.util.List;

public interface AdvMapper {

    public int insert(Adv adv);

    public int update(Adv adv);

    public int deleteAdv(Long id);

    public Adv selectByPrimaryKey(Long id);

    public List<Adv> selectAdvByPostion(String postion);

    public List<Adv> selectAllAdv();
}
