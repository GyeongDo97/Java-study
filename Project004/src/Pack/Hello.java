package Pack;



/*
//ex5) DAO (�����ͺ��̽����� CRUD�� �� �� �ִ� Ŭ����)
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
		System.out.println("����ŬDB ����");
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
//ex4) DAO (�����ͺ��̽����� CRUD�� �� �� �ִ� Ŭ����)
abstract class UserDao{
	void addUser() {//�ǵ������� �μ� ���� ���� ����
		//ũ�� 3������ �ڵ尡 ����.
		//1.DB ����
		ConnectionMaker conn = getConnection();
		conn.connect();
		//2.DB�� ���(insert into)
		System.out.println("insert into");
		//3.DB ����
		conn.close();
	}
	
	void getUser() {//�ǵ������� �μ� ���� ���� ����
		//ũ�� 3������ �ڵ尡 ����.
		//1.DB ����
		ConnectionMaker conn = getConnection();
		conn.connect();
		//2.DB�� ��ȸ(select)
		System.out.println("select...");
		//3.DB ����
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
		System.out.println("����ŬDB ����");
	}
	public void close() {
		System.out.println("����ŬDB �շ�");
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
		System.out.println("���� �귣�带 �̿��ؼ� �Ǹ��Ѵ�");
	}	
	abstract Pizza CreatePizza();
	//������ ���� ��ӹ޴� ��ü�� getFuel�� ���弼��
	//���ø� �޼ҵ� ����
}

class SeoulPizzaStore extends PizzaStore{
	@Override
	Pizza CreatePizza() {
		return new SeoulPizza();
		//���丮 �޽�� ����
		//�ڽ� Ŭ������ � ��ü�� �������� �����ϴ� ����
	}
}

interface Pizza{
	void make();
}
class SeoulPizza implements Pizza{
	@Override
	public void make() {
		System.out.println("������ ���ڸ� �����.");
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
		System.out.println("�� ���ư��ϴ�.");
	}
	
	void method() {}; // hook �Լ�
	
	abstract Fuel getFuel();
	//������ ���� ��ӹ޴� ��ü�� getFuel�� ���弼��
	//���ø� �޽�� ����
}

class KoreaAir extends Airplane{
	@Override
	Fuel getFuel() {
		return new Water();
		//���丮 �޽�� ����
		//�ڽ� Ŭ������ � ��ü�� �������� �����ϴ� ����
	}
}

interface Fuel{
	void use();
}
class Water implements Fuel{
	@Override
	public void use() {
		System.out.print("��");
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
		System.out.println("�� ���ư��ϴ�.");
	}
}
interface Fuel{
	void use();
}
class Water implements Fuel{
	@Override
	public void use() {
		System.out.print("��");
	}
}
public class Hello {
	public static void main(String[] args) {
		Airplane airplane = new Airplane(new Water());
		//������ (���� ����⿡ �־��ִ°�)
		//������ ���� - DI(������ ����defendship injection)
		airplane.fly();
	}
}
*/