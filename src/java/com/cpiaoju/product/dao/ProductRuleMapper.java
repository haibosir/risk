package com.cpiaoju.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.product.model.ProductRule;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品规则; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleMapper extends BaseMapper<ProductRule> {

    List<ProductRule> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
