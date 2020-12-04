package com.ming.controller;

import com.ming.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * json交互测试
 */
@Controller
@RequestMapping("/jsonTest")
public class JsonTestController {
    /**
     *  请求json串(商品信息)，响应输出json(商品信息)
     *  RequestBody将请求的商品信息json串转出Java对象itemsCustom
     *  ResponseBody将Java对象itemsCustom转换成json输出
     * @return
     */
    @RequestMapping(value = "/requestJson")
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
        System.out.println(itemsCustom);
        return itemsCustom;
    }
}
