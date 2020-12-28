package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //5.查询所有数据
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //6.关闭资源
        session.close();
        in.close();

    }

    /**
     * 保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //5.保存数据
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(300d);

        dao.saveAccount(account);
        //6.提交事务
        session.commit();
        //7.关闭资源
        session.close();
        in.close();
    }
}
