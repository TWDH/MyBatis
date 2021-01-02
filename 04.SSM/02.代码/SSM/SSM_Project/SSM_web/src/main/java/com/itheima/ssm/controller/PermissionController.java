package com.itheima.ssm.controller;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permission")
@Controller
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //查找
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    //保存
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    //详情：通过id
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(id);
        mv.addObject("permission", permission);
        mv.setViewName("permission-show");
        return mv;
    }

    //删除permission
    @RequestMapping("/deletePermission.do")
    public String deletePermission(int id) throws Exception{
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }
}
