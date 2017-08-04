package annotation;

import annotation.PayTypes.PayType;

public class Apple extends Fruit{

	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	@FruitName("苹果")
	private String Fruitname;
	
	@PayTypes(payType=PayType.支付宝)
	private String payType;
	
	@FrruitType(fruitHome = "浙江", fruitLevel = "A", num1 = 0) 
	private String fruittype;

	public String getFruitname() {
		return Fruitname;
	}

	public void setFruitname(String fruitname) {
		Fruitname = fruitname;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFruittype() {
		return fruittype;
	}

	public void setFruittype(String fruittype) {
		this.fruittype = fruittype;
	}
	
	

}
