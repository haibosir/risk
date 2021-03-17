package com.cpiaoju.order.controller;

import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.order.model.*;
import com.cpiaoju.order.service.*;
import com.cpiaoju.product.model.Product;
import com.cpiaoju.product.service.ProductService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 无票保理-订单表; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderContractFileService contractFileService;
    @Autowired
    private OrderContractInvoiceService contractInvoiceService;
    @Autowired
    private OrderContractService contractService;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderAgreementService agreementService;


    @RequestMapping
    public String order(Model model) {
        return "product/order/order.html";
    }
    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<OrderDO> list(@RequestParam Map<String,Object> map) {
        Query query = new Query(map);
        List<OrderDO> list = orderService.list(query);
        int count = orderService.count(map);
        return new PageResult<>(list,count);
    }

    @RequestMapping("/view/{id}")
    public String order(@PathVariable("id") Integer id, Model model) {

        OrderDO order = orderService.get(id);

        Product product = productService.getById(order.getProductId());

        Platform platform = platformService.getById(product.getSource());

        Map<String,Object> map = new HashMap<>();
        map.put("oid",id);
        List<OrderContract> contractList = contractService.list(map);//合同列表

        List<Integer> list = contractList.stream().map(c -> c.getId()).collect(Collectors.toList());

        List<OrderContractFile> fileList = contractFileService.list(list);

        List<OrderContractInvoice> invoiceList = contractInvoiceService.list(list);

        List<OrderContractFile> contractFiles;

        List<OrderContractInvoice> invoiceFiles;


        for (OrderContract orderContract : contractList) {

            for (OrderContractFile file : fileList) {

                if(orderContract.getId() == file.getCid()){

                    contractFiles = orderContract.getContractFiles();
                    if(CollectionUtils.isEmpty(contractFiles)){
                        contractFiles = new ArrayList<>();
                        contractFiles.add(file);
                        orderContract.setContractFiles(contractFiles);
                    }else{
                        contractFiles.add(file);
                        orderContract.setContractFiles(contractFiles);
                    }
                }
            }

            for (OrderContractInvoice invoice : invoiceList) {

                if(invoice.getCid() == orderContract.getId()){
                    invoiceFiles = orderContract.getInvoices();
                    if(CollectionUtils.isEmpty(invoiceFiles)){
                        invoiceFiles = new ArrayList<>();
                        invoiceFiles.add(invoice);
                        orderContract.setInvoices(invoiceFiles);
                    }else{
                        invoiceFiles.add(invoice);
                        orderContract.setInvoices(invoiceFiles);
                    }
                }
            }
        }
        order.setContracts(contractList);
        List<OrderAgreement> agreementList = agreementService.list(id);
        List<OrderAgreement> agreements = new ArrayList<>();
        List<OrderAgreement> otherFiles = new ArrayList<>();

        for (OrderAgreement agreement : agreementList) {
            if(agreement.getType() == 0){//协议
                agreements.add(agreement);
            }else{
                otherFiles.add(agreement);
            }
        }
        model.addAttribute("order",order);
        model.addAttribute("platform",platform);
        model.addAttribute("agreements",agreements);
        model.addAttribute("otherFiles",otherFiles);
        return "product/order/view.html";
    }


}
