package com.cpiaoju.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/productOrder")
public class ProductOrderController extends BaseController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PlatformService platformService;

    @RequestMapping
    public String list(Model model) {
        List<Platform> platformList = platformService.list(new QueryWrapper<Platform>().eq("status", 0));
        model.addAttribute("platformList", platformList);
        return "product/order/productOrder.html";
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



}
