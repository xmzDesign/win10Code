package cglibProxy;

import org.junit.Test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
/**
 * 
 * @author Minzhe Xu	2017年4月18日下午1:38:19
 *
 */
public class CglibTest {
	/**
	 * CallbackFilter的accept方法返回的数值表示的是顺序，
	 * 顺序和setCallbacks里面Proxy的顺序是一致的。再解释清楚一点，Callback数组中有三个callback，
	 * 那么：方法名为"select"的方法返回的顺序为0，即使用Callback数组中的0位callback，
	 * 即DaoProxy方法名不为"select"的方法返回的顺序为1，即使用Callback数组中的1位callback，即DaoAnotherProxy
	 * update()方法不是方法名为"select"的方法，因此返回1，返回1使用DaoAnotherProxy，即打印时间；
	 * select()方法是方法名为"select"的方法，因此返回0，返回0使用DaoProxy，即方法调用前后输出两句话。
	 * ，Callback数组中我特意定义了一个NoOp.INSTANCE，
	 * 这表示一个空Callback，即如果不想对某个方法进行拦截，可以在DaoFilter中返回2，具体效果可以自己尝试一下。
	 */
	@Test
	public void testCglib1(){
		DaoProxy daoProxy=new DaoProxy();
		DaoAnotherProxy daoAnotherProxy=new DaoAnotherProxy();
		
		
		Enhancer enhancer=new Enhancer();
		
		enhancer.setSuperclass(Dao.class);
		//enhancer.setCallback(daoProxy);
		enhancer.setCallbacks(new Callback[]{daoProxy,daoAnotherProxy,NoOp.INSTANCE});
		enhancer.setCallbackFilter(new DaoFilter());
		enhancer.setInterceptDuringConstruction(false);
		Dao dao = (Dao) enhancer.create();
		dao.update();
		dao.select();
		
	}
	/**
	 * setSuperclass表示设置要代理的类，
	 * setCallback表示设置回调即MethodInterceptor的实现类，
	 * 使用create()方法生成一个代理对象，注意要强转一下，因为返回的是Object
	 */
	@Test
	public void testCglib(){
		DaoProxy daoProxy=new DaoProxy();
		
		Enhancer enhancer=new Enhancer();
		
		enhancer.setSuperclass(Dao.class);
		enhancer.setCallback(daoProxy);
		
		Dao dao = (Dao) enhancer.create();
		dao.update();
		
		dao.select();
		
	}

}
