package com.jiagou.store.dao;

import com.jiagou.common.annotation.MybatisMapper;
import com.jiagou.common.dao.BaseMapper;
import com.jiagou.store.vo.StoreModel;


@MybatisMapper
public interface StoreMapper extends BaseMapper<StoreModel>{

	StoreModel getByGoodsUuid(Integer goodsUuid);
	
}
