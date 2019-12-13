package com.lsytest.demo.utlis.excel;

import java.io.*;

/**
 * 文件以及文件夹的创建与删除工具
 * @author Foldcc
 *
 */
public class FileUtils {
	/**
	 * 创建目录
	 * @param destDirName
	 * @return
	 */
	public boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			return true;
		} else {
			return false;
		}
	}


	public boolean createFile(String filePath){
		File file = new File(filePath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}


	/**
	 * 修改文件名
	 * @param file
	 * @param newName
	 * @return
	 */
	public boolean sFileName(File file , String newName){
		file.renameTo(new File(newName));   //改名
		return true;
	}

	/***
	 * 写入指定string到指定文本中
	 * @param Msg
	 * @param Path
	 */
	public void WriteBase(String Msg , String fileName){
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName), true)));
			out.write(Msg);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取指定路径文本返回String
	 * @param path
	 * @return
	 */
	public String ReadBase(String path) {
		StringBuffer buffer = null;
		try {
			InputStream is;
			is = new FileInputStream(path);
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null){
				buffer.append(line);
			}
			in.close();
			return buffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 判断指定文件地址是否存在 存在返回true
	 * @param destDirName
	 * @return
	 */
	public boolean existsDir(String destDirName){
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			return true;
		}
		return false;
	}

	/**
	 *  判断文件是否存在
	 * @param file
	 */
	public boolean judeFileExists(String fileName) {
		File file = new File(fileName);
		if (file.exists()){
			return true;
		}
		return false;
	}


	/**
	 *  删除单个文件
	 * @param filePath
	 * @return
	 */
	public boolean deleteFile(String filePath) {
		boolean flag = false;
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
			file.delete();// 文件删除
			flag = true;
		}
		return flag;
	}


	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * @param dirPath
	 * @return
	 */
	public boolean deleteDirectory(String dirPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!dirPath.endsWith(File.separator)) {
			dirPath = dirPath + File.separator;
		}
		File dirFile = new File(dirPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		File[] files = dirFile.listFiles();// 获得传入路径下的所有文件
		for (int i = 0; i < files.length; i++) {// 循环遍历删除文件夹下的所有文件(包括子目录)
			if (files[i].isFile()) {// 删除子文件
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;// 如果删除失败，则跳出
			} else {// 运用递归，删除子目录
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;// 如果删除失败，则跳出
			}
		}
		if (!flag)
			return false;
		if (dirFile.delete()) {// 删除当前目录
			return true;
		} else {
			return false;
		}
	}
}
