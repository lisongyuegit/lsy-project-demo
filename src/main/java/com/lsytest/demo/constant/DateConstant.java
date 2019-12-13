package constant;

import java.text.SimpleDateFormat;

/**
 * ������
 * @author LiSongYue
 *
 */
public class DateConstant {
	//��
	public static final long ny = 24 * 60 * 60 * 365 * 1000L;
	//��
	public static final long mo = 1000 * 24 * 60 * 60 * 30L;
	//��
	public static final long nd = 1000 * 24 * 60 * 60;
	//Сʱ
	public static final long nh = 1000 * 60 * 60;
    //��
	public static final long nm = 1000 * 60;
    //��
	public static final long ns = 1000;
	//չʾ��ʱ���ʽ
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
	//ת����ʱ���ʽ
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    
}
