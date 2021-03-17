package com.cpiaoju.order.service;

import com.cpiaoju.order.model.OrderBankDO;
import java.util.List;
import java.util.Map;

/**
 * 订单--银行信息; InnoDB free: 8192 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 11:00:50
 */
public interface OrderBankService {
	
	OrderBankDO get(Integer id);
	
	List<OrderBankDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderBankDO orderBank);
	
	int update(OrderBankDO orderBank);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
