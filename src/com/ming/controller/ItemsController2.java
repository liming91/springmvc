package com.ming.controller;

import com.ming.po.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 另一种处理器ItemsController2就是自己写的controller实现HttpRequestHandler接口
 */
public class ItemsController2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        //设置模型数据
        request.setAttribute("itemsList", itemsList);
        //设置转发的视图
        request.getRequestDispatcher("WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
        //因为没有返回值ModelAndView,所以可以返回json
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("appliction/json;charset=utf-8");
//        response.getWriter().write("josn串");
    }
}
