package com.itheima.dao;

import com.itheima.domain.Account;


import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户uid查询账户
     * @return
     */
    List<Account> findAccountByUid(Integer uid);


}
