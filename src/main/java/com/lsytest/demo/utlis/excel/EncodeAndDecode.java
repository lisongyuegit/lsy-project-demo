package com.Foldcc.EJ_Tools;

import java.io.UnsupportedEncodingException;

/**
 * 加密解密器
 * @author Foldcc
 *
 */
public class EncodeAndDecode {
	private String[] encodeByte = {
			"@",
			"#",
			"*",
			"$",
			"+",
			"~",
			"&",
			"%",
			"(",
			")",
			"-"
	};
	/**
	 * 加密指定字符串
	 *
	 * @param str
	 *            要译码的字符串
	 * @return 译码后的字符串
	 */
	public String encode(String str) {
		if(str == null){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		byte[] sby;
		try {
			sby = str.getBytes("UTF-8");
			int n = sby.length;
			for (int i = 0; i < n; i++) {
				int a = sby[i];
				char[] s = String.valueOf(a).toCharArray();
				for (char b : s) {
					if((int)b != 45){
						sb.append(encodeByte[(int)b - 48]);
					}else{
						sb.append(encodeByte[10]);
					}
				}
				sb.append("_");
			}
			return sb.deleteCharAt(sb.length()-1).toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密指定字符串
	 *
	 * @param str
	 *            要解码的字符串
	 * @return 解码后的字符串
	 */
	public String decode(String str) {
		if(str == null){
			return null;
		}
		String strs[] = str.split("_");
		int n = strs.length;
		byte[] sby = new byte[n];
		for (int i = 0; i < n; i++) {
			char[] s = strs[i].toCharArray();
			String num = "";
			for(char ss : s){
				if(ss == '-'){
					num += "-";
				}else{
					for(int j = 0 ; j < encodeByte.length ; j++){
						if(encodeByte[j].toCharArray()[0] == ss){
							num += String.valueOf(j);
							break;
						}
					}
				}

			}
			try {
				sby[i] = Integer.valueOf(num).byteValue();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		try {
			return new String(sby , "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}  