package com.junmo.testssm.service;

import com.junmo.testssm.domain.User;

public interface LoginService {

    //根据名称密码查询
    User getSelectUser(User user);
}
