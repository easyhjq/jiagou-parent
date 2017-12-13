package com.jiagou.order.service;


import com.jiagou.common.service.IBaseService;

import com.jiagou.order.vo.OrderModel;


public interface IOrderService extends IBaseService<OrderModel>{
	
	public OrderModel getByOrderId(String OrderId);

	public void order(int customerUuid);
}

