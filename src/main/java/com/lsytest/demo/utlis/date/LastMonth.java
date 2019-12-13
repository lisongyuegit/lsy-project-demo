package date;

import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LastMonth {
  private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static void main(String[] args) {
	  getStartTime();
	  getNowEndTime();
	  int aa = getCurrentMonthLastDay();
	  System.out.println(aa);
	  
}
  public static void testb(){
	  
	  Date  nowData = new Date ();
	  Calendar date = Calendar.getInstance();
	  String month = String.valueOf(date.get(Calendar.MONTH)-1);
	  System.out.println("月份为: "+month);
	  date.setTime(nowData);
	  date.add(Calendar.MONTH, -2);

	  String b2 = String.valueOf(date.get(Calendar.MONTH)+1);
	  System.out.println("test: "+b2);
	  String bb = dateFormat.format((date.getTime()));
	  System.out.println("转变后: "+bb);
  }
  public static void testa(){
	  Calendar date = Calendar.getInstance();
	    String year = String.valueOf(date.get(Calendar.YEAR));
	    String month = String.valueOf((date.get(Calendar.MONTH)+1));
	    date.add(Calendar.MONTH, -1);
	   // year = String.valueOf(date.get(Calendar.YEAR));
	    String lastMonth = String.valueOf(date.get(Calendar.MONTH)+1);
	    date.add(Calendar.MONTH, -1);
	   // year = String.valueOf(date.get(Calendar.YEAR));
	    String llMonth = String.valueOf(date.get(Calendar.MONTH)+1);
	    System.out.println("当前年份为: "+year+" 当前月份为: "+month+"上月为: "+lastMonth+" 上上月为: "+llMonth);
		
   }
  /**
   * 获取当天开始时间
   */
   public static void getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		String date = dateFormat.format(todayStart.getTime());
		System.out.println(date);
	}
   /**
    * 获取当天最晚时间
    */
	public static void getNowEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		String date = dateFormat.format(todayEnd.getTime());
		System.out.println(date);
	}

	/** 
	 * 取得当月天数 
	 * */  
	public static int getCurrentMonthLastDay()  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
	    return maxDate;  
	}
}
