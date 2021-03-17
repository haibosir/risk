package com.cpiaoju.company.controller;


import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.company.model.Company;
import com.cpiaoju.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/companyUser")
public class CompanyUserController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping
    public String list(Model model) {
        return "userManager/company/company.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Company> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<Company> target = companyService.list(query);
        int count = companyService.count(query);
        return new PageResult<>(target,count);
    }

}
