package com.itheima.dao;


import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
     * CRUD一共有四个注解
     * @Select @Insert @Update @Delete
     * @return
     */
    @Select("select * from user")
    List<User> findAll();


    /**
     * 保存用户
     * values填入实体类的属性
     * @param user
     */
    @Insert("insert into user(username, address, sex, birthday)values(#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);


    /**
     * 更新
     * @param user
     */
    @Update("update user set username=#{username}, sex=#{sex}, birthday=#{birthday}, address=#{address} where id=#{id}")
     void updateUser(User user);

    /**
     * 删除
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deteletUser(Integer userId);

    /**
     * 通过id查询
     * @param userId
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    /**
     * 通过username模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);


    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();
}
