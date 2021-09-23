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
	A m2() {return new B();} //업캐스팅
	//B m3() {return new A();} //자식 = 부모(자바 문법에서 성립안됨)
	B m4() {return new B();}
}

public class Hello{
	public static void main(String[] args) {
		//왼쪽은 문법 = 오른쪽은 메모리 확보
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
		return "물";
	}
}
class Gas implements Fuel{
	public String getFuel() {
		return "가스";
	}
}

class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
	}
}
class Ship{
	Fuel fuel;
	Ship(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 헤엄치다");
	}
}
class Car{
	Fuel fuel;
	Car(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 달린다");
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
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
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
		//아래의 코드와 동일한 역활을 한다.(사용할 타입으로 타입캐스팅)
		//Fuel fuel = (Fuel)ctx.getBean("makeFuel");
			
		//Airplane airplane = new Factory().airplane();
		//빈을 이용하여 아래의 코드를 사용
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
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
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
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
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
	//연료를 사용할 객체를 생성하기위함
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
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
	}
}
class Factory{
	//연료를 사용할 객체를 생성하기위함
	//방법1)
//	Airplane nakeAirplane() {
//		Airplane airplane = new Airplane(new Water());
//		return airplane;
//	}

	//방법2)
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
// step1) 의존적 관계
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel){this.fuel = fuel;}
	void fly() {
		System.out.println(fuel.getFuel() + "로 날다");
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