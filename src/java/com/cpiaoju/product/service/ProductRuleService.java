package com.cpiaoju.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.product.model.ProductRule;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品规则; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleService extends IService<ProductRule> {


    List<ProductRule> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
