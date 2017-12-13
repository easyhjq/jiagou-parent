package com.jiagou.cart.vo;

import java.io.Serializable;

public class CartModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	private int uuid;
	private Integer customerUuid;
	private Integer goodsUuid;
	private Integer buyNum;
	
	public void setCustomerUuid(Integer obj){
		this.customerUuid = obj;
	}
	public Integer getCustomerUuid(){
		return this.customerUuid;
	}
	
	public void setGoodsUuid(Integer obj){
		this.goodsUuid = obj;
	}
	public Integer getGoodsUuid(){
		return this.goodsUuid;
	}
	
	public void setBuyNum(Integer obj){
		this.buyNum = obj;
	}
	public Integer getBuyNum(){
		return this.buyNum;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[customerUuid=" + this.getCustomerUuid() + ",goodsUuid=" + this.getGoodsUuid() + ",buyNum=" + this.getBuyNum() + ",]";
	}	
}
