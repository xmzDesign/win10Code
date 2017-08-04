package test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo4 {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   	 Calendar cal_1=Calendar.getInstance();
   	 cal_1.add(Calendar.MONTH, 0);
   	 cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
   	cal_1.set(Calendar.HOUR_OF_DAY, 0);
   	cal_1.set(Calendar.MINUTE, 0);
   	cal_1.set(Calendar.SECOND, 0);
   	cal_1.set(Calendar.MILLISECOND, 0);
   	 System.out.println(cal_1.getTime());

	}

}
