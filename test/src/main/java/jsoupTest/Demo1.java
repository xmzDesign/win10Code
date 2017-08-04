package jsoupTest;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		 Document document=Jsoup.connect("https://zhuanlan.zhihu.com/p/25746402")
	                //模拟火狐浏览器
	                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
	                .get();
		// #react-root > div > div > div.Layout-main.Layout-titleImage--normal > div.RichText.PostIndex-content > blockquote
	        Elements main=document.getElementsByTag("blockquote");
	       // Elements url=main.children();
	        System.out.println(main);
	        
	        
	        Connection.Response res = Jsoup.connect("http://www.example.com/login.php")
	        	    .data("username", "myUsername", "password", "myPassword")
	        	    .method(Method.POST)
	        	    .execute();

	        	Document doc = res.parse();
	        	//这儿的SESSIONID需要根据要登录的目标网站设置的session Cookie名字而定
	        	String sessionId = res.cookie("SESSIONID"); 
	        	//在上面的代码成功登录后，就可以利用登录的cookie来保持会话，抓取网页内容了
	        	Document objectDoc = Jsoup.connect("http://www.example.com/otherPage")
	        		    .cookie("SESSIONID", sessionId)
	        		    .get();
	    }
	}


