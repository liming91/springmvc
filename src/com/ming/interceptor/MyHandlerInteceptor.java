package com.ming.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试拦截器，基于aop
 */
public class MyHandlerInteceptor implements HandlerInterceptor {

    /**
     * 进入Handler方法之前执行
     * 用于身份认证，身份授权
     * 比如身份认证，如果认证不通过表示当前用户没有登录，需要此方法拦截不再向下执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle进入Handler方法之前执行");
        //return false 表示拦截，不向下执行
        //return true 表示放行
        return true;
    }

    /**
     * 进入Handler方法之后，返回ModelAndView之前执行
     * 应用场景：从ModelAndView出发，将公用的模型数据(比如菜单的导航)传到视图，也可以统一指定视图
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入Handler方法之后，返回ModelAndView之前执行");

    }

    /**
     * 执行Handler完成后执行此方法
     * 统一异常处理，日志处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行Handler完成后执行此方法");
    }
}
