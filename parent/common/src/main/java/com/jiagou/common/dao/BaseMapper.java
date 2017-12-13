package com.jiagou.common.dao;

import java.util.List;


public interface BaseMapper<M>{
	
	public void create(M m);
	public void update(M m);
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	
	public List<M> getByConditionPage(M m);
}
