package unittsting;

import java.io.IOException;

public class OpenExternalProgram {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		//��һ���ⲿ���� 
		String youdaoNote = "D:\\Program Files\\Notepad++\\notepad++.exe";
		for(int i = 0 ; i <= 60 ; i++){
			//Thread.sleep(1000);
			//Thread.sleep(1000);
		}
		Runtime.getRuntime().exec(youdaoNote);

	}

}
