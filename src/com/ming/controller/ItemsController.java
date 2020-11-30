package com.ming.controller;

import com.ming.po.Items;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;
import com.ming.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 整合持久层，业务层，表现层
 */
@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemService;

    //商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        ModelAndView model = new ModelAndView();
        List<ItemsCustom> itemList = itemService.findItemsList(null);
        model.addObject("itemList",itemList);
        model.setViewName("/items/itemsList");
        return model;
    }

    //商品修改


}
