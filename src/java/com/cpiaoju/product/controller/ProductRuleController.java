package com.cpiaoju.product.controller;

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
import com.cpiaoju.intelligent.service.ChannelTargetService;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.product.model.Product;
import com.cpiaoju.product.model.ProductRule;
import com.cpiaoju.product.model.ProductRuleApproval;
import com.cpiaoju.product.model.ProductRuleDetail;
import com.cpiaoju.product.service.ProductRuleApprovalService;
import com.cpiaoju.product.service.ProductRuleDetailService;
import com.cpiaoju.product.service.ProductRuleService;
import com.cpiaoju.product.service.ProductService;
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
 * 产品; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/productRule")
public class ProductRuleController extends BaseController {

    @Autowired
    ProductService productService;
    @Autowired
    PlatformService platformService;
    @Autowired
    ProductRuleService productRuleService;
    @Autowired
    ProductRuleDetailService productRuleDetailService;
    @Autowired
    ProductRuleApprovalService productRuleApprovalService;
    @Autowired
    ChannelTargetService channelTargetService;

    @RequestMapping
    public String channel(Model model) {
        return "intelligent/productRule/list.html";
    }

    /**
     * 查询渠道列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<ProductRule> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<ProductRule> list = productRuleService.list(query);
        int count = productRuleService.count(query);
        if(CollectionUtils.isEmpty(list)){
            return new PageResult<>(new ArrayList<>(),0);
        }
        List<Long> collect = list.stream().map(ProductRule::getId).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)){
            List<ProductRuleDetail> productRuleDetailList = productRuleDetailService.list(collect);

            Map<String,Integer> detail = new HashMap<>();

            for (ProductRuleDetail ruleDetail : productRuleDetailList) {
                if (CommonUtil.isEmpty(detail.get(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString()))) {
                    detail.put(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString(),1);
                }else{
                    Integer num = detail.get(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString());
                    detail.put(ruleDetail.getRuleId().toString()+ruleDetail.getType().toString(),num+1);
                }
            }
            ProductRuleDetail ruleDetail;
            for (ProductRule productRule : list) {
                List<ProductRuleDetail> detailList = new ArrayList<>();
                if(!CommonUtil.isEmpty(detail.get(productRule.getId().toString()+"1"))){
                    ruleDetail = new ProductRuleDetail();
                    ruleDetail.setType(1);
                    ruleDetail.setUserdCount(detail.get(productRule.getId().toString()+"1"));
                    detailList.add(ruleDetail);
                }

                if(!CommonUtil.isEmpty(detail.get(productRule.getId().toString()+"2"))){
                    ruleDetail = new ProductRuleDetail();
                    ruleDetail.setType(2);
                    ruleDetail.setUserdCount(detail.get(productRule.getId().toString()+"2"));
                    detailList.add(ruleDetail);
                }

                if(!CommonUtil.isEmpty(detail.get(productRule.getId().toString()+"3"))){
                    ruleDetail = new ProductRuleDetail();
                    ruleDetail.setType(3);
                    ruleDetail.setUserdCount(detail.get(productRule.getId().toString()+"3"));
                    detailList.add(ruleDetail);
                }
                if(!CommonUtil.isEmpty(detail.get(productRule.getId().toString()+"4"))){
                    ruleDetail = new ProductRuleDetail();
                    ruleDetail.setType(4);
                    ruleDetail.setUserdCount(detail.get(productRule.getId().toString()+"4"));
                    detailList.add(ruleDetail);
                }
                productRule.setProductRuleDetailList(detailList);
            }
        }
        return new PageResult<>(list,count);
    }
    /**
     * 编辑平台规则
     **/
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model) {
        ProductRule productRule = productRuleService.getById(id);
        model.addAttribute("productRule",productRule);
        Product product = productService.getById(productRule.getProductId());
        model.addAttribute("product",product);
        return "intelligent/productRule/edit.html";
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
        List<ChannelTarget> channelTargets = channelTargetService.queryProductRuleDetailTargetList(id);
        List<ChannelTarget> oneList = new ArrayList<>();//平台准入
        List<ChannelTarget> twoList = new ArrayList<>();//债权人巡查
        List<ChannelTarget> treeList = new ArrayList<>();//债务人巡查
        List<ChannelTarget> fourList = new ArrayList<>();//债务人巡查
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
            }else if(targets.getType() == 4){
                fourList.add(targets);
            }
        }
        return JsonResult.ok().put("tree",result).put("oneList",oneList).put("twoList",twoList).put("treeList",treeList).put("fourList",fourList);
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
                boolean isExist = true;
                for(int i=0;i<channelTargets.size();i++){
                    if(channelTargets.get(i).getTargetId() == target.getTargetId()){
                        isExist = false;
                    }
                }
                if(isExist){
                    channelTargets.add(target);
                    params.put(target.getParentTargetId(),channelTargets);
                }
            }
        }
        for(Map.Entry<Integer,List<ChannelTarget>> entry :params.entrySet()){
            Map<String,Object> map = new HashMap<>();
            map.put("label",entry.getValue().get(0).getParentTargetName());
            map.put("value",entry.getKey());
            List<Map<String, Object>> lists = new ArrayList<>();
            for (ChannelTarget channelTarget : entry.getValue()) {
                Map<String, Object> child = new HashMap<>();
                child.put("label", channelTarget.getDictTargetName());
                child.put("value", channelTarget.getTargetId());
                List<Map<String, Object>> slists = new ArrayList<>();
                for (ChannelTarget target : list) {
                    if(target.getParentTargetId() == entry.getKey() && target.getTargetId() == channelTarget.getTargetId()){
                        Map<String, Object> schild = new HashMap<>();
                        schild.put("label", target.getTargetName());
                        schild.put("value", target.getId());
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
     * 获取指标分类
     */
    @ResponseBody
    @RequestMapping("/buildSelect")
    public JsonResult getBuildSelect(){
        List<Map<String, Object>> result = buildSelect();
        return JsonResult.ok().put("tree",result);
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
        if(!CommonUtil.isEmpty(params.get("tableAdmit"))){
            JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableAdmit")));
            common(jsonArray,ruleId,1);
        }
        if(!CommonUtil.isEmpty(params.get("tableCheck"))){
            JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableCheck")));
            common(jsonArray,ruleId,2);
        }
        if(!CommonUtil.isEmpty(params.get("tableScore"))){
            JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableScore")));
            common(jsonArray,ruleId,3);
        }
        if(!CommonUtil.isEmpty(params.get("tableTime"))){
            JSONArray jsonArray = JSONArray.parseArray(String.valueOf(params.get("tableTime")));
            common(jsonArray,ruleId,4);
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
        ProductRuleDetail productRuleDetail;
        for (int i=0;i<jsonArray.size();i++) {
            productRuleDetail = new ProductRuleDetail();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(!CommonUtil.isEmpty(jsonObject.get("parentIds"))){
                String[] parentIds = jsonObject.getString("parentIds").split(",");
                if(parentIds.length != 3 ){
                    throw new ParameterException(400,"编辑信息参数异常");
                }
                productRuleDetail.setChannelTargetId(Long.valueOf(parentIds[2]));
                productRuleDetail.setParentTargetId(Long.valueOf(parentIds[0]));
                productRuleDetail.setTargetId(Long.valueOf(parentIds[1]));

            }
            if(!CommonUtil.isEmpty(jsonObject.get("operator"))){
                productRuleDetail.setOperator(jsonObject.getInteger("operator"));
            }
            if(!CommonUtil.isEmpty(jsonObject.get("content"))){
                productRuleDetail.setContent(jsonObject.getString("content"));
            }
            if(CommonUtil.isEmpty(jsonObject.get("id"))){
                productRuleDetail.setType(type);
                productRuleDetail.setRuleId(ruleId);
                productRuleDetail.setCreateTime(LocalDateTime.now());
                productRuleDetail.setStatus(Constant.SYSTEM_STATUS_VALID);
                productRuleDetailService.save(productRuleDetail);
            }else{
                Long id = jsonObject.getLong("id");
                productRuleDetail.setId(id);
                productRuleDetailService.updateById(productRuleDetail);
            }
        }
        return JsonResult.ok();
    }
    /**
     * 编辑平台详情
     **/
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Long id, Model model) {
        ProductRule productRule = productRuleService.getById(id);
        Platform platform = platformService.getById(productRule.getPlatformId());
        model.addAttribute("productRule",productRule);
        model.addAttribute("platform",platform);
        Product product = productService.getById(productRule.getProductId());
        model.addAttribute("product",product);

        Map<String,Object> map = new HashMap<>();
        map.put("ruleId",id);
        List<ProductRuleApproval> ruleApprovalList = productRuleApprovalService.list(map);
        model.addAttribute("approvalList",ruleApprovalList);
        return "intelligent/productRule/view.html";
    }
}
