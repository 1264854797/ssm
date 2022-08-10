package com.junmo.testssm.dao;

import com.junmo.testssm.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    //根据用户名查询
    @Select("select * from user where name=#{name} and password=#{password}")
    User getSelectUser(User user);
}
