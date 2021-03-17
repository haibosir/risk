package com.cpiaoju.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.company.dao.WarningUserMapper;
import com.cpiaoju.company.model.WarningUser;
import com.cpiaoju.company.service.WarningUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WarningUserServiceImpl extends ServiceImpl<WarningUserMapper, WarningUser> implements WarningUserService {


    @Override
    public List<WarningUser> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }
}
