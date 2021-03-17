package com.cpiaoju.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.product.dao.ProductRuleMapper;
import com.cpiaoju.product.model.ProductRule;
import com.cpiaoju.product.service.ProductRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品规则; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class ProductRuleServiceImpl extends ServiceImpl<ProductRuleMapper, ProductRule> implements ProductRuleService {

    @Override
    public List<ProductRule> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
