package com.cpiaoju.personal.controller;


import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.company.model.Company;
import com.cpiaoju.company.service.CompanyService;
import com.cpiaoju.personal.model.PersonalUser;
import com.cpiaoju.personal.service.PersonalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 个人用户; InnoDB free: 7168 kB 前端控制器
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/system/personal")
public class PersonalUserController extends BaseController {

    @Autowired
    private PersonalUserService personalUserService;

    @RequestMapping
    public String list(Model model) {
        return "userManager/personal/personal.html";
    }

    /**
     * 查询所有
     **/
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<PersonalUser> list(HttpServletRequest request) {
        PageParam pageParam = new PageParam(request);
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
            HashMap<String,Object> map = new HashMap<>();
            map.put("status",status);
            pageParam.setPageData(map);
        }
        List<PersonalUser> target = personalUserService.listFull(pageParam);
        return new PageResult<>(target);
    }

}
