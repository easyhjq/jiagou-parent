package com.jiagou.store.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.jiagou.common.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.store.dao.StoreMapper;
import com.jiagou.store.vo.StoreModel;
import com.jiagou.store.vo.StoreQueryModel;

@Service
@Transactional
public class StoreService extends BaseServiceImpl<StoreModel> implements IStoreService{
	
	private StoreMapper mapper ;
	
	@Autowired
	public void setMapper(StoreMapper mapper){
		this.mapper = mapper;
		super.setBaseMapper(mapper);
	}
	

	public StoreMapper  getMapper() {
		
		return mapper;
	}
	
	@Override
	public PageInfo<StoreModel> getByConditionPage(StoreModel t) {
		
		StoreQueryModel cq = (StoreQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<StoreModel> list = mapper.getByConditionPage(cq);
		 	
		PageInfo<StoreModel> page = new PageInfo<StoreModel>(list);
		
		return page;
	}

	@Override
	public StoreModel getByStoreId(String StoreId) {
		
		return null;
	}


	@Override
	public StoreModel getByGoodsUuid(Integer goodsUuid) {
		// TODO Auto-generated method stub
		return mapper.getByGoodsUuid(goodsUuid);
	}
}