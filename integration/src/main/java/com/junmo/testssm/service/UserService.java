package com.junmo.testssm.service;

import com.junmo.testssm.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //查询
    List<User> getListUser();

    //新增
    void saveUser(User user);

}
