package com.jiagou.customermgr.service;

import com.jiagou.common.service.IBaseService;
import com.jiagou.customermgr.vo.CustomerModel;

public interface ICustomerService extends IBaseService<CustomerModel>{
	
	public CustomerModel getByCustomerId(String customerId);
	
}
