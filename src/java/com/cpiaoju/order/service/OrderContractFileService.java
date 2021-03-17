package com.cpiaoju.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.order.model.OrderContractFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同附表; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface OrderContractFileService extends IService<OrderContractFile> {

    List<OrderContractFile> list(List<Integer> ids);

}
