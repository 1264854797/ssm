package com.junmo.testssm.service.impl;

import com.junmo.testssm.dao.LoginDao;
import com.junmo.testssm.domain.User;
import com.junmo.testssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    public User getSelectUser(User user) {
        return loginDao.getSelectUser(user);
    }
}
