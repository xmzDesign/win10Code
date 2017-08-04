package jsoupTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		
		File file=new File("D://image");
		if(!file.exists()){
			file.mkdirs();
		}
		//for(int i=1;i<=10;i++){
			Document document=Jsoup.connect("https://www.zhihu.com/question/28106019").userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
	                .get();
			Elements pngs = document.select("img[src~=(?i)\\.(png|jpe?g|jpg)]");
			for(Element e:pngs){
				String src=e.attr("src");//获取img中的src路径
				//String newSrc=src.replace("_b", "_r");
				 //获取后缀名
	            String imageName = src.substring(src.lastIndexOf("/") + 1,src.length());
	          //连接url
	            try {
	            	 URL url = new URL(src);
	 	            URLConnection uri=url.openConnection();
	 	           InputStream is=uri.getInputStream();
		            //写入数据流
		            OutputStream os = new FileOutputStream(new File("D://image", imageName)); 
		            byte[] buf = new byte[1024];
		            int l=0; 
		            while((l=is.read(buf))!=-1){
		            	os.write(buf, 0, l);
		            }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	           
	          //获取数据流
	            
	            
	            
			}
		//}
		
		
		
		
	}

}
