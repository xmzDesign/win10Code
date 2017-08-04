package test1;

import java.util.Calendar;

public class demo5 {
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();    
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//        int hour = ca.get(Calendar.HOUR_OF_DAY);    
//        int minute = ca.get(Calendar.MINUTE);    
//        int second = ca.get(Calendar.SECOND);    
//        //时分秒（毫秒数）    
//        long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;    
//        //凌晨00:00:00    
//        ca.setTimeInMillis(ca.getTimeInMillis()-millisecond);
//        ca.setTimeInMillis(ca.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
        System.out.println(ca.getTime());
        
        String str="-null-null";
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
        	System.out.println(split.length);
			System.out.println(split[i]);
		}
        
        String str1="0000a";
        String upperCase = str1.toUpperCase();
        System.out.println(upperCase);
	}

}
