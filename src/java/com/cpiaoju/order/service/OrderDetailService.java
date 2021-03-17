package com.cpiaoju.order.service;


import com.cpiaoju.order.model.OrderDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 订单详情; InnoDB free: 8192 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 14:08:48
 */
public interface OrderDetailService {
	
	OrderDetailDO get(Integer id);
	
	List<OrderDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDetailDO orderDetail);
	
	int update(OrderDetailDO orderDetail);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
