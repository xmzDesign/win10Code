package cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 
 * @author Minzhe Xu	2017年4月18日下午1:37:55
 *intercept方法的参数名并不是原生的参数名，
 *我做了自己的调整，几个参数的含义为：
 *Object表示要进行增强的对象Method表示拦截的方法Object[]数组表示参数列表，
 *基本数据类型需要传入其包装类型，
 *如int-->Integer、long-Long、double-->DoubleMethodProxy表示对方法的代理，
 *invokeSuper方法表示对被代理对象方法的调用
 */
public class DaoProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		 System.out.println("Before Method Invoke");
	        proxy.invokeSuper(object, objects);
	        System.out.println("After Method Invoke");
	        
	        return object;
	}

}
