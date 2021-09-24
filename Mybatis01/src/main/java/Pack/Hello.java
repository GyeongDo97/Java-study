package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Bean 의 약속 2가지
//1. 디폴트 생성자만 있다.(인수전달 생성자가 있으면 안 된다.)
//2. 반드시 setter, getter함수가 있어야 한다.
class Person{
	String name;//필드(클래스 내부에 있는 변수) - setter, getter를 가지게되면 필드라 안 하고property라고 한다.
	//단줄처리해주는 단축키 : Ctrl + Alt + j
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	int age;
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}
public class Hello{
	public static void main(String[] args) {
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
		
		System.out.println(1);
		
		session = ssf.openSession();

		
		//객체이용 select
//		try {
//			List<Person> mm = session.selectList("test08");
//			for (Person p : mm) {
//				System.out.println(p.getName() + " " + p.getAge());
//			}
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		
		
		//객체이용 업데이트
//		try {
//			Person p = new Person();
//			p.setName("4321");
//			p.setAge(10);
//			int r = session.update("test07", p);
//			int r = session.update("test07", p);
//			if(session.update("test07", p) > 0)
//				session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		
		
		//객체이용 삭제
		try {
			Person p = new Person();
			p.setName("4321");
			p.setAge(10);
			int r = session.delete("test06", p);
			if(r > 0) {
			session.commit();
			}
			
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}

		
		//객체이용 삽입
//		try {
//			Person p = new Person();
//			p.setName("독수리");
//			p.setAge(10);
//			int r = session.insert("test05", p);
//			if(session.insert("test05", p) > 0)
//				session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		System.out.println(2);
	}
}

/*
interface Delegate{
	int delegate(SqlSession session);
}

class Proxy{
	static void command(UserDao dao, Delegate d) {
		SqlSession session = dao.ssf.openSession();
		try {
			if(d.delegate(session) > 0)
				session.commit();
		}catch (Exception e) {e.printStackTrace();
		}finally {session.close();}
	}
}

class UserDao{
	SqlSessionFactory ssf;
	UserDao(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {e.printStackTrace();}		
	}
	
	void insert(final String s) {	
		Proxy.command(this,  new Delegate() {
			public int delegate(SqlSession session) {
				return session.insert("test02", s);				
			}
		});
	}

	void update(final String s) {	
		Proxy.command(this,  new Delegate() {
			public int delegate(SqlSession session) {
				return session.insert("test04", s);				
			}
		});
	}
	
}
public class Hello{
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		dao.insert("1234");
		dao.update("1234");
		
	}
}
*/



/*
class UserDao{
	SqlSessionFactory ssf;
	UserDao(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {e.printStackTrace();}		
	}
	
	void showAge() {
		SqlSession session = ssf.openSession();
		List<Integer> mm = session.selectList("test01");
		for(Integer item : mm) {
			System.out.println(item + " ");
		}		
		session.close();
	}

	void insert(String s) {	
		SqlSession session = ssf.openSession();
		try {
			int result = session.insert("test02", s);
			if(result > 0)	session.commit();
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}	
	}

	void delete(String s) {	
		SqlSession session = ssf.openSession();
		try {
			int result = session.delete("test03", s);
			if(result > 0)	session.commit();
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}	
	}

	void update(String s) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.update("test04", s);
			if(result > 0)	session.commit();
		} catch (Exception e) {	e.printStackTrace();
		} finally {	session.close();}
	}
}

public class Hello{
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		dao.insert("1234");
//		dao.update("1234");
		dao.showAge();
		
	}
}
*/


/*
public class Hello {

	public static void main(String[] args) {
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
		
		System.out.println(1);
		
		session = ssf.openSession();

		//select하는 부분
//		try {
//			List<Integer> mm = session.selectList("test01");
//			for(Integer item : mm) {
//				System.out.println(item + " ");
//			}
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}

		
		// update하는 부분
//		try {
//			int result = session.update("test04", "호랑이");
//			System.out.println(result);
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		
		
		//delete하는 부분
//		try {
//			int result = session.delete("test03", "9999");
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}

		
		//insert하는 부분
//		try {
//			int result = session.insert("test02", "9999");
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
	}

}
*/