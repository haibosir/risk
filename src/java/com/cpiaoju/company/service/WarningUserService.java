package com.cpiaoju.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.company.model.WarningUser;

import java.util.List;
import java.util.Map;

public interface WarningUserService extends IService<WarningUser> {

    List<WarningUser> list(Map<String,Object> map);

}
