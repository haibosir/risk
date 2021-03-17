package com.cpiaoju.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.product.dao.ProductRuleApprovalMapper;
import com.cpiaoju.product.model.ProductRuleApproval;
import com.cpiaoju.product.service.ProductRuleApprovalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class ProductRuleApprovalServiceImpl extends ServiceImpl<ProductRuleApprovalMapper, ProductRuleApproval> implements ProductRuleApprovalService {

    @Override
    public List<ProductRuleApproval> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }
}
