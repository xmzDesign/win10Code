package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaDemo2 {
	private static List<String> list=new ArrayList<>();
	static{
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
	}
	private static Map<String, Integer> items = new HashMap<>();
	static {
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
    }
	
	public static void main(String[] args) {
		//java8之前的操作遍历集合
//		for(String item:list){
//			System.out.println(item);
//		}
		list.forEach(c->System.out.println(c));
		System.out.println("--------");
		//设置表达式
		list.forEach(c->{
			if("C".equals(c)){
				System.out.println(c);
			}
		});
		
		System.out.println("--------");
		//先过滤
		list.stream().filter(s->!s.equals("A")).forEach(c->System.out.println(c));
		System.out.println("--------");
		//Java8之前遍历是这样遍历map
        for(Map.Entry<String,Integer> entry:items.entrySet()){
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }
        System.out.println("--------");
        items.forEach((key,value)->System.out.println("key:"+key+" value:"+value));
	}

}
