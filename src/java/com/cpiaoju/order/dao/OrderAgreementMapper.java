package com.cpiaoju.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.order.model.OrderAgreement;

import java.util.List;

/**
 * <p>
 * 订单协议; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-30
 */
public interface OrderAgreementMapper extends BaseMapper<OrderAgreement> {

    List<OrderAgreement> list(Integer oid);
}
