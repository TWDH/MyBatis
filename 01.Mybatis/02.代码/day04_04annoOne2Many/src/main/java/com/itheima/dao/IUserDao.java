package com.itheima.dao;


import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    //解决实体类属性名和数据库名称不一致的问题
    @Results(id="userMap",value={
            //id：主键， property：实体类， column：数据库
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            //一对多：配置accounts
            //通过column(id)查找相应的account
            @Result(property = "accounts", column = "id", many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY))

    })
    List<User> findAll();


    /**
     * 通过id查询
     * @param userId
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value={"userMap"})
    User findById(Integer userId);


    /**
     * 通过username模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

}
