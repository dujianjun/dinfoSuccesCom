package com.dscexpen.date;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-05-10  14:27  星期四
 * version 1.0
 */
public class ChineseWorkDay {
private  static    Logger logger = Logger.getLogger(ChineseWorkDay.class);
/**
 * 获取当年中国的法定节假日和工作日等信息。 如下是当前包含的功能：
 * 01-给定日期，判断是否是法定节假日。
 * 02-给定日期，判断是否是周末（周末不一定是休息日，可能需要补班）。
 * 03-给定日期，判断是否是需要额外补班的周末。
 * 04-给定日期，判断是否是休息日（包含法定节假日和不需要补班的周末）。
 * 05-给定日期，判断是否是工作日(非休息日)。
 * 06-获取一年中总共的天数。
 * 07-获取一年中法定节假日的天数。
 * 08-获取一年中需要补班的周末天数。
 * 09-获取一年中周末的天数（周六+周日）。
 * 10-获取一年中休息日的天数（法定节假日+不需要补班的周末）。
 *
 */

private  String calendar;
    private  Date date;
    public ChineseWorkDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.calendar= sdf.format(date);
        this.date = date;
    }
    // 法律规定的放假日期
    private List<String> lawHolidays = new ArrayList<String>(Arrays.asList(
            "2018-01-01", "2018-02-15", "2018-02-16", "2018-02-17", "2017-12-30", "2018-12-31",
            "2018-02-18", "2018-02-19", "2018-02-20", "2018-02-21",
            "2018-04-05", "2018-04-06", "2018-04-07", "2018-04-29",
            "2018-04-30", "2018-05-01", "2018-05-01", "2018-06-16",
            "2018-06-17", "2018-06-18",  "2018-09-22", "2018-09-23",
            "2018-09-24", "2018-10-01",  "2018-10-02","2018-10-03",
            "2018-10-04", "2018-10-05",  "2018-10-06", "2018-10-07"));
    // 由于放假需要额外工作的周末
    private List<String> extraWorkdays = new ArrayList<String>(Arrays.asList(
            "2018-02-11", "2018-02-24", "2018-04-08", "2018-04-28", "2018-09-29", "2018-09-30"));

    /**
     * 判断是否是法定假日
     *
     * @return
     * @throws Exception
     */
    public boolean isLawHoliday() throws Exception {

        if (lawHolidays.contains(calendar)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是周末
     *
     * @return
     * @throws ParseException
     */
    public boolean isWeekends() throws Exception {

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        if (ca.get(Calendar.DAY_OF_WEEK) == 1
                || ca.get(Calendar.DAY_OF_WEEK) == 7) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是需要额外补班的周末
     *
     * @return
     * @throws Exception
     */
    public boolean isExtraWorkday() throws Exception {
        if (extraWorkdays.contains(calendar)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是休息日（包含法定节假日和不需要补班的周末）
     *
     * @return
     * @throws Exception
     */
    public boolean isHoliday() throws Exception {

        // 首先法定节假日必定是休息日
        if (this.isLawHoliday()) {
            return true;
        }
        // 排除法定节假日外的非周末必定是工作日
        if (!this.isWeekends()) {
            return false;
        }
        // 所有周末中只有非补班的才是休息日
        if (this.isExtraWorkday()) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是工作日
     *
     * @return
     * @throws Exception
     */
    public boolean isWorkday() throws Exception {

        return !(this.isHoliday());
    }

    public int getTotalDays() {
        return new GregorianCalendar().isLeapYear(Calendar.YEAR) ? 366 : 365;
    }

    public int getTotalLawHolidays() {
        return lawHolidays.size();
    }

    public int getTotalExtraWorkdays() {
        return extraWorkdays.size();
    }

    /**
     * 获取一年中所有周末的天数
     * @return
     */
    public int getTotalWeekends() {
        List<String> saturdays = new ArrayList<String>();
        List<String> sundays = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int nextYear = 1 + calendar.get(Calendar.YEAR);
        Calendar cstart = Calendar.getInstance();
        Calendar cend = Calendar.getInstance();
        cstart.set(currentYear, 0, 1);// 今年的元旦
        cend.set(nextYear, 0, 1);// 明年的元旦
        return this.getTotalSaturdays(saturdays, calendar, cstart, cend,
                currentYear)
                + this.getTotalSundays(sundays, calendar, cstart, cend,
                currentYear);
    }

    private int getTotalSaturdays(List<String> saturdays, Calendar calendar,
                                  Calendar cstart, Calendar cend, int currentYear) {
        // 将日期设置到上个周六
        calendar.add(Calendar.DAY_OF_MONTH, -calendar.get(Calendar.DAY_OF_WEEK));
        // 从上周六往这一年的元旦开始遍历，定位到去年最后一个周六
        while (calendar.get(Calendar.YEAR) == currentYear) {
            calendar.add(Calendar.DAY_OF_YEAR, -7);
        }
        // 将日期定位到今年第一个周六
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        // 从本年第一个周六往下一年的元旦开始遍历
        for (; calendar.before(cend); calendar.add(Calendar.DAY_OF_YEAR, 7)) {
            saturdays.add(calendar.get(Calendar.YEAR) + "-"
                    + calendar.get(Calendar.MONTH) + "-"
                    + calendar.get(Calendar.DATE));
        }
        return saturdays.size();
    }

    private int getTotalSundays(List<String> sundays, Calendar calendar,
                                Calendar cstart, Calendar cend, int currentYear) {
        // 将日期设置到上个周日
        calendar.add(Calendar.DAY_OF_MONTH,
                -calendar.get(Calendar.DAY_OF_WEEK) + 1);
        // 从上周日往这一年的元旦开始遍历，定位到去年最后一个周日
        while (calendar.get(Calendar.YEAR) == currentYear) {
            calendar.add(Calendar.DAY_OF_YEAR, -7);
        }
        // 将日期定位到今年第一个周日
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        // 从本年第一个周日往下一年的元旦开始遍历
        for (; calendar.before(cend); calendar.add(Calendar.DAY_OF_YEAR, 7)) {
            sundays.add(calendar.get(Calendar.YEAR) + "-"
                    + calendar.get(Calendar.MONTH) + "-"
                    + calendar.get(Calendar.DATE));
        }
        return sundays.size();
    }

    public int getTotalHolidays(){
        //先获取不需要补班的周末天数
        int noWorkWeekends = this.getTotalWeekends() - this.getTotalExtraWorkdays();
        return noWorkWeekends + this.getTotalLawHolidays();
    }


    /**
     *
     * 如果date不是工作日，date前一天是工作日，返回date前一天
     *
     * @param date
     * @return
     * @throws Exception
     */

    public static Date chaekDate(Date date) throws Exception {
        ChineseWorkDay cc = new ChineseWorkDay(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,-1);
        ChineseWorkDay   cc2 = new ChineseWorkDay(cal.getTime());
        if(!cc.isWorkday()&&cc2.isWorkday()){
            return cal.getTime();
        }
        return chaekDate(cal.getTime());
    }




    public static void main(String[] args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2018-09-25";
        Date dateSt = simpleDateFormat.parse(str);
        Calendar ca0 = Calendar.getInstance();
        ca0.setTime(dateSt);
        ca0.set(Calendar.HOUR_OF_DAY, 0);
        ca0.set(Calendar.MINUTE, 0);
        ca0.set(Calendar.SECOND, 0);
        ChineseWorkDay today = new ChineseWorkDay(ca0.getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateSt);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        ChineseWorkDay yestoday = new ChineseWorkDay(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dateSt);
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        ChineseWorkDay tomorrow = new ChineseWorkDay(cal2.getTime());


        if(today.isWorkday()&&!yestoday.isWorkday()){
            Date startDate = ChineseWorkDay.chaekDate(ca0.getTime());
            Date endDate = ca0.getTime();
            logger.info("执行节假日job： " + simpleDateFormat.format(startDate) + "-->" + simpleDateFormat.format(endDate) + "(不包括)");

        }else if(today.isWorkday()&&yestoday.isWorkday()){
            logger.info("执行正常job： " + simpleDateFormat.format(ca0.getTime()));

        }else{
            logger.info("不需要执行job： " + simpleDateFormat.format(ca0.getTime()));

        }

      /*  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2018-06-04";
        Date dateSt = format.parse(str);
        ChineseWorkDay today = new ChineseWorkDay(dateSt);

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateSt);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        ChineseWorkDay yestoday = new ChineseWorkDay(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal.setTime(dateSt);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        ChineseWorkDay tomorrow = new ChineseWorkDay(cal2.getTime());*/


       /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ChineseWorkDay today = new ChineseWorkDay(new Date());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        ChineseWorkDay yestoday = new ChineseWorkDay(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        ChineseWorkDay tomorrow = new ChineseWorkDay(cal2.getTime());


        if(today.isWorkday()&&!yestoday.isWorkday()) {
            System.out.println(format.format(chaekDate(cal.getTime())) + "---->" + format.format(new Date()) + "|执行节日job");

        }else if(today.isWorkday()&&tomorrow.isWorkday()){
            System.out.println((format.format(new Date()))+ "|执行正常job");
        }else{
            System.out.println("不执行job");
        }*/






       /* Calendar cal =  Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2018-09-29");
        cal.setTime(date);

        ChineseWorkDay cc = new ChineseWorkDay(date);
        System.out.println("是否是法定节假日：" + cc.isLawHoliday());
        System.out.println("是否是周末：" + cc.isWeekends());
        System.out.println("是否是需要额外补班的周末：" + cc.isExtraWorkday());
        System.out.println("是否是休息日：" + cc.isHoliday());
        System.out.println("是否是工作日：" + cc.isWorkday());
        System.out.println("今年总共有" + cc.getTotalDays() + "天");
        System.out.println("今年总共有" + cc.getTotalLawHolidays() + "天法定节假日");
        System.out.println("今年总共有" + cc.getTotalExtraWorkdays() + "天需要补班的周末");
        System.out.println("今年总共有" + cc.getTotalWeekends() + "天周末");
        System.out.println("今年总共有" + cc.getTotalHolidays() + "天休息日");*/
    }

}