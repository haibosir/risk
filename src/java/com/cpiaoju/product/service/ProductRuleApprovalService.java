package com.cpiaoju.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.product.model.ProductRuleApproval;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleApprovalService extends IService<ProductRuleApproval> {

    List<ProductRuleApproval> list(Map<String,Object> map);

}
