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
}
