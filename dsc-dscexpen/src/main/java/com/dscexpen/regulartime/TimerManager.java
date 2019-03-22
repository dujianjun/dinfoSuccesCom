package com.dscexpen.regulartime;

import java.util.Calendar;  
import java.util.Date;  
import java.util.Timer;  

  
/** 
 * 任务管理 
 * @author admin_Hzw 
 * 
 */  
public class TimerManager {  
  
    /**
     * 1、
     * timer.schedule(task, time);
     * time为Date类型：在指定时间执行一次。
     * 2、
     *timer.schedule(task, firstTime, period);
     * firstTime为Date类型,period为long
     *从firstTime时刻开始，每隔period毫秒执行一次。
     * 3、
     *timer.schedule(task, delay)
     * delay 为long类型：从现在起过delay毫秒执行一次
     * 4、
     *timer.schedule(task, delay, period)
     *delay为long,period为long：从现在起过delay毫秒以后，每隔period
     *  毫秒执行一次。
     * @param args
     */  
    public static void main(String[] args) {  
        new TimerManager();    
    }  
  
    //时间间隔(一天)  
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;  
    public TimerManager() {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 15);
        Date date=calendar.getTime(); //第一次执行定时任务的时间  
        //如果第一次执行定时任务的时间 小于当前的时间  
        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。  
       if (date.before(new Date())) {
            date = this.addDay(date, 1);  
        }
        Timer timer = new Timer();
        Task task = new Task();  
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
        timer.schedule(task,10000);
    }  
    // 增加或减少天数  
    public Date addDay(Date date, int num) {  
        Calendar startDT = Calendar.getInstance();  
        startDT.setTime(date);  
        startDT.add(Calendar.DAY_OF_MONTH, num);  
        return startDT.getTime();  
    }  
  
}  