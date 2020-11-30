package com.ming.service.imple;

import com.ming.mapper.ItemsMapperCustom;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;
import com.ming.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
            throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }
}
