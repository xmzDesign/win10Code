package test1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 * 将一个正常格式txt文件的内容读取出来，封装到HashMap中
 * @author Minzhe Xu	2017年3月3日下午6:13:11
 *
 */
public class CarNoTxtInputToMap {
	public static void main(String[] args) {
		 FileInputStream fis = null;
		  InputStreamReader isr = null;
		  BufferedReader br = null; 
		  String str2="";
		  Map map=new HashMap();
		  String key="";
		  String value="";
		  try {
				 fis = new FileInputStream("D:\\Total.txt");
				 isr = new InputStreamReader(fis,"GBK");// InputStreamReader 是字节流通向字符流的桥梁,
				 br = new BufferedReader(isr);
				 while ((str2 = br.readLine()) != null) {
					 if(str2!=null){
							key=str2.substring(0, 12);//这边代码写的太丑了，应该加个逗号用split
							value=str2.substring(12);
							System.out.println(key+"           "+value);
							map.put(key, value);
						}
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					br.close();
					isr.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
