package com.ming.mapper;

import com.ming.po.Items;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}