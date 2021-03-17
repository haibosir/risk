package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.warn.dao.InvoiceWarningContractMapper;
import com.cpiaoju.warn.model.InvoiceWarningContract;
import com.cpiaoju.warn.service.InvoiceWarningContractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@Service
public class InvoiceWarningContractServiceImpl extends ServiceImpl<InvoiceWarningContractMapper, InvoiceWarningContract> implements InvoiceWarningContractService {

    @Override
    public List<InvoiceWarningContract> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }
}
