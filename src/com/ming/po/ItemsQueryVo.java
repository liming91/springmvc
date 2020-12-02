package com.ming.po;

import java.util.List;

/**
 * 商品包装对象用于表现层
 */
public class ItemsQueryVo {
    //将商品信息包装
    private Items items;
    //为了系统的扩展性，对原始的po进行扩展
    private  ItemsCustom itemsCustom;
    //批量修改页面查询的id
    private Integer[] id;
    //批量修修改的商品
    private List<ItemsCustom> itemsCustomList;

    public List<ItemsCustom> getItemsCustomList() {
        return itemsCustomList;
    }

    public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
        this.itemsCustomList = itemsCustomList;
    }

    public Integer[] getId() {
        return id;
    }

    public void setId(Integer[] id) {
        this.id = id;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
