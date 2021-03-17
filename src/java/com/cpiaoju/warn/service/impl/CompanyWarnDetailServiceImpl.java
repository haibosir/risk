package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.CompanyWarnDetailMapper;
import com.cpiaoju.warn.model.CompanyWarnDetail;
import com.cpiaoju.warn.service.CompanyWarnDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警信息; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class CompanyWarnDetailServiceImpl extends ServiceImpl<CompanyWarnDetailMapper, CompanyWarnDetail> implements CompanyWarnDetailService {

    @Override
    public List<CompanyWarnDetail> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }
}
