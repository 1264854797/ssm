package com.junmo.testssm.controller;

import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.LoginService;
import com.junmo.testssm.service.UserService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView getLogin(User user, HttpSession session, ModelAndView modelAndView, HttpSession  httpSession) {
        if (user.getName() != null && user.getPassword() != null) {
            if (loginService.getSelectUser(user) != null) {
                modelAndView.setViewName("home");
                httpSession.setAttribute("USER_SESSION",user);
                return modelAndView;
            } else {
                modelAndView.addObject("msg", "用户名或密码错误，请检查！");
                modelAndView.setViewName("login");
                return modelAndView;
            }
        }
        return null;
    }

}
