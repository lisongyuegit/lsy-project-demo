//package date;
//
//import constant.DateConstant;
//
//import java.text.ParseException;
//import java.util.Date;
///**
// * 计算时间差
// * @author LiSongYue
// *
// */
//public class DatePoor {
//	public static void main(String[] args) throws ParseException {
//		String minYear = "2020-01-18";
//		System.out.println("小年还有: "+getDatePoor(minYear));
//
//		String yearDate = "2020-01-24";
//		String results = getDatePoor(yearDate);
//		System.out.println("过年还有: " +results);
//
//		String houseDate = "2020-9-9";
//		System.out.println("距离交房还有: "+getDatePoor(houseDate));
//
//		String comeHere = "2016-07-17";
//		System.out.println("李伟麒已经出生: "+getDatePoor(comeHere));
//
//		String mrLiWeiQi = "2019-7-1";
//		System.out.println("我已经来公司: "+getDatePoor(mrLiWeiQi));
//
//	}
//	/**
//	 * 计算传入时间和当前时间差
//	 * @param date
//	 * @return
//	 */
//	public static String getDatePoor(String date){
//		String resultsStr = "";
//		StringBuffer strBuf = new StringBuffer("");
//		//余数
//		long remainder = 0;
//		//获取当前时间
//		Date nowDate = new Date();
//		try {
//			//转换入参时间
//			Date endDate = DateConstant.sdf2.parse(date);
////			System.out.println("计算时间为: "+DateConstant.sdf.format(endDate));
////			System.out.println("当前时间为: "+DateConstant.sdf.format(nowDate));
//			//计算时间差
//			long datePoor = Math.abs(endDate.getTime()-nowDate.getTime());
//			//System.out.println("时间差为: "+datePoor+"毫秒");
//			//计算相差年
//			long year = getShang(datePoor, DateConstant.ny);
//			remainder = getRemainder(datePoor, DateConstant.ny);
//			//计算相差月
//			long month = getShang(remainder, DateConstant.mo);
//			remainder = getRemainder(remainder, DateConstant.mo);
//			//计算相差天数
//			long day = getShang(remainder,DateConstant.nd);
//			remainder = getRemainder(remainder,DateConstant.nd);
//			//计算相差小时
//			long hours = getShang(remainder,DateConstant.nh);
//			remainder = getRemainder(remainder,DateConstant.nh);
//			//计算相差分
//			long min = getShang(remainder,DateConstant.nm);
//			remainder = getRemainder(remainder,DateConstant.nm);
//			//计算相差秒
//			long second = getShang(remainder,DateConstant.ns);
//			remainder = getRemainder(remainder,DateConstant.ns);
//			//组装字符串
//			addAppend(strBuf, year, "年.");
//			addAppend(strBuf, month, "个月.");
//			addAppend(strBuf, day, "天.");
//			addAppend(strBuf, hours, "小时.");
//			addAppend(strBuf, min, "分钟.");
//			addAppend(strBuf, second, "秒.");
//			strBuf.append(remainder).append("毫秒!");
//			resultsStr = strBuf.toString();
//			return resultsStr;
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return resultsStr;
//	}
//
//	/**
//	 * 取商
//	 * @param divisor
//	 * @param dividend
//	 * @return
//	 */
//	public static long getShang(long divisor,long dividend){
//		if(dividend > divisor){
//			return 0;
//		}
//		return divisor / dividend;
//	}
//	/**
//	 * 取余数
//	 * @param divisor
//	 * @param dividend
//	 * @return
//	 */
//	public static long getRemainder(long divisor,long dividend){
//		if(dividend > divisor){
//			return divisor;
//		}
//		return divisor % dividend;
//	}
//	/**
//	 * 字符串拼接
//	 * @param strBuf
//	 * @param year
//	 * @param str
//	 * @return
//	 */
//	public static void addAppend(StringBuffer strBuf,long year,String str){
//		if(0 != year){
//			strBuf.append(year).append(str);
//		}
//	}
//}
