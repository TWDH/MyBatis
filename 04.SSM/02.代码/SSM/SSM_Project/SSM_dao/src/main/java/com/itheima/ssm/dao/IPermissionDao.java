package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    //查询所有permission
    @Select("SELECT * FROM permission")
    List<Permission> findAll() throws Exception;

    //保存permission
    @Insert("insert into permission(permissionName, url) values (#{permissionName}, #{url})")
    void save(Permission permission) throws Exception;

    //删除permission
    @Select("select * from permission where id = #{id}")
    Permission findById(int id);

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(int id);

    @Delete("delete from permission where id = #{id}")
    void deleteById(int id);
}
