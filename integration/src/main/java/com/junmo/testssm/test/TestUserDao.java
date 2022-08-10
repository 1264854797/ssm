package com.junmo.testssm.test;

import com.junmo.testssm.dao.UserDao;
import com.junmo.testssm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestUserDao {

//    @Test
//    public void testUserDao() throws IOException {
//        //加载配置文件
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //创建sqlsession对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        //创建sqlsession
//        SqlSession sqlSession = factory.openSession();
//        //获取代理对象
//        UserDao dao = sqlSession.getMapper(UserDao.class);
//
//        List<User> listUser = dao.getListUser();
//        for (User list:listUser){
//            System.out.println(list.getName()+list.getPassword());
//        }
//        //释放资源
//        sqlSession.close();
//        inputStream.close();
//    }
//
//    @Test
//    public void testUserDao2() throws IOException {
//        User user = new User();
//        user.setName("李鮮紅");
//        user.setPassword("123");
//        //加载配置文件
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //创建sqlsession对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        //创建sqlsession
//        SqlSession sqlSession = factory.openSession();
//        //获取代理对象
//        UserDao dao = sqlSession.getMapper(UserDao.class);
//
//        dao.saveUser(user);
//        sqlSession.commit();
//        System.out.println("新增成功！");
//        //释放资源
//        sqlSession.close();
//        inputStream.close();
//    }
}
