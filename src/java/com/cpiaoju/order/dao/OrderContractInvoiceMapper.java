package com.cpiaoju.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.order.model.OrderContractInvoice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易发票表; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface OrderContractInvoiceMapper extends BaseMapper<OrderContractInvoice> {

    List<OrderContractInvoice> list(@Param("ids") List<Integer> ids);
}
