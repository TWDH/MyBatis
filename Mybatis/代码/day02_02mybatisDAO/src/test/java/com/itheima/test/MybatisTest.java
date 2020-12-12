package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;


    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);
    }
    @After
    public void destroy() throws Exception{
        in.close();
    }

    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    /*保存user*/
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("张小美");
        user.setAddress("旧文化街");
        user.setSex("女");
        user.setBirthday(new Date());

        System.out.println("执行保存之前"+user);
        //执行保存之前User{id=null, username='张大美', birthday=Thu Dec 03 20:31:27 EST 2020, sex='男', address='新文化街'}

        /*执行保存方法*/
        userDao.saveUser(user);
        System.out.println("执行保存之后"+user);
        //执行保存之后 User{id=51, username='张大美', birthday=Thu Dec 03 20:31:27 EST 2020, sex='男', address='新文化街'}
    }

    /*更新User*/
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(50);
        user.setUsername("MyBatis update test2");
        user.setAddress("新文化街2");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /*删除User*/
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(52);
    }

    /*查询一个User*/
    @Test
    public void testFindOne(){
      User result = userDao.findById(50);
      System.out.println(result);
    }


    /*模糊查询操作*/
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    /*模糊查询操作*/
    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }

}
