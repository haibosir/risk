package com.cpiaoju.order.service.impl;

import com.cpiaoju.order.dao.OrderDetailDao;
import com.cpiaoju.order.model.OrderDetailDO;
import com.cpiaoju.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Override
	public OrderDetailDO get(Integer id){
		return orderDetailDao.get(id);
	}
	
	@Override
	public List<OrderDetailDO> list(Map<String, Object> map){
		return orderDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderDetailDao.count(map);
	}
	
	@Override
	public int save(OrderDetailDO orderDetail){
		return orderDetailDao.save(orderDetail);
	}
	
	@Override
	public int update(OrderDetailDO orderDetail){
		return orderDetailDao.update(orderDetail);
	}
	
	@Override
	public int remove(Integer id){
		return orderDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderDetailDao.batchRemove(ids);
	}
	
}
