package com.jiagou.cart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.cart.dao.CartMapper;
import com.jiagou.cart.vo.CartModel;
import com.jiagou.cart.vo.CartQueryModel;
import com.jiagou.common.service.BaseServiceImpl;

@Service
@Transactional
public class CartService extends BaseServiceImpl<CartModel> implements ICartService{
	
	private CartMapper mapper = null;
	
	@Autowired
	public void setMapper(CartMapper mapper){
		this.mapper = mapper;
		super.setBaseMapper(mapper);
	}
	

	public CartMapper  getMapper() {
		
		return mapper;
	}
	
	@Override
	public PageInfo<CartModel> getByConditionPage(CartModel t) {
		
		CartQueryModel cq = (CartQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<CartModel> list = mapper.getByConditionPage(cq);
	
		PageInfo<CartModel> page = new PageInfo<CartModel>(list);
		
		return page;
	}

	@Override
	public CartModel getByCartId(String CartId) {
		
		return null;
	}
}