package com.cpiaoju.warn.contrpller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.company.model.WarningUser;
import com.cpiaoju.company.service.WarningUserService;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.order.model.OrderDO;
import com.cpiaoju.order.service.OrderService;
import com.cpiaoju.warn.model.*;
import com.cpiaoju.warn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 发票风险信息
 * </p>
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/invoiceWarning")
public class InvoiceController extends BaseController {

    @Autowired
    private InvoiceWarningLogService invoiceWarningLogService;
    @Autowired
    private WarningUserService warningUserService;
    @Autowired
    private InvoiceWarningContractService contractService;
    @Autowired
    private InvoiceWarningInvoiceService invoiceService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackAnnexService annexService;
    @Autowired
    private PlatformService platformService;

    @RequestMapping
    public String list(Model model) {
        return "afterloan/invoice/invoiceWarning.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<InvoiceWarningLog> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<InvoiceWarningLog> target = invoiceWarningLogService.list(query);
        int count = invoiceWarningLogService.count(query);
        return new PageResult<>(target,count);
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        InvoiceWarningLog byId = invoiceWarningLogService.getById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("warnId",id);
        List<WarningUser> warningUserList = warningUserService.list(map);
        List<String> collect = warningUserList.stream().map(c -> c.getUsername()).collect(Collectors.toList());
        byId.setNoticer(collect.toString());
        //预警信息
        Platform platform = platformService.getById(byId.getSource());
        byId.setPlatformName(platform.getPlatformName());
        model.addAttribute("warn",byId);
        //合同
        List<InvoiceWarningContract> contractList = contractService.list(map);
        for (InvoiceWarningContract contract : contractList) {
            List<InvoiceWarningInvoice> list = invoiceService.list(new QueryWrapper<InvoiceWarningInvoice>().eq("cid", contract.getId()));
            long count = list.stream().filter(o -> o.getIsWarn() == 1).count();
            contract.setInvoiceList(list);
            contract.setWarnCount(count);
        }
        model.addAttribute("contractList",contractList);
        //订单记录
        map.clear();
        map.put("companyId",byId.getCompanyId());
        map.put("status",6);
        List<OrderDO> orderList = orderService.list(map);
        model.addAttribute("orderList",orderList);
        //反馈记录
        map.clear();
        map.put("relationId",id);
        map.put("type",2);
        List<Feedback> feedbackList = feedbackService.list(map);
        for (Feedback feedback : feedbackList) {
            List<FeedbackAnnex> list = annexService.list(feedback.getId().intValue());
            feedback.setAnnexList(list);
        }

        model.addAttribute("feedbackList",feedbackList);

        return "afterloan/invoice/view.html";
    }

}
