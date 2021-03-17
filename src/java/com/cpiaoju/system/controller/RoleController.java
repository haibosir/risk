package com.cpiaoju.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.system.model.Authorities;
import com.cpiaoju.system.model.Role;
import com.cpiaoju.system.service.AuthoritiesService;
import com.cpiaoju.system.service.RoleAuthoritiesService;
import com.cpiaoju.system.service.RoleService;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 角色管理
 **/
@Controller
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthoritiesService authoritiesService;
    @Autowired
    private RoleAuthoritiesService roleAuthoritiesService;

    @RequestMapping()
    public String role() {
        return "system/role.html";
    }

    /**
     * 查询所有角色
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Role> list(HttpServletRequest request) {
        PageParam pageParam = new PageParam(request);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        String keywords = (String) pageParam.get("keywords");
        if (StringUtil.isNotBlank(keywords)) {
            queryWrapper.like("role_name", keywords).or().like("comments", keywords);
        }
        return new PageResult<>(roleService.page(pageParam, queryWrapper).getRecords(), pageParam.getTotal());
    }

    /**
     * 添加角色
     **/
    @ResponseBody
    @RequestMapping("/add")
    public JsonResult add(Role role) {
        if (roleService.save(role)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改角色
     **/
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Role role) {
        if (roleService.updateById(role)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除角色
     **/
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer roleId) {
        if (roleService.removeById(roleId)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 角色权限树
     */
    @ResponseBody
    @GetMapping("/authTree")
    public List<Map<String, Object>> authTree(Integer roleId) {
        List<Authorities> roleAuths = authoritiesService.listByRoleId(roleId);
        List<Authorities> allAuths = authoritiesService.list();
        List<Map<String, Object>> authTrees = new ArrayList<>();
        for (Authorities one : allAuths) {
            Map<String, Object> authTree = new HashMap<>();
            authTree.put("id", one.getAuthorityId());
            authTree.put("name", one.getAuthorityName() + " " + StringUtil.getStr(one.getAuthority()));
            authTree.put("pId", one.getParentId());
            authTree.put("open", true);
            authTree.put("checked", false);
            for (Authorities temp : roleAuths) {
                if (temp.getAuthorityId().equals(one.getAuthorityId())) {
                    authTree.put("checked", true);
                    break;
                }
            }
            authTrees.add(authTree);
        }
        return authTrees;
    }

    /**
     * 修改角色权限
     */
    @ResponseBody
    @PostMapping("/updateRoleAuth")
    public JsonResult updateRoleAuth(Integer roleId, String authIds) {
        if (roleAuthoritiesService.updateRoleAuth(roleId, JSONUtil.parseArray(authIds, Integer.class))) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }
}
