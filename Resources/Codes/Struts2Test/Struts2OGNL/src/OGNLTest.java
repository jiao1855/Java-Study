import org.junit.Test;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OGNLTest {
	
	@Test
	public void test1() throws OgnlException {
		
		
		OgnlContext context = new OgnlContext();
		Object root = context.getRoot();
		
		//1,调用对象的方法
		Object val = Ognl.getValue("'jyq'.length()", context, root);
		System.out.println(val);
		
		//2,调用对象的静态方法：@类名@方法名
		val = Ognl.getValue("@java.lang.Math@random()", context, root);
		System.out.println(val);
		
		//3，获取root中的数据，不需要加#
		context.setRoot(new User("jyq","123"));
		root = context.getRoot();
		Object username = Ognl.getValue("name", context, root);
		Object password = Ognl.getValue("password", context,root);
		System.out.println(username+":"+password);
		
		context.put("name", "jyq");
		val = Ognl.getValue("name", context, root);
		System.out.println(val);
	}

}
