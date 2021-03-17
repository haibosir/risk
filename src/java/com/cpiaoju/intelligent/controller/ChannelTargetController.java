package com.cpiaoju.intelligent.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.CommonUtil;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.intelligent.model.ChannelTarget;
import com.cpiaoju.intelligent.service.ChannelService;
import com.cpiaoju.intelligent.service.ChannelTargetService;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.service.DictService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 指标; InnoDB free: 9216 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@Controller
@RequestMapping("/system/channelTarget")
public class ChannelTargetController {


    @Autowired
    private ChannelTargetService channelTargetService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private DictService dictService;


    @RequestMapping
    public String channel(Model model) {
        QueryWrapper<Channel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "0");
        List<Channel> channelList = channelService.list(queryWrapper);
        model.addAttribute("channelList",channelList);
        return "intelligent/target/target.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<ChannelTarget> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<ChannelTarget> target = channelTargetService.list(query);
        int count = channelTargetService.count(query);
        return new PageResult<>(target,count);
    }


    /**
     * 添加
     **/
    @RequestMapping("/add")
    public String addView(Model model) {
        QueryWrapper<Channel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "0");
        List<Channel> channelList = channelService.list(queryWrapper);
        model.addAttribute("channelList",channelList);
        Map<String,Object> map = new HashMap<>();
        map.put("type","target_type");
        List<DictDO> list = dictService.list(map);
        model.addAttribute("targetTypeList",list);
        return "intelligent/target/add.html";
    }

    /**
     * 获取指标分类
     */
    @ResponseBody
    @RequestMapping("/dictTree")
    public JsonResult queryDictTree(){
        Map<String,Object> params = new HashMap<>();
        params.put("type","target");
        List<DictDO> list = dictService.list(params);
        List<Map<String, Object>> tree = buildTree(list,Long.valueOf(0));
        return JsonResult.ok().put("tree",tree);
    }

    /**
     * 递归转化树形菜单
     */
    private List<Map<String, Object>> buildTree(List<DictDO> dictList, Long parentId) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < dictList.size(); i++) {
            DictDO temp = dictList.get(i);
            if (parentId.intValue() == temp.getParentId().intValue()) {
                Map<String, Object> map = new HashMap<>();
                map.put("value", temp.getId());
                map.put("label", temp.getValue());
                List<Map<String, Object>> lists = buildTree(dictList, dictList.get(i).getId());
                if(!CollectionUtils.isEmpty(lists)){
                    map.put("children",lists);
                }
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 保存
     **/
    @ResponseBody
    @RequestMapping("/save")
    @Transactional
    public JsonResult save(ChannelTarget target) {
        String[] split = target.getParentIds().split(",");
        if(split.length != 2){
            return JsonResult.error("指标分类不正常");
        }
        target.setParentTargetId(Integer.parseInt(split[0]));
        target.setTargetId(Integer.parseInt(split[1]));
        target.setTargetNo(CommonUtil.getDateTime());
        target.setCreateTime(new Date());
        target.setUpdateTime(new Date());
        if (channelTargetService.save(target)){
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }


    /**
     * 编辑
     **/
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model) {

        ChannelTarget target = channelTargetService.getById(id);

        QueryWrapper<Channel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "0");
        List<Channel> channelList = channelService.list(queryWrapper);
        model.addAttribute("channelList",channelList);
        Map<String,Object> map = new HashMap<>();
        map.put("type","target_type");
        List<DictDO> list = dictService.list(map);
        model.addAttribute("targetTypeList",list);
        StringBuilder sb = new StringBuilder();
        sb.append(target.getParentTargetId());
        sb.append(",").append(target.getTargetId());
        target.setParentIds(sb.toString());
        model.addAttribute("target",target);
        return "intelligent/target/edit.html";
    }

    /**
     * 删除指标
     **/
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer id) {
        if (channelTargetService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 保存
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult update(ChannelTarget target) {
        String[] split = target.getParentIds().split(",");
        if(split.length != 2){
            return JsonResult.error("指标分类不正常");
        }
        target.setParentTargetId(Integer.parseInt(split[0]));
        target.setTargetId(Integer.parseInt(split[1]));
        target.setUpdateTime(new Date());
        if (channelTargetService.updateById(target)){
            return JsonResult.ok("编辑成功");
        }
        return JsonResult.error("编辑失败");
    }

    /**
     * 详情
     **/
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id, Model model) {
        ChannelTarget target = channelTargetService.get(id);
        model.addAttribute("target",target);
        return "intelligent/target/view.html";
    }

}
