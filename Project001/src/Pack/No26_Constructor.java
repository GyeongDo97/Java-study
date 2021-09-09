package Pack;
/*
//1) 생성자는 함수이다. 생성자 함수라 한다.
//2) 함수 이름은 클래스 이름과 반드시 동일해야한다.
//3) 생성자 함수는 return값을 가질 수가 없다.그래서 void도 생략한다.
//4) 생성자 함수도 오버로딩이 가능하다.
//5) 생성자 함수는 객체가 생성될 때 단 한번만 호출된다.(임의로 호출할 수 없다.)
//6) 생성자를 사용하는 목적은 멤버 메소드를 초기화시키기 위해 사용된다.
//7) 생성자 함수를 작성하지 않을시에는 자동으로 default생성자가 만들어진다.

class Tiger{
	int age = 20;
	String name = "홍길동";
	Tiger(){//인수 전달이 없는 생성자 - defualt 생성자
		System.out.println("생성자 쿼리");
		System.out.println("생성자가 호출되었다.");
		//age = 20;
		//name = "홍길동";
	}
	Tiger(int a, String n){
		age = a;
		name = n;
	}
	void showInfo() {
		System.out.println(age + " " + name);
	}
}

public class No26_Constructor
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger(100, "독수리");
		Tiger t4 = new Tiger(200, "앵무새");
		//System.out.println(t1.age + t1.name);
		//System.out.println(t2.age + t2.name);
		//System.out.println(t3.age + t3.name);
		//System.out.println(t4.age + t4.name); 아래와 같은 역활
		t1.showInfo();
		t2.showInfo();
		t3.showInfo();
		t4.showInfo();
	}
}
*/
