package zhujie;

import java.lang.reflect.Method;

public class MyReflection {
	public static void main(String[] args) throws Exception {
		MyTest myTest = new MyTest();
		Class<MyTest> c = MyTest.class;
		Method method =c.getMethod("output");
		if(MyTest.class.isAnnotationPresent(MyAnnotation.class))  
		  {  
		   System.out.println("have annotation");  
		  }  
		   if (method.isAnnotationPresent(MyAnnotation.class))  
		   {  
		   method.invoke(myTest, null); //调用output方法  
		   //获取方法上注解@MyAnnotation的信息  
		     MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);  
		    String hello = myAnnotation.hello();  
		   String world = myAnnotation.world();  
		   System.out.println(hello + ", " + world);//打印属性hello和world的值    
		   System.out.println(myAnnotation.style());  
		   }  
	}

}
