package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    //根据用户id查询对应角色+权限
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    //查找所有Role
    @Select("select * from role")
    List<Role> findAll();

    //存储role
    @Insert("insert into role(roleName, roleDesc) values (#{roleName}, #{roleDesc})")
    void save(Role role);

    //通过id查找role
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(int roleId);

    //查询没有关联的permission
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(int roleId);

    //删除role
    @Delete("delete from users_role where roleId = #{roleId}")
    void deleteFrom_RoleByRoleId(String roleId);

    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);

    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(String roleId);

    //向role添加permission
    @Insert("insert into role_permission (roleId, permissionId) values (#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
