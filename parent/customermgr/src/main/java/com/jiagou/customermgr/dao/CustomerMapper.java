package com.jiagou.customermgr.dao;

import com.jiagou.common.annotation.MybatisMapper;
import com.jiagou.common.dao.BaseMapper;
import com.jiagou.customermgr.vo.CustomerModel;

@MybatisMapper
public interface CustomerMapper extends BaseMapper<CustomerModel>{

	CustomerModel getByCustomerId(String customerId);
	
	
	
}
              
                
                       
                                  
                                                        
                       