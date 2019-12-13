//package com.lsytest.demo.testrun;
//
//import com.lsytest.demo.enums.DataImportExportSceneEnum;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.ooxml.POIXMLProperties;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddressList;
//import org.apache.poi.xssf.usermodel.*;
//
//import java.io.*;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
//public class GenerateExcel {
//    private File generateHREmployeeExcel2007Template(String merchantId, String projectCode) throws Exception {
//        String[] colHeads = generateExcelHeader4HREmployee();
//        int colSize = colHeads.length;
//        Map<String, Object> map = initWorkBook2007(projectCode, colHeads, DataImportExportSceneEnum.HR_EMPLOYEE);
//        XSSFWorkbook workbook = (XSSFWorkbook) map.get("workbook");
//        XSSFSheet sheet = (XSSFSheet) map.get("sheet");
//
//        DataValidationHelper dataValidationHelper;
//        DataValidation dataValidation;
//        CellRangeAddressList cellRangeAddressList;
//        DataValidationConstraint dataValidationConstraint;
//        String tip = "", errMsg = "";
//
//
//        flag:
//        for (int i = 0; i < colHeads.length; i++) {
//            String str = string.StringSplit.split(colHeads[i]);
//
//            tip = "请从下拉列表中选择";
//            errMsg = "请从下拉列表中选择";
//            dataValidationHelper = new XSSFDataValidationHelper(sheet);
//
//            switch (str) {
//                case "所属机构":
//                    String organizationListSheetName = "organizationList";
//                    String listFormula4Org = organizationListSheetName + "!$A$1:$A$" ;
//                    // 表示A列1 - arr.length行作为下拉列表来源数据
//                    errMsg = "请从下拉列表中选择组织机构";
//                    break;
//                case "职位":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getPostNameArray(projectCode, postService));
//                    errMsg = "请从下拉列表中选择岗位";
//                    break;
//                case "职位类型":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getPostTypeList());
//                    errMsg = "请从下拉列表中选择职位类型";
//                    break;
//                case "姓名":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "20", null);
//                    errMsg = "长度超出限定值";
//                    tip = "必填，长度为20个字符以内";
//                    break;
//                case "性别":
//                    String[] genderArray = {"男", "女"};
//                    dataValidationConstraint = new XSSFDataValidationConstraint(genderArray);
//                    errMsg = "请从下拉列表中选择性别";
//                    break;
//                case "手机号码":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "11", null);
//                    errMsg = "长度超出限定值";
//                    tip = "必填，长度为11位数字";
//                    break;
//                case "邮箱":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "30", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，英文、数字、符号，不超过30个字符；";
//                    break;
//                case "民族":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getNationList());
//                    errMsg = "请从下拉列表中民族";
//                    break;
//                case "身份证号码":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "18", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度不超过18个字符；";
//                    break;
//                case "通讯地址":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度不超过50个字符；";
//                    break;
//                case "身份证有效截止日期":
//                case "入职日期":
//                case "转正日期":
//                case "职称批准日期":
//                case "技能等级证批准日期":
//                case "合同起始日期":
//                case "合同结束日期":
//                case "毕业时间":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.DATE,
//                            DataValidationConstraint.OperatorType.GREATER_OR_EQUAL, "date(1970,1,1)", null);
//                    errMsg = "日期格式有误。示例：2018/01/01 或 2018-01-01";
//                    tip = "示例：2018/01/01 或 2018-01-01";
//                    break;
//                case "户口性质":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getHuKouTypeList());
//                    errMsg = "请从下拉列表中户口性质";
//                    break;
//                case "婚姻状况":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getMarriageStateList());
//                    errMsg = "请从下拉列表中选择婚姻状况";
//                    break;
//                case "员工状态":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getEmployeeStateList());
//                    errMsg = "请从下拉列表中选择员工状态";
//                    break;
//                case "试用期":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.INTEGER,
//                            DataValidationConstraint.OperatorType.BETWEEN, "1", "100");
//                    errMsg = "有效值为1到100";
//                    tip = "选填，有效值为1到100";
//                    break;
//                case "职级":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(postLevelArray);
//                    errMsg = "请从下拉列表中选择职级";
//                    break;
//                case "工资归属":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "办公地点":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "200", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为200个字符以内";
//                    break;
//                case "最高学历":
//                case "第一学历":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getEmloyeeEducationList());
//                    errMsg = "请从下拉列表中选择最高学历";
//                    break;
//                case "毕业院校":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "院校类型":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getSchoolTypeList());
//                    errMsg = "请从下拉列表中选择院校类型";
//                    break;
//                case "学科专业":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "毕业证书编号":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "学位证书编号":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "职称名称":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "职称级别":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "职称编号":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "40", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为40个字符以内";
//                    break;
//                case "职称评定机构":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "30", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为30个字符以内";
//                    break;
//                case "技能等级证名称":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "技能等级证级别":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getQualificationLevelList());
//                    errMsg = "请从下拉列表中选择资格证级别";
//                    break;
//                case "技能等级证编号":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "发证机构":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "30", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为30个字符以内";
//                    break;
//                case "合同公司":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "50", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为50个字符以内";
//                    break;
//                case "合同年限":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getContractYearsList());
//                    errMsg = "请从下拉列表中选择合同年限";
//                    break;
//
//                case "合同签订次数":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getContractCountList());
//                    errMsg = "请从下拉列表中选择签订次数";
//                    break;
//                case "紧急联系人姓名":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "20", null);
//                    errMsg = "长度超出限定值";
//                    tip = "选填，长度为20个字符以内";
//                    break;
//                case "紧急联系人电话":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "11", null);
//                    errMsg = "长度超出限定值";
//                    tip = "必填，长度为11位数字";
//                    break;
//                case "紧急联系人与员工关系":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getFamilyMerberRelationList());
//                    errMsg = "请从下拉列表中选择关系类别";
//                    break;
//                case "籍贯":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.TEXT_LENGTH,
//                            DataValidationConstraint.OperatorType.LESS_OR_EQUAL, "20", null);
//                    errMsg = "长度超出限定值";
//                    tip = "必填，长度为20个字符以内";
//                    break;
//                case "是否为伤残人士":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getIsDisabilityList());
//                    errMsg = "请从下拉列表中选择是/否";
//                    break;
//                case "伤残等级":
//                    dataValidationConstraint = new XSSFDataValidationConstraint(getDisabilityLevelList());
//                    errMsg = "请从下拉列表中选择级别";
//                    break;
//                default:
//                    continue flag;
//            }
//
//            cellRangeAddressList = new CellRangeAddressList(1, 2000, i, i);
//
//            dataValidation = dataValidationHelper.createValidation(dataValidationConstraint, cellRangeAddressList);
//            dataValidation.setSuppressDropDownArrow(true);
//            dataValidation.setShowErrorBox(true);
//            dataValidation.createErrorBox("错误提示", errMsg);
//            dataValidation.setShowPromptBox(true);
//            dataValidation.createPromptBox("输入提示", tip);
//            sheet.addValidationData(dataValidation);
//        }
//
//
//        Project project = projectService.selectOne(new EntityWrapper<Project>().eq("PROJECT_CODE", projectCode));
//        String fileName = String.format("员工数据导入模板", ".xlsx");
//        return genearteTemplateFile(workbook, fileName);
//    }
//    private String[] generateExcelHeader4HREmployee() {
//        String[] headers = {
//                "所属机构（必选）",
//                "职位（必选）",
//                "职位类型",
//                "姓名（必填）",
//                "性别（必选）",
//                "手机号码（必填）",
//                "邮箱",
//                "民族",
//                "籍贯",
//                "身份证号码",
//                "通讯地址",
//                "身份证有效截止日期",
//                "户口性质",
//                "婚姻状况",
//                "是否为伤残人士",
//                "伤残等级",
//                "员工状态",
//                "入职日期",
//                "试用期（月）",
//                "转正日期",
//                "职级",
//                "工资归属",
//                "办公地点",
//                "第一学历",
//                "毕业院校",
//                "院校类型",
//                "学科专业",
//                "毕业时间",
//                "毕业证书编号",
//                "学位证书编号",
//                "最高学历",
//                "毕业院校_最高",
//                "院校类型_最高",
//                "学科专业_最高",
//                "毕业时间_最高",
//                "毕业证书编号_最高",
//                "学位证书编号_最高",
//                "职称名称",
//                "职称级别",
//                "职称编号",
//                "职称评定机构",
//                "职称批准日期",
//                "技能等级证名称",
//                "技能等级证级别",
//                "技能等级证批准日期",
//                "技能等级证编号",
//                "发证机构",
//                "合同公司",
//                "合同起始日期",
//                "合同结束日期",
//                "合同年限",
//                "合同签订次数",
//                "紧急联系人姓名",
//                "紧急联系人电话",
//                "紧急联系人与员工关系"
//        };
//
//        return headers;
//    }
//    protected final Map<String, Object> initWorkBook2007(String projectCode, String[] headers, DataImportExportSceneEnum sceneEnum) {
//        // 声明一个工作薄
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        //添加自定义属性
//        POIXMLProperties.CustomProperties customProperties = workbook.getProperties().getCustomProperties();
//        customProperties.addProperty("tag", "yidcloud");
//        customProperties.addProperty("scene", "4");
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
//                logger.error(String.format("生成Excel模板文件设置列宽时出错：%s", e.getMessage()), e);
//            }
//        }
//
//        settingCellTextStyle2007(workbook, sheet, sceneEnum);
//
//        return new HashMap<String, Object>(2) {{
//            put("workbook", workbook);
//            put("sheet", sheet);
//        }};
//    }
//    private void settingCellTextStyle2007(XSSFWorkbook workbook, XSSFSheet sheet, DataImportExportSceneEnum sceneEnum) {
//        int[] celIndex = getNeedFormatCellIndex(sceneEnum);
//
//        if (celIndex != null && celIndex.length > 0) {
//            XSSFCellStyle cellStyle;
//            XSSFDataFormat format;
//            XSSFRow row;
//            Cell cell;
//            for (int i = 1; i <= 2000; i++) {
//                row = sheet.createRow(i);
//                for (int j = 0; j < celIndex.length; j++) {
//                    cell = row.createCell(celIndex[j]);
//                    cellStyle = workbook.createCellStyle();
//                    format = workbook.createDataFormat();
//                    cellStyle.setDataFormat(format.getFormat("@"));
//                    cell.setCellStyle(cellStyle);
//                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                }
//            }
//        }
//    }
//    private int[] getNeedFormatCellIndex(DataImportExportSceneEnum sceneEnum){
//        int[] celIndex = null;
//        switch (sceneEnum) {
//            case HR_EMPLOYEE:
//                celIndex = new int[]{3, 5, 6, 8, 9, 18, 19, 21, 23, 25, 26, 27,28, 29,30 ,32, 35, 36, 37,42};
//                break;
//            case EMPLOYEE:
//                celIndex = new int[]{2, 4, 5, 6, 7};
//                break;
//            case VEHICLE:
//                celIndex = new int[]{3, 7};
//                break;
//            case FACILITY:
//                celIndex = new int[]{2, 4};
//                break;
//            case EQUIPMENT:
//                celIndex = new int[]{1, 2, 4, 5, 6};
//                break;
//        }
//
//        return celIndex;
//    }
//    public final File genearteTemplateFile(Workbook workbook, String fileName) throws BusinessException {
//        try {
//            fileName = URLEncoder.encode(fileName, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            logger.error("文件名URL编码出错。", e);
//        }
//        PropertiesHelper propertiesHelper = new PropertiesHelper("system.properties");
//        String uploadBasePath = propertiesHelper.getStringProperty("file.upload");
//        //String uploadFullpath = uploadBasePath + "data_import_temp_dir";
//        String uploadFullpath = "H://home/app/upload/" + "data_import_temp_dir";
//        File uploadDir = new File(uploadFullpath);
//        //创建一个目录
//        if (!uploadDir.exists()) {
//            if (!uploadDir.mkdirs()) {
//                throw new Exception("创建目录失败。");
//            }
//        }
//
//        String path = uploadFullpath + "/" + fileName;
//        OutputStream outputStream = null;
//
//        try {
//            outputStream = new FileOutputStream(path);
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            logger.error(String.format("生成Excel模板文件出错：%s", e.getMessage()), e);
//            throw new Exception(-1, "系统异常，请稍后再试");
//        } finally {
//            try {
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                logger.error(String.format("生成Excel模板文件出错：%s", e.getMessage()), e);
//                throw new Exception(-1, "系统异常，请稍后再试");
//            }
//        }
//
//        File file;
//        try {
//            file = new File(path);
//            // 以流的形式下载文件。
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
//            byte[] buffer = new byte[inputStream.available()];
//            inputStream.read(buffer);
//            inputStream.close();
//        } catch (IOException e) {
//            logger.error(String.format("生成Excel模板文件出错：%s", e.getMessage()), e);
//            throw new Exception(-1, "系统异常，请稍后再试");
//        }
//
//        return file;
//    }
//}
