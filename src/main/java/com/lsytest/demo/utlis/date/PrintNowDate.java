package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 打印当前时间
 * @author LiSongYue
 *
 */
public class PrintNowDate {

	public static void main(String[] args) throws InterruptedException{
		for(int i = 0; i >= 0; i++){
			Date nowDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			//等待1秒钟也就是1000毫秒
			Thread.sleep(1000);
			String dateStr = sdf.format(nowDate);
			String regEx="[^0-9]";  
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(dateStr);  
			String testStr = m.replaceAll("").trim();
			System.out.println("当前时间为: "+testStr);
		}

	}
}
