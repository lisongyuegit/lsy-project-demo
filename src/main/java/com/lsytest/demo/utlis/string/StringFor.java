package com.lsytest.demo.utlis.string;

import java.util.ArrayList;
import java.util.List;

public class StringFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 1;
		List<String> list = new ArrayList<String>();
		//list = null;
		if(null != list && list.size()>0) {
			for(int i = 0 ; i < list.size() ; i++){
				System.out.println("�������: "+i);
			}
		}

	}

}
