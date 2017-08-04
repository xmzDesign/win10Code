package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 
 * @author Minzhe Xu	2017年4月27日下午3:39:17
 *
 */
public class ParseAnotation {
	
	public static void parseTypeAnnotation() throws ClassNotFoundException{
		Class clazz=Class.forName("annotation.UserAnotation");
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation annotation:annotations){
			TestA testA=(TestA) annotation;
			System.out.println("id="+testA.id()+";name="+testA.name()+";gid="+testA.gid());
		}
	}
	public static void parseMethodAnnotation(){
		Method[] methods = UserAnotation.class.getDeclaredMethods();
		for(Method method:methods){
			boolean hasAnnotation=method.isAnnotationPresent(TestA.class);
			if(hasAnnotation){
				TestA testA=method.getAnnotation(TestA.class);
				System.out.println("id="+testA.id()+";name="+testA.name()+";gid="+testA.gid());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void parseConstractAnnotation(){
		Constructor[] constructors = UserAnotation.class.getConstructors();
		for(Constructor contructor:constructors){
			boolean annotationPresent = contructor.isAnnotationPresent(TestA.class);//isAnnotationPresent方法来判断是否使用了某个注解
			if(annotationPresent){
				TestA testA = (TestA) contructor.getAnnotation(TestA.class);
				System.out.println("id="+testA.id()+";name="+testA.name()+";gid="+testA.gid());
			}
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		parseTypeAnnotation();
		parseMethodAnnotation();
		parseConstractAnnotation();
	}

}
