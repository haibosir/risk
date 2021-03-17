package com.cpiaoju.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.order.model.OrderContract;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface OrderContractMapper extends BaseMapper<OrderContract> {

    List<OrderContract> list(Map<String,Object> map);

}
