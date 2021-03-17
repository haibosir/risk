package com.cpiaoju.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.order.dao.OrderAgreementMapper;
import com.cpiaoju.order.model.OrderAgreement;
import com.cpiaoju.order.service.OrderAgreementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单协议; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-30
 */
@Service
public class OrderAgreementServiceImpl extends ServiceImpl<OrderAgreementMapper, OrderAgreement> implements OrderAgreementService {

    @Override
    public List<OrderAgreement> list(Integer oid) {
        return this.baseMapper.list(oid);
    }
}
