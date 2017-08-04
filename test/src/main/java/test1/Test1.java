package test1;

import java.util.Date;

public class Test1 {
	public static void main(String[] args){
        String a = "沪A00001浙A3433X浙A1638T";   
        String[] strs = new String[a.length()-1];
        for(int i=0;i<a.length()-1;i+=7){
            strs[i] = a.substring(i, i+7);
            System.out.println(strs[i]);
        }
        System.out.println(new Date(1212213210000l));
    }

}
