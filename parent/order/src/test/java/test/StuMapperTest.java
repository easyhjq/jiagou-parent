
package test;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiagou.common.format.DateFormatHelper;
import com.jiagou.order.service.IOrderService;
import com.jiagou.order.vo.OrderModel;

public class StuMapperTest {

	
	@Test
	public void testFindAllStu() throws InterruptedException {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:resources/spring.xml","classpath:resources/spring-mvc.xml");
		
		IOrderService ios = act.getBean(IOrderService.class);
		
		OrderModel order = new OrderModel();
		order.setCustomerUuid(1);
		order.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		order.setSaveMoney(0.0f);
		order.setTotalMoney(100.0f);
		order.setState(1);
		ios.create(order);
		
		System.out.println(order.getUuid());
	
		
	}

	
}
