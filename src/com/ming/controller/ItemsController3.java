//package com.ming.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 注解的Handler处理器（就是controller）
// * Controller注解标示是一个 控制器
// */
//@Controller
//public class ItemsController3 {
//    /**
//     * RequestMapping注解 实现对queryItems()方法和url的映射
//     * 查询商品列表
//     * @return modelAndView
//     */
//    @RequestMapping("/queryItemsList")
//    public ModelAndView queryItems(){
//        //调用service查找数据库，查询商品列表，使用静态数据模拟
//        List<Items> itemsList = new ArrayList<Items>();
//        Items items = new Items();
//        items.setName("联想笔记本");
//        items.setPrice(5000f);
//        items.setDetail("T430联系笔记本");
//        Items items2 = new Items();
//        items2.setName("苹果手机");
//        items2.setPrice(8000f);
//        items2.setDetail("苹果手机iphone12");
//        itemsList.add(items);
//        itemsList.add(items2);
//        //返回ModelAndView
//        ModelAndView modelAndView = new ModelAndView();
//        //相当于Request的setAttribute()方法，在jsp页面中通过itemsList取数据
//        modelAndView.addObject("itemsList", itemsList);
//        //指定视图
//        //如果在InternalResourceViewResolver视图解析器中配置了jsp路径的前缀和后缀,可以不用指定jsp的前缀和后缀路径
//        //modelAndView.setViewName("WEB-INF/jsp/items/itemsList.jsp");
//        modelAndView.setViewName("/items/itemsList");
//        return modelAndView;
//    }
//
//}
