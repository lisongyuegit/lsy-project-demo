package date;
/**
 * ��ʱ��
 * @author Administrator
 *
 */
public class Timer {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("��ʱ��ʼ......");
		for(int i = 0; i >= 0; i++){
			Thread.sleep(1000);
			String  times = run(i);
			System.out.println("�ѹ�ʱ��: "+times);
		}
	}

	public static String run(int i){
		int min = i / 60;
		int yunum = i % 60;
		int hours = min / 60;
		int day = hours / 24;
		if(0 != hours){
			min = min % 60;
		}
		if(0 != day){
			hours = hours % 24;
		}
		return  String.valueOf(day)+"��"+String.valueOf(hours)+"ʱ"+String.valueOf(min)+"��"+String.valueOf(yunum)+"��";
	}
}
