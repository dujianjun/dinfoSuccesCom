package com.dscexpen.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyOrMove {

		public static void copyFolder(String oldPath, String newPath, String fileName) {
			try {
				File file = new File(newPath);
				if(!file.exists()){
					file.mkdirs();
				}
				File temp = null;
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + fileName);
				} else {
					temp = new File(oldPath + File.separator + fileName);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					//设置缓冲区最大字节为5M
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					//关闭流
					output.flush();
					output.close();
					input.close();
					temp.delete();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
	
		}

}
