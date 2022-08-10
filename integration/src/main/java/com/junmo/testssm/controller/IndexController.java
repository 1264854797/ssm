package com.junmo.testssm.controller;

import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView login(HttpServletResponse response,HttpServletRequest request){
        return new ModelAndView("home");
    }

    @RequestMapping("/login")
    public ModelAndView home(HttpServletResponse response,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("login");
        String msg= (String) request.getAttribute("msg");
        if (msg!=null){
            modelAndView.addObject("msg",msg);
        }
        return modelAndView;
    }



}
