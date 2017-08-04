package zhujie;
@MyAnnotation(hello = "beijing", world="shanghai",style=int.class)
public class MyTest {
	@MyAnnotation(hello = "beijing",world = "shanghai")  
	 @Deprecated  
	 @SuppressWarnings("")
	public void output()  
	 {  
	  System.out.println("output something!");  
	 }  

}
