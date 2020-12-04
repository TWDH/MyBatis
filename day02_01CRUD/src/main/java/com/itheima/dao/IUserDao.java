package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 保存
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新
     */
    void updateUser(User user);


    /**
     * 根据Id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据Id查询用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据name模糊查找
     * @param userName
     * @return
     */
    List<User> findByName(String userName);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();
}
