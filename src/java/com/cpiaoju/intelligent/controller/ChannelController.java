package com.cpiaoju.intelligent.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.intelligent.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 渠道; InnoDB free: 9216 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@Controller
@RequestMapping("/system/channel")
public class ChannelController extends BaseController {

    @Autowired
    private ChannelService channelService;

    @RequestMapping
    public String channel(Model model) {
        return "intelligent/channel/channel.html";
    }

    /**
     * 查询渠道列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Channel> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<Channel> list = channelService.list(query);
        int count = channelService.count(query);
        return new PageResult<>(list,count);
    }


    /**
     * 添加渠道
     **/
    @RequestMapping("/add")
    public String addView(Model model) {
        return "intelligent/channel/add.html";
    }


    /**
     * 保存渠道
     **/
    @ResponseBody
    @RequestMapping("/save")
    @Transactional
    public JsonResult save(Channel channel) {
        channel.setStatus(Constant.SYSTEM_STATUS_VALID);
        channel.setCreateTime(new Date());
        channel.setUpdateTime(new Date());
        if (channelService.save(channel)){
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 删除渠道
     **/
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer id) {
        if (channelService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 编辑渠道
     **/
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model) {
        Channel byId = channelService.getById(id);
        model.addAttribute("channel",byId);
        return "intelligent/channel/edit.html";
    }



    /**
     * 保存渠道
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult update(Channel channel) {
        channel.setUpdateTime(new Date());
        if (channelService.updateById(channel)){
            return JsonResult.ok("编辑成功");
        }
        return JsonResult.error("编辑失败");
    }

    /**
     * 渠道详情
     **/
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id, Model model) {
        Channel channel = channelService.getById(id);
        model.addAttribute("channel",channel);
        return "intelligent/channel/view.html";
    }
}
