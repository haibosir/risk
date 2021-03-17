package com.cpiaoju.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.product.model.ProductRuleApproval;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleApprovalMapper extends BaseMapper<ProductRuleApproval> {

    List<ProductRuleApproval> list(Map<String, Object> map);

    int count(Map<String, Object> map);

}
