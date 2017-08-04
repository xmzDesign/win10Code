package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) throws IOException {
		
		  FileInputStream fis = null;
		  InputStreamReader isr = null;
		  BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		  FileOutputStream fos=null;
		  OutputStreamWriter osr=null;
		  BufferedWriter bw=null;
		   String str2 = "";
		   String str3 = "";
		   try {
			 fis = new FileInputStream("D:\\世茂茂悦府.txt");
			 isr = new InputStreamReader(fis,"gbk");// InputStreamReader 是字节流通向字符流的桥梁,
			 br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
			
			fos = new FileOutputStream("D:\\世茂茂悦府utf-8.txt");
			osr=new OutputStreamWriter(fos,"utf-8");
			bw=new BufferedWriter(osr);
			 
			 while ((str2 = br.readLine()) != null) {
				 String str4=chepaiJiequ(str2);
				// String str5=wenjianJiequ(str2);
				 if(str4!=null){
					 str3 += str4 +"\r\n";
				 }
				   }
			 bw.write(str3);
			 System.out.println(str3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 br.close();
		     isr.close();
		     fis.close();
		     bw.close();
		     osr.close();
		     fos.close();
		     
		}
		
//		String str="IMG_8461.jpg                   浙AXR926 浙 AXR926";
//		Pattern p=Pattern.compile("[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z,0-9]{4}[A-Z0-9挂学警港澳]{1}");
//		Matcher m = p.matcher(str);
//		
//		while(m.find()){
//			String tmp=m.group();
//			if(!"".equals(tmp)){
//				System.out.println(tmp);
//			}
//		}
//		Pattern p1=Pattern.compile("IMG_[0-9]{4}\\.jpg");
//		Matcher m1 = p1.matcher(str);
//		while(m1.find()){
//			String tmp=m1.group();
//			if(!"".equals(tmp)){
//				System.out.println(tmp);
//			}
//		}		
	}
	
	/**
	 * 截取车牌号码
	 * @param str
	 * @return
	 */
	public static String chepaiJiequ(String str){
		Pattern p=Pattern.compile("[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z,0-9]{4}[A-Z0-9挂学警港澳]{1}");
		Matcher m = p.matcher(str);
		String tmp=null;
		while(m.find()){
			tmp=m.group();
			if(!"".equals(tmp)){
				return tmp;
			}else{
				return null;
			}
		}
		return tmp;
	}
	
	/**
	 * 截取文件名称
	 */
	public static String wenjianJiequ(String str){
		Pattern p1=Pattern.compile("IMG_[0-9]{4}\\.jpg");
		Matcher m1 = p1.matcher(str);
		String tmp=null;
		while(m1.find()){
			tmp=m1.group();
			if(!"".equals(tmp)){
				return tmp;
			}else{
				return null;
			}
		}
		return tmp;		
	}

}

