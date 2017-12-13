package com.jiagou.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.jiagou.cart.service.ICartService;
import com.jiagou.cart.vo.CartModel;
import com.jiagou.cart.vo.CartQueryModel;
import com.jiagou.common.format.DateFormatHelper;
import com.jiagou.goodsweb.service.IGoodsService;
import com.jiagou.goodsweb.vo.GoodsModel;
import com.jiagou.goodsweb.vo.GoodsQueryModel;
import com.jiagou.order.service.IOrderDetailService;
import com.jiagou.order.service.IOrderService;
import com.jiagou.order.vo.OrderDetailModel;
import com.jiagou.order.vo.OrderModel;
import com.jiagou.store.service.IStoreService;
import com.jiagou.store.vo.StoreModel;


@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private IGoodsService igs;
	@Autowired
	private ICartService ics;
	@Autowired
	private IOrderService ios ;
	@Autowired
	private IOrderDetailService iods ;
	@Autowired
	private IStoreService iss ;
	
	/*
	 * 首页展示商品列表
	 */
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(Model model){
		
		GoodsQueryModel gqm = new GoodsQueryModel();
		
		gqm.setPageSize(100);

		PageInfo<GoodsModel> page = igs.getByConditionPage(gqm);
		
		model.addAttribute("page",page);
		
		
		return "index";
	}
	
	/*
	 * 显示商品详情
	 */
	@RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
	public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
		
		GoodsModel gm = igs.getByUuid(goodsUuid);
		
		model.addAttribute("m",gm);
		return "goods/desc";
	}
	
	/*
	 * 添加到购物车
	 */
	@RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
	public String addToCart(Model model,@PathVariable("goodsUuid")int goodsUuid,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartModel cm = new CartModel();
		cm.setBuyNum(1);
		cm.setCustomerUuid(customerUuid);
		cm.setGoodsUuid(goodsUuid);
		
		ics.create(cm);
		///////////////////////////
		
		CartQueryModel cqm = new CartQueryModel();
		
		cqm.setPageSize(1000);
		
		cqm.setCustomerUuid(customerUuid);
		
		
		PageInfo<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	
	/*
	 * 查看购物车列表
	 */
	@RequestMapping(value="/toCart",method=RequestMethod.GET)
	public String toCart(Model model,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		
		cqm.setPageSize(1000);
		cqm.setCustomerUuid(customerUuid);
		
		PageInfo<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(@CookieValue("MyLogin") String myLogin){
		//1:查出这个人购物车所有的信息		
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.setCustomerUuid(customerUuid);
		PageInfo<CartModel> page = ics.getByConditionPage(cqm);
		float totalMoney = 0.0f;
		
		for(@SuppressWarnings("unused") CartModel cm:page.getList()){
			totalMoney += 10;
		}
		
		OrderModel order = new OrderModel();
		order.setCustomerUuid(customerUuid);
		order.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		order.setSaveMoney(0.0f);
		order.setTotalMoney(totalMoney);
		order.setState(1);
		ios.create(order);
		
		for(CartModel cm:page.getList()){
			
			OrderDetailModel odm = new OrderDetailModel();
			odm.setGoodsUuid(cm.getGoodsUuid());
			odm.setOrderNum(cm.getBuyNum());
			odm.setPrice(10.0f);
			odm.setMoney(odm.getPrice()*odm.getOrderNum());
			odm.setOrderUuid(order.getUuid());
			iods.create(odm);
			
			StoreModel storeModel = iss.getByGoodsUuid(cm.getGoodsUuid());
			storeModel.setStoreNum(storeModel.getStoreNum()-odm.getOrderNum());
			
			iss.update(storeModel);
			
			ics.delete(cm.getUuid());
		}
		
		return "success";
	}
}
