package com.jiagou.common.service;

import com.github.pagehelper.PageInfo;

public interface IBaseService<T> {
	
	public void create(T t);
	public void update(T t);
	public void delete(int uuid);
	
	public T getByUuid(int uuid);
	
	public PageInfo<T> getByConditionPage(T t);
}
