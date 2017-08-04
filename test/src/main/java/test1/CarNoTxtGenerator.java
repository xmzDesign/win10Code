package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将车牌生成器生成的车牌txt文件   变成一个正常格式的车牌文件
 * @author Minzhe Xu	2017年3月3日下午5:48:56
 *
 */
public class CarNoTxtGenerator {
	/**
	 * 生成一个正常格式的车牌txt文件
	 * @throws IOException
	 */
	public static void GeneratorNormalTextFile() throws IOException{
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		FileOutputStream fos = null;
		OutputStreamWriter osr = null;
		BufferedWriter bw = null;
		String str2 = "";
		String str3 = "";
		try {
			// 原始车牌号码汇总文件合成到一个文件 车牌.txt
			fis = new FileInputStream("D:\\SY-2B.txt");
			isr = new InputStreamReader(fis, "GBK");// InputStreamReader是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
			// 需要生成一个漂亮的车牌号码汇总文件 Total.txt
			fos = new FileOutputStream("D:\\丁香.txt");
			osr = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osr);
			//逐行读取文件
			while ((str2 = br.readLine()) != null) {
				String str4 = catchCarNo(str2);
				String str5 = catchImageFileName(str2);
				if (str4 != null && str5 != null) {
					//截取出来两个记录组装起来(这里其实可以加一个","),这样以后可以用split拆分,别忘了换行
					str3 += str5 + str4 + "\r\n";
				}
			}
			bw.write(str3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				bw.close();
				osr.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	/**
	 * 将一行车牌记录中的车牌号码截取出来出来
	 * 例如从"IMG_8461.jpg                   浙AXR926 浙 AXR926"中截取到"浙AXR926"
	 * @param str
	 * @return
	 */
	public static String catchCarNo(String str){
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
	 * 将一行车牌记录中的照片文件名截取出来出来
	 * 例如从"IMG_8461.jpg                   浙AXR926 浙 AXR926"中截取到"IMG_8461.jpg"
	 * @param str
	 * @return
	 */
	public static String catchImageFileName(String str){
		Pattern p1=Pattern.compile("IMG_[0-9]{4}\\.jpg");//4可以改成*
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
