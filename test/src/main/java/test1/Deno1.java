package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deno1 {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String,String>();
		 map.put("闽CR722Z", "IMG_5992.jpg");
	        map.put("浙A6AL79", "IMG_5993.jpg");
	        map.put("浙AE516S", "IMG_5994.jpg");
	        map.put("浙AU081D", "IMG_5995.jpg");
	        map.put("浙AVF665", "IMG_5996.jpg");
	        map.put("浙C70A7C", "IMG_5997.jpg");
	        map.put("浙A4VF66", "IMG_5998.jpg");
	        map.put("浙C70A7C", "IMG_5999.jpg");
	        
	        
	        for(Map.Entry<String,String> entry:map.entrySet()){
	        	System.out.println(entry.getKey());
	        	System.out.println(entry.getValue());
	        }
	}

}
