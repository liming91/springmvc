package com.ming.mapper;

import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;

import java.util.List;


public interface ItemsMapperCustom {
    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    //批量删除商品
    void deleteBatchItems(Integer[] items_id);

}