package annotation;
/**
 * 支付类型
 * @author Minzhe Xu	2017年4月27日下午4:37:20
 *
 */
public @interface PayTypes {
	/**
	 * 类型枚举
	 */
	public enum PayType{支付宝,微信,现金};
	
	/**
	 * 支付方式
	 */
	PayType payType() default PayType.现金;
	

}
