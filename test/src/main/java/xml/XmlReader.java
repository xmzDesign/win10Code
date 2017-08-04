package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
//D:\workspace\test\src\main\resources\test.xml
//D:\workspace\test\src\main\java\xml\XmlReader.java
public class XmlReader {
	public static void main(String[] args) {
		Element element=null;
		File file=new File("src/main/resources/test.xml");
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		try {
			// 返回documentBuilderFactory对象
			   dbf = DocumentBuilderFactory.newInstance();
			   // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
			   db = dbf.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			   Document dt = db.parse(file);
			   // 得到一个elment根元素
			   element = dt.getDocumentElement();
			   // 获得根节点
			   System.out.println("根元素：" + element.getNodeName());
			   NodeList nList = dt.getElementsByTagName("Account");
			 //遍历该集合，显示结合中的元素及其子元素的名字
	            for(int i = 0; i< nList.getLength() ; i ++){
	                Element node = (Element)nList.item(i);
	                System.out.println("Name: "+ node.getElementsByTagName("code").item(0).getFirstChild().getNodeValue());
	                System.out.println("Num: "+ node.getElementsByTagName("pass").item(0).getFirstChild().getNodeValue());
	                System.out.println("Classes: "+ node.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
	                System.out.println("Address: "+ node.getElementsByTagName("money").item(0).getFirstChild().getNodeValue());
	            }
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
