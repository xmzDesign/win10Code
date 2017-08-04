package test1;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	    list.add("111");
	    list.add("222");
	    
	    for (String str : list)
	    {
	        System.out.println(str);
	    }
	}

}
