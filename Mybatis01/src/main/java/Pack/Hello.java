package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Bean �� ��� 2����
//1. ����Ʈ �����ڸ� �ִ�.(�μ����� �����ڰ� ������ �� �ȴ�.)
//2. �ݵ�� setter, getter�Լ��� �־�� �Ѵ�.
class Person{
	String name;//�ʵ�(Ŭ���� ���ο� �ִ� ����) - setter, getter�� �����ԵǸ� �ʵ�� �� �ϰ�property��� �Ѵ�.
	//����ó�����ִ� ����Ű : Ctrl + Alt + j
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

		
		//��ü�̿� select
//		try {
//			List<Person> mm = session.selectList("test08");
//			for (Person p : mm) {
//				System.out.println(p.getName() + " " + p.getAge());
//			}
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		
		
		//��ü�̿� ������Ʈ
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
		
		
		//��ü�̿� ����
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

		
		//��ü�̿� ����
//		try {
//			Person p = new Person();
//			p.setName("������");
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

		//select�ϴ� �κ�
//		try {
//			List<Integer> mm = session.selectList("test01");
//			for(Integer item : mm) {
//				System.out.println(item + " ");
//			}
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}

		
		// update�ϴ� �κ�
//		try {
//			int result = session.update("test04", "ȣ����");
//			System.out.println(result);
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
		
		
		//delete�ϴ� �κ�
//		try {
//			int result = session.delete("test03", "9999");
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}

		
		//insert�ϴ� �κ�
//		try {
//			int result = session.insert("test02", "9999");
//			if(result > 0)	session.commit();
//		} catch (Exception e) {	e.printStackTrace();
//		} finally {	session.close();}
	}

}
*/