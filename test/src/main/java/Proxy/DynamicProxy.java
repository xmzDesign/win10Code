package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * jdk代理
 * 通过Proxy.newProxyInstance代理一个该接口对应的InvocationHandler对象
 * 然后在InvocationHandler的invoke方法内封装细节就可以
 * 
 * 实现InvocationHandler 
* 使用Proxy.newProxyInstance产生代理对象
* 被代理的对象必须要实现接口
 * 
 * @author Minzhe Xu	2017年4月6日下午10:48:04
 *
 */
public class DynamicProxy implements InvocationHandler{
	private Object object;
	public DynamicProxy(Object object){
		this.object=object;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//before();
		Object result=method.invoke(object, args);
		return result;
	}
	public static void main(String[] args) {
		Human human=new HuamnImpl();
		DynamicProxy dynamicProxy=new DynamicProxy(human);
		Human HumanProxy=(Human) Proxy.newProxyInstance(human.getClass().getClassLoader()
				, human.getClass().getInterfaces(), dynamicProxy);
		HumanProxy.eat("rice");
	}

}
