package com.cpiaoju.system.controller;


import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.model.MessageTemplate;
import com.cpiaoju.system.service.DictService;
import com.cpiaoju.system.service.MessageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信模板; InnoDB free: 9216 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@Controller
@RequestMapping("/system/message-template")
public class MessageTemplateController {

    @Autowired
    private MessageTemplateService templateService;
    @Autowired
    private DictService dictService;

    @RequestMapping()
    public String messages(Model model) {
        return "system/message/template.html";
    }

    /**
     * 查询列表
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<MessageTemplate> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<MessageTemplate> messageTemplates = templateService.list(query);
        int count = templateService.count(query);
        return new PageResult<>(messageTemplates,count);
    }

    @RequestMapping("/add")
    public String add(Model model) {
        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","template_message");
        List<DictDO> templateList = dictService.list(queryWrapper);

        model.addAttribute("templateList", templateList);
        return "system/message/add.html";
    }

    @RequestMapping("/edit/{templateId}")
    public String edit(@PathVariable("templateId") Integer templateId, Model model) {
        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","template_message");
        List<DictDO> templateList = dictService.list(queryWrapper);
        model.addAttribute("templateList", templateList);
        MessageTemplate template = templateService.getById(templateId);
        model.addAttribute("template", template);
        return "system/message/edit.html";
    }

    /**
     * 添加模板
     **/
    @ResponseBody
    @RequestMapping("/save")
    @Transactional
    public JsonResult save(MessageTemplate messageTemplate) {
        messageTemplate.setCreateTime(LocalDateTime.now());
        messageTemplate.setUpdateTime(LocalDateTime.now());
        messageTemplate.setStatus(Constant.MESSAGE_TEMPLATE_USER);
        messageTemplate.setTemplateNo(String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))));
        if(templateService.save(messageTemplate)){
            return JsonResult.ok("模板添加完成");
        }
        return JsonResult.error("模板添加失败");
    }

    /**
     * 删除模板
     **/
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer templateId) {
        if (templateId == null) {
            return JsonResult.error("参数模板id不能为空");
        }
        if (templateService.removeById(templateId)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }


    /**
     * 编辑模板
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult update(MessageTemplate messageTemplate) {
        if(templateService.updateById(messageTemplate)){
            return JsonResult.ok("模板编辑完成");
        }
        return JsonResult.error("模板编辑失败");
    }
}
