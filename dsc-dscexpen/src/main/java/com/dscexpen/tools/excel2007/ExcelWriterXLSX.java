package com.dscexpen.tools.excel2007;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterXLSX {
	//2007excel模板
		public void wpsTemplate(List<String> templateList, OutputStream out,String sheetName) throws IOException {
			// 声明一个工作薄
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 生成一个表格
			XSSFSheet sheet = workbook.createSheet(sheetName);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short)25);
			sheet.setColumnWidth(0, 10*512);
			// 生成一个样式
			XSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			XSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
//			// 声明一个画图的顶级管理器
//			XSSFDrawing patriarch = sheet.createDrawingPatriarch();
//			// 定义注释的大小和位置,详见文档
//			XSSFComment comment = patriarch.createComment(new XSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
//			// 设置注释内容
//			comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
//			// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
//			comment.setAuthor("leno");

			// 产生表格标题行
			XSSFRow row = sheet.createRow(0);
			for (short i = 0; i < templateList.size(); i++) {
				XSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				XSSFRichTextString text = new XSSFRichTextString(
						templateList.get(i));
				cell.setCellValue(text);

			}
			// // 产生表格示例行
			// HSSFRow sampleRow = sheet.createRow(1);
			// List<String> sampleFirstCatalogue=map.get("sampleFirstCatalogue");
			// for (short i = 0; i <sampleFirstCatalogue.size(); i++) {
			// sampleRow.createCell(i).setCellValue(sampleFirstCatalogue.get(i));
			// }
			// // 产生表格示例行
			// HSSFRow sampleRow1 = sheet.createRow(2);
			// List<String>
			// sampleSecondCatalogList=map.get("sampleSecondCatalogList");
			// for (short i = 0; i <sampleSecondCatalogList.size(); i++) {
			// sampleRow1.createCell(i).setCellValue(sampleSecondCatalogList.get(i));
			// }
			// // 产生表格示例行
			// HSSFRow sampleRow2 = sheet.createRow(3);
			// List<String> sampleLeaf=map.get("sampleLeaf");
			// for (short i = 0; i <sampleLeaf.size(); i++) {
			// sampleRow2.createCell(i).setCellValue(sampleLeaf.get(i));
			// }
			workbook.write(out);
			out.close();
		}
}
