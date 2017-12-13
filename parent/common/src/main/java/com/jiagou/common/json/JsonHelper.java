package com.jiagou.common.json;

import com.alibaba.fastjson.JSON;

public class JsonHelper {
	
	private JsonHelper(){}
	
	public static String object2str(Object obj){
		
		String retStr = "";
		
		retStr = JSON.toJSONString(obj);
		
		return retStr;
	}
	
	
	public static <T> T str2Object(String str,Class<T> obj){
		
	     T t =  JSON.parseObject(str,obj); 
	     
	     return t;
	     
	}
}
