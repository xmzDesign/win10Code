package Proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{
	/**
	 * 创建代理对象
	 * // 回调方法  
     enhancer.setCallback(this);
     // 创建代理对象  
     * enhancer.create();    
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result=proxy.invokeSuper(obj, args);
		return result;
	}
	public static void main(String[] args) {
		CGLibProxy cgLibProxy=new CGLibProxy();
		Human humanProxy=cgLibProxy.getProxy(HuamnImpl.class);
		humanProxy.eat("rice");//执行intercept()这个方法
	}
}
