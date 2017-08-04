package cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DaoAnotherProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
		proxy.invokeSuper(object, objects);
		System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
		return object;
	}

}
