package com.junmo.testssm.dao;

import com.junmo.testssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    //查询
    @Select("select * from user")
    List<User> getListUser();

    //新增
    @Insert("insert into user(name,password) values(#{name},#{password})")
    void saveUser(User user);

}
