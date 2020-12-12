package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    //查询所有账户，并获取用户信息
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            //这里配置Account的信息
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            //配置User信息，使用findById (uid) 查询相应user信息
            //select选择：”使用何种方法查询user“
            @Result(property = "user", column = "uid", one = @One(select = "com.itheima.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
