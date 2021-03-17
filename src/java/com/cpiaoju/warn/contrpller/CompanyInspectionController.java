package com.cpiaoju.warn.contrpller;


import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.company.model.Company;
import com.cpiaoju.company.service.CompanyService;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.service.DictService;
import com.cpiaoju.warn.model.CompanyInspection;
import com.cpiaoju.warn.service.CompanyInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业巡查; InnoDB free: 8192 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2021-01-18
 */
@Controller
@RequestMapping("/system/inspection")
public class CompanyInspectionController extends BaseController {

    @Autowired
    private CompanyInspectionService companyInspectionService;

    @Autowired
    private DictService dictService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping
    public String list(Model model) {
        return "afterloan/inspection/list.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<CompanyInspection> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<CompanyInspection> target = companyInspectionService.list(query);
        int count = companyInspectionService.count(query);
        return new PageResult<>(target,count);
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        CompanyInspection inspection = companyInspectionService.getById(id);
        Company company = companyService.get(inspection.getCompanyId());
        model.addAttribute("inspection",inspection);
        model.addAttribute("company",company);
        Map<String,Object> map = new HashMap<>();
        map.put("type","space");
        List<DictDO> spaceList = dictService.list(map);
        model.addAttribute("spaceList",spaceList);
        map.clear();
        map.put("type","level");
        List<DictDO> levelList = dictService.list(map);
        model.addAttribute("levelList",levelList);
        return "afterloan/inspection/edit.html";
    }


    /**
     * 保存渠道
     **/
    @ResponseBody
    @RequestMapping("/update")
    @Transactional
    public JsonResult upadte(CompanyInspection inspection) {
        if(companyInspectionService.updateById(inspection)){
            return JsonResult.ok();
        }
        return JsonResult.error("添加失败");
    }
}
