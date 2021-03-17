package com.cpiaoju.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.order.model.OrderContractFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 无票保理-贸易合同附表; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface OrderContractFileMapper extends BaseMapper<OrderContractFile> {

    List<OrderContractFile> list(@Param("ids") List<Integer> ids);
}
