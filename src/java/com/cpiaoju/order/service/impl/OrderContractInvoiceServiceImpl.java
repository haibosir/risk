package com.cpiaoju.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.order.dao.OrderContractInvoiceMapper;
import com.cpiaoju.order.model.OrderContractInvoice;
import com.cpiaoju.order.service.OrderContractInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 无票保理-贸易发票表; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class OrderContractInvoiceServiceImpl extends ServiceImpl<OrderContractInvoiceMapper, OrderContractInvoice> implements OrderContractInvoiceService {

    @Override
    public List<OrderContractInvoice> list(List<Integer> ids) {
        return this.baseMapper.list(ids);
    }
}
