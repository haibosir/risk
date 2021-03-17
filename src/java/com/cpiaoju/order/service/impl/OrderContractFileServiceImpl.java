package com.cpiaoju.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.order.dao.OrderContractFileMapper;
import com.cpiaoju.order.model.OrderContractFile;
import com.cpiaoju.order.service.OrderContractFileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同附表; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class OrderContractFileServiceImpl extends ServiceImpl<OrderContractFileMapper, OrderContractFile> implements OrderContractFileService {

    @Override
    public List<OrderContractFile> list(List<Integer> ids) {
        return this.baseMapper.list(ids);
    }
}
