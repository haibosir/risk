package com.cpiaoju.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.company.model.Company;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.product.model.Product;
import com.cpiaoju.product.model.ProductApprovalLog;
import com.cpiaoju.product.model.ProductFile;
import com.cpiaoju.product.service.ProductApprovalLogService;
import com.cpiaoju.product.service.ProductFileService;
import com.cpiaoju.product.service.ProductService;
import com.cpiaoju.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 产品; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/product")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private ProductFileService productFileService;
    @Autowired
    private ProductApprovalLogService logService;

    @RequestMapping
    public String list(Model model) {
        List<Platform> platformList = platformService.list(new QueryWrapper<Platform>().eq("status", 0));
        model.addAttribute("platformList", platformList);
        return "product/product/product.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<Product> list(@RequestParam  Map<String,Object> map) {
        Query query = new Query(map);
        List<Product> list = productService.list(query);
        int count = productService.count(map);
        return new PageResult<>(list,count);
    }

    /**
     * 详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        common(id,model);
        return "product/product/view.html";
    }

    @RequestMapping("/wait")
    public String wait(Model model) {
        List<Platform> platformList = platformService.list(new QueryWrapper<Platform>().eq("status", 0));
        model.addAttribute("platformList", platformList);
        return "product/product/approval.html";
    }

    /**
     * 审核
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/examine/{id}")
    public String examine(@PathVariable("id") Integer id, Model model) {
        common(id,model);
        return "product/product/examine.html";
    }

    /**
     * 处理审核和详情公共数据
     * @param id
     * @param model
     * @return
     */
    public Model common(Integer id,Model model){
        Product product = productService.getById(id);
        List<ProductFile> productFileList = productFileService.list(new QueryWrapper<ProductFile>().eq("product_id", id));
        List<ProductFile> createProductList = new ArrayList<>();
        List<ProductFile> orderProductList = new ArrayList<>();
        List<ProductFile> pdfProductList = new ArrayList<>();
        for (ProductFile file : productFileList) {
            if("1".equals(file.getFileType())){
                createProductList.add(file);
            }else if("2".equals(file.getFileType())){
                orderProductList.add(file);
            }else if("3".equals(file.getFileType())){
                pdfProductList.add(file);
            }
        }
        List<ProductApprovalLog> logList = logService.list(new QueryWrapper<ProductApprovalLog>().eq("product_id", id));
        model.addAttribute("product",product);
        model.addAttribute("createProductList",createProductList);
        model.addAttribute("orderProductList",orderProductList);
        model.addAttribute("pdfProductList",pdfProductList);
        model.addAttribute("logList",logList);
        return model;
    }


    /**
     * 产品审核
     **/
    @ResponseBody
    @RequestMapping("/approval")
    public JsonResult remove(ProductApprovalLog approvalLog) {
        User loginUser = getLoginUser();
        approvalLog.setApprovalPost(loginUser.getRoleNames());
        approvalLog.setApprovalUser(loginUser.getUsername());
        approvalLog.setCreateTime(new Date());
        if(logService.save(approvalLog)){
            Product product = new Product();
            product.setId(approvalLog.getProductId());
            product.setApprovalStatus(approvalLog.getStatus());
            productService.updateById(product);
            return JsonResult.ok();
        }
        return JsonResult.error("删除失败");
    }
}
