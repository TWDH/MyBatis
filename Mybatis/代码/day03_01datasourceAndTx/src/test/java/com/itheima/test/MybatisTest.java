package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
    private SqlSession sqlSession;
    private IUserDao userDao;


    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
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
        user.setUserName("张小美");
        user.setUserAddress("旧文化街");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

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
        user.setUserId(50);
        user.setUserName("MyBatis update test");
        user.setUserAddress("新文化街");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        userDao.updateUser(user);
    }

    /*删除User*/
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(48);
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

    /*使用QueryVo作为查询条件*/
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        //创界要查询的 对象+属性
        User userVo = new User();
        userVo.setUserName("%王%");
        //建立vo与user的联系
        vo.setUser(userVo);

        //执行查询方法
        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }
}
