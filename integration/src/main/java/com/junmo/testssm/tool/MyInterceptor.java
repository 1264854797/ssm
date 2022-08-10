package com.junmo.testssm.tool;

import com.junmo.testssm.domain.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {

    //代码执行前 return false不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取路径,判断是否是登录页面,如果是登录页面放行,如果不是验证是或否有用户信息
        String url = request.getRequestURI();
        System.out.println(url);
        //登录
        if (url.contains("login")) {

            return true;
        }
        //如果有用户信息,说明已登录 放行
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user != null) {
            return true;
        }

        //        判断是不是ajax请求
        String XRequested = request.getHeader("X-Requested-With");
        if (XRequested != null) {
            if (XRequested.equals("XMLHttpRequest")) {
                //说明这是一个ajax请求
                return true;
            }
        }
        request.setAttribute("msg", "你还没登录，请先登录！");
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
