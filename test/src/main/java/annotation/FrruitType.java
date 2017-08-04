package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FrruitType {
	/**
	 * 水果标号
	 */
	int num1() ;
	
	/**
	 * 水果原厂地
	 */
	String fruitHome() ;
	
	/**
	 * 水果等级
	 */
	String fruitLevel() ;

}
