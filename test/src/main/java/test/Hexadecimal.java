package test;
/**
 * 16进制与10进制相互转换
 * @author Minzhe Xu	2017年5月15日上午10:40:08
 *
 */
public class Hexadecimal {
	private static Integer valueOf;

	public static void main(String[] args) {
		//16进制转10进制
		System.out.println(Integer.parseInt("1f", 16));
		//10进制转16进制
		System.out.println(Integer.toHexString(9));
		valueOf = Integer.valueOf("010205");
		System.out.println(Integer.toHexString(010205));
		System.out.println(Integer.valueOf("010205"));
		
		String change = addZero("9");
		System.out.println(change);
		String topwd10 = removeZero(change);
		System.out.println(topwd10);
	}
	
	
	public static String addZero(String str){
		int length = str.length();
		char[] charArray = str.toCharArray();
		String str16="";
		for(int i=0;i<length;i++){
			str16+="0"+charArray[i];
		}
		return str16;
	}
	public static String removeZero(String str){
		int length = str.length();
		char[] charArray = str.toCharArray();
		String str10="";
		for(int i=1;i<length;i++){
			str10+=""+charArray[i++];
		}
		return str10;
	}

}
