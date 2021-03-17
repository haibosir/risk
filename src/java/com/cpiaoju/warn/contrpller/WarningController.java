package com.cpiaoju.warn.contrpller;

import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.company.model.WarningUser;
import com.cpiaoju.company.service.*;
import com.cpiaoju.order.model.OrderDO;
import com.cpiaoju.order.service.OrderService;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.service.DictService;
import com.cpiaoju.warn.model.*;
import com.cpiaoju.warn.service.CompanyWarnDetailService;
import com.cpiaoju.warn.service.CompanyWarningLogService;
import com.cpiaoju.warn.service.FeedbackAnnexService;
import com.cpiaoju.warn.service.FeedbackService;
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
 * 风险信息; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/companyWarning")
public class WarningController extends BaseController {

    @Autowired
    private CompanyWarningLogService warningLogService;
    @Autowired
    private WarningUserService warningUserService;
    @Autowired
    private CompanyWarnDetailService warnDetailService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DictService dictService;
    @Autowired
    private FeedbackAnnexService annexService;

    @RequestMapping
    public String list(Model model) {
        return "afterloan/company/companyWarning.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<CompanyWarningLog> list(@RequestParam Map<String,Object> params) {
        Query query = new Query(params);
        List<CompanyWarningLog> target = warningLogService.list(query);
        int count = warningLogService.count(query);
        return new PageResult<>(target,count);
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {

        CompanyWarningLog warningLog = warningLogService.getById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("warnId",id);
        List<WarningUser> warningUserList = warningUserService.list(map);
        List<String> collect = warningUserList.stream().map(c -> c.getUsername()).collect(Collectors.toList());
        warningLog.setNoticer(collect.toString());

        DictDO dictDO = dictService.get(warningLog.getSpace().longValue());
        warningLog.setSpaceName(dictDO.getName());
        model.addAttribute("warn",warningLog);

        List<CompanyWarnDetail> detailList = warnDetailService.list(map);
        List<PackageWarnDetail> packageWarnDetailList = new ArrayList<>();
        List<CompanyWarnDetail> resultList;
        PackageWarnDetail detail;
        for(int i=0;i<detailList.size();i++){
            detail = new PackageWarnDetail();
            resultList = new ArrayList<>();
            resultList.add(detailList.get(i));
            if(i != detailList.size()-1){
                resultList.add(detailList.get(i+1));
            }
            detail.setDetailList(resultList);
            packageWarnDetailList.add(detail);
            i ++;
        }
        model.addAttribute("detailList",packageWarnDetailList);
        //订单记录
        map.clear();
        map.put("companyId",warningLog.getCompanyId());
        map.put("status",7);
        List<OrderDO> orderList = orderService.list(map);
        model.addAttribute("orderList",orderList);
        //反馈记录
        map.clear();
        map.put("relationId",id);
        map.put("type",1);
        List<Feedback> feedbackList = feedbackService.list(map);
        for (Feedback feedback : feedbackList) {
            List<FeedbackAnnex> list = annexService.list(feedback.getId().intValue());
            feedback.setAnnexList(list);
        }

        model.addAttribute("feedbackList",feedbackList);


        return "afterloan/company/view.html";
    }
}
