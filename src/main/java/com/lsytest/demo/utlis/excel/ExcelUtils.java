//package com.lsytest.demo.utlis.excel;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// * Excel数据处理工具
// * @author Foldcc
// *
// */
//public class ExcelUtils {
//	/**
//	 * 指定数据转换为excel表格到指定地址,转换成功返回true
//	 * @param table
//	 * @param filePath
//	 * @return
//	 */
//	public boolean toExcel(List<String[]> table , String filePath){
////		FileUtils.createFile(filePath);
//		XSSFWorkbook  wb = new XSSFWorkbook ();
//		SXSSFWorkbook swb=new SXSSFWorkbook(wb,1000);
//
//		SXSSFSheet sheet = (SXSSFSheet) swb.createSheet("Sheet");
//
//		for (int i = 0 ; i < table.size() ; i++) {
//			Row row = sheet.createRow(i);
//			for (int j = 0 ; j < table.get(i).length ; j++) {
//				row.createCell(j).setCellValue(table.get(i)[j]);
//			}
//		}
//		//创建一个文件 命名为workbook.xls
//		FileOutputStream fileOut;
//		try {
//			fileOut = new FileOutputStream(filePath);
//
//			// 把上面创建的工作簿输出到文件中
//			swb.write(fileOut);
//
//			swb.close();
//			//关闭输出流
//			fileOut.close();
//
//			return true;
//
//		} catch (FileNotFoundException e) {
//			System.out.println("文件流创建失败");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	/**
//	 * 指定数据库文件,将数据库中的数据导出为Excel文件到本地 ，数据最大值： < 100万
//	 * @param rs
//	 * @param filePath
//	 * @return
//	 */
//	public boolean toExcelWithResultSet(ResultSet rs, String filePath){
//		if(rs == null){
//			System.out.println("rs为空");
//			return false;
//		}
//		try {
//			rs.last();
//			//获取有多少行数据
//			long rcount = rs.getRow();
//
//			if(rcount > 1000000){
//				System.out.println("【ExcelUtils】 数据量过大");
//				return false;
//			}
//
//			rs.first();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		XSSFWorkbook  wb = new XSSFWorkbook ();
//		SXSSFWorkbook swb=new SXSSFWorkbook(wb,10000);
//		SXSSFSheet sheet = (SXSSFSheet) swb.createSheet("Sheet");
//		ResultSetMetaData data;
//		try {
//
//			data = rs.getMetaData();
//			int count = data.getColumnCount();
//			Row row;
//			row = sheet.createRow(0);
//			for (int i = 1; i <= data.getColumnCount() ; i++){
//				row.createCell(i-1).setCellValue(data.getColumnName(i));
//			}
//			int c = 1;
//			while(rs.next()){
//				row = sheet.createRow(c);
//				for (int i = 1; i <= count; i++) {
//					row.createCell(i-1).setCellValue(rs.getString(i));
//				}
//				c++;
//			}
//			System.out.println("数据总量: " + c);
//			FileOutputStream fileOut;
//			fileOut = new FileOutputStream(filePath);
//			// 把创建的工作簿输出到文件中
//			swb.write(fileOut);
//			swb.close();
//			//关闭输出流
//			fileOut.close();
//			return true;
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//			System.out.println();
//			System.out.println("【ExcelUtils】 数据拉取失败");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			System.out.println("【ExcelUtils】 导出Excel失败");
//		}
//		return false;
//	}
//
//	/**
//	 * 判断文件是否为excel文件
//	 * @param file
//	 * @return
//	 */
//	public boolean checkFile(File file){
//		//判断文件是否存在
//		if(null == file){
//			return false;
//		}
//		//获得文件名
//		String fileName = file.getName();
//		//判断文件是否是excel文件
//		if(fileName.endsWith("xlsx")){
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 读取指定路径下的exlce文件
//	 * @param file
//	 * @return
//	 */
//	public List<String[]> readExcel(File file){
//		List<String[]> list = new ArrayList<String[]>();
//		try {
//			InputStream inputStream = new FileInputStream(file);
//			String fileName = file.getName();
//			Workbook wb = null;
//			if(fileName.endsWith("xls")){
//				wb = new HSSFWorkbook(inputStream);//解析xls格式
//			}else if(fileName.endsWith("xlsx")){
//				wb = new XSSFWorkbook(inputStream);//解析xlsx格式
//			}
//			Sheet sheet = wb.getSheetAt(0);//第一个工作表
//
//			int firstRowIndex = sheet.getFirstRowNum();
//			int lastRowIndex = sheet.getLastRowNum();
//			for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex ++){
//				Row row = sheet.getRow(rIndex);
//				if(row != null){
//					int firstCellIndex = row.getFirstCellNum();
//					int lastCellIndex = row.getLastCellNum();
//					if(lastCellIndex < 0){
//						continue;
//					}
//					String[] tempCell = new String[lastCellIndex];
//					for(int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex ++){
//						Cell cell = row.getCell(cIndex);
//						if(cell != null){
//							tempCell[cIndex] = getStringValueFromCell(cell);
//						}
//					}
//					list.add(tempCell);
//				}
//			}
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return list;
//	}
//
//	public static String getStringValueFromCell(Cell cell) {
//		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
//		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		String cellValue = "";
//		if(cell == null) {
//			return cellValue;
//		}
//		else if(cell.getCellType() == CellType.STRING) {
//			cellValue = cell.getStringCellValue();
//		}
//
//		else if(cell.getCellType() == CellType.NUMERIC) {
//			if(HSSFDateUtil.isCellDateFormatted(cell)) {
//				double d = cell.getNumericCellValue();
//				Date com.lsytest.demo.date = HSSFDateUtil.getJavaDate(d);
//				cellValue = sFormat.format(com.lsytest.demo.date);
//			}
//			else {
//				cellValue = decimalFormat.format((cell.getNumericCellValue()));
//			}
//		}
//		else if(cell.getCellType() == CellType.BLANK) {
//			cellValue = "";
//		}
//		else if(cell.getCellType() == CellType.BOOLEAN) {
//			cellValue = String.valueOf(cell.getBooleanCellValue());
//		}
//		else if(cell.getCellType() == CellType.ERROR) {
//			cellValue = "";
//		}
//		else if(cell.getCellType() == CellType.FORMULA) {
//			cellValue = cell.getCellFormula().toString();
//		}
//		return cellValue;
//	}
//
//
//	/**
//	 * 获取指定表的行总数 和列总数
//	 * @param file
//	 * @return
//	 */
//	public String[] readExcelInfo(File file){
//		String[] info = new String[2];
//		try {
//			InputStream inputStream = new FileInputStream(file);
//			String fileName = file.getName();
//			Workbook wb = null;
//			if(fileName.endsWith("xls")){
//				wb = new HSSFWorkbook(inputStream);//解析xls格式
//			}else if(fileName.endsWith("xlsx")){
//				wb = new XSSFWorkbook(inputStream);//解析xlsx格式
//			}
//			Sheet sheet = wb.getSheetAt(0);//第一个工作表
//			int lastRowIndex = sheet.getLastRowNum();
//			Row hssfRow = sheet.getRow(0);
//			if(hssfRow != null){
//				info[0] = (lastRowIndex + 1 )+ "";
//				info[1] = hssfRow.getPhysicalNumberOfCells() + "";
//			}else{
//				info[0] = "0";
//				info[1] = "0";
//			}
//			wb.close();
//			inputStream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return info;
//	}
//
//	/**
//	 * 比较两个excel文件内容是否相同
//	 * @param oldExcel
//	 * @param nowExcel
//	 * @return
//	 */
//	public String excelCompare(File oldExcel , File nowExcel){
//		String log = null;
//		InputStream inputStream;
//		InputStream inputStream2;
//		try {
//			inputStream = new FileInputStream(oldExcel);
//			inputStream2 = new FileInputStream(nowExcel);
//			Workbook wb = new XSSFWorkbook(inputStream);//解析xlsx格式
//			Workbook wb2 = new XSSFWorkbook(inputStream2);//解析xlsx格式
//			Sheet sheet = wb.getSheetAt(0);//第一个工作表
//			Sheet sheet2 = wb2.getSheetAt(0);//第一个工作表
//			int firstRowIndex = sheet.getFirstRowNum();
//			int lastRowIndex = sheet.getLastRowNum();
//			for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex ++){
//				Row row = sheet.getRow(rIndex);
//				Row row2 = sheet2.getRow(rIndex);
//				if(row != null && row2 != null){
//					int firstCellIndex = row.getFirstCellNum();
//					int lastCellIndex = row.getLastCellNum();
//					for(int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex ++){
//						Cell cell = row.getCell(cIndex);
//						Cell cell2 = row2.getCell(cIndex);
//						if(cell != null && cell2 != null){
//							if(!cell.toString().equals(cell2.toString())){
//								log = "但数据有被修改， " + (rIndex+1) + "行, " + (cIndex+1) +" 列 发现不同";
//								wb.close();
//								wb2.close();
//								return log;
//							}
//						}else{
//							log = "但数据有被修改， 第" + rIndex + "行发现不同";
//							wb.close();
//							wb2.close();
//							return log;
//						}
//					}
//				}else{
//					log = "但数据有被修改， 第" + rIndex + "行发现不同";
//				}
//			}
//			wb.close();
//			wb2.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return log;
//	}
//
//	/**
//	 * 在指定excel文件尾添加新数据
//	 * @param msg
//	 * @param file
//	 * @return
//	 */
//	public boolean addMsgToExcel(List<String[]> msg , File file){
//		try {
//			InputStream inputStream = new FileInputStream(file);
//			Workbook wb = new XSSFWorkbook(inputStream);//解析xlsx格式
//			Sheet sheet = wb.getSheetAt(0);//第一个工作表
//			int endcount = sheet.getLastRowNum();
//			for (String[] strings : msg) {
//				Row row = sheet.createRow(endcount++);
//				if(row != null){
//					for (int i = 0; i < strings.length; i++) {
//						row.createCell(i).setCellValue(strings[i]);
//					}
//				}
//			}
//			FileOutputStream fileOut;
//			fileOut = new FileOutputStream(file.getPath());
//			// 把创建的工作簿输出到文件中
//
//			wb.close();
////			 关闭输出流
//			fileOut.close();
//			return true;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//}
