package date;
/**
 * 计时器
 * @author Administrator
 *
 */
public class Timer {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("计时开始......");
		for(int i = 0; i >= 0; i++){
			Thread.sleep(1000);
			String  times = run(i);
			System.out.println("已过时间: "+times);
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
		return  String.valueOf(day)+"天"+String.valueOf(hours)+"时"+String.valueOf(min)+"分"+String.valueOf(yunum)+"秒";
	}
}
