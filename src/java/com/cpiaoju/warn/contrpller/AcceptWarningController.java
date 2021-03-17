package com.cpiaoju.warn.contrpller;


import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.company.model.WarningUser;
import com.cpiaoju.company.service.WarningUserService;
import com.cpiaoju.intelligent.model.Platform;
import com.cpiaoju.intelligent.service.PlatformService;
import com.cpiaoju.order.model.OrderDO;
import com.cpiaoju.order.model.OrderDetailDO;
import com.cpiaoju.order.service.OrderDetailService;
import com.cpiaoju.order.service.OrderService;
import com.cpiaoju.warn.model.AcceptWarningLog;
import com.cpiaoju.warn.model.Feedback;
import com.cpiaoju.warn.model.FeedbackAnnex;
import com.cpiaoju.warn.service.AcceptWarningLogService;
import com.cpiaoju.warn.service.AcceptWarningOrderService;
import com.cpiaoju.warn.service.FeedbackAnnexService;
import com.cpiaoju.warn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
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
 * 风险预警-承兑提示; InnoDB free: 8192 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
@Controller
@RequestMapping("/system/acceptWarning")
public class AcceptWarningController extends BaseController {

    @Autowired
    private AcceptWarningLogService acceptWarningLogService;
    @Autowired
    private AcceptWarningOrderService acceptWarningOrderService;
    @Autowired
    private WarningUserService warningUserService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackAnnexService annexService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping
    public String list(Model model) {
        return "afterloan/accept/acceptWarning.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<AcceptWarningLog> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<AcceptWarningLog> target = acceptWarningLogService.list(query);
        int count = acceptWarningLogService.count(query);
        return new PageResult<>(target,count);
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        AcceptWarningLog acceptWarning = acceptWarningLogService.getById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("warnId",id);
        map.put("type",3);
        List<WarningUser> warningUserList = warningUserService.list(map);

        List<String> collect = warningUserList.stream().map(c -> c.getUsername()).collect(Collectors.toList());
        acceptWarning.setNoticer(collect.toString());
        //预警信息
        Platform platform = platformService.getById(acceptWarning.getSource());
        acceptWarning.setPlatformName(platform.getPlatformName());
        model.addAttribute("warn",acceptWarning);
        //订单记录
        map.clear();
        map.put("companyId",acceptWarning.getCompanyId());
        map.put("status",6);
        List<OrderDO> orderList = orderService.list(map);
        model.addAttribute("orderList",orderList);
        OrderDO orderDO = orderService.get(acceptWarning.getOrderId());
        model.addAttribute("order",orderDO);
        map.clear();
        map.put("orderId", orderDO.getId());
        List<OrderDetailDO> orderDetails = orderDetailService.list(map);
        OrderDetailDO orderDetailDO;
        if(CollectionUtils.isEmpty(orderDetails)){
            orderDetailDO = new OrderDetailDO();
        }else{
            orderDetailDO = orderDetails.get(0);
        }
        model.addAttribute("orderDetail",orderDetailDO);
        //反馈记录
        map.clear();
        map.put("relationId",id);
        map.put("type",3);
        List<Feedback> feedbackList = feedbackService.list(map);
        for (Feedback feedback : feedbackList) {
            List<FeedbackAnnex> list = annexService.list(feedback.getId().intValue());
            feedback.setAnnexList(list);
        }
        model.addAttribute("feedbackList",feedbackList);
        return "afterloan/invoice/view.html";
    }

}
