package com.jiagou.goodsweb.service;


import com.jiagou.common.service.IBaseService;
import com.jiagou.goodsweb.vo.GoodsModel;

public interface IGoodsService extends IBaseService<GoodsModel>{
	
	public GoodsModel getByGoodsId(String GoodsId);
}

