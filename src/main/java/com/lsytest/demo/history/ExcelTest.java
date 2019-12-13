//
//package excel;
//
//import com.sun.rowset.internal.Row;
//import javafx.scene.control.Cell;
//import org.apache.poi.POIXMLDocumentPart;
//import org.apache.poi.ss.usermodel.PictureData;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
//import org.apache.poi.xssf.usermodel.XSSFDrawing;
//import org.apache.poi.xssf.usermodel.XSSFPicture;
//import org.apache.poi.xssf.usermodel.XSSFShape;
//import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.security.KeyStore.Entry;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class ExcelTest {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) throws Exception {
//		  getDataFromExcel("E:"+ File.separator +"ѧ����Ϣ��.xlsx");
//
//
//	}
//	public static void getDataFromExcel(String filePath) throws IOException
//    {
//        //String filePath = "E:\\123.xlsx";
//
//        //�ж��Ƿ�Ϊexcel�����ļ�
//        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
//        {
//            System.out.println("�ļ�����excel����");
//        }
//
//        FileInputStream fis =null;
//        Workbook wookbook = null;
//        Sheet sheet =null;
//        try
//        {
//            //��ȡһ�����Ե�ַ����
//              fis = new FileInputStream(filePath);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        try
//        {
//            //2003�汾��excel����.xls��β
//            wookbook = new HSSFWorkbook(fis);//�õ�������
//
//        }
//        catch (Exception ex)
//        {
//            //ex.printStackTrace();
//            try
//            {
//                //2007�汾��excel����.xlsx��β
//            	 fis = new FileInputStream(filePath);
//                wookbook = new XSSFWorkbook(fis);//�õ�������
//            } catch (IOException e)
//            {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//
//        Map<String, PictureData>  maplist=null;
//
//        sheet = wookbook.getSheetAt(0);
//            // �ж���07����03�ķ�����ȡͼƬ
//        if (filePath.endsWith(".xls")) {
//            maplist = getPictures1((HSSFSheet) sheet);
//        } else if(filePath.endsWith(".xlsx")){
//            maplist = getPictures2((XSSFSheet) sheet);
//        }
//        try {
//			printImg(maplist);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        //�õ�һ��������
//
//
//
//        //��ñ�ͷ
//        Row rowHead = sheet.getRow(0);
//
//        //�жϱ�ͷ�Ƿ���ȷ
//        System.out.println(rowHead.getPhysicalNumberOfCells());
//        if(rowHead.getPhysicalNumberOfCells() != 5)
//        {
//            System.out.println("��ͷ����������!");
//        }
//
//        //������ݵ�������
//        int totalRowNum = sheet.getLastRowNum();
//
//        //Ҫ�������
//       int studentid=0;
//       String studentname="";
//       String grade="";
//       String classes="";
//       String pic="";
//       //�����������
//        for(int i = 1 ; i <= totalRowNum ; i++)
//        {
//            //��õ�i�ж���
//            Row row = sheet.getRow(i);
//
//            //��û�õ�i�е�0�е� String���Ͷ���
//            Cell cell = row.getCell((short)0);
//            studentid = (int) cell.getNumericCellValue();
//
//            //���һ���������͵�����
//            //studentname = (int) cell.getNumericCellValue();
//            cell = row.getCell((short)1);
//            studentname =cell.getStringCellValue().toString();
//
//            cell = row.getCell((short)2);
//            grade =cell.getStringCellValue().toString();
//
//            cell = row.getCell((short)3);
//            classes =cell.getStringCellValue().toString();
//
//            cell = row.getCell((short)3);
//            classes =cell.getStringCellValue().toString();
//
//            System.out.println("ѧ�ţ�"+studentid+",������"+studentname+",�꼶��"+grade+",�༶��"+classes+",֤���գ�"+pic);
//        }
//        for (Entry<String, PictureData> entry : maplist.entrySet()) {
//
//        	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//
//        }
//    }
//  /**
//   * ��ȡͼƬ��λ�� (xls)
//   * @param sheet
//   * @return
//   * @throws IOException
//   */
//  public static Map<String, PictureData> getPictures1 (HSSFSheet sheet) throws IOException {
//	    Map<String, PictureData> map = new HashMap<String, PictureData>();
//	    List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
//	    for (HSSFShape shape : list) {
//	        if (shape instanceof HSSFPicture) {
//	            HSSFPicture picture = (HSSFPicture) shape;
//	            HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
//	            PictureData pdata = picture.getPictureData();
//	            String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // �к�-�к�
//	            map.put(key, pdata);
//	        }
//	    }
//	    return map;
//	}
//
//  /**
//   * ��ȡͼƬ��λ�� (xlsx)
//   * @param sheet
//   * @return
//   * @throws IOException
//   */
//  public static Map<String, PictureData> getPictures2 (XSSFSheet sheet) throws IOException {
//      Map<String, PictureData> map = new HashMap<String, PictureData>();
//      List<POIXMLDocumentPart> list = sheet.getRelations();
//      for (POIXMLDocumentPart part : list) {
//          if (part instanceof XSSFDrawing) {
//              XSSFDrawing drawing = (XSSFDrawing) part;
//              List<XSSFShape> shapes = drawing.getShapes();
//              for (XSSFShape shape : shapes) {
//                  XSSFPicture picture = (XSSFPicture) shape;
//                  XSSFClientAnchor anchor = picture.getPreferredSize();
//                  CTMarker marker = anchor.getFrom();
//                  String key = marker.getRow() + "-" + marker.getCol();
//                  map.put(key, picture.getPictureData());
//              }
//          }
//      }
//      return map;
//  }
//  //ͼƬд��
//  public static void printImg(Map<String, PictureData> sheetList) throws IOException {
//
//        //for (Map<String, PictureData> map : sheetList) {
//            Object key[] = sheetList.keySet().toArray();
//            for (int i = 0; i < sheetList.size(); i++) {
//                // ��ȡͼƬ��
//                PictureData pic = sheetList.get(key[i]);
//                // ��ȡͼƬ����
//                String picName = key[i].toString();
//                // ��ȡͼƬ��ʽ
//                String ext = pic.suggestFileExtension();
//
//                byte[] data = pic.getData();
//
//            //ͼƬ����·��
//                FileOutputStream out = new FileOutputStream("D:\\img\\pic" + picName + "." + ext);
//                out.write(data);
//                out.close();
//            }
//       // }
//
//    }
//
//
//
//}
