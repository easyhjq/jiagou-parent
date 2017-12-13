package com.jiagou.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.jiagou.common.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.order.dao.OrderMapper;
import com.jiagou.order.vo.OrderModel;
import com.jiagou.order.vo.OrderQueryModel;


@Service
@Transactional
public class OrderService extends BaseServiceImpl<OrderModel> implements IOrderService{
	
	private OrderMapper mapper = null;
	
	@Autowired
	public void setMapper(OrderMapper mapper){
		this.mapper = mapper;
		super.setBaseMapper(mapper);
	}
	

	public OrderMapper  getMapper() {
		
		return mapper;
	}
	
	@Override
	public PageInfo<OrderModel> getByConditionPage(OrderModel t) {
		
		OrderQueryModel cq = (OrderQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<OrderModel> list = mapper.getByConditionPage(cq);
		 	
		PageInfo<OrderModel> page = new PageInfo<OrderModel>(list);
		
		return page;
	}

	@Override
	public OrderModel getByOrderId(String OrderId) {
		
		return null;
	}


	@Override
	public void order(int customerUuid) {
		// TODO Auto-generated method stub
		
	}
}