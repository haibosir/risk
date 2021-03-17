package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.CompanyWarningLogMapper;
import com.cpiaoju.warn.model.CompanyWarningLog;
import com.cpiaoju.warn.service.CompanyWarningLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警记录(企业风险,发票风险,承兑风险); InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class CompanyWarningLogServiceImpl extends ServiceImpl<CompanyWarningLogMapper, CompanyWarningLog> implements CompanyWarningLogService {

    @Override
    public List<CompanyWarningLog> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return this.baseMapper.count(map);
    }
}
