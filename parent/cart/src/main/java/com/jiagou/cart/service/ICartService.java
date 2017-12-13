package com.jiagou.cart.service;


import com.jiagou.cart.vo.CartModel;
import com.jiagou.common.service.IBaseService;

public interface ICartService extends IBaseService<CartModel>{
	
	public CartModel getByCartId(String CartId);
}

