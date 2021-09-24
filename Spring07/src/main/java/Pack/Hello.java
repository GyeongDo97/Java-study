package Pack;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/*Controller
public class Hello {
	@RequestMapping("/hello")
	public static String main(String[] args, HttpServletRequest request) {
		
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(name + " " + age);
		
		ADto adto = new ADto();
		adto.setAge(age);
		adto.setName(name);

		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {e.printStackTrace();}
		ssf = new SqlSessionFactoryBuilder().build(is);
		System.out.println(1);
		session = ssf.openSession();
		try {
			int result = session.insert("hello", adto);
				if(result > 0)	session.commit();
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}
		System.out.println(3);
		return "success";
	}
}
*/

@Controller
public class Hello {
	@RequestMapping("/hello")
	public String insert(ADto adto) {
		
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {e.printStackTrace();}
		ssf = new SqlSessionFactoryBuilder().build(is);
		session = ssf.openSession();
		try {
			int result = session.insert("hello", adto);
				if(result > 0)	session.commit();
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}
		return "success";
	}
}
