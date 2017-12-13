package com.jiagou.goodsweb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiagou.common.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.goodsweb.dao.GoodsMapper;
import com.jiagou.goodsweb.vo.GoodsModel;
import com.jiagou.goodsweb.vo.GoodsQueryModel;

@Service
@Transactional
public class GoodsService extends BaseServiceImpl<GoodsModel> implements IGoodsService{
	
	private GoodsMapper mapper;
	
	@Autowired
	public void setMapper(GoodsMapper mapper){
		this.mapper = mapper;
		super.setBaseMapper(mapper);
	}
	

	public GoodsMapper  getMapper() {
		
		return mapper;
	}
	
	@Override
	public PageInfo<GoodsModel> getByConditionPage(GoodsModel t) {
		
		GoodsQueryModel cq = (GoodsQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<GoodsModel> list = mapper.getByConditionPage(cq);
		 	
		PageInfo<GoodsModel> page = new PageInfo<GoodsModel>(list);
		
		return page;
	}

	@Override
	public GoodsModel getByGoodsId(String GoodsId) {
		
		return null;
	}
}