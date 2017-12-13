package com.jiagou.store.service;


import com.jiagou.common.service.IBaseService;

import com.jiagou.store.vo.StoreModel;


public interface IStoreService extends IBaseService<StoreModel>{
	
	public StoreModel getByStoreId(String StoreId);

	public StoreModel getByGoodsUuid(Integer goodsUuid);
}

