package com.lsytest.demo.utlis.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author LiSongYue
 *
 */
public class PrintNowDate {

	public static void main(String[] args) throws InterruptedException{
		for(int i = 0; i >= 0; i++){
			Date nowDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			//�ȴ�1����Ҳ����1000����
			Thread.sleep(1000);
			String dateStr = sdf.format(nowDate);
			String regEx="[^0-9]";  
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(dateStr);  
			String testStr = m.replaceAll("").trim();
			System.out.println("11: "+testStr);
		}

	}
}
