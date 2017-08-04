package designPatterns;

public class Test {
	public static void main(String[] args) {
		String loginType="password";
		String name="name";
		String password="password";
		Login login = LoginManage.factory(loginType);
		boolean b = login.vertify(name, password);
		
	}
}
