package constant;

import java.text.SimpleDateFormat;

/**
 * 常量类
 * @author LiSongYue
 *
 */
public class DateConstant {
	//年
	public static final long ny = 24 * 60 * 60 * 365 * 1000L;
	//月
	public static final long mo = 1000 * 24 * 60 * 60 * 30L;
	//天
	public static final long nd = 1000 * 24 * 60 * 60;
	//小时
	public static final long nh = 1000 * 60 * 60;
    //分
	public static final long nm = 1000 * 60;
    //秒
	public static final long ns = 1000;
	//展示的时间格式
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
	//转换的时间格式
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    
}
