package com.risk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.OrderDetailDao;
import com.risk.model.OrderDetail;

@Service("orderDetailsService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailDao orderDetailDao;
	
	@Override
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailDao.getOrderDetaiList();
	}

	@Override
	public void SaveOrderDetail(OrderDetail orderDetail) {
		orderDetailDao.SaveOrderDetail(orderDetail);
	}

	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) {
		orderDetailDao.deleteOrderDetail(orderDetail);
	}

	@Override
	public OrderDetail findById(int id) {
		// TODO Auto-generated method stub
		return orderDetailDao.findById(id);
	}

	
}
