package Proxy;
/**
 * 静态代理
 * @author Minzhe Xu	2017年4月6日下午9:33:59
 *
 */
public class HumanProxy implements Human{
	private Human human;
	public HumanProxy(){
		human=(Human) new HumanProxy();
		//human=new HuamnImpl();
	}
	@Override
	public void eat(String food) {
		before();
		human.eat(food);
		after();
	}
	private void before(){
	    System.out.println("cook");
	  }

	  private void after(){
	    System.out.println("swap");
	  }
	  public static void main(String[] args) {
		Human humanProxy=new HumanProxy();
		humanProxy.eat("rice");
	}

}
