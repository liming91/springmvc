package com.ming.controller;

import com.ming.po.ItemsCustom;
import com.ming.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 整合持久层，业务层，表现层
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemService;

    /**
     * 商品查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryItems",method = {RequestMethod.GET})
    public ModelAndView queryItems() throws Exception {
        ModelAndView model = new ModelAndView();
        List<ItemsCustom> itemsList = itemService.findItemsList(null);
        model.addObject("itemsList",itemsList);
        model.setViewName("/items/itemsList");
        return model;
    }

    /**
     *  商品修改
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editItems() throws Exception{
        ModelAndView model = new ModelAndView();
        ItemsCustom itemsCustom = itemService.findItemsById(1);
        model.addObject("itemsCustom",itemsCustom);
        model.setViewName("/items/editItems");
        return model;
    }

    /**
     * 商品信息修改提交
     * @throws Exception
     */
    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.POST})
    public ModelAndView editItemsSubmit() throws Exception{
        ModelAndView model = new ModelAndView();
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("最新联想笔记本");
        itemsCustom.setPrice(10000f);
        itemService.updateItemsById(1,itemsCustom);
        model.setViewName("success");
        return  model;
    }
}
