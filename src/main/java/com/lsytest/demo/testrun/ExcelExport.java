//package com.lsytest.demo.testrun;
//
//import com.lsytest.demo.constant.ExcelHeaderContants;
//import com.lsytest.demo.enums.DataImportExportSceneEnum;
//import com.lsytest.demo.utlis.file.FileUtils;
//import org.apache.poi.ooxml.POIXMLProperties;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataValidation;
//import org.apache.poi.ss.usermodel.DataValidationConstraint;
//import org.apache.poi.ss.usermodel.DataValidationHelper;
//import org.apache.poi.ss.util.CellRangeAddressList;
//import org.apache.poi.xssf.usermodel.XSSFRichTextString;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//import java.net.URLEncoder;
//
//public class ExcelExport {
//
//    public static void main(String[] args) {
//        String projectCode = "";
//        String merchantId = "";
//        //数据头
//        String[] headers = ExcelHeaderContants.EXCEL_HEADER_HR;
//        int colSize = headers.length;
//
//        // 声明一个工作薄
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        //添加自定义属性
//        POIXMLProperties.CustomProperties customProperties = workbook.getProperties().getCustomProperties();
//        DataImportExportSceneEnum sceneEnum = DataImportExportSceneEnum.HR_EMPLOYEE;
//        customProperties.addProperty("scene", sceneEnum.getValue());
//        customProperties.addProperty("projectCode", projectCode);
//        // 生成一个表格(指定为Sheet1)
//        XSSFSheet sheet = workbook.createSheet("Sheet1");
//
//        String head;
//        Cell cell;
//        XSSFRichTextString text;
//        XSSFRow row = sheet.createRow(0);
//
//        for (int j = 0; j < headers.length; j++) {
//            head = headers[j];
//            cell = row.createCell(j);
//            text = new XSSFRichTextString(headers[j]);
//            cell.setCellValue(text);
//            try {
//                sheet.setColumnWidth(j, head.getBytes("UTF-8").length * 2 * 100);
//            } catch (UnsupportedEncodingException e) {
//            }
//        }
//        row = sheet.createRow(1);
//        for (int j = 0; j < headers.length; j++) {
//            head = headers[j];
//            cell = row.createCell(j);
//            text = new XSSFRichTextString(headers[j]);
//            cell.setCellValue(text);
//            try {
//                sheet.setColumnWidth(j, head.getBytes("UTF-8").length * 2 * 100);
//            } catch (UnsupportedEncodingException e) {
//            }
//        }
//
//
//        DataValidationHelper dataValidationHelper;
//        DataValidation dataValidation;
//        CellRangeAddressList cellRangeAddressList;
//        DataValidationConstraint dataValidationConstraint;
//
//        String fileName = "test_20190923.xlsx";
//        //return genearteTemplateFile(workbook, fileName);
//        try {
//            fileName = URLEncoder.encode(fileName, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//        }
//        String uploadFullpath = "H://LiSongYue/TempTest";
//        File uploadDir = new File(uploadFullpath);
//        //创建一个目录
//        if (!uploadDir.exists()) {
//            if (!uploadDir.mkdirs()) {
//                System.out.println("创建目录失败");
//            }
//        }
//
//        String path = uploadFullpath + "/" + fileName;
//        OutputStream outputStream = null;
//
//        try {
//            if (FileUtils.existsFile(path)) {
//                FileUtils.deleteIfExists(path);
//            }
//
//            outputStream = new FileOutputStream(path);
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            System.out.println("创建目录失败");
//        } finally {
//            try {
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                System.out.println("创建目录失败");
//            }
//        }
//
//        File file;
//        try {
//
//            file = new File(path);
//            // 以流的形式下载文件。
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
//            byte[] buffer = new byte[inputStream.available()];
//            inputStream.read(buffer);
//            inputStream.close();
//        } catch (IOException e) {
//            System.out.println("创建目录失败");
//        }
//
//    }
//
//
//}
