package com.dscexpen.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * 遍历文件夹
     *
     * @param
     */
    public final static List<String> getPdfFiles(String filePath) {
        List<String> list = new ArrayList<String>();

        File file = new File(filePath);
        File[] fs = file.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile() && fs[i].getAbsolutePath().endsWith(".pdf")) {
                list.add(fs[i].getAbsolutePath());
            }
        }
        return list;
    }
    
    public final static String getPdfFile(String filePath,String fileName) {
        File file = new File(filePath);
        File[] fs = file.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile() && fs[i].getAbsolutePath().endsWith(".pdf")) {
            	if(fs[i].getName().equals(fileName)){
            		return fs[i].getAbsolutePath();
            	}
            }
        }
        return null;
    }

    // 获取文件名
    public final static String getFileName(String filePath) {
        String filePathFormat = filePath.replace('\\', '/');
        int index = filePathFormat.lastIndexOf('/');
        return index < 0 ? filePathFormat : filePathFormat.substring(index + 1);
    }


    // 创建，如果文件有内容，则清空文件
    public final static void create(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.close();
    }

    // 创建文件目录
    public final static boolean createDir(String dirPath) {
        File file = new File(dirPath);
        boolean isMaked = file.mkdirs();
        file = null;
        return isMaked;
    }
}
