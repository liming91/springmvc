package com.ming.controller;

import com.ming.po.Items;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现controller接口的处理器
 */
public class ItemsController1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //调用service查找数据库，查询商品列表，使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();
        Items items = new Items();
        items.setName("联想笔记本");
        items.setPrice(5000f);
        items.setDetail("T430联系笔记本");
        Items items2 = new Items();
        items2.setName("苹果手机");
        items2.setPrice(8000f);
        items2.setDetail("苹果手机iphone12");
        itemsList.add(items);
        itemsList.add(items2);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于Request的setAttribute()方法，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        //指定视图
        modelAndView.setViewName("WEB-INF/jsp/items/itemsList.jsp");
        return modelAndView;
    }
}
