package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;


class A{
	void f1() {}
}
class B extends A{
	void f2() {}
}
class C{
	A m1() {return new A();}
	A m2() {return new B();} //��ĳ����
	//B m3() {return new A();} //�ڽ� = �θ�(�ڹ� �������� �����ȵ�)
	B m4() {return new B();}
}

public class Hello{
	public static void main(String[] args) {
		//������ ���� = �������� �޸� Ȯ��
		C c = new C();
		A a0 = c.m2();
		A a1 = (A)c.m2();
		A a2 = (B)c.m2();
		a1.f1();
		a2.f1();
		//a2.f2();
		
		((A)c.m2()).f1();
		//((A)c.m2()).f2();
		((B)c.m2()).f1();
		((B)c.m2()).f2();
	}
}

/*
//step6)
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Gas implements Fuel{
	public String getFuel() {
		return "����";
	}
}

class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}
class Ship{
	Fuel fuel;
	Ship(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ���ġ��");
	}
}
class Car{
	Fuel fuel;
	Car(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� �޸���");
	}
}

public class Hello {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("Context.xml");
//		Fuel fuel = ctx.getBean("makeFuel", Water.class);
//		System.out.println(fuel.getFuel());
		
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		airplane.fly();
		Ship ship = ctx.getBean("ship", Ship.class);
		ship.fly();
		Car car = ctx.getBean("car", Car.class);
		car.fly();
	}
}
*/

/*
//step5)
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}

@Configuration
class Factory{
	@Bean
	Fuel makeFuel() {
		return new Water();
	}
	@Bean
	Airplane airplane() {
		return new Airplane(makeFuel());
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Factory.class);
		
		Fuel fuel = ctx.getBean("makeFuel", Fuel.class);
		//�Ʒ��� �ڵ�� ������ ��Ȱ�� �Ѵ�.(����� Ÿ������ Ÿ��ĳ����)
		//Fuel fuel = (Fuel)ctx.getBean("makeFuel");
			
		//Airplane airplane = new Factory().airplane();
		//���� �̿��Ͽ� �Ʒ��� �ڵ带 ���
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		airplane.fly();
		ctx.close();
	}
}
*/

/*
//step4)
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}
class Ship{
	Fuel fuel;
	Ship(Fuel fuel){this.fuel = fuel;}
}
class Car{
	Fuel fuel;
	Car(Fuel fuel){this.fuel = fuel;}
}

class Factory{
	Fuel makeFuel() {
		return new Water();
	}
	Airplane airplane() {
		return new Airplane(makeFuel());
	}
	Ship ship() {
		return new Ship(makeFuel());
	}
	Car car() {
		return new Car(makeFuel());
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane();
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car= new Factory().car();
	}
}
*/

/*
//step3) 
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}
class Ship{
	Fuel fuel;
	Ship(Fuel fuel){this.fuel = fuel;}
}
class Car{
	Fuel fuel;
	Car(Fuel fuel){this.fuel = fuel;}
}

class Factory{
	//���Ḧ ����� ��ü�� �����ϱ�����
	Airplane airplane() {
		Airplane airplane = new Airplane(makeFuel());
		return airplane;
	}
	Ship ship() {
		Ship ship = new Ship(makeFuel());
		return ship;
	}
	Car car() {
		Car car = new Car(makeFuel());
		return car;
	}
	Fuel makeFuel() {
		return new Water();
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane();
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car= new Factory().car();
	}
}
*/


/*
//step2)
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}
class Factory{
	//���Ḧ ����� ��ü�� �����ϱ�����
	//���1)
//	Airplane nakeAirplane() {
//		Airplane airplane = new Airplane(new Water());
//		return airplane;
//	}

	//���2)
	Airplane airplane() {
		Airplane airplane = new Airplane(new Water());
		return airplane;
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane();
		airplane.fly();
	}
}
*/

/*
// step1) ������ ����
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "�� ����");
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Airplane(new Water());
		airplane.fly();
	}
}
*/