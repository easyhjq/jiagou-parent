package com.ssm.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiagou.goodsweb.service.IGoodsService;
import com.jiagou.goodsweb.vo.GoodsModel;

public class StuMapperTest {

	
	@Test
	public void testFindAllStu() throws InterruptedException {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:resources/spring.xml","classpath:resources/spring-mvc.xml");
		
		final IGoodsService mapper = act.getBean(IGoodsService.class);
		
		System.out.println(mapper);
		
		GoodsModel cm = new GoodsModel();
		
		for(int i=0;i<50;i++){
			cm.setName("饮料"+i);
			cm.setImgPath("G:/img/1.jpg");
			cm.setDescription("产品"+i);
			mapper.create(cm);
		}
		
		
		
	}

	
}
