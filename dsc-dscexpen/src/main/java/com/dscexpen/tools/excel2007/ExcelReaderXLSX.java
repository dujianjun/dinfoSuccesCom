package com.dscexpen.tools.excel2007;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderXLSX {
	// public Account account;
	private static Logger logger = Logger.getLogger(ExcelReaderXLSX.class);

	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private XSSFRow row;

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param
	 * @return String 表头内容的数组
	 */

	public String[] readExcelTitle(String fileName) {
		try {
			InputStream is = new FileInputStream(fileName);
			wb = new XSSFWorkbook(new BufferedInputStream(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			title[i] = getCellFormatValue(row.getCell((short) i));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param
	 * @return Map 包含单元格数据内容的Map对象
	 * @throws Exception
	 */

	public List<Map<String, String>> readExcelContent(String fileName)
			throws Exception {
		// Map<Integer, String> content = new HashMap<Integer, String>();
		String str = "";
		try {
			InputStream is = new FileInputStream(fileName);
			wb = new XSSFWorkbook(new BufferedInputStream(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		List<Map<String, String>> taskList = new ArrayList<Map<String, String>>();

		if (rowNum >= 1) {
			String[] title = this.readExcelTitle(fileName);
			for (int i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				int j = 0;
				Map<String, String> task = new HashMap<String, String>();
				while (j < colNum) {

					str = getCellFormatValue(row.getCell((short) j)).trim();
					task.put(title[j], str);
					j++;
				}
				taskList.add(task);
			}
		} else {
			return null;
		}
		return taskList;

	}

	public List<Map<String, String>> readExcelContent(BufferedInputStream is) throws Exception {
		String str = "";
		try {
			wb = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			title[i] = getCellFormatValue(row.getCell((short) i));
		}		
		// 正文内容应该从第二行开始,第一行为表头的标题
		List<Map<String, String>> taskList = new ArrayList<Map<String, String>>();
		if (rowNum >= 1) {
			for (int i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				int j = 0;
				Map<String, String> task = new HashMap<String, String>();
				while (j < colNum) {
					str = getCellFormatValue(row.getCell((short) j)).trim();
					task.put(title[j], str);
					j++;
				}
				taskList.add(task);
			}
		} else {
			return null;
		}
		return taskList;
	}

	/**
	 * 根据XSSFCell类型设置数据
	 * 
	 * @param
	 * @return
	 */
	private String getCellFormatValue(XSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case XSSFCell.CELL_TYPE_NUMERIC:
			case XSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (XSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式

					// 这样子的data格式是带时分秒的
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// 这样子的data格式是不带带时分秒的
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为STRIN
			case XSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}

}