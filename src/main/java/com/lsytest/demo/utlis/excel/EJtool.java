//package com.lsytest.demo.utlis.excel;
//
//import com.Foldcc.EJ_Tools.EncodeAndDecode;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 用于操作加密解密文件
// * @author Foldcc
// *
// */
//public class EJtool {
//	private ExcelUtils excelUtils = new ExcelUtils();
//	private JsonTool jsonTool = new JsonTool();
//	private FileUtils fileTool = new FileUtils();
//	private EncodeAndDecode encodeTool = new EncodeAndDecode();
//	/**
//	 * 将指定路径下的excel文件转为指定路径文件(路径+文件全名) ，转换成功返回true
//	 * @param excelFilePath
//	 * @param jsonFilePath
//	 * @return
//	 */
//	public String ExcelToJson(String excelFilePath , String jsonFilePath){
//		boolean isT = false;
//		String jsonStr = "";
//		List<String[]> msg = excelUtils.readExcel(new File(excelFilePath));
//		if(msg != null){
//			String[] columns = msg.get(0);
//			List<Map<String,String>> resultMapList = new ArrayList<Map<String,String>>();
//			for (int i = 1; i < msg.size(); i++) {
//				Map<String,String> data = new HashMap<>();
//				resultMapList.add(data);
//				for (int j = 0; j < columns.length; j++) {
//					data.put(string.StringSplit.splitStr(columns[j]),msg.get(i)[j]);
//				}
//			}
//
//			jsonStr = jsonTool.getJsonWithMap(resultMapList);
//			System.out.println(jsonStr);
//
//			if(null != jsonFilePath && jsonStr != null && fileTool.createFile(jsonFilePath)){
//				//fileTool.WriteBase(jsonStr, jsonFilePath);
//				isT = true;
//			}
//		}
//		return jsonStr;
//	}
//
//	/**
//	 * 将指定json格式文件转化为指定路径excel文件(路径+文件全名),转换成功返回true
//	 * @param jsonFilePath
//	 * @param excelFilePath
//	 * @return
//	 */
//	public boolean JsonToExcel(String jsonFilePath , String excelFilePath){
//		boolean isT = false;
//		String jsonStr = fileTool.ReadBase(jsonFilePath);
//		if(jsonStr != null){
//			List<String[]> msg = jsonTool.getList(jsonStr);
//			if(msg!=null && excelUtils.toExcel(msg, excelFilePath)){
//				isT = true;
//			}
//		}
//		return isT;
//	}
//
//	/**
//	 * 将指定加密格式的Json文件转换为Excel文件
//	 * @param jsonFilePath
//	 * @param excelFilePath
//	 * @return
//	 */
//	public boolean JsonToExcelEncode(String jsonFilePath , String excelFilePath){
//		boolean isT = false;
//		String jsonStr = fileTool.ReadBase(jsonFilePath);
//		jsonStr = encodeTool.decode(jsonStr);
//		if(jsonStr != null){
//			List<String[]> msg = jsonTool.getList(jsonStr);
//			if(msg!=null && excelUtils.toExcel(msg, excelFilePath)){
//				isT = true;
//			}
//		}
//		return isT;
//	}
//
//	/**
//	 * 将指定Excle文件转化为加密格式的json文件
//	 * @param excelFilePath
//	 * @param jsonFilePath
//	 * @return
//	 */
//	public boolean ExcelToJsonEncode(String excelFilePath , String jsonFilePath){
//		boolean isT = false;
//		List<String[]> msg = excelUtils.readExcel(new File(excelFilePath));
//		if(msg != null){
//			String jsonStr = jsonTool.getJsonWithList(msg);
//			jsonStr = encodeTool.encode(jsonStr);
//			if(jsonStr != null && fileTool.createFile(jsonFilePath)){
//				fileTool.WriteBase(jsonStr, jsonFilePath);
//				isT = true;
//			}
//		}
//		return isT;
//	}
//	public void testaa(){
//		//String file = "[{"name":"id","needUpdate":false},{"name":"certificateDate","needUpdate":true,"mapKey":"行驶证发证日期"},{"name":"modelcode","needUpdate":true,"mapKey":"车辆所有人"},{"name":"owner","needUpdate":true,"mapKey":"行驶证发证日期"},{"name":"lessee","needUpdate":true,"mapKey":"当前租凭人"},{"name":"registrationbookowner","needUpdate":true,"mapKey":"车辆登记证归属"},{"name":"licenseDate","needUpdate":true,"mapKey":"挂牌登记日期"},{"name":"validDeadline","needUpdate":true,"mapKey":"年检有效期至"},{"name":"invoicePrice","needUpdate":true,"mapKey":"开票价格"},{"name":"originalPrice","needUpdate":true,"mapKey":"原价值"},{"name":"vehicleIdentificationNo","needUpdate":true,"mapKey":"车辆识别号"},{"name":"engineNo","needUpdate":true,"mapKey":"发动机号"}]";
//	}
//	public static void main(String[] args) {
//		String reslut = new EJtool().ExcelToJson("H:\\LiSongYue\\TempTest\\ImportTest2.xlsx","D:\\xx\\123.json");
//
//	}
//}
