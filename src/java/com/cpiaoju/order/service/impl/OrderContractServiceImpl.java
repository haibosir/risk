package com.cpiaoju.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.order.dao.OrderContractMapper;
import com.cpiaoju.order.model.OrderContract;
import com.cpiaoju.order.service.OrderContractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class OrderContractServiceImpl extends ServiceImpl<OrderContractMapper, OrderContract> implements OrderContractService {

    @Override
    public List<OrderContract> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }
}
