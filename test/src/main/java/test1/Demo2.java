package test1;

public class Demo2 {
	public static void main(String[] args) {
		String str="服务速度太慢、服务态度不好、服务质量不好、未使用清洗包$_$明亮，我做个测试！！！！！！";
		
		String [] str1=str.split("\\$_\\$");
		
		System.out.println(str1[1]);
		System.out.println(str1[0]);
	}

}
