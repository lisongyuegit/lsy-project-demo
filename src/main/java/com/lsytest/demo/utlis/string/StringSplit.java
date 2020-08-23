package com.lsytest.demo.utlis.string;

public class StringSplit {
	public static void main(String[] args) {
		String aa = "手机号码（必填）";
		String result = splitStr(aa);
		System.out.println(result);

	}

	public static String splitStr(Object obj){
		if(null == obj){
			return obj.toString();
		}
		String [] sub = obj.toString().split("（");
		return sub[0];
	}

}
