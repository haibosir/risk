package com.cpiaoju.intelligent.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.exception.ParameterException;
import com.cpiaoju.common.utils.CommonUtil;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.intelligent.model.*;
import com.cpiaoju.intelligent.service.*;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 平台规则; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/platformRule")
public class PlatformRuleController extends BaseController {

    @Autowired
    PlatformRuleService platformRuleService;
    @Autowired
    PlatformRuleDetailService platformRuleDetailService;
    @Autowired
    ChannelTargetService channelTargetService;
    @Autowired
    PlatformService platformService;
    @Autowired
    PlatformRuleApprovalService platformRuleApprovalService;

    @RequestMapping
    public String channel(Model model) {
        return "intelligent/platformRule/list.html";
    }

    /**
     * 查询产品规则列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<PlatformRule> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<PlatformRule> list = platformRuleService.list(query);
        int count = platformRuleService.count(query);
        if(CollectionUtils.isEmpty(list)){
            return new PageResult<>(new ArrayList<>(),0);
        }
        List<Long> collect = list.stream().map(PlatformRule::getId).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)){
            List<PlatformRuleDetail> platformRuleDetails = platformRuleDetailService.listFull(collect);

            Map<Long,PlatformRule> map = new HashMap<>();

            Map<String,Integer> detail = new HashMap<>();

            for (PlatformRuleDetail ruleDetail : platformRuleDetails) {
                if (CommonUtil.isEmpty(detail.get(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString()))) {
                    detail.put(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString(),1);
                }else{
                    Integer num = detail.get(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString());
                    detail.put(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString(),num+1);
                }
            }
            PlatformRuleDetail ruleDetail;
            for (PlatformRule platformRule : list) {
                List<PlatformRuleDetail> detailList = new ArrayList<>();
                if(!CommonUtil.isEmpty(detail.get(platformRule.getId().toString()+"1"))){
                    ruleDetail = new PlatformRuleDetail();
                    ruleDetail.setType(1);
                    ruleDetail.setUserdCount(detail.get(platformRule.getId().toString()+"1"));
                    detailList.add(ruleDetail);
                }

                if(!CommonUtil.isEmpty(detail.get(platformRule.getId().toString()+"2"))){
                    ruleDetail = new PlatformRuleDetail();
                    ruleDetail.setType(2);
                    ruleDetail.setUserdCount(detail.get(platformRule.getId().toString()+"2"));
                    detailList.add(ruleDetail);
                }

                if(!CommonUtil.isEmpty(detail.get(platformRule.getId().toString()+"3"))){
                    ruleDetail = new PlatformRuleDetail();
                    ruleDetail.setType(3);
                    ruleDetail.setUserdCount(detail.get(platformRule.getId().toString()+"3"));
                    detailList.add(ruleDetail);
                }
                platformRule.setPlatformRuleDetailList(detailList);
            }
        }
        return new PageResult<>(list,count);
    }

    /**
     * 编辑平台规则
     **/
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model) {
        PlatformRule platformRule = platformRuleService.getById(id);
        model.addAttribute("platformRule",platformRule);
        Platform platform = platformService.getById(platformRule.getPlatformId());
        model.addAttribute("platform",platform);
        return "intelligent/platformRule/edit.html";
    }



    /**
     * 获取指标分类
     */
    @ResponseBody
    @RequestMapping("/targetLevel/{id}")
    public JsonResult targetLevel(@PathVariable Integer id){
        List<Map<String, Object>> result = buildSelect();
        List<Long> ids = new ArrayList<>();
        ids.add(id.longValue());
        List<ChannelTarget> channelTargets = channelTargetService.queryRuleDetailTargetList(id);
        List<ChannelTarget> oneList = new ArrayList<>();//平台准入
        List<ChannelTarget> twoList = new ArrayList<>();//债权人巡查
        List<ChannelTarget> treeList = new ArrayList<>();//债务人巡查
        StringBuilder sb;
        for (ChannelTarget targets : channelTargets) {
            sb = new StringBuilder();
            sb.append(targets.getParentTargetId());
            sb.append(",").append(targets.getTargetId());
            sb.append(",").append(targets.getId());
            targets.setParentIds(sb.toString());
            if(targets.getType() == 1){
                oneList.add(targets);
            }else if(targets.getType() == 2){
                twoList.add(targets);
            }else if(targets.getType() == 3){
                treeList.add(targets);
            }
        }
        return JsonResult.ok().put("tree",result).put("oneList",oneList).put("twoList",twoList).put("treeList",treeList);
    }

    /**
     * 获取指标分类
     */
    @ResponseBody
    @RequestMapping("/buildSelect")
    public JsonResult getBuildSelect(){
        List<Map<String, Object>> result = buildSelect();
        return JsonResult.ok().put("tree",result);
    }
    /**
     * 构建指标层级选择
     * @return
     */
    public  List<Map<String, Object>> buildSelect(){
        Map<String,Object> map = new HashMap<>();
        List<ChannelTarget> list = channelTargetService.list(map);
        return levelTarget(list);
    }

    /**
     * 指标三级联动数据
     * @param list
     * @return
     */
    public List<Map<String, Object>> levelTarget(List<ChannelTarget> list){
        List<Map<String, Object>> result = new ArrayList<>();
        Map<Integer,List<ChannelTarget>> params = new HashMap<>();
        for (ChannelTarget target : list) {
           if(CommonUtil.isEmpty(params.get(target.getParentTargetId()))){
               List<ChannelTarget> inner = new ArrayList<>();
               inner.add(target);
               params.put(target.getParentTargetId(),inner);
           }else{
               List<ChannelTarget> channelTargets = params.get(target.getParentTargetId());
               boolean isExist = false;
               for(int i=0;i<channelTargets.size();i++){
                    if(channelTargets.get(i).getTargetId() == target.getTargetId()){
                        isExist = true;
                    }
               }
               if(!isExist){
                   channelTargets.add(target);
                   params.put(target.getParentTargetId(),channelTargets);
               }
           }
        }
        for(Map.Entry<Integer,List<ChannelTarget>> entry :params.entrySet()){
            Map<String,Object> map = new HashMap<>();
            map.put("value",entry.getKey());
            map.put("label",entry.getValue().get(0).getParentTargetName());
            List<Map<String, Object>> lists = new ArrayList<>();
            for (ChannelTarget channelTarget : entry.getValue()) {
                Map<String, Object> child = new HashMap<>();
                child.put("value", channelTarget.getTargetId());
                child.put("label", channelTarget.getDictTargetName());
                List<Map<String, Object>> slists = new ArrayList<>();
                for (ChannelTarget target : list) {
                    if(target.getParentTargetId() == entry.getKey() && target.getTargetId() == channelTarget.getTargetId()){
                        Map<String, Object> schild = new HashMap<>();
                        schild.put("value", target.getId());
                        schild.put("label", target.getTargetName());
                        slists.add(schild);
                    }
                }
                child.put("children",slists);
                lists.add(child);
            }

            map.put("children",lists);
            result.add(map);
        }
        return result;
    }


    /**
     * 编辑保存
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult update(@RequestParam Map<String, Object> params) {
        if(CommonUtil.isEmpty(params.get("ruleId"))){
            return JsonResult.error("编辑信息参数异常");
        }
        Long ruleId = Long.valueOf(params.get("ruleId").toString());
        PlatformRule platformRule = platformRuleService.getById(ruleId);
        if(CommonUtil.isEmpty(params.get("inspection"))){
            platformRule.setInspection(Constant.SYSTEM_STATUS_UNVALID);//不巡查
            platformRule.setNotice(params.get("notice")==null?"":params.get("notice").toString());
        }else{
            platformRule.setInspection(Constant.SYSTEM_STATUS_VALID);//巡查
        }

        if(!CommonUtil.isEmpty(params.get("tableAdmit"))){
            JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableAdmit")));
            common(jsonArray,ruleId,1);
        }
        if(platformRule.getInspection() == 0){
            platformRuleDetailService.batchRemove(ruleId);
        }else{
            if(!CommonUtil.isEmpty(params.get("tableCreditor")) && platformRule.getInspection() == 1){
                JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableCreditor")));
                common(jsonArray,ruleId,2);
            }
            if(!CommonUtil.isEmpty(params.get("tableObligor")) && platformRule.getInspection() == 1){
                JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableObligor")));
                common(jsonArray,ruleId,3);
            }
        }
        return JsonResult.ok();
    }

    /**
     * 处理规则明细
     * @param jsonArray
     * @param ruleId
     * @param type
     * @return
     */
    public JsonResult common(JSONArray jsonArray,Long ruleId,Integer type){
        PlatformRuleDetail platformRuleDetail;
        for (int i=0;i<jsonArray.size();i++) {
            platformRuleDetail = new PlatformRuleDetail();
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            if(!CommonUtil.isEmpty(jsonObject.get("parentIds"))){
                String[] parentIds = jsonObject.getString("parentIds").split(",");
                if(parentIds.length != 3 ){
                    throw new ParameterException(400,"编辑信息参数异常");
                }
                platformRuleDetail.setParentTargetId(Long.valueOf(parentIds[0]));
                platformRuleDetail.setTargetId(Long.valueOf(parentIds[1]));
                platformRuleDetail.setChannelTargetId(Long.valueOf(parentIds[2]));
            }
            if(!CommonUtil.isEmpty(jsonObject.get("operator"))){
                platformRuleDetail.setOperator(jsonObject.getInteger("operator"));
            }
            if(!CommonUtil.isEmpty(jsonObject.get("content"))){
                platformRuleDetail.setContent(jsonObject.getString("content"));
            }
            if(CommonUtil.isEmpty(jsonObject.get("id"))){
                platformRuleDetail.setRuleId(ruleId);
                platformRuleDetail.setCreateTime(LocalDateTime.now());
                platformRuleDetail.setStatus(Constant.SYSTEM_STATUS_VALID);
                platformRuleDetail.setType(type);
                platformRuleDetailService.save(platformRuleDetail);
            }else{
                Long id = jsonObject.getLong("id");
                platformRuleDetail.setId(id);
                platformRuleDetailService.updateById(platformRuleDetail);
            }
        }
        return JsonResult.ok();
    }

    /**
     * 编辑平台详情
     **/
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Long id, Model model) {
        PlatformRule platformRule = platformRuleService.getById(id);
        model.addAttribute("platformRule",platformRule);
        Platform platform = platformService.getById(platformRule.getPlatformId());
        model.addAttribute("platform",platform);

        Map<String,Object> map = new HashMap<>();
        map.put("ruleId",id);
        List<PlatformRuleApproval> list = platformRuleApprovalService.list(map);
        model.addAttribute("approvalList",list);
        return "intelligent/platformRule/view.html";
    }
}
