package com.ssm.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.jiagou.cart.service.ICartService;
import com.jiagou.cart.vo.CartModel;
import com.jiagou.cart.vo.CartQueryModel;

public class StuMapperTest {

	
	@Test
	public void testFindAllStu() throws InterruptedException {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:resources/spring.xml","classpath:resources/spring-mvc.xml");
		
		final ICartService mapper = act.getBean(ICartService.class);
		
//		System.out.println(mapper);
//		
//		CartModel cm = new CartModel();
//		for(int i=0;i<10;i++){
//			cm.setBuyNum(3+i);
//			cm.setCustomerUuid(103+i);
//			cm.setGoodsUuid(104+i);
//			
//		
//			mapper.create(cm);
//		
//		}
		
//		CartQueryModel cqm =	new CartQueryModel(1,11);
//		
//		cqm.setCustomerUuid(1);
//		
//		PageInfo<CartModel> page = mapper.getByConditionPage(cqm);
//		
//		System.out.println(page);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				PageInfo<CartModel> page = mapper.getByConditionPage(new CartQueryModel());
				System.out.println(page.getList().size());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				PageInfo<CartModel> page = mapper.getByConditionPage(new CartQueryModel());
				System.out.println(page.getList().size());
				
				CartModel cm = new CartModel();
				cm.setBuyNum(301);
				cm.setCustomerUuid(301);
				cm.setGoodsUuid(301);
				
			
				mapper.create(cm);
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				PageInfo<CartModel> page = mapper.getByConditionPage(new CartQueryModel());
				System.out.println(page.getList().size());
			}
		});
		
			
		t1.start();
		
		Thread.sleep(3000);
		t2.start();
		
		Thread.sleep(3000);
		t3.start();
		
		Thread.sleep(30000);
		
		
		
	
		
	}

	
}
