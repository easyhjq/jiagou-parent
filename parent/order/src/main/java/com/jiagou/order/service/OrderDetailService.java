package com.jiagou.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.jiagou.common.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.order.dao.OrderDetailMapper;
import com.jiagou.order.vo.OrderDetailModel;
import com.jiagou.order.vo.OrderDetailQueryModel;

@Service
@Transactional
public class OrderDetailService extends BaseServiceImpl<OrderDetailModel> implements IOrderDetailService{
	
	private OrderDetailMapper mapper = null;
	
	@Autowired
	public void setMapper(OrderDetailMapper mapper){
		this.mapper = mapper;
		super.setBaseMapper(mapper);
	}
	

	public OrderDetailMapper  getMapper() {
		
		return mapper;
	}
	
	@Override
	public PageInfo<OrderDetailModel> getByConditionPage(OrderDetailModel t) {
		
		OrderDetailQueryModel cq = (OrderDetailQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<OrderDetailModel> list = mapper.getByConditionPage(cq);
		 	
		PageInfo<OrderDetailModel> page = new PageInfo<OrderDetailModel>(list);
		
		return page;
	}

	@Override
	public OrderDetailModel getByOrderDetailId(String OrderDetailId) {
		
		return null;
	}
}