package com.dscexpen.tools.excel2003;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExcelWriter {
	 //2003excel模板
		public void template(List<String> templateList, OutputStream out,String sheetName) throws IOException {
			// 声明一个工作薄
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(sheetName);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short) 15);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 声明一个画图的顶级管理器
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			// 定义注释的大小和位置,详见文档
			HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
					0, 0, 0, (short) 4, 2, (short) 6, 5));
			// 设置注释内容
			comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
			// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
			comment.setAuthor("leno");

			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (short i = 0; i < templateList.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
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
