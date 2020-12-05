package com.ming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception{
        //调用service进行用户认证
        session.setAttribute("username",username);
        return "redirect:/items/queryItems.action";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpSession session, String username, String password) throws Exception{
       //清除session
        session.invalidate();
        return "redirect:/items/queryItems.action";
    }
}
