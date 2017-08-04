package cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;
/**
 * 返回的数值表示顺序
 * @author Minzhe Xu	2017年4月18日下午2:06:06
 *
 */
public class DaoFilter implements CallbackFilter{

	@Override
	public int accept(Method method) {
		if("select".equals(method.getName())){
			return 0;
		}
		return 1;
	}
}
