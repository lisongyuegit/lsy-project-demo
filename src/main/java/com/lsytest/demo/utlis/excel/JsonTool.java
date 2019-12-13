//package com.lsytest.demo.utlis.excel;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.*;
//
///**
// * 用于json数据与List<String[]>类型之间相互转换
// * @author Foldcc
// *
// */
//public class JsonTool {
//	private Gson gson = new Gson();
//	/**
//	 * 将传入的List<String[]>数据转换为String类型的json语句
//	 * @param msg
//	 * @return
//	 */
//	public String getJsonWithList(List<String[]> msg){
//		return gson.toJson(msg);
//	}
//
//	public String getJsonWithMap(List<Map<String,String>> msg){
//		return gson.toJson(msg);
//	}
//	/**
//	 * 将传入的String类型的json语句转换为List<String[]>类型数据
//	 * @param gsonstr
//	 * @return
//	 */
//	public List<String[]> getList(String gsonstr){
//		Type type = new TypeToken<ArrayList<String[]>>() {}.getType();
//		return gson.fromJson(gsonstr, type);
//	}
//}
