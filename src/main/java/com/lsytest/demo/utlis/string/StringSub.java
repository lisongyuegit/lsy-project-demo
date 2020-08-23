package com.lsytest.demo.utlis.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSub {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = stringSubTest("");
		System.out.println("2: "+str);

	}

	public static String stringSubTest(String str){
		String result = "";
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(str);  
		String strReq = m.replaceAll("").trim();
		System.out.println("1: "+strReq);
		if(strReq.length() >= 3){
			result = strReq.substring(0, strReq.length()-3);
		}
		return result;
	}
}
