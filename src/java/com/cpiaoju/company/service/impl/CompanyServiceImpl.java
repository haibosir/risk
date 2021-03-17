package com.cpiaoju.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.company.dao.CompanyMapper;
import com.cpiaoju.company.model.Company;
import com.cpiaoju.company.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Override
    public List<Company> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }

    @Override
    public Company get(Integer id) {
        return baseMapper.get(id);
    }
}
