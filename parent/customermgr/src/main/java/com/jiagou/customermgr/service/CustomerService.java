package com.jiagou.customermgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiagou.common.service.BaseServiceImpl;
import com.jiagou.customermgr.dao.CustomerMapper;
import com.jiagou.customermgr.vo.CustomerModel;
import com.jiagou.customermgr.vo.CustomerQueryModel;


@Service
@Transactional
public class CustomerService extends BaseServiceImpl<CustomerModel> implements ICustomerService{
	
	
	private CustomerMapper cMapper;
	

	public CustomerMapper  getcMapper() {
		
		return cMapper;
	}

	@Autowired
	public void setcMapper(CustomerMapper cMapper) {
		
		this.cMapper = cMapper;
		super.setBaseMapper(cMapper);
	}

	
	@Override
	public PageInfo<CustomerModel> getByConditionPage(CustomerModel t) {
		
		CustomerQueryModel cq = (CustomerQueryModel)t;
		
		PageHelper.startPage(cq.getPageNum(), cq.getPageSize());
		
		List<CustomerModel> list = cMapper.getByConditionPage(cq);
		 	
		PageInfo<CustomerModel> page = new PageInfo<CustomerModel>(list);
		
		return page;
	}

	@Override
	public CustomerModel getByCustomerId(String customerId) {
		
		return cMapper.getByCustomerId(customerId);
	}


	
}
