package com.bao.order.service;

import java.util.List;

import com.bao.order.dao.OrderDao;
import com.bao.order.domain.Order;



public class OrderService {
	
	  OrderDao orderDao = new OrderDao();	
	
	  //�����û���ѯ ������Ϣ
	  public List<Order> findByUid(String uid){		  
		  List<Order> orderList = orderDao.findByUid(uid);
		  return orderList;
	  }
	  
	  //���Ӷ�����¼
	  public boolean addOrder(Order order){
		  int num=orderDao.addOrder(order);
		  if(num!=0){
			  return true;
		  }else{
			  return false;
		  }
	  }
}
