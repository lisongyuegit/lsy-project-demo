package string;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class BytesString {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		 Properties initProp = new Properties(System.getProperties());
		 System.out.println("当前系统编码:" + initProp.getProperty("file.encoding"));
		 System.out.println("当前系统语言:" + initProp.getProperty("user.language"));
		 String sb = "中文";
		 String cc = vail2(sb);
		 System.out.println(cc);


	}
	public static void vail (Object obj) throws UnsupportedEncodingException{
		 String iso8859 = new String(obj.toString().getBytes("iso8859-1"));
		 String gbk = new String(obj.toString().getBytes("gbk"));
		 String utf8 = new String(obj.toString().getBytes("utf-8"));
		 if(iso8859.equals(obj.toString())){
		     System.out.println("iso8859");
		 }else  if(gbk.equals(obj.toString())){
		     System.out.println("gbk");
		 }else  if(utf8.equals(obj.toString())){
		     System.out.println("utf8");
		 }
	}
	public static String vail2 (String str){
		 
		String encode = "GB2312"; 
//		try { 
//		if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
//		String s = encode; 
//		return s; //是的话，返回“GB2312“，以下代码同理
//		} 
//		} catch (Exception exception) { 
//		} 
		encode = "ISO-8859-1"; 
		try { 
		if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
		String s1 = encode; 
		return s1; 
		} 
		} catch (Exception exception1) { 
		} 
		encode = "UTF-8"; 
		try { 
		if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
		String s2 = encode; 
		return s2; 
		} 
		} catch (Exception exception2) { 
		} 
		encode = "GBK"; 
		try { 
		if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
		String s3 = encode; 
		return s3; 
		} 
		} catch (Exception exception3) { 
		}
		return encode; 
	}
	
	
	

}
