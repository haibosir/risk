package com.cpiaoju.order.service.impl;

import com.cpiaoju.order.dao.OrderBankDao;
import com.cpiaoju.order.model.OrderBankDO;
import com.cpiaoju.order.service.OrderBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;




@Service
public class OrderBankServiceImpl implements OrderBankService {
	@Autowired
	private OrderBankDao orderBankDao;
	
	@Override
	public OrderBankDO get(Integer id){
		return orderBankDao.get(id);
	}
	
	@Override
	public List<OrderBankDO> list(Map<String, Object> map){
		return orderBankDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderBankDao.count(map);
	}
	
	@Override
	public int save(OrderBankDO orderBank){
		return orderBankDao.save(orderBank);
	}
	
	@Override
	public int update(OrderBankDO orderBank){
		return orderBankDao.update(orderBank);
	}
	
	@Override
	public int remove(Integer id){
		return orderBankDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderBankDao.batchRemove(ids);
	}
	
}
