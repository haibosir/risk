package com.cpiaoju.intelligent.controller;


import cn.hutool.Hutool;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.CommonUtil;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.intelligent.model.ChannelTarget;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.system.model.Role;
import com.cpiaoju.system.model.User;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台数据; InnoDB free: 8192 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-02
 */
@Controller
@RequestMapping("/system/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @RequestMapping
    public String channel(Model model) {
        return "intelligent/platform/platform.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Platform> list(HttpServletRequest request) {
        PageParam pageParam = new PageParam(request);
        QueryWrapper<Platform> queryWrapper = new QueryWrapper<>();
        String platformName = (String) pageParam.get("platformName");
        if (StringUtil.isNotBlank(platformName)) {
            queryWrapper.like("platform_name", platformName).or();
        }
        String status = (String) pageParam.get("status");
        if (StringUtil.isNotBlank(status)) {
            queryWrapper.eq("status", status);
        }

        IPage<Platform> page = platformService.page(pageParam, queryWrapper);
        return new PageResult<>(page.getRecords(), pageParam.getTotal());
    }


    /**
     * 添加
     **/
    @RequestMapping("/add")
    public String addView(Model model) {
        return "intelligent/platform/add.html";
    }

    /**
     * 保存
     **/
    @ResponseBody
    @RequestMapping("/save")
    @Transactional
    public JsonResult save(Platform platform) {
        platform.setPlatformNo(CommonUtil.getDateTime());
        platform.setCreateTime(new Date());
        platform.setUpdateTime(new Date());
        platform.setStatus(Constant.SYSTEM_STATUS_VALID);
        if (platformService.save(platform)){
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }



    /**
     * 删除
     **/
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer id) {
        if (platformService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 编辑渠道
     **/
    @RequestMapping("/edit/{id}")
    public String addView(@PathVariable("id")Integer id, Model model) {
        Platform platform = platformService.getById(id);
        model.addAttribute("platform",platform);
        return "intelligent/platform/edit.html";
    }

    /**
     * 保存
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult update(Platform platform) {
        platform.setUpdateTime(new Date());
        if (platformService.updateById(platform)){
            return JsonResult.ok("编辑成功");
        }
        return JsonResult.error("编辑失败");
    }

    /**
     * 修改用户状态
     **/
    @ResponseBody
    @RequestMapping("/updateState")
    public JsonResult updateState(Integer id, Integer status) {
        if (id == null) {
            return JsonResult.error("参数Id不能为空");
        }
        if (status == null || (status != 0 && status != 1)) {
            return JsonResult.error("状态值不正确");
        }
        Platform platform = new Platform();
        platform.setId(id);
        platform.setStatus(status);
        if (platformService.updateById(platform)) {
            return JsonResult.ok();
        }
        return JsonResult.error();
    }


    /**
     * 编辑渠道
     **/
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id, Model model) {
        Platform platform = platformService.getById(id);
        model.addAttribute("platform",platform);
        return "intelligent/platform/view.html";
    }
}
