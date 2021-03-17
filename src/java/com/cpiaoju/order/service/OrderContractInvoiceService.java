package com.cpiaoju.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.order.model.OrderContractInvoice;

import java.util.List;

/**
 * <p>
 * 无票保理-贸易发票表; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface OrderContractInvoiceService extends IService<OrderContractInvoice> {

    List<OrderContractInvoice> list(List<Integer> ids);

}
