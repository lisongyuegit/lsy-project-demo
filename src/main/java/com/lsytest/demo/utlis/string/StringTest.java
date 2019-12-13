package string;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
public static void main(String[] args) {
	String filename = "À³¿¨»úÆ÷ÈË";
	System.out.println("test1:"+filename);
	filename = setFileName(filename);
	System.out.println("test2:"+filename);
}
public static String setFileName(String filename){
	Date nowDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateStr = sdf.format(nowDate);
	String regEx="[^0-9]";  
	Pattern p = Pattern.compile(regEx);  
	Matcher m = p.matcher(dateStr);  
	String timeStr = m.replaceAll("").trim();
	filename = filename + timeStr;
	filename = "20190222.xls";
	return filename;
	
}
}
