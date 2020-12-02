package com.ming.service;

import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;

import java.util.List;

/**
 * 商品业务层
 */
public interface ItemsService {
    //商品列表查询
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    //根据id查询商品信息
    public ItemsCustom findItemsById(Integer id) throws Exception;
    //修改商品信息
    public void updateItemsById(Integer id,ItemsCustom itemsCustom) throws Exception;

    //批量删除商品
    void deleteBatchItems(Integer[] items_id);

    void updateBatchItems(List<ItemsCustom> customList);
}
