package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.CompanyInspectionMapper;
import com.cpiaoju.warn.model.CompanyInspection;
import com.cpiaoju.warn.service.CompanyInspectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业巡查; InnoDB free: 8192 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-18
 */
@Service
public class CompanyInspectionServiceImpl extends ServiceImpl<CompanyInspectionMapper, CompanyInspection> implements CompanyInspectionService {

    @Override
    public List<CompanyInspection> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return this.baseMapper.count(map);
    }
}
