package test1;

import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class demo1 {
	public static void main(String[] args) {
		InputStreamReader isr=null;
		String name="I am 徐敏哲";
		char[] name1=name.toCharArray();
		for(int i=0;i<name.length();i++){
			System.out.println(name1[i]);
		}
		Charset s=null;
	}

}
