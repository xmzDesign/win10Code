package annotation;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Minzhe Xu	2017年4月27日下午3:09:20
 *
 */
@TestA(gid = Long.class, name = "type")
public class UserAnotation {
	@TestA(gid = Long.class, name = "param",id=1)
	private Integer age;
	
	@TestA(gid = Long.class, name = "constract",id=2)
	public UserAnotation(){
		
	}
	@TestA(gid = Long.class, name = "method",id=3)
	public void test1(){
		@SuppressWarnings("rawtypes")
		Map m=new HashMap(0);
	}
	
	@TestA(gid = Long.class, name = "method3",id=5)
	public void test2(@TestA(gid = Long.class, name = "inner_param",id=4) Integer a){
		
	}
	

}
