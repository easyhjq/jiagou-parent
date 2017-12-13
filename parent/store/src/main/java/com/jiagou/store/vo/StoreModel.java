package com.jiagou.store.vo;



public class StoreModel {
	private int uuid;
	private Integer goodsUuid;
	private Integer storeNum;
	
	public void setGoodsUuid(Integer obj){
		this.goodsUuid = obj;
	}
	public Integer getGoodsUuid(){
		return this.goodsUuid;
	}
	
	public void setStoreNum(Integer obj){
		this.storeNum = obj;
	}
	public Integer getStoreNum(){
		return this.storeNum;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[goodsUuid=" + this.getGoodsUuid() + ",storeNum=" + this.getStoreNum() + ",]";
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}	
}
