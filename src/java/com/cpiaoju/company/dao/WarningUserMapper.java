package com.cpiaoju.company.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.company.model.WarningUser;

import java.util.List;
import java.util.Map;

public interface WarningUserMapper extends BaseMapper<WarningUser> {

    List<WarningUser> list(Map<String,Object> map);
}
