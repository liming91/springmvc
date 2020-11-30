package com.ming.po;

/**
 * 商品包装对象用于表现层
 */
public class ItemsQueryVo {
    //将商品信息包装
    private Items items;
    //为了系统的扩展性，对原始的po进行扩展
    private  ItemsCustom itemsCustom;

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
