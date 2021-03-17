package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.InvoiceWarningLogMapper;
import com.cpiaoju.warn.model.InvoiceWarningLog;
import com.cpiaoju.warn.service.InvoiceWarningLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 发票预警信息; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@Service
public class InvoiceWarningLogServiceImpl extends ServiceImpl<InvoiceWarningLogMapper, InvoiceWarningLog> implements InvoiceWarningLogService {
    @Override
    public List<InvoiceWarningLog> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return this.baseMapper.count(map);
    }
}
