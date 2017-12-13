package com.jiagou.order.vo;

public class OrderDetailQueryModel extends OrderDetailModel {
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+","+super.toString()+" ,[]";
	}
	
	
	public OrderDetailQueryModel(){
		
	}
	
	public OrderDetailQueryModel(int pageNum, int pageSize) {
		
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}


	private int pageNum;
	
	private int pageSize;
	
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	
}
