package com.dscexpen.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Export {

	/**
	 * 统计导出EXCEL文件
	 * 
	 * @param list
	 * @param request
	 */
	public static void ExportEXCEL(List<?> list, HttpServletRequest request,
			String[] titles) {
		File path = new File(request.getSession().getServletContext()
				.getRealPath("\\")
				+ "tracefiles\\"
				+ request.getSession().getId()
				+ "exportEXCEL.xls");

		HSSFWorkbook workbook = new HSSFWorkbook();// 创建个空白的workbook
		HSSFSheet sheet = workbook.createSheet();// 创建个空白的sheet
		int rownum = 0;
		HSSFRow row = sheet.createRow(rownum);// 创建行
		for (int j = 0; j < titles.length; j++) {
			row.createCell(j).setCellValue(titles[j]);
		}
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			if (rownum == 60000) {
				sheet = workbook.createSheet();// 创建个空白的sheet
				rownum = 0;
			}

			row = sheet.createRow(++rownum);// 创建行
			for (int i = 0; i < objects.length; i++) {
				HSSFCell cell = row.createCell(i);// 创建上面行的第一个单元格
				if (objects[i] != null) {
					cell.setCellValue(objects[i].toString());
				} else {
					cell.setCellValue("");
				}
			}
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path.getAbsolutePath());
			workbook.write(out);// 调用HSSFWorkbook类的write方法写入到输出流
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param file
	 * @throws IOException
	 */
	public static void downFile(HttpServletResponse response, File file)
			throws IOException {
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(
				file));
		byte[] buf = new byte[1024];
		int len = 0;
		response.reset();
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ file.getName());
		OutputStream out = response.getOutputStream();
		while ((len = br.read(buf)) > 0)
			out.write(buf, 0, len);
		file.delete();
		br.close();
		out.close();
	}
	public static HttpServletResponse downFile2(HttpServletResponse response,
			String path) throws IOException {
		try {
			// path下载的文件的路径。
			File file = new File(path);
			if(!file.exists()){
				PrintWriter	out = response.getWriter();
				StringBuffer strb = new StringBuffer();
				strb.append("<script type='text/javascript' charset='UTF-8'>");
				strb.append("alert('文件不存在~~~');window.history.go(-1)");
				strb.append("</script>");
				out.print(strb.toString());
				out.close();
				return response;
				
			}
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			/*String ext = filename.substring(filename.lastIndexOf(".") + 1)
					.toUpperCase();*/

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(),"ISO-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public static boolean removeFile(String path) {
		File file = new File(path);
		boolean delete = false;
		if(file.exists()){
			delete = file.delete();
			delete=true;
		}
		return delete;
		
	}

}
