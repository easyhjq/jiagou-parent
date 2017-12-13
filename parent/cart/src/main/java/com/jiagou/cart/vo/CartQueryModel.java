package com.jiagou.cart.vo;

public class CartQueryModel extends CartModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CartQueryModel(){
		
	}
	
	public CartQueryModel(int pageNum, int pageSize) {
		
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
