package test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
	public static void main(String[] args) throws ParseException {
//		 Date now = new Date();  
//	        Date time = new Date(now.getYear(), now.getMonth(), now.getDate());  
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置时间格式  
//	        Calendar cal = Calendar.getInstance();  
//	        cal.setTime(time);  
//	        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
//	        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
//	        if (1 == dayWeek) {  
//	            cal.add(Calendar.DAY_OF_MONTH, -1);  
//	        }  
//	        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
//	        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
//	        cal.setFirstDayOfWeek(Calendar.MONDAY);  
//	        // 获得当前日期是一个星期的第几天  
//	        int day = cal.get(Calendar.DAY_OF_WEEK);  
//	        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
//	        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
//	        cal.set(Calendar.HOUR, 0);  
//	        cal.set(Calendar.MINUTE, 0);  
//	        cal.set(Calendar.SECOND, 0);  
//	        String imptimeBegin = sdf.format(cal.getTime()); 
//	        Date parse = sdf.parse(imptimeBegin);
//	        Date mondayDate = cal.getTime();  
//	        System.out.println("所在周星期一的日期：" + parse);  
		
//		Date date=new Date();
//		Date morningOfday = getMorningOfday(date);
//		System.out.println(morningOfday);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		Date date=new Date();
		String format = sdf.format(date);
		Date parse = sdf.parse(format);
		
		System.out.println(format);
		
//		Calendar calendar = Calendar.getInstance();
//		 calendar.set(Calendar.HOUR_OF_DAY, 0);
//         calendar.set(Calendar.MINUTE, 0);
//         calendar.set(Calendar.SECOND, 0);
//         calendar.set(Calendar.MONTH, 3);
//         calendar.set(Calendar.YEAR,2017);
//         calendar.set(Calendar.DAY_OF_MONTH,1);
//         Date zero = calendar.getTime();
//         System.out.println(zero); 
	}
	
	public static Date getMorningOfday(Date date){
    	Calendar calendar = Calendar.getInstance();
    	 calendar.setTime(date);
    	 calendar.set(Calendar.HOUR_OF_DAY, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date zero = calendar.getTime();
         return zero;
    }

}
