package test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class demo3 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(df.parse("2017-03-15"));
		
	}

}
