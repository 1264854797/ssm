package com.junmo.testssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/select")
    public ModelAndView select(@RequestParam(required = false) int pageNumber,@RequestParam(required = false) int pageSize, ModelAndView modelAndView){
        //PageHelper.startPage(page, pageSize);这段代码表示，程序开始分页了，
        //page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
        PageHelper.startPage(pageNumber, pageSize);
        //查询
        List<User> listUser = userService.getListUser();
        //创建PageInfo对象，保存查询出的结果，PageInfo是pageHelper中的对象
        PageInfo<User> p=new PageInfo<User>(listUser);
        //将数据存放到model域中
        modelAndView.addObject("list",listUser);
        modelAndView.addObject("page",p);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
