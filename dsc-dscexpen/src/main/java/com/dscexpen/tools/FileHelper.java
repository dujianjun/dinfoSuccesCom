package com.dscexpen.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	// 文件名
	private String fileName;
	// 字符集名称
	private String charsetName;

	public FileHelper(String fileName) {
		setFileName(fileName);
		setCharsetName("utf-8");
	}

	public FileHelper(String fileName, String charsetName) {
		setFileName(fileName);
		setCharsetName(charsetName);
	}

	public String getCharsetName() {
		return charsetName;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    // 文件清零
	public int reset() {
		try {
			File file = new File(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream(file), charsetName);
			osw.close();
			osw = null;
			file = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> readAllLine() {
		List<String> lst = new ArrayList<String>();

		String tempstr = null;
		try {
			String path = getFileName();
			File file = new File(path);
			if (!file.exists()) {
				throw new FileNotFoundException();
			}

			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), getCharsetName());
			BufferedReader br = new BufferedReader(read);

			while ((tempstr = br.readLine()) != null) {
				lst.add(tempstr);
			}
			br.close();
			read.close();
			
			br = null;
			read = null;
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		return lst;
	}

	public int read(StringBuffer sb) {
		try {
			// 方法1：新建FileInputStream对象
			// 新建文件“file.txt”对应File对象
			File file = new File(fileName);
			InputStreamReader in = new InputStreamReader(new FileInputStream(
					file), charsetName);

			char[] buff = new char[1024 * 1024];
			while (0 < in.read(buff, 0, buff.length)) {
				sb.append(buff);
				// System.out.println("buf=" + new String(buff));
			}
			in.close();
			in = null;
			file = null;
			String str = sb.substring(0);
		//	System.out.println(str);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int write(StringBuffer sb) {
		try {
			// 创建文件“file.txt”对应File对象
			File file = new File(fileName);
			// 创建FileOutputStream对应OutputStreamWriter：将字节流转换为字符流，即写入out1的数据会自动由字节转换为字符。
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream(file), charsetName);
			osw.write(sb.substring(0));

			osw.close();
			osw = null;
			file = null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	// 在文件末尾添加内容
	public int append(StringBuffer sb) {
		try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            byte[] content = sb.substring(0).getBytes(charsetName);
            randomFile.write(content);
            randomFile.close();
            
            randomFile = null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 在文件末尾添加内容
	public int append(String text) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(text);

			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			//将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			byte[] content = sb.substring(0).getBytes(charsetName);
			randomFile.write(content);
			randomFile.close();

			randomFile = null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

}

