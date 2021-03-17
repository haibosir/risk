package com.cpiaoju.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.system.model.Authorities;
import com.cpiaoju.system.model.Message;
import com.cpiaoju.system.service.MessageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信记录; InnoDB free: 9216 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@Controller
@RequestMapping("/system/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @RequestMapping()
    public String messages() {
        return "system/message/message.html";
    }

    /**
     * 查询所有权限
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Message> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<Message> message = messageService.list(query);
        int count = messageService.count(query);
        return new PageResult<>(message,count);
    }
}
