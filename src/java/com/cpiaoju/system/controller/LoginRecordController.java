package com.cpiaoju.system.controller;


import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.system.model.LoginRecord;
import com.cpiaoju.system.service.LoginRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录日志管理
 **/
@Controller
@RequestMapping("/system/loginRecord")
public class LoginRecordController {
    @Autowired
    private LoginRecordService loginRecordService;

    @RequiresPermissions("loginRecord:view")
    @RequestMapping()
    public String loginRecord() {
        return "system/log/loginRecord.html";
    }

    /**
     * 查询所有登录日志
     **/
    @RequiresPermissions("loginRecord:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<LoginRecord> list(HttpServletRequest request) {
        return loginRecordService.listFull(new PageParam(request).setDefaultOrder(null, new String[]{"create_time"}));
    }

}
