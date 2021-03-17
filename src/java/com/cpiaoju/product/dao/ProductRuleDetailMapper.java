package com.cpiaoju.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.product.model.ProductRuleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductRuleDetailMapper extends BaseMapper<ProductRuleDetail> {

    List<ProductRuleDetail> list(@Param("ids")List<Long> ids);
}
