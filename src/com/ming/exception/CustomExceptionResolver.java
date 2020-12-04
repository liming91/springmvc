package com.ming.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        //Object handler就是处理器适配器最终要执行的handler
        // 解析出异常类型
        //如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
       /* String message = null;
        if(ex instanceof CustomException){
            message = ((CustomException)ex).getMessage();
        }else{
            // 如果该异常类型不是系统自定义的异常，构造一个自定义异常类型（信息为未知错误）
            message="未知错误";
        }*/
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException) ex;
        } else {
            customException = new CustomException("未知错误");
        }
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
