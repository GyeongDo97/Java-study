package Pack;



/*
//ex5) DAO (데이터베이스에서 CRUD를 할 수 있는 클래스)
class UserDao{
	ConnectionMaker c;
	UserDao(ConnectionMaker c){
		this.c = c;
	}
	void addUser() {
		c.connect();
		System.out.println("insert into");
	}
}

interface ConnectionMaker{
	void connect();
}
class AnazomConnection implements ConnectionMaker{
	@Override
	public void connect() {
		System.out.println("오라클DB 연결");
	}
}
public class Hello {
	public static void main(String[] args) {
		UserDao userDao = new UserDao(new AnazomConnection());
		userDao.addUser();
	}
}
*/


/*
//ex4) DAO (데이터베이스에서 CRUD를 할 수 있는 클래스)
abstract class UserDao{
	void addUser() {//의도적으로 인수 전달 하지 않음
		//크게 3가지의 코드가 들어간다.
		//1.DB 접속
		ConnectionMaker conn = getConnection();
		conn.connect();
		//2.DB에 등록(insert into)
		System.out.println("insert into");
		//3.DB 종료
		conn.close();
	}
	
	void getUser() {//의도적으로 인수 전달 하지 않음
		//크게 3가지의 코드가 들어간다.
		//1.DB 접속
		ConnectionMaker conn = getConnection();
		conn.connect();
		//2.DB에 조회(select)
		System.out.println("select...");
		//3.DB 종료
		conn.close();
	}	
	abstract ConnectionMaker getConnection();
}

class AmazonDao extends UserDao{
	@Override
	ConnectionMaker getConnection() {
		return new AnazomCommection();
	}
}

interface ConnectionMaker{
	void connect();
	void close();
}
class AnazomCommection implements ConnectionMaker{
	@Override
	public void connect() {
		System.out.println("오라클DB 연결");
	}
	public void close() {
		System.out.println("오라클DB 죵료");
	}
}
public class Hello {
	public static void main(String[] args) {
		UserDao userDao = new AmazonDao();
		userDao.addUser();
		userDao.getUser();
	}
}
*/


/*
//ex3)
abstract class PizzaStore{
	void orderPizza() {
//		CreatePizza().make();
		Pizza pizza = CreatePizza();
		pizza.make();
		System.out.println("본점 브랜드를 이용해서 판매한다");
	}	
	abstract Pizza CreatePizza();
	//앞으로 나를 상속받는 객체는 getFuel를 만드세요
	//템플릿 메소드 패턴
}

class SeoulPizzaStore extends PizzaStore{
	@Override
	Pizza CreatePizza() {
		return new SeoulPizza();
		//팩토리 메쏘드 패턴
		//자식 클래스가 어떤 객체를 생성할지 결정하는 패턴
	}
}

interface Pizza{
	void make();
}
class SeoulPizza implements Pizza{
	@Override
	public void make() {
		System.out.println("서울형 피자를 만든다.");
	}
}
public class Hello {
	public static void main(String[] args) {
		PizzaStore pizzastore = new SeoulPizzaStore();
		pizzastore.orderPizza();
	}
}
*/



/*
//ex2)
abstract class Airplane{
	void fly() {
		getFuel().use();
		System.out.println("로 날아갑니다.");
	}
	
	void method() {}; // hook 함수
	
	abstract Fuel getFuel();
	//앞으로 나를 상속받는 객체는 getFuel를 만드세요
	//템플릿 메쏘드 패턴
}

class KoreaAir extends Airplane{
	@Override
	Fuel getFuel() {
		return new Water();
		//팩토리 메쏘드 패턴
		//자식 클래스가 어떤 객체를 생성할지 결정하는 패턴
	}
}

interface Fuel{
	void use();
}
class Water implements Fuel{
	@Override
	public void use() {
		System.out.print("물");
	}
}
public class Hello {
	public static void main(String[] args) {
		Airplane airplane = new KoreaAir();
		airplane.fly();
	}
}
*/




/* 
//ex1)
class Airplane{
	Fuel fuel;
	public Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		fuel.use();
		System.out.println("로 날아갑니다.");
	}
}
interface Fuel{
	void use();
}
class Water implements Fuel{
	@Override
	public void use() {
		System.out.print("물");
	}
}
public class Hello {
	public static void main(String[] args) {
		Airplane airplane = new Airplane(new Water());
		//인젝션 (물을 비행기에 넣어주는거)
		//의존적 관계 - DI(의존적 주입defendship injection)
		airplane.fly();
	}
}
*/