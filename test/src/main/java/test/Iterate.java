package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Iterate {
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		List list=new ArrayList();

		
		Map<String, String> map=new HashMap<String, String>();

		for(int i=0;i<10;i++){

		list.add(new String("list"+i) );

		//map.put(i, new String("map"+i));

		}
		Iterator iterList= list.iterator();
		while(iterList.hasNext()){

			String strList=(String)iterList.next();

			System.out.println(strList.toString());

			}
		//Set entrySet = map.entrySet();
		for(Map.Entry<String, String> entrySet1:map.entrySet()){
			entrySet1.getKey();
			entrySet1.getValue();
		}
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			next.getValue();
			next.getKey();
		}
	}

}
