package com.cpiaoju.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.product.dao.ProductRuleDetailMapper;
import com.cpiaoju.product.model.ProductRuleDetail;
import com.cpiaoju.product.service.ProductRuleDetailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class ProductRuleDetailServiceImpl extends ServiceImpl<ProductRuleDetailMapper, ProductRuleDetail> implements ProductRuleDetailService {

    @Override
    public List<ProductRuleDetail> list(List<Long> ids) {
        return baseMapper.list(ids);
    }
}
