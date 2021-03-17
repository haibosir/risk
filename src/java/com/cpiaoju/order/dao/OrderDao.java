package com.cpiaoju.order.dao;

import java.util.List;
import java.util.Map;
import com.cpiaoju.order.model.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表; InnoDB free: 8192 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 11:00:50
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
