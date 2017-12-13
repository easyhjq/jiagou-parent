package com.jiagou.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jiagou.common.dao.BaseMapper;

public class BaseServiceImpl<T> implements IBaseService<T> {

	
	private BaseMapper<T> baseMapper;
	
	@Override
	public void create(T t) {
		
		this.baseMapper.create(t);
	}

	@Override
	public void update(T t) {
		
		baseMapper.update(t);	
	}

	@Override
	public void delete(int uuid) {
		
		baseMapper.delete(uuid);
	}

	@Override
	public T getByUuid(int uuid) {
		
		return baseMapper.getByUuid(uuid);
	}

	@Override
	public PageInfo<T> getByConditionPage(T t) {
		
		
		List<T> list = baseMapper.getByConditionPage(t);
		
		PageInfo<T> page = new PageInfo<T>(list);
		
		return page;
	}

	public BaseMapper<T> getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

}
