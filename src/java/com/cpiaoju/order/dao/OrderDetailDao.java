package com.cpiaoju.order.dao;


import java.util.List;
import java.util.Map;

import com.cpiaoju.order.model.OrderDetailDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情; InnoDB free: 8192 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 14:08:48
 */
@Mapper
public interface OrderDetailDao {

	OrderDetailDO get(Integer id);
	
	List<OrderDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDetailDO orderDetail);
	
	int update(OrderDetailDO orderDetail);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
