package com.ssm.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.jiagou.customermgr.service.ICustomerService;
import com.jiagou.customermgr.vo.CustomerModel;
import com.jiagou.customermgr.vo.CustomerQueryModel;

public class StuMapperTest {



	@Test
	public void testFindAllStu() {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:resources/spring.xml","classpath:resources/spring-mvc.xml");
		
		ICustomerService customerMapper = act.getBean(ICustomerService.class);
		
		System.out.println(customerMapper);
		
//		CustomerModel cm = new CustomerModel();
//		
//		for(int i=0;i<10;i++){
//			  cm.setCustomerId("c1"+i);
//			  cm.setPwd("c1"+i);
//			  cm.setRegisterTime("2017-10-10");
//			  cm.setShowName("c1"+i);
//			  cm.setTrueName("张三"+i);
//			  customerMapper.create(cm);
//		 }
		
		CustomerQueryModel cqm =	new CustomerQueryModel();
		
		cqm.setPageSize(10);
		
		PageInfo<CustomerModel> page = customerMapper.getByConditionPage(cqm);
//				
		System.out.println(page.getList().size());
//		
		System.out.println(page.getList());
	
		
	}

	
}
