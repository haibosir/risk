package com.cpiaoju.company.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.company.model.*;
import com.cpiaoju.company.service.*;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.service.DictService;
import com.cpiaoju.warn.model.CompanyWarningLog;
import com.cpiaoju.warn.service.CompanyWarningLogService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DictService dictService;
    @Autowired
    private CompanyAgentService companyAgentService;
    @Autowired
    private CompanyLicenseService companyLicenseService;
    @Autowired
    private CompanyShareholderService shareholderService;
    @Autowired
    private CompanyMemberService companyMemberService;
    @Autowired
    private CompanyInvestmentService investmentService;
    @Autowired
    private CompanyBeneficiaryService beneficiaryService;
    @Autowired
    private HoldingCompanyService holdingCompanyService;
    @Autowired
    private CompanyBranchService branchService;
    @Autowired
    private CompanyChangeLogService logService;
    @Autowired
    private CompanyLogService companyLogService;
    @Autowired
    private CompanyCreditService creditService;

    @Autowired
    private CompanyWarningLogService warningLogService;
    @Autowired
    private PlatformService platformService;


    @RequestMapping
    public String list(Model model) {
        List<Platform> platformList = platformService.list(new QueryWrapper<Platform>().eq("status", 0));
        model.addAttribute("platformList", platformList);
        return "userManager/whiteCompany/company.html";
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

    @RequestMapping("/blackList")
    public String blackList(Model model) {
        List<Platform> platformList = platformService.list(new QueryWrapper<Platform>().eq("status", 0));
        model.addAttribute("platformList", platformList);
        return "userManager/blackCompany/company.html";
    }

    /**
     * 白黑名单转移
     **/
    @ResponseBody
    @RequestMapping("/changeStatus")
    public JsonResult remove(Integer id) {
        Company company = companyService.getById(id);
        if(company.getStatus() == 0){
            company.setStatus(Constant.SYSTEM_STATUS_UNVALID);
        }else{
            company.setStatus(Constant.SYSTEM_STATUS_VALID);
        }
        if (companyService.updateById(company)) {
            return JsonResult.ok();
        }
        return JsonResult.error("删除失败");
    }


    @RequestMapping("/add")
    public String add(Model model) {
        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","company_nature");
        List<DictDO> companyType = dictService.list(queryWrapper);
        model.addAttribute("companyNatures",companyType);

        queryWrapper.put("type","platform");
        List<DictDO> sources = dictService.list(queryWrapper);
        model.addAttribute("sources",sources);
        return "userManager/blackCompany/add.html";
    }


    /**
     * 添加企业
     **/
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Company company) {
        company.setStatus(Constant.SYSTEM_STATUS_UNVALID);
        company.setCreateTime(new Date());
        company.setInTime(new Date());
        company.setUpdateTime(new Date());
        if (companyService.save(company)) {
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
        if (companyService.removeById(id)) {
            return JsonResult.ok();
        }
        return JsonResult.error("删除失败");
    }


    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model) {
        Map<String,Object> queryWrapper = new HashMap();
        queryWrapper.put("type","company_nature");
        List<DictDO> companyType = dictService.list(queryWrapper);
        model.addAttribute("companyNatures",companyType);

        queryWrapper.put("type","platform");
        List<DictDO> sources = dictService.list(queryWrapper);
        model.addAttribute("sources",sources);
        Company company = companyService.getById(id);
        model.addAttribute("company",company);
        return "userManager/blackCompany/edit.html";
    }
    /**
     * 修改企业
     **/
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Company company) {
        if (companyService.updateById(company)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id,Model model) {
        Company company = companyService.get(id);
        model.addAttribute("company",company);
        //经办人信息
        List<CompanyAgent> agentList = companyAgentService.list(new QueryWrapper<CompanyAgent>().eq("company_id", id));
        CompanyAgent companyAgent;
        if(CollectionUtils.isEmpty(agentList)){
            companyAgent = new CompanyAgent();
        }else{
            companyAgent = agentList.get(0);
        }
        model.addAttribute("companyAgent",companyAgent);
        //执照信息
        List<CompanyLicense> licenseList = companyLicenseService.list(new QueryWrapper<CompanyLicense>().eq("company_id", id));
        CompanyLicense companyLicense;
        if(CollectionUtils.isEmpty(licenseList)){
            companyLicense = new CompanyLicense();
        }else{
            companyLicense = licenseList.get(0);
        }
        model.addAttribute("companyLicense",companyLicense);
        //股东信息
        List<CompanyShareholder> shareholderList = shareholderService.list(new QueryWrapper<CompanyShareholder>().eq("company_id", id));
        if(CollectionUtils.isEmpty(shareholderList)){
            shareholderList = new ArrayList<>();
        }
        model.addAttribute("shareholderList",shareholderList);
        //主要成员
        List<CompanyMember> list = companyMemberService.list(new QueryWrapper<CompanyMember>().eq("company_id", id));
        if(CollectionUtils.isEmpty(list)){
            list = new ArrayList<>();
        }
        model.addAttribute("memberList",list);
        //对外投资
        List<CompanyInvestment> investmentList = investmentService.list(new QueryWrapper<CompanyInvestment>().eq("company_id", id));
        if(CollectionUtils.isEmpty(investmentList)){
            investmentList = new ArrayList<>();
        }
        model.addAttribute("investmentList",investmentList);
        //最终收益人
        List<CompanyBeneficiary> beneficiariesList = beneficiaryService.list(new QueryWrapper<CompanyBeneficiary>().eq("company_id", id));
        if(CollectionUtils.isEmpty(beneficiariesList)){
            beneficiariesList = new ArrayList<>();
        }
        model.addAttribute("beneficiariesList",beneficiariesList);
        //控股企业
        List<HoldingCompany> holdingCompanyList = holdingCompanyService.list(new QueryWrapper<HoldingCompany>().eq("company_id", id));
        if(CollectionUtils.isEmpty(holdingCompanyList)){
            holdingCompanyList = new ArrayList<>();
        }
        model.addAttribute("holdingCompanyList",holdingCompanyList);
        //分支机构
        List<CompanyBranch> branchList = branchService.list(new QueryWrapper<CompanyBranch>().eq("company_id", id));
        if(CollectionUtils.isEmpty(branchList)){
            branchList = new ArrayList<>();
        }
        model.addAttribute("branchList",branchList);
        //日志记录
        List<CompanyChangeLog> logList = logService.list(new QueryWrapper<CompanyChangeLog>().eq("company_id", id));
        if(CollectionUtils.isEmpty(logList)){
            logList = new ArrayList<>();
        }
        model.addAttribute("logList",logList);
        //内控记录
        List<CompanyLog> companyLogList = companyLogService.list(new QueryWrapper<CompanyLog>().eq("company_id", id));
        if(CollectionUtils.isEmpty(companyLogList)){
            companyLogList = new ArrayList<>();
        }
        model.addAttribute("companyLogList",companyLogList);
        //授信记录
        List<CompanyCredit> creditList = creditService.list(new QueryWrapper<CompanyCredit>().eq("company_id", id));
        if(CollectionUtils.isEmpty(creditList)){
            creditList = new ArrayList<>();
        }
        model.addAttribute("creditList",creditList);

        List<CompanyWarningLog> warningLogList = warningLogService.list(new QueryWrapper<CompanyWarningLog>().eq("company_id", id));
        if(CollectionUtils.isEmpty(warningLogList)){
            warningLogList = new ArrayList<>();
        }
        model.addAttribute("warningLogList",warningLogList);

        return "userManager/company/view.html";
    }
}
