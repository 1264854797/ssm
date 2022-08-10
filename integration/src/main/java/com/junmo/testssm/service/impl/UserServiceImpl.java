package com.junmo.testssm.service.impl;

import com.junmo.testssm.dao.UserDao;
import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    UserDao userDao;

    public List<User> getListUser() {
        System.out.println("查询用户信息");
        return userDao.getListUser();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
