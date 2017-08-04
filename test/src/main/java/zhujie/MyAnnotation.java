package zhujie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String hello() default "";
	String world();
	Class style() default void.class;

}
