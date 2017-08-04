package test1;

public class strDemo {
	public static void main(String[] args) {
		String str="{1}已确定新合伙人{2}，请门门店督导3尽快重新开业。";
		String str1=str.replace("{1}", "某个门店");
		String str2=str1.replace("{2}","某人");
		System.out.println(str2);
	}

}
