import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class dom4jTest {
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		
		try {
			//1,创建SAX解析对象
			SAXReader reader = new SAXReader();
			//2,指定Xml解析源文件
			Document document = reader.read(new File("src/stus.xml"));
			//3,获取根元素
			Element root = document.getRootElement();
			
			String firstEleName = root.element("stu").element("name").getText();
			System.out.println(firstEleName);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testWithXPath() {
		try {
			//1,创建SAX解析对象
			SAXReader reader = new SAXReader();
			//2,指定Xml解析源文件
			Document doc = reader.read(new File("src/stus.xml"));
			List<Element> names = doc.selectNodes("//stus//stu//name");
			for(Element name : names) {
				System.out.println(name.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
