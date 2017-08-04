package test;

public class Demo5 {
	public static void main(String[] args) {
		String hexString = Integer.toHexString(1);
		String addToEight = addToEight(hexString);
		System.out.println(addToEight);
		//addToEight("9");
	}
	private static String addToEight(String str){
		
		int length = str.length();
		String preStr="";
		for(int i=0;i<8-length;i++){
			preStr+=0;
		}
		str=preStr+str;
		//System.out.println(str);
		return str;
		
	}
	

}
