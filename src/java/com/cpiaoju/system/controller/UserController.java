package com.cpiaoju.system.controller;


import cn.hutool.core.bean.BeanUtil;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.shiro.EndecryptUtil;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.system.model.*;
import com.cpiaoju.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
    private static final String DEFAULT_PSW = "123456";  // 用户默认密码
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserPlatformService userPlatformService;
    @Autowired
    private DictService dictService;

    @RequiresPermissions("user:view")
    @RequestMapping
    public String user(Model model) {

        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);

        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","platform");
        List<DictDO> platforms = dictService.list(queryWrapper);
        model.addAttribute("platforms", platforms);
        return "system/user/user.html";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("user:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<User> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<User> list = userService.list(query);
        int count = userService.count(query);
        return new PageResult<>(list, count);
        //return userService.listUser(new PageParam(request).setDefaultOrder(null, new String[]{"create_time"}));
    }
    /**
     * 添加用户
     **/
    @RequestMapping("/user_add")
    public String addView(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);

        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","platform");
        List<DictDO> platforms = dictService.list(queryWrapper);
        model.addAttribute("platforms", platforms);
        return "system/user/add.html";
    }
    /**
     * 添加用户
     **/
    @RequiresPermissions("user:update")
    @ResponseBody
    @RequestMapping("/add")
    @Transactional
    public JsonResult add(User user, String roleIds,String platformIds) {
        user.setState(0);
        user.setPassword(EndecryptUtil.encrytMd5(DEFAULT_PSW, 3));
        if (userService.addUser(user, getRoleIds(roleIds),getRoleIds(platformIds))){
            return JsonResult.ok("添加成功，初始密码为" + DEFAULT_PSW);
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 添加用户
     **/
    @RequestMapping("/user_update/{userId}")
    public String updateView(@PathVariable("userId") Integer userId,Model model) {
        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","platform");
        List<DictDO> platforms = dictService.list(queryWrapper);
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        model.addAttribute("platforms", platforms);
        User user = userService.getById(userId);
       /*List<UserPlatform> userPlatformList = userPlatformService.findPlatformNameByUserId(userId);
        user.setUserRoles(userRoleList);
        user.setPlatforms(userPlatformList);*/
        //List<UserRole> userRoleList = userRoleService.findUserRoleByUserId(userId);
        model.addAttribute("user", user);
        return "system/user/edit.html";
    }

    /**
     * 修改用户
     **/
    @ResponseBody
    @RequestMapping("/list/{userId}")
    public JsonResult listRoles(@PathVariable("userId") Integer userId) {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(userId);
        List<UserPlatform> userPlatformList = userPlatformService.findPlatformNameByUserId(userIds);

        List<Integer> ids = new ArrayList<>();
        userPlatformList.forEach(platform->{
            ids.add(platform.getPlatformId());
        });
        return JsonResult.ok().put("platform",ids);
    }

    /**
     * 修改用户
     **/
    @RequiresPermissions("user:update")
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(User user, String roleIds,String platformIds) {
        if (userService.updateUser(user, getRoleIds(roleIds),getRoleIds(platformIds))) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 用逗号分割角色
     */
    private List<Integer> getRoleIds(String rolesStr) {
        List<Integer> roleIds = new ArrayList<>();
        if (rolesStr != null) {
            String[] split = rolesStr.split(",");
            for (String t : split) {
                try {
                    roleIds.add(Integer.parseInt(t));
                } catch (Exception e) {
                }
            }
        }
        return roleIds;
    }

    /**
     * 修改用户状态
     **/
    @RequiresPermissions("user:update")
    @ResponseBody
    @RequestMapping("/updateState")
    public JsonResult updateState(Integer userId, Integer state) {
        if (userId == null) {
            return JsonResult.error("参数userId不能为空");
        }
        if (state == null || (state != 0 && state != 1)) {
            return JsonResult.error("状态值不正确");
        }
        User user = new User();
        user.setUserId(userId);
        user.setState(state);
        if (userService.updateById(user)) {
            return JsonResult.ok();
        }
        return JsonResult.error();
    }

    /**
     * 删除用户
     **/
    @RequiresPermissions("user:update")
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer userId) {
        if (userId == null) {
            return JsonResult.error("参数userId不能为空");
        }
        if (userService.removeById(userId)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 重置密码
     **/
    @RequiresPermissions("user:update")
    @ResponseBody
    @RequestMapping("/restPsw")
    public JsonResult resetPsw(Integer userId) {
        if (userId == null) {
            return JsonResult.error("参数userId不能为空");
        }
        User user = new User();
        user.setUserId(userId);
        user.setPassword(EndecryptUtil.encrytMd5(DEFAULT_PSW, 3));
        if (userService.updateById(user)) {
            return JsonResult.ok("重置成功，初始密码为" + DEFAULT_PSW);
        }
        return JsonResult.error("重置失败");
    }

    /**
     * 修改自己密码
     **/
    @ResponseBody
    @RequestMapping("/updatePsw")
    public JsonResult updatePsw(String oldPsw, String newPsw) {
        if (StringUtil.isBlank(oldPsw, newPsw)) {
            return JsonResult.error("参数不能为空");
        }
        if (getLoginUser() == null) {
            return JsonResult.error("未登录");
        }
        if (!getLoginUser().getPassword().equals(EndecryptUtil.encrytMd5(oldPsw, 3))) {
            return JsonResult.error("原密码输入不正确");
        }
        User user = new User();
        user.setUserId(getLoginUser().getUserId());
        user.setPassword(EndecryptUtil.encrytMd5(newPsw, 3));
        if (userService.updateById(user)) {
            return com.cpiaoju.common.JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 跳转到查看用户详情页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        Integer userId = getLoginUser().getUserId();
        User user = this.userService.getById(userId);
        model.addAllAttributes(BeanUtil.beanToMap(user));
        List<Role> roles = roleService.list();

        StringBuilder sb = new StringBuilder();

        List<UserRole> userRoleList = userRoleService.findUserRoleByUserId(userId);
        userRoleList.stream().forEach(userRole ->{
            if(sb.length()==0){
                sb.append(userRole.getRoleName());
            }else{
                sb.append(","+userRole.getRoleName());
            }
        });
        user.setRoleNames(sb.toString());

        StringBuilder sb2 = new StringBuilder();


        List<Integer> userIds = new ArrayList<>();
        userIds.add(userId);
        List<UserPlatform> platformList = userPlatformService.findPlatformNameByUserId(userIds);

        platformList.stream().forEach(platform->{
            if(sb2.length()==0){
                sb2.append(platform.getPlatformName());
            }else{
                sb2.append(","+platform.getPlatformName());
            }
        });
        user.setPlatformNames(sb2.toString());
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "system/user_info.html";
    }

    /**
     * 个人中心修改密
     **/
    @RequestMapping("/info")
    public String info(Model model) {
        User loginUser = getLoginUser();
        model.addAttribute("user",loginUser);
        return "system/user/info.html";
    }

 /*   *//**
     * 修改用户
     **//*
    @ResponseBody
    @RequestMapping("/update_info")
    public JsonResult update_info(User user) {
        if (userService.updateById(user)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }*/
}
