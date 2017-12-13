package com.jiagou.order.service;


import com.jiagou.common.service.IBaseService;

import com.jiagou.order.vo.OrderDetailModel;


public interface IOrderDetailService extends IBaseService<OrderDetailModel>{
	
	public OrderDetailModel getByOrderDetailId(String OrderDetailId);
}

