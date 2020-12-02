package com.ming.service.imple;

import com.ming.mapper.ItemsMapper;
import com.ming.mapper.ItemsMapperCustom;
import com.ming.po.Items;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;
import com.ming.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
            throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        //可能中间对数据库的商品信息进行处理
        //..比如处理时间，显示过期不过期，给扩展类添加过期标示，用于页面展示
       //将items的属性值拷贝到ItemsCustom
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    @Override
    public void updateItemsById(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验不如id不为空
        //根据id校验，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs不洗传入id
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public void updateBatchItems(List<ItemsCustom> customList) {
        if(customList.size()>0){
            itemsMapperCustom.updateBatchItems(customList);
        }
    }

    @Override
    public void deleteBatchItems(Integer[] items_id) {
        if(items_id.length<0){
            throw new RuntimeException("参数为空！");
        }
        itemsMapperCustom.deleteBatchItems(items_id);
    }
}
