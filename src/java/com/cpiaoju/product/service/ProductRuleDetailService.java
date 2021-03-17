package com.cpiaoju.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.product.model.ProductRuleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleDetailService extends IService<ProductRuleDetail> {

    List<ProductRuleDetail> list(@Param("ids") List<Long> ids);
}
