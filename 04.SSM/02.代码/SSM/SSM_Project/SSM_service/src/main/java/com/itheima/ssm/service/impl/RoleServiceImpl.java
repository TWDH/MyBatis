package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询所有role
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /**
     * 保存role
     * @throws Exception
     * @param role
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 通过id查找role
     * @param roleId
     * @return
     */
    @Override
    public Role findById(int roleId) throws Exception{
        return roleDao.findById(roleId);
    }

    /**
     * 删除role
     * @param roleId
     */
    @Override
    public void deleteRoleById(String roleId) {
        //从user_role中删除
        roleDao.deleteFrom_RoleByRoleId(roleId);
        //从role_permission中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    /**
     * 找到还可以添加的permission
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermissions(int roleId)throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    /**
     * 向role添加permission
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) throws Exception {
        for(int permissionId : permissionIds){
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
