package test;

public class demo1 {
	public static void main(String[] args) {
		String str="GETBAGSTATE-01-16-01020304";
		String[] split = str.split("-");
		for(int i=0;i<split.length;i++){
			System.out.println(split[i]);
		}
	}

}
