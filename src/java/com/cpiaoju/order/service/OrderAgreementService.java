package com.cpiaoju.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.order.model.OrderAgreement;

import java.util.List;

/**
 * <p>
 * 订单协议; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-30
 */
public interface OrderAgreementService extends IService<OrderAgreement> {

    List<OrderAgreement> list(Integer oid);
}
