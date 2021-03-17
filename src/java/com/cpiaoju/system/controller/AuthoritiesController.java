package com.cpiaoju.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.system.model.Authorities;
import com.cpiaoju.system.service.AuthoritiesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限管理
 **/
@Controller
@RequestMapping("/system/authorities")
public class AuthoritiesController extends BaseController {
    @Autowired
    private AuthoritiesService authoritiesService;

    @RequiresPermissions("authorities:view")
    @RequestMapping()
    public String authorities(Model model) {
        List<Authorities> authorities = authoritiesService.list(new QueryWrapper<Authorities>().eq("is_menu", 0).orderByAsc("authority_id"));
        model.addAttribute("authorities", authorities);
        return "system/authorities.html";
    }

    /**
     * 查询所有权限
     **/
    @RequiresPermissions("authorities:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Authorities> list() {
        List<Authorities> authorities = authoritiesService.list(new QueryWrapper<Authorities>().orderByAsc("order_number"));
        return new PageResult<>(authorities);
    }

    /**
     * 添加权限
     */
    @RequiresPermissions("authorities:update")
    @ResponseBody
    @RequestMapping("/add")
    public com.cpiaoju.common.JsonResult add(Authorities authorities) {
        if (authoritiesService.save(authorities)) {
            return com.cpiaoju.common.JsonResult.ok("添加成功");
        }
        return com.cpiaoju.common.JsonResult.error("添加失败");
    }

    /**
     * 修改权限
     */
    @RequiresPermissions("authorities:update")
    @ResponseBody
    @RequestMapping("/update")
    public com.cpiaoju.common.JsonResult update(Authorities authorities) {
        if (authoritiesService.updateById(authorities)) {
            return com.cpiaoju.common.JsonResult.ok("修改成功");
        }
        return com.cpiaoju.common.JsonResult.error("修改失败");
    }

    /**
     * 删除权限
     */
    @RequiresPermissions("authorities:update")
    @ResponseBody
    @RequestMapping("/delete")
    public com.cpiaoju.common.JsonResult delete(Integer authorityId) {
        if (authoritiesService.removeById(authorityId)) {
            return com.cpiaoju.common.JsonResult.ok("删除成功");
        }
        return com.cpiaoju.common.JsonResult.error("删除失败");
    }

}
