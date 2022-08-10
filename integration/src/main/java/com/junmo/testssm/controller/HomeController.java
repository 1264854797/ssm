package com.junmo.testssm.controller;

import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    /*
    跳到新增页面
     */
    @RequestMapping("/save")
    public ModelAndView save(ModelAndView modelAndView) {
        return new ModelAndView("save");
    }
}
