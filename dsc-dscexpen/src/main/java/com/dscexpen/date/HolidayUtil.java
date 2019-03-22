package com.dscexpen.date;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dscexpen.tools.FileUtils;
import org.apache.log4j.Logger;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * 根据读取配置的excel判断是否为法定节假日，及法定工作日
 * @author Administrator
 *
 */
public class HolidayUtil {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<String> holidays = new ArrayList<String>();
    private List<String> workdays = new ArrayList<String>();
    private Date now = new Date();
    private Logger logger = Logger.getLogger(HolidayUtil.class);

    /**
     * 判断当天是否是工作日 (工作日：true；节假日：false)
     * @param filePath
     * @return
     */
    public boolean isWorkDay(String filePath){
        boolean flag = true;
        parseExcel(filePath);//读取excel中的节假日和工作日

        int dateType = getDateType();

        //如果excel不存在当前日期。判断是否周六日
        if(dateType==0){

            Calendar c = Calendar.getInstance();
            if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||
                    c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                flag = false;
            }

        }else{//如果存在当前日期，根据返回的类型判断

            if(dateType==1){//节假日
                flag = false;
            }

/*            else if(dateType==2){//工作日
                flag = true;
            }*/

        }

        logger.info("当前日期是："+(flag==true?"工作日":"节假日"));

        return flag;
    }

    /**
     * 根据判断当前时间是否是节假日还是工作日  (excel中不存在当前日期：0；节假日：1；工作日：2)
     * 如果当前日期在excel中的节假日和工作日都写了，默认的工作日
     * @return
     */
    private int getDateType(){
        int type = 0;

        String today = sdf.format(now);

        if(holidays.size()>0){
            for(String holiday:holidays){
                if(holiday.equals(today)){
                    type = 1;
                    break;
                }
            }
        }

        if(workdays.size()>0){
            for(String workday:workdays){
                if(workday.equals(today)){
                    type = 2;
                }
            }
        }

        return type;
    }


    /**
     * 读取excel中的节假日和工作日
     * @param filePath
     */
    private void parseExcel(String filePath){
        if(filePath==null||"".equals(filePath)){
            return ;
        }

        Workbook workbook = null;
        try {
            File file =new File(filePath);
            if(!file.exists()){
                System.out.println("文件不存在");
            }
            workbook = Workbook.getWorkbook(new FileInputStream(filePath));
            Sheet sheets[] = workbook.getSheets();

            if(sheets==null||sheets.length==0){
                return;
            }
            Sheet sheet = sheets[0];//取到第一个sheet
            int rows = sheet.getRows();
            //获取第一列数据-节假日
            for(int rowIndex = 1;rowIndex <rows;rowIndex++){
                Cell cell = sheet.getCell(0, rowIndex);
                if(cell==null){
                    break;
                }

                if(cell.getType() == CellType.DATE){
                    DateCell dateCell = (DateCell)cell;
                    Date date = dateCell.getDate();
                    String dateStr = sdf.format(date);
                    holidays.add(dateStr);
                }

            }


            //获取第二列数据-额外工作日
            for(int rowIndex = 1;rowIndex <rows;rowIndex++){
                Cell cell = sheet.getCell(1, rowIndex);
                if(cell==null){
                    break;
                }
                if(cell.getType() == CellType.DATE){
                    DateCell dateCell = (DateCell)cell;
                    Date date = dateCell.getDate();
                    String dateStr = sdf.format(date);
                    workdays.add(dateStr);
                }
            }

            logger.info(holidays.toString());
            logger.info(workdays.toString());

        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(workbook!=null){
                workbook.close();
                workbook = null;
            }
        }
    }


    public static void main(String[] args) {
       HolidayUtil h = new HolidayUtil();
        String path = FileUtils.class.getResource("/").getPath() + "com/geex/file/HolidayUtil2.xls";
       h.parseExcel(path);
        System.out.println(111111111);

    }
}