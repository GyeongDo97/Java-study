package Pack;

import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
// ex)
class Animal{

}
class Tiger extends Animal{

}
public class Hello 
{
	public static void main(String[] args) {
		
	}
}
 */






/*
//ex69)UI에서 Thread 사용하기
class ConnectThread extends Thread{
	Hello hello;
	ConnectThread(Hello hello){
		this.hello = hello;
	}
	public void run() {
		System.out.println(2);
		Platform.runLater(
				()->{
					hello.btn1.setText("호랑이");
				});
	}
}
public class Hello extends Application{
	Button btn1 = new Button("테스트1");
	Button btn2 = new Button("테스트2");
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//------------------------------------

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new Thread() {
					//Thread는 만들고 나서 바로 실행시키는게 일반적
					//객체를 굳이 만들필요없다.
					public void run() {
						System.out.println(1);

						//btn2.setText("호랑이");
						//Thread안에서 조작을할려고하면 에러 발생
						//사용할려면 runLater이용해야함
						
						Platform.runLater(
								()->{
									btn2.setText("호랑이");
								});
					}
				}.start();
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
//				Thread t = new ConnectThread();
//				t.start();
//				아래처럼 변경가능
				
//				new ConnectThread().start();
				
				new ConnectThread(Hello.this).start();
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch();//blocking
		System.out.println("Exit");
	}
}
*/

/*
//ex68)
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//------------------------------------
		Button btn1 = new Button("테스트1");
		Button btn2 = new Button("테스트2");

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("호랑이");
				//btn2의 텍스트 변경
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
//				btn1.setVisible(false);
				//생성/삭제
				btn1.setDisable(true);
				//텍스트 활성화/비활성화
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch();//blocking
		System.out.println("Exit");
	}
}
*/

/*
//ex67)
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//------------------------------------
		Button btn1 = new Button("테스트1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("호랑이");
			}
		});
		TextArea textArea = new TextArea();
		//텍스트지역 생성
		
		TextField textField = new TextField();
		//입력창 생성
		
		textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("코끼리");
				String s = textField.getText();
				
				textArea.appendText(s + "\n");
				//textArea에 입력된 문자열을 전송
				//\n을 이용하여 문자열을 전송받은 이후 다음 줄로 엔터
				
//컨트롤 안에 내용이나 속성이나 모양 등등 수정, 변경을 할려고 할 때 쓰레드 안에서 하면 안 된다.
//쓰레드 안에서 밖에 할 수 없는 상황이 발생하면 
//run later을 이용하여 할 수 있다.
				
				textField.setText("");
				//textField에 입력엔터 이후 나오는 창을 만들어 줌
			}
		});
		root.getChildren().addAll(btn1, textArea, textField);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch();//blocking
		System.out.println("Exit");
	}
}
/*

/*
//ex66)
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//------------------------------------
		Button btn1 = new Button("테스트1");
		Button btn2 = new Button("테스트2");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("호랑이");
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("사자");
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch();//blocking
		System.out.println("Exit");
	}
}
*/


/*
//ex65)
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		//VBox 사용하면 세로로 붙음
		//HBox 사용하면 가로로 붙음
		root.setPrefSize(400, 300);
		
		root.setSpacing(10);
		//버튼끼리의 간격
		
		//------------------------------------
		// 이 영역 안에 모든 코드가 들어간다.
		
		// 방법1)
//		Button btn1 = new Button("테스트1");
//		root.getChildren().add(btn1);
//		//root밑으로 버튼을 추가하겠습니다.
//		Button btn2 = new Button("테스트2");
//		root.getChildren().add(btn2);
		
		// 방법2)
		Button btn1 = new Button("테스트1");
		Button btn2 = new Button("테스트2");
		root.getChildren().addAll(btn1, btn2);
		
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch();//blocking
		System.out.println("Exit");
	}
}
*/

/*
//ex64-4)Thread 예제3
public class Hello 
{
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				System.out.println(1);
			}
		};
		t.start();//Thread가 발동된다고 이해

		new Thread() {
			public void run() {
				System.out.println(2);
			}
		}.start();//Thread가 발동된다고 이해
		//call할 경우 갔다가 다시 돌아오는데 
		//이 경우는 run과 start가 같이 출발
	}
}
*/

/*
//ex64-3)Thread 예제2
class Tiger extends Thread{
	public void run() {
		System.out.println("Tiger start");
		Thread t = new Lion();
		t.start();
		Scanner sc = new Scanner(System.in);
//		sc.nextInt();//블로킹 함수
		System.out.println("tiger"+sc.nextInt());
		System.out.println("Tiger end");
	}
}
class Lion extends Thread{
	public void run() {
		System.out.println("Lion start");
		Scanner sc = new Scanner(System.in);
//		sc.nextInt();//블로킹 함수1
		System.out.println("Lion"+sc.nextInt());
		System.out.println("Lion end");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Tiger();
		t.start();
		Scanner sc = new Scanner(System.in);
//		sc.nextInt();//블로킹 함수
		System.out.println("main"+sc.nextInt());
		//Window - Show View - Other - Debug - Debug
		
		System.out.println("main end");
	}
}
*/

/*
//ex64-2)Tread 예제1
//순서가 어떻게 될지모를떄 즉, 왔다갔다할떄
//프로세스가 2개 돈다라고함
class Tiger extends Thread{
	public void run() {
		System.out.println(2);
		for (int i = 0; i < 10; i++) {
			System.out.println("호랑이" + i);
			try {Thread.sleep(0);} catch (Exception e) {}
			//0을 넣었을때 안 쉬는 것이 아니라
			//가능한 최소한의 시간을 쉰다.
		}
		System.out.println("종료");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Thread t = new Tiger();
		t.start();
		System.out.println(1);
		for (int i = 0; i < 10; i++) {
			System.out.println("사자" + i);
		}
		System.out.println("main Exit");
	}
}
*/

/*
//ex64-1)
class A {
	void start() {
		System.out.println("start call");
		run();
	}
	void run() {
		System.out.println("A run call");
	}
}
class B extends A {
	void run() {
		System.out.println("스레드 시작");
		System.out.println("B run call");
		System.out.println("스레드 종료");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		A a = new B();
		a.start();
	}
}
*/

/*
//ex63-2) 제네릭 문법
class A <T> {
	//type이 바뀔때마다 문법을 바꾸는 경우가 있는데
	//변경될때마다 자동으로 받아주는 문법
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
public class Hello 
{
	public static void main(String[] args) {
		A<Integer> a = new A<Integer>();
		a.setData(100);
		System.out.println(a.getData());

		A<String> b = new A<String>();
		b.setData("호랑이");
		System.out.println(b.getData());
		
		LinkedList<Integer> mm = new LinkedList<Integer>();
	}
}
*/

/*
//ex63-1)
class A {
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
class B {
	private String data;
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}
class C {
	private float data;
	
	public float getData() {
		return data;
	}
	
	public void setData(float data) {
		this.data = data;
	}
}
public class Hello 
{
	public static void main(String[] args) {
		A a = new A();
		a.setData(100);
		System.out.println(a.getData());

		B b = new B();
		b.setData("호랑이");
		System.out.println(b.getData());
	}
}
*/

/*
//ex62-3)디자인패턴.데커레이터(Decorator)
class 커피{
	int 가격 = 30;
	int 계산() {
		System.out.println("커피 주문");
		return 가격;
	}
}
class 설탕 extends 커피{
	int 가격 = 20;
	커피 a; // 곧 사라지게 될 객체를 백업받는다.
	설탕(커피 a){
		this.a = a;
	}
	int 계산() {
		System.out.println("설탕 추가");
		return 가격 + a.계산();
	}
}
class 프림 extends 커피{
	int 가격 = 10;
	커피 a; // 곧 사라지게 될 객체를 백업받는다.
	프림(커피 a){
		this.a = a;
	}
	int 계산() {
		System.out.println("프림 추가");
		return 가격 + a.계산();
	}
}


public class Hello 
{
	public static void main(String[] args) {
		커피 a = new 커피();
		System.out.println(a.계산());
		System.out.println("---------------");
		a = new 설탕(a);
		a = new 설탕(a);
		System.out.println(a.계산());
		System.out.println("---------------");
		a = new 프림(a);
		a = new 프림(a);
		a = new 프림(a);
		System.out.println(a.계산());
	}
}
*/


/*
//ex62-2)디자인패턴.데커레이터(Decorator)
//B객체는 A를 장식하고 있고 C객체는 B객체를 덧붙이고 있다.

class A{
	int num = 10;
	int run() {
		System.out.println("A Run");
		return num;
	}
}
class B extends A{
	int num = 20;
	A a; // 곧 사라지게 될 객체를 백업받는다.
	B(A a){
		this.a = a;
	}
	int run() {
		System.out.println("B Run");
		return num + a.run();
	}
}
class C extends A{
	int num = 30;
	A a; // 곧 사라지게 될 객체를 백업받는다.
	C(A a){
		this.a = a;
	}
	int run() {
		System.out.println("C Run");
		return num + a.run();
	}
}

public class Hello 
{
	public static void main(String[] args) {
		A a = new A();
		a = new B(a);
		System.out.println(a.run());
		a = new C(a);
		System.out.println("---------------");
		System.out.println(a.run());
	}
}
*/


/*
//ex62-1)
class AA{}
class BB extends AA{}
class CC extends AA{}

public class Hello 
{
	public static void main(String[] args) {
		AA a1 = new BB();
		System.out.println(a1.hashCode());
		a1 = new CC();
		System.out.println(a1.hashCode());
		
		AA a2 = a1;
		a1 = new BB();
		System.out.println(a1.hashCode());
	}
}
*/

/*
//ex61)
public class Hello 
{
	public static void main(String[] args) {
		try {
			//Package Explorer에서 project
			//오른쪽 마우스 Properties
			//Location에서 폴더가기
			Reader r = new FileReader("test02.txt", StandardCharsets.UTF_8);
			while(true) {
				int data = r.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			r.close();
			System.out.println("\n파일 입출력 종료");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(1000);
	}
}
*/

/*
 //ex 60)파일 입출력 삼항연산자
public class Hello 
{
	public static void main(String[] args) {
		try {
			//Package Explorer에서 project
			//오른쪽 마우스 Properties
			//Location에서 폴더가기
			Writer w = new FileWriter("test01.txt");
			for (int i = 0; i <8; i++) {
				for (int j = 0; j < 10; j++) {
					w.write((i+j)%2==0 ?"o ":"x ");
				}
				w.write("\n");
			}
			w.close();
			System.out.println("파일 입출력 종료");
		}catch(Exception e) {
			
		}
	}
}
/*

/*
//ex59)파일 입출력 코드
public class Hello 
{
	public static void main(String[] args) {
		try {
			//Package Explorer에서 project
			//오른쪽 마우스 Properties
			//Location에서 폴더가기
			Writer w = new FileWriter("test01.txt");
			
			w.write("apple");
			w.write("\n\n");
			w.write("무궁화");
			
			w.close();
			System.out.println("파일 입출력 종료");
		}catch(Exception e) {
			
		}
	}
}
/*

/*
//ex58)
public class Hello 
{
	public static void main(String[] args) {
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("[" + i +" " + j + "]");
			}
			System.out.println();
		}System.out.println();
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 4; j++) {
				if((i + j) % 2 == 0) {
					System.out.print("O ");
				}else {
					System.out.print("X ");
				}
			}System.out.println();
		}System.out.println();	
	}
}
*/

/*
//ex58)디자인패턴.싱글톤(only one)
//객체가 한개만 만들어지는 class를 만드는 방법
//객체 한개가 생성이 되었을때 비용이 많이 들 경우 싱글톤 패턴을 사용
//객체가 2개가 필요없는 경우
class Tiger{
	int num;
	private static Tiger instance = null;//멤버 변수
	private Tiger(){}
	
	static Tiger getInstance() {
		if(instance == null) {
			System.out.println(1);
			instance = new Tiger();
		}
		return instance;
	}
	void m1() {
		System.out.println(1000);
	}
}
public class Hello 
{
	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
//		Tiger t2 = new Tiger();
		Tiger t1 = Tiger.getInstance();
		Tiger t2 = Tiger.getInstance();
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		t1.m1();
		t2.m1();
		t1.num = 2000;
		System.out.println("-----------");
		System.out.println(t2.num);
	}
}
*/

/*
//ex58)
class Tiger{
	private String name;
	private int age;
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t = new Tiger();
		//t.a = 10; private라서 사용 불가
		t.setName("김경도");
		System.out.println(t.getName());
		t.setAge(25);
		System.out.println(t.getAge());
	}
}
*/

/*
//ex57)
class Tiger{
	private int a;
	public int b; 
	// default int b;
	// 기본적으로 default가 생략되어있는데 사용하면 에러
	// 굳이 쓰고 싶으면 비슷한 성질인 public 사용
	
	private int num;
	public void setNum(int num) {
		this.num = num;
	}
	//위 함수를 안 쓸경우 읽기 전용
	public int getNum() {
		return this.num;
	}
	//위 함수를 안 쓸경우 쓰기 전용
	
	void m1() {
		a = 100;
		b = 200;
	}
	private void m2() {
		
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t = new Tiger();
		//t.a = 10; private라서 사용 불가
		t.b = 10;
		t.setNum(100);
		System.out.println(t.getNum());
	}
}
*/

/*
//ex57)
interface Test1{
	void m1();
}
interface Test2{
	int m1();
}
class Tiger{
	void m2(Test1 t) {
		t.m1();
	}
	void m3(Test2 t) {
		System.out.println(t.m1());
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Test1 t1 = () -> {
			System.out.println(1);
		};
		
		Tiger tiger = new Tiger();
		tiger.m2(t1);
		//실제 사용 모습
		tiger.m2(()->{
			System.out.println(2);
		});
		tiger.m3(()->100);
	
		LinkedList<Integer> mm = new LinkedList<Integer>();
		mm.removeIf(lion->{ 
			return lion % 2 == 0;
		});
		mm.removeIf(lion->(lion % 2 == 0));
	}
}
*/

/*
//ex56)
interface Test1{
	void m1();
}
interface Test2{
	void m1(int num);
}
interface Test3{
	int m1();
}
interface Test4{
	String m1(int num, String str);
}
interface Test5{
	int m1();
}
public class Hello 
{
	public static void main(String[] args) {
		//1)
		Test1 t1 = new Test1() {
			@Override
			public void m1() {
				System.out.println(1);
			}
		};
		t1.m1();
		
		//2)
		Test1 t2 = ()-> {
				System.out.println(2);
		};
		t2.m1();

		//3)
		Test2 t3 = (n)-> {
			System.out.println(n);
		};
		t3.m1(100);
		
		//4)
		Test3 t4 = () -> {
			System.out.println(3);
			return 100;
		};
		System.out.println(t4.m1());
		
		//5)
		Test4 t5 = (n, s) -> {
			return n + s;
		};
		System.out.println(t5.m1(101, "호랑이"));
		
		//6)
		Test5 t6 = () -> 100;
		//return 100 한줄만 있을경우 
		//{return 100;};을 위와 같이 쓸 수 있다.
	}
}
*/

/*
// ex55)
public class Hello 
{
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		mm.add(0);
		mm.add(2);
		mm.add(4);
		for (int i = 0; i < 10; i++) {
			mm.add(i * 2);
		}
		mm.add(101);
		mm.add(102);
		mm.add(103);
		LinkedList<String> m = new LinkedList<String>();
		m.add("123");
		m.add("124");
		m.add("121");
		m.add(1,"123");
		m.remove("123");
		System.out.println(m);
		//ex1)
//		for (int i = 0; i < mm.size();) {
//			int num = mm.get(i);
//			if(num % 2 == 0) {
//				mm.remove(i);
//			}
//			else {
//				i++;
//			}
//		}
//		System.out.println(mm);
		
		//ex2)
//		for (Iterator<Integer> it = mm.iterator(); it.hasNext();) {
//			Integer num = it.next();
//			if(num % 2 == 0) {
//				it.remove();
//			}
//		}
//		System.out.println(mm);
		
		//ex3) mm.removeIf(Predicate<>)
		mm.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer num) {
				return num % 2 == 0;
			}
		});
		System.out.println(mm);
		
		//ex4) 람다 함수 사용 
//		mm.removeIf(num -> num % 2 == 0);
//		System.out.println(mm);
	}
}
*/

/*
//ex54)
public class Hello 
{
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + 1);
		}
		System.out.println(mm);
		
		for (int i = 0; i < mm.size(); i++) {
			int num = mm.get(i);
			if(num == 51) {
				System.out.println(i + "번쨰 찾았다");
				mm.remove(i);
				break;
			}
			if(i == mm.size() - 1) {
				System.out.println("Not Found");
			}
		}
		System.out.println(mm);
	}
}
*/

/*
//ex53)
public class Hello 
{
	public static void main(String[] args) {
		//컨테이너(제네릭 문법< >) - 한가지의 내용물만 담고 있는 것
		LinkedList<Integer> mm = new LinkedList<Integer>();
		
		//C(reate)RUD
		mm.add(10);
		System.out.println(mm.size());
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		
		//CR(ead)UD
		//1.
		System.out.println(mm);
		
		//2.
		int size = mm.size();
		for (int i = 0; i < size; i++) {
			//for문에서 mm.size()를 쓰게될경우 계속 호출시키기 떄문에 비용에 문제가 생긴다
			int data = mm.get(i);
			System.out.print(data + " ");
		}System.out.println(" ");
		
		//3. foreach의 경우 x, item, data, value를 주로 사용
		for(Integer x : mm){
			System.out.print(x + " ");
		}System.out.println(" ");
	
		//CRU(pdate)D
		mm.set(5, 999);
		System.out.println(mm);
		
		//CRUD(elete)
		mm.remove(5);
		System.out.println(mm);
	}
}
*/

/*
//ex52)
public class Hello{
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		while(s.length() < 32) 
			s = "0" + s;
		StringBuffer s1 = new StringBuffer(s);
		for(int i = 0; i < 7; i++) 
			s1.insert((7 - i) * 4, " ");

		return s1.toString();
	}
	
	public static void main(String[] args) {
		int a = 0x3b12cd59;
		int b = 0x0000ff00;
		int c = 0x0ff00000;
		
		int d = 0x0000cd5a;
		int e = 0x0000f800;
		int f = 0x000007e0;
		int g = 0x0000001f;
		int h = 0x000000ff;
		int j = 0x77000000;
		
		System.out.println(hexaToBinary(a));
		System.out.println(hexaToBinary(b));
		System.out.println(hexaToBinary(a & b));
		System.out.println(a & b);
		System.out.println(hexaToBinary(a & b >> 8));
		System.out.println(hexaToBinary((a & b) >> 8));
		System.out.println((a & b) >> 8);
		System.out.println(hexaToBinary((a & c) >> 20));
		System.out.println((a & c) >> 20);

		System.out.println("-------------------------");
		
		System.out.println((d & 0xf800) >> 11);
		System.out.println((d & 0x07e0) >> 5);
		System.out.println((d & 0x001f));
		
		System.out.println("-------------------------");
		
		System.out.println((d & e) >> 11);		
		System.out.println((d & f) >> 5);		
		System.out.println(d & g);	
		
		System.out.println("-------------------------");
		
		System.out.println((d & ((h >> 3) << 11)) >> 11);	
		System.out.println((d & ((h >> 2) << 5)) >> 5);	
		System.out.println((d & ((h >> 3))));	
		
		System.out.println("");
		
		int c1 = 25;
		int c2 = 42;
		int c3 = 26;
		int c4 = (c1 << 11) | (c2 << 5) | (c3);
		System.out.println(c4);
		System.out.println(hexaToBinary(c4));
		System.out.println(Integer.toHexString(c4));
		
//		System.out.println();
		
//		char c5 = 0x00dc;
//		String s = Integer.toBinaryString(c5);
//		int num = Integer.parseInt(s);
//		System.out.println(num);
//
//		for (int j = 0; j < 8; j++) {
//			int x = num % 10;
//			num = num / 10;
//			if(x == 1) {
//				System.out.println(j + "번이 켜짐");
//			}else {
//				System.out.println(j + "번이 꺼짐");				
//			}
//		}
		
		System.out.println("");
		char c5 = 0x00dc;
		int mask = 0x80;
		String[] st = new String[] {"냉장고", "컴퓨터", "TV", "세탁기", "밥솥", "정수기", "히터", "에어컨"};
		for (int i = 0; i < 8; i++, mask >>= 1) {
			System.out.println((c5 & mask) == mask ? st[i] + "\tON" : st[i] + "\tOFF");
		}
//		for (int i = 0; i < 8; i++) {
//			if ((c5 & (mask >> i)) != 0) {
//				System.out.println(st[i] + "\t: ON");
//			} else {
//			System.out.println(st[i] + "\t: OFF");
//			}
//		}	
	}
}
*/

/*
//ex51)
public class Hello 
{
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
//		System.err.println(s);
//		System.err.println(s.length());
		while(s.length() < 32) {
			s = "0" + s;
		}
//		System.out.println(s);
//		System.out.println(s.length());
		StringBuffer s1 = new StringBuffer(s);
//		s1.insert(4, '한');
//		System.out.println(s1);
//		s1.insert(9, '글');
//		System.out.println(s1);
		for(int i = 0; i < 7; i++) {
			System.out.println((7 - i) * 4);
			s1.insert((7 - i) * 4, " ");
			
		}
		System.out.println(s1);
		return s1.toString();
		
	}
	static int m1() {
		System.out.println(m1());
		return 100;
	}
	public static void main(String[] args) {
		// 0011 1011 0001 0010 1100 1101 0101 1001
		int a = 0x3b12cd59;
		int b = 991087961;// 2진수 -> 1001000110100
		System.out.println(a);
		System.out.println(b);
		if(a == b) {
			System.out.println(1);
		}
		System.out.println(hexaToBinary(a));
		System.out.println(hexaToBinary(b));
	}
}
*/

/*
ex50)
public class Hello 
{
	public static void main(String[] args) {
		String s = "무궁화꽃이피었습니다.";
		// 1)
		System.out.println(s.length());
		//s의 길이

		// 2)
		System.out.println(s.charAt(3));
		//s의 3번쨰 단어

		// 3)
		System.out.println(s.indexOf("화"));
		//"화"가 몇번쨰에 있나
		System.out.println(s.indexOf("수"));
		//없으면 -1
		
		int n = s.indexOf("화꽃이");
		if(n != -1) {
			System.out.println(n + "번쨰에서 find");
		} else {
			System.out.println("not find");
		}
		
		// 4)
		System.out.println(s.replace("꽃이", "나무가"));
		//단어를 찾아 변경
		System.out.println(s.replace("꽃기", "나무가"));
		//없으면 원래 s 출력
		System.out.println(s);
		//replace를 사용하여도 원본 데이터는 유지
		
		//s = "대한민국";
		//System.out.println(s);
		//위와 같은 경우는 갱신이 아니라 객체를 없애고 새로 만든 것
		//String은 데이터를 변경할 수 없다.
		
		// 5) slicing
		System.out.println(s.substring(5));
		//5번부터 끝까지 출력
		System.out.println(s.substring(3, 6));
		//3번부터 6번 앞까지 출력
	
		// 6)
		String s2 = "   App   le   ";
		System.out.print(s2.trim());
		//앞뒤의 공백을 제거
		//ID, PW 입력받을떄 주로 사용
		System.out.println("호랑이");
		
		// 7) 
		String s3 = "APple";
		System.out.println(s3.toUpperCase());
		//대문자로 변경
		System.out.println(s3.toLowerCase());
		//소문자로 변경

		// 8)
		byte[] data = new byte[] {65, 'B', 'C', 'D'};
		String s4 = new String(data, 0, data.length);
		System.out.println(s4);
		//받은 데이터의 문자를 문자열로 변환
		String s5 = "Banana";
		byte[] data1 = s5.getBytes();
		for (byte value : data1) {
			System.out.println((char)value);
		}
		//데이터를 전송할떄 
	}
}
*/

/*
//ex49)
class Tiger{
	void m1(int a, int b) {
		if (a > b) {
			System.out.println(1);
		} else {
			return;
		}
		System.out.println(2);
	}
	void m2(int a, int b) {
		try {
			if (a > b) {
				System.out.println(1);
			} else {
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println(2);
		}
	}
}

public class Hello 
{
	public static void main(String[] args) {
		try {
			int a = 10 / 0;
		} catch (Exception e) {

		} finally {
			System.out.println(1);
		}
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		t1.m1(10, 0);
		t2.m1(10, 0);
	}
}
*/

/*
//ex 48)
public class Hello 
{
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {Thread.sleep(2000);} catch (Exception e) {}
		}		
	}
}
/*

/*
//ex 47)
class Tiger{
	void m1() {
		System.out.println(1);
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("익셉션발생함");
		}
	}
	void m2() throws Exception{
		System.out.println(2);
		throw new Exception();
	}
}
public class Hello 
{
	public static void main(String[] args){
		Tiger t1 = new Tiger();
		t1.m1();
		
		//Unhandled exception
		try {
			t1.m2();
		} catch (Exception e) {
		}
		System.out.println(3);
	}
}
*/

/*
 ex 46)
public class Hello 
{
	public static void main(String[] args) {
		System.out.println(1);
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
		int[]ar = {1, 2, 3};
		// Array Index OutOf Bounds Exception
		try {
			ar[3] = 10;
		} catch (Exception e) {
			
		}		
		System.out.println(3);
		
		String s = "무궁화꽃이피었습니다";
		System.out.println(s.length());
		s = null;
		
		// NullPoiterException
		try {
			System.out.println(s.length());	
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(4);
	}
}
*/

/*
//ex45 - 5)
class Baduk{
	Ai ai;
	Baduk(Ai ai) {
		System.out.println("대국을 시작합니다.");
		this.ai = ai;
	}
	void play() {
		ai.play();
	}
	void stop() {
		ai.stop();
	}
}
interface Ai{
	void play();
	void stop();
}
//google에서 만듦
class Alpago implements Ai{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수 계산을 합니다.");
	}
}
//아마존에서 만듦
class Betago implements Ai{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수 계산을 합니다.");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Baduk baduk1 = new Baduk(new Alpago());
		baduk1.play();
		baduk1.stop();
		
		Baduk baduk2 = new Baduk(new Betago());
		baduk2.play();
		baduk2.stop();	
	}
}
*/

/*
//ex45 - 4)
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	void play(Ai ai) {
		ai.play();
	}
	void stop(Ai ai) {
		ai.stop();
	}
}
interface Ai{
	void play();
	void stop();
}
//google에서 만듦
class Alpago implements Ai{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수 계산을 합니다.");
	}
}
//아마존에서 만듦
class Betago implements Ai{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수 계산을 합니다.");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new Alpago());
		baduk.stop(new Alpago());
		baduk.play(new Betago());
		baduk.stop(new Betago());
		
	}
}
*/

/*
//ex45 - 3)
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	void play(Ai ai) {
		ai.play();
	}
}
interface Ai{
	void play();
}
//google에서 만듦
class Alpago implements Ai{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
//아마존에서 만듦
class Betago implements Ai{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new Alpago());
		baduk.play(new Betago());
	}
}
*/

/*
//ex45 - 2)
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	void play(Alpago alpago) {
		alpago.play();
	}
	void play(Betago betago) {
		betago.play();
	}
}
//google에서 만듦
class Alpago{
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
//아마존에서 만듦
class Betago{
	void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new Alpago());
		baduk.play(new Betago());
	}
}
*/

/*
//ex45 - 1)
//인공지능이 바뀌게 되면 어떻게 할 것인가
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play();
	}
}
*/

/*
//ex44 - 2)
interface Animal{
	void m1();
}
class Zoo{
	void sound(Animal t) {
		t.m1();
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Animal() {
			@Override
			public void m1() {
				System.out.println(1);
			}
		};
		t1.m1();
		
		Zoo t2 = new Zoo();
		t2.sound(new Animal() {
			@Override
			public void m1() {
				System.out.println(4);
			};
		});
	}
}
*/

/*
//ex44 -1)
interface Animal{
	void m1();
}
class Tiger implements Animal{
	public void m1() {
		System.out.println(1);
	}
}
class Zoo{
	void m1(Animal t) {
		t.m1();
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();
		Animal t2 = new Tiger();
		t2.m1();
		Animal t3 = new Animal() {
			@Override
			//익명 class
			public void m1() {
				System.out.println(2);
			}
		};
		t3.m1();
		new Animal() {
			@Override
			public void m1() {
				System.out.println(3);
			}
		}.m1();
		//익명 객체
		Zoo t4 = new Zoo();
		t4.m1(new Animal() {
			@Override
			public void m1() {
				System.out.println(4);
			};
		});
		t4.m1(t1);
	}
}
*/

/*
//ex43-5)
class Tiger{
	//this를 이용하여 자기 class 안에서 다른 생성자를 호출 할때
	Tiger(){
		System.out.println(1);
	}
	
	Tiger(int a){
		this();//인수가 없는 생성자 콜
		System.out.println(a);
	}
	
	Tiger(int a, int b){
		this(a + b);//생성자 호출할 떄 사용
		System.out.println(a + " " + b);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 20);
	}
}
*/

/*
//ex43-4)
class Tiger{
	void m1() {
		Lion t1 = new Lion();
		if(t1.marry(this)) {
			System.out.println("감사합니다");
		}else {
			System.out.println("ㅠㅠ");
		}
	}
	int m2() {
		System.out.println("가지고있는 재산은");
		return 50;
	}
	String m3() {
		return "난폭";
	}
}
class Lion{
	Boolean marry(Tiger t) {
		if(t.m2() >= 80) {
			System.out.println(1);
			return true;
		}else {
			String s = t.m3();
			switch (s) {
			case "온순":
				return true;
			case "난폭":
				return false;
			}
			return false;
		}
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t = new Tiger();
		int a = t.m2();
		t.m1();
		System.out.println(a);
	}
}
/*

/*
//ex43-3)
class Tiger{
	//this를 사용하여 chaining을 이용
	//chaining을 위해 this 사용
	//Tiger this;
	//Tiger(Tiger t - t1이 인수전달로 넘어간다, int a, int b){
		//this = t;
	//}
	Tiger m1() {
		//return new Tiger();
	
		//Tiger t = new Tiger();
		//return t;
		System.out.println(1);
		return this;
	}
	Tiger m2() {
		System.out.println(2);
		return this;
	}
	void m3() {
		System.out.println(3);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = t1.m1();
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		t2.m2();
		t1.m1().m2();
		t1.m1().m2().m1().m2().m2().m3();
		//Chaining 
		System.out.println("------------------");
		t1.m1().m2().m3();
		t1.m1();
		t1.m2();
		System.out.println("호랑이");
		//일반적인 경우 m1~3연계작업을 하게되면 같이 사용하게 되는 경우가 생기는데 
		//"호랑이"와 같이 중간에 오게 되면 난입 되었다고 한다.
		//chaining을 사용하게되면 난입을 방지할 수 있다.
		t1.m3();
	}
}
*/

/*
//ex43-2)
class Tiger{
	//Tiger this;
	//Tiger(Tiger t){
	//	this t;
	//}
	int a, b;//멤버 변수
	int size;
	Tiger(int a, int b, int size){
		//멤버 변수를 초기화하기위해 생성자 사용
		//가독성을 위해 변수의 이름 생성에 유의
		this.a = a;//필드의 a = 인수전달a, 이름이 중접될때 this 사용
		this.b = b;//this를 사용하게되면 멤버 변수를 가르킬 수 있다.
		this.size = size;
	}
	void show() {
		System.out.println(this.a + " " + this.b);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 20, 30);
		int num = 10;
		num = num;//self 대입, 자기 대입, 의미없는 코드
		t1.show();
	}
}
*/

/*
//ex43-1)
class Tiger{
	//Tiger this;
	//Tiger(Tiger t - t1이 인수전달로 넘어간다, int a, int b){
		//this = t;
	//}
	// 위와 아래의 Tiger 생성자를 비교하면 자동으로 생략되어있는 부분을 확인할 수 있다.
	// 하지만 직접 작성시 에러
	Tiger(int a, int b){
		System.out.println(this.hashCode());
	}
	void m1(int a, String b, Tiger c) {
		System.out.println(1);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 20);
		//t1.m1(1, "2", t1);
		System.err.println(t1.hashCode());
		Tiger t2 = new Tiger(30, 40);
		System.out.println(t2.hashCode());
	}
}
*/

/*
//ex42) final
// final은 3곳에서 사용 가능
final class Animal{
	//class앞에 final을 사용하게되면 상속을 받을 수 없게 된다.
	final int NUM = 10;
	//final을 사용하면 값을 변경할 수 없다.
	//상수 - 메모리 안에 내용을 변경할 수 없는 경우
	//변수 - 메모리 안에 내용을 변경가능한 경우
	final void m1() {
		//함수 앞에 final이 붙으면 오버라이딩(부모와 자식의 똑같은 이름)이 마지막이다.

	}
}
class Tiger extends Animal{
	
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Animal();
		System.out.println(Math.PI);
		String s1 = null;
		
	}
}
*/


/*
ex41)
class A{
	void m1() {
		System.out.println(1);
	}
}
interface B{//함수 원형
	void m2();
}
interface C{
	void m3();
}
class D extends A implements B, C{
	@Override
	public void m2() {
		System.out.println(2);
	}
	@Override
	public void m3() {
		System.out.println(3);
	}
}
@FunctionalInterface  // 가르키는 인터페이스 안에는 함수가 1개 있다.
interface E{
	void m1();
	//void m2();
}
public class Hello 
{
	public static void main(String[] args) {
		D t = new D();
		t.m1();
		t.m2();
		t.m3();
		Thread t2 = null;
		String s = null;
		StringBuffer sf = null;
	}
}
*/

/*
//ex40)
interface 한국은행{
	void 입금();
	void 출금();
	void 이체();
	void 대출();
}
class 국민은행 implements 한국은행{
	@Override
	public void 입금() {
		System.out.println("이자율 : 3%");
	}
	@Override
	public void 출금() {
	}
	@Override
	public void 이체() {
	}
	@Override
	public void 대출() {
	}
}
class 우리은행  implements 한국은행{
	@Override
	public void 입금() {
		System.out.println("이자율 : 5%");
	}
	@Override
	public void 출금() {		
	}
	@Override
	public void 이체() {		
	}
	@Override
	public void 대출() {		
	}
}
public class Hello 
{
	public static void main(String[] args) {
		국민은행 t1 = new 국민은행();
		우리은행 t2 = new 우리은행();
		t1.입금();
		t2.입금();
	}
}
*/

/*
//ex39)
class 대장장이{
	void 칼() {
		System.out.println("칼을 잘 만듭니다.");
	}
	void 방패() {};
}
class 나그네1 extends 대장장이{
	void 방패() {
		System.out.println("방패 잘 만듭니다.");
	}
}
class 나그네2 extends 대장장이{
	//어노테이션 - 프로그래머가 실수할 수 있는 상황을 방지하기 위함
	@Override
	void 방패() {
	}
}
public class Hello 
{
	public static void main(String[] args) {
		나그네1 t1 = new 나그네1();
		나그네2 t2 = new 나그네2();
		t1.칼();
		t1.방패();
		t2.칼();
		t2.방패();
	}
}
*/

/*
//ex38)
//abstract class Animal{
//	abstract void m1(); 
//} 누군가의 가이드역활은 가능하지만 class로서 역활이 없다.
interface Animal{
	//void m1();  -  {}없는 "미완성 코드"
	abstract void m1();
	//abstract - 추상, 미완성
	//abstract을 안 적을 경우 자동으로 생략된다.
}
class Tiger implements Animal{
	//인터페이스의 경우 extends가 아닌 implements를 사용
	//클래스와 인터페이스를 두개 다 사용가능할 경우 인터페이스로 하는것이 좋다.
	public void m1() {
		//implements의 경우 public사용
		System.out.println(2);
	}//부모 클래스가 abstract이면 Tiger 클래스에 아무것도 없을 경우 에러가 생김
	
}
public class Hello 
{
	public static void main(String[] args) {
		Animal a = new Tiger();
		a.m1();
		//Animal t2 = new Animal(); 미완성코드이기에 객체 생성 불가
	}
}
*/

/*
//ex37)
class Animal{
	void cry() {
		System.out.println(". . .");
	}
}
class Dog extends Animal{
	void cry() {
		System.out.println("멍! 멍!");
	}
}
class Cat extends Animal{
	void cry() {
		System.out.println("미야옹~");
	}
}
class Snake extends Animal{
	
}
public class Hello 
{
	public static void main(String[] args) {
		Random rn = new Random();
		Animal t0 = new Dog(); 
		Animal t1 = new Cat(); 
		Animal t2 = new Snake(); 
		for (int i = 0; i < 10; i++) {
			int num = rn.nextInt(3);
			switch (num) {
			case 0:
				t0.cry();
				break;
			case 1:
				t1.cry();
				break;
			case 2:
				t2.cry();
				break;
			}
		}
		System.out.println("-----------");
		Animal[] t3 = new Animal[] {new Dog(), new Cat(), new Snake()};
		for (int i = 0; i < 10; i++) {
			t3[rn.nextInt(3)].cry();	
		}
	}
}
*/

/*
//ex36) random
public class Hello 
{
	public static void main(String[] args) {
		Random rn = new Random();
		System.out.println(rn.nextInt());//int 범위안에 수를 가져온다
		for (int i = 0; i < 10; i++) {//랜덤으로 뽑음
			//int num = rn.nextInt(2);
			//System.out.println(num);
			System.out.println(rn.nextInt(10));
		}
	}
}
*/

/*
//ex35)
public class Hello 
{
	public static void main(String[] args) {
		int a = 10;//4바이트 인수 한개 주세요
		int [] ar = new int[5];
		int [] br = new int[] {1, 2, 3, 4, 5};
		int [] cr = {10, 20, 30, 40, 50};
		System.out.println(ar.length);
		for (int i = 0; i < br.length; i++) {
			System.out.print(br[i] + " ");
			//일반적으로 배열이나 연속된 수를 사용할때 println을 주로 사용 안함
		}
		System.out.println("");
		System.out.println("호랑이");
		//i대신 쓰는 변수 : x, data, value
		for (int x : cr) {
			//for문의 간략화 형태, 배열에서 앞에서부터 x변수에 넣어준다
			//foreach문을 사용할떄 각자의 index를 알 수 없다.
			System.out.print(x + " ");
		}
		System.out.println("");
		//cr의 경우 메모리를 5개 달라고 하였따
		//배열의 길이 - 1 의 크기를 사용가능
		cr[0] = 100;
		cr[4] = 200;
		//cr[5] = 300; 유효 범의를 벗어났기 떄문에 에러 발생
		//ar[-1] = 400; 
		int num = 3;
		ar[num] = 500;
		ar[num * 3 - 5] = 600;
		ar[2] = 3;
		ar[ar[2]] = 999;
		
		System.out.println(ar[2] + " " + ar[3]);
		
		ar[ar[3] - 998] = 888;
		
		for (int x : ar) {
			System.out.print(x + " ");
		}
		//배열의 유효 범위 : 0 ~ (배열의 길이 - 1)
		System.out.println("\n------------------");
		
		boolean[] dr = {true, false, true, false};
		for (boolean x : dr) {
			System.out.print(x + " ");
		}
		System.out.println("-------------------");
		
		String[] ss = new String[4];
		ss[0] = "호랑이";
		ss[1] = "고양이";
		ss[2] = "개";
		ss[3] = "판다";
		
		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i] + " ");
		}
		System.out.println("");
		for (String x : ss) {
			System.out.print(x + " ");
		}
		System.out.println("");
		
		String [] st = new String[] {"장미", "튤립", "해바라기"};
		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		String s1 = "호랑이";
		String s2 = new String("호랑이");
		
		String [] su = new String[] {new String("장미")};
		
	}
}
*/

/*
//ex34)
class Animal{
	void cry() {
		System.out.println(". . .");
	}
}
class Dog extends Animal{
	void cry() {
		System.out.println("멍! 멍!");
	}
}
class Cat extends Animal{
	void cry() {
		System.out.println("미야옹~");
	}
}
class Snake extends Animal{
	
}
class Zoo{
	//확장해서 열려있다. (개방) 쉽게 사용할수있게한다 
	//코드변경은 하지마라 (폐쇄적)
	//void sound(Dog t) {
		//t.cry();
	//}
	//void sound(Cat t) {
		//t.cry();
	//}
	//void sound(Snake t) {
		//t.cry();
	//}
	void sound(Animal t) {
		t.cry();
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Dog();
		Animal t2 = new Cat();
		Animal t3 = new Snake();
		t1.cry();
		t2.cry();
		t3.cry();
		
		Dog t4 = new Dog();
		Cat t5 = new Cat();
		Snake t6 = new Snake();
		t4.cry();
		t5.cry();
		t6.cry();
	
		System.out.println("--------");
		
		Zoo t7 = new Zoo();
		t7.sound(new Dog());
		t7.sound(new Cat());
		t7.sound(new Snake());
	}
}
//객체지향 개발 5가지 원리 : SOILD
//SRP(단일책임의 원칙)
//ex)도서관 책 관리할떄 프린터에 문제가 생겨도 도서관 책 관리에 책임이 없다.
//프린터에 문제가 생겼는데 도서관 책 관리 프로그램을 건드려도 의미가 없다.
//OCP(개방폐쇄의 원칙)
//LSP(리스코브 치환의 원칙)
//ISP(인터페이스 분리의 원칙)
//DIP(의존성역전의 원칙)
*/
/*
//ex33)
class Animal{
	void m1() {
		System.out.println(1);
	}
	void m3() {
		System.out.println(31);
	}
}
class Tiger extends Animal{
	void m2() {
		System.out.println(2);
	}
	void m3() {
		System.out.println(32);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Animal();//case 1)
		Tiger t2 = new Tiger();//case 2)
		Animal t3 = new Tiger(); //case 3) 업 캐스팅, 부자관계
		//Tiger(문법) t4 = new Animal(메모리)(); case 4) 자바에서는 사용 안 한다. 다운 캐스팅
		t3.m1();
		//t3.m2(); Tiger의 메모리를 받아오지만 Animal 문법만 사용가능하여 m2를 사용할수 없다.
		t3.m3();
		//메모리를 받아왔기때문에 Animal 문법만 받지만 자식class에 같은 함수가 있으면 자식 함수를 사용한다.
	}
}
*/

/*
//ex32) 
class Animal{
	Animal(){
		System.out.println("부모생성자 콜");
	}
	Animal(int n){
		System.out.println(n);
	}
}
class Tiger extends Animal{
	Tiger(){
		//현재 라인의 코드가 한줄이 생략되어있다. 밑에 명령문
		super();//부모의 생성자를 콜하는 명령문
		System.out.println("자식생성자 콜");
	}
	Tiger(int num){
		super(num + 100);//이거 없어도 결과 똑같음(없으면 자동으로 만들어 줌)
		//원하는 부모 생성자가 있으면 인수를 맞춰주면 된다.
		System.out.println(num);
	}
	Tiger(int a, int b){
		super(a * b);
		System.out.println("3번쨰 생성자");
		//super();  -->  super()는 함수의 제일 첫번째 와야한다
		//뒤에 사용하면 에러 발생
	}	
}

public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(100);
		Tiger t3 = new Tiger(3, 4);
	}
}
*/

/*
//ex31) 상속
class Animal{
	void m2() {
		System.out.println(2);
	}
	void m3() {
		System.out.println(31);
	}
}
class Tiger extends Animal{
	void m1() {
		System.out.println(1);
	}
	void m3() {
		System.out.println(32);
	}
	void m4() {
		m3();
		super.m3();//super를 사용하여 부모class에서 m3를 호출가능
		System.out.println(4);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Animal();
		Tiger t2 = new Tiger();
		t2.m1();
		t2.m2();//자신 class에 확인 이후 찾는 함수가 없을 경우 부모 class에서 찾아서 사용
		t2.m3();//같은 이름의 함수가 있을 경우 자신의 class안의 함수 사용
		t2.m4();//같은 class안의 함수를 서로 사용할 수 있다.
	}
}
*/

/*
//ex30 math함수)
public class Hello 
{
	public static void main(String[] args) {
		//절대값
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);

		//올림값
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);

		//버림값
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5 = " + v5);
		System.out.println("v6 = " + v6);
		
		//최대값
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.7);
		System.out.println("v7 = " + v7);
		System.out.println("v8 = " + v8);

		//최소값
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.7);
		System.out.println("v9 = " + v9);
		System.out.println("v10 = " + v10);
		
		//가까운 정수의 실수 값
		double v11 = Math.rint(5.3);
		double v12 = Math.rint(5.74343);
		System.out.println("v12 = " + v11);
		System.out.println("v13 = " + v12);

		//반올림
		long v13 = Math.round(5.3);
		long v14 = Math.round(5.7);
		System.out.println("v13 = " + v13);
		System.out.println("v14 = " + v14);
	}
}
*/

/*
//ex29)
class Tiger{
	static void myMain() {
		Tiger t = new Tiger();
		t.m1();//new를 통해 생성되었기때문에 사용 가능
		//m1(); static m1()이 아니기 때문에 사용할 수 없다.
	}
	void m1() {
		
	}
}

public class Hello 
{
	static int num = 10;
	Hello(){

	}
	static void m1() {
		System.out.println(1);
	}
	public static void main(String[] args) {
		System.out.println(num);
		//static 함수 안에서는 static 변수만 사용 가능하다.
		m1();//출력
		Hello h = new Hello();
		h.m1();//출력 m1은 static을 통해서 같이 나가기때문에 굳이 h.m1()을 할 필요가 없다.
		h.m2();//출력
		Hello.m1(); // class이름으로 불러들였을때 static을 같이 사용하면 사용 가능
		//Hello.m2(); static m2()가 아니기 떄문에 사용할 수 없다.
	}
	void m2() {
		System.out.println(2);
	}
}
*/

/*
//ex28)
class Tiger{//공용으로 사용하는 변수를 만들고 싶을때 사용, 객체간의 전역 변수
	int num1;
	static int num2 = 100;
	static void m1() {
		System.out.println("static 함수 쿼리");
	}
}

public class Hello 
{
	public static void main(String[] args) {
		System.out.println(Tiger.num2);
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		System.out.println(t1.num2);
		t2.num2 = 200;
		System.out.println(t1.num2);
		System.out.println(Tiger.num2);
		Tiger.m1();
		
		//ex) 
		System.out.println(Math.abs(-10));
	}
}
*/


/*
//ex27)
class Car{
	int fuel = 100;
	String name = "n";
	Car(){
		name = "무명";
	}//default 쿼리
	Car(String n,int f){//인수받음
		fuel = f;
	}
	void Move() {	
		System.out.println("자동차가 달린다.");
		fuel -= 30;
		System.out.println("달린다" + name);
	}
	void Stop() {
		System.out.println("스탑");
		fuel -= 10;
	}
	void Show() {
		System.out.println(fuel);
	}
	void Inject() {
		fuel += 100;
	}
	void Inject(int f) {
		fuel += f;
	}
	
}
public class Hello 
{
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("꼬마자동차", 50);
		
		car1.Move();
		car2.Move();
	}
}
*/

/*
//ex26)
class Tiger{
	Tiger(int a, int b){
		
	}
	Tiger(){}//안에 아무것도 없다는 가정하에 한줄로 하자
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(10,20);
	}
}
*/

/*
//ex25) 생성자
// 1) 생성자는 함수이다. 생성자 함수라 한다.
// 2) 함수 이름은 클래스 이름과 반드시 동일해야한다.
// 3) 생성자 함수는 return값을 가질 수가 없다.그래서 void도 생략한다.
// 4) 생성자 함수도 오버로딩이 가능하다.
// 5) 생성자 함수는 객체가 생성될 때 단 한번만 호출된다.(임의로 호출할 수 없다.)
// 6) 생성자를 사용하는 목적은 멤버 메소드를 초기화시키기 위해 사용된다.
// 7) 생성자 함수를 작성하지 않을시에는 자동으로 default생성자가 만들어진다.

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

public class Hello 
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

/*
//ex24)
public class Hello 
{
	public static void main(String[] args) {
		int a = 100;
		String s1 = Integer.toString(a);
		System.out.println(s1 + 200);
		String s2 = "" + a;
		System.out.println(s2 + 200);
		String s3 = "456";
		int b = Integer.parseInt(s3);
	}
}
*/

/*
//ex23)
class Tiger{
	//함수에 전달되는 인수의 갯수가 다르거나 타입이 다르면 함수의 이름을 동일하게 사용할 수 있다.
	//이것을 함수 오버로딩, 재정의라고 한다.
	void method01() {
		System.out.println(1);
	}
	void method01(int a) {
		System.out.println(2);
	}
	void method01(int a, int b) {
		System.out.println(3);
	}
	void method01(String a, int b) {
		System.out.println(4);
	}
	int getArea(int w, int h) {
		System.out.println(w * h);
		return w * h;
	}
	int getArea(int w) {
		System.out.println(w * w);
		return w * w;
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.method01();
		t1.method01(0);
		t1.method01(0, 0);
		t1.method01("호랑이", 0);
	}
}
*/
/*
//ex22)
public class Hello 
{
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if(i < 3) {
				continue;
			}
			System.out.println(i);
			if(i == 7) {
				break;
			}
		}
		System.out.println("호랑이");
		int num = 0;
		while(true) {
			num++;
			if(num % 2 != 0) {
				System.out.println("호랑이" + num);
				continue;
			}
			if(num == 10) {
				System.out.println("코끼리" + num);
				break;
			}
		}
	}
}
*/

/*
ex21)
class Tiger{
	int m1(int a, int b) {
		if(a > b) {
			return 100;
		}else {
			return 200;
		}
	}
	void m2() {
		System.out.println(1);
		return ;
		//System.out.println(2);
	}
	void m3(int num) {
		for(int i = 0; i < 10; i++) {
			if(i == num) {
				System.out.println("찾았다");
				return ;
			}
		}
		System.out.println("검색 데이터 찾지 못함.");
	}
}

public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.m1(2, 1));
		t1.m3(7);
	}
}
*/

/*
//ex20)
class Tiger{
   String m1() {
      
      return "독수리";
   }
   Rion m2() {
      //return new Rion(); 아래와 동일
      Rion t = new Rion();
      return t;
   }
   Rion m3 (Rion t) {
      return t;
   }
}
class Rion{
   void show() {
      System.out.println(1000);
   }
}
public class Hello{
   
   public static void main(String[] args) {
   
   Tiger t1 = new Tiger();
   String s1 = t1.m1();
   System.out.println(s1);
   System.out.println(t1.m1());
   
   Rion t2 = t1.m2();
   t2.show();
   
   Rion t3 = t1.m3(new Rion());
   t3.show();
   
   t1.m3(new Rion()).show();
   }
}
*/

/*
//ex19)
class Tiger{
	//주의 - 인수 전달 2개 이상 할 경우 int a, b는 안된다.
	//각각의 데이터 타입을 적어주어야한다.
	void m1(int a, int b) {
		System.out.println(a + " " + b);
		System.out.println(a * b + a);
	}
	void m2(int a, char b, boolean c, float d, String e) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
	void m3(Lion a) {//사용자가 생성한 클래스를 받아 사용가능하다.
		System.out.println(a.hashCode());
		a.sound();
	}
}

class Lion{
	void sound() {
		System.out.println("어흥");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		String s1 = "호랑이";//자바에서 제공하는 표준 클래스 - String
		System.out.println(s1.length());
		Tiger t1 = new Tiger();
		t1.m1(3, 4);
		t1.m2(10, '한', true, 3.14f, "호랑이");
		
		Lion t2 = new Lion();
		System.out.println(t2.hashCode());
		t1.m3(t2);
		//Lion a = new Lion()
		t1.m3(new Lion());
	}
}
*/


/*
//ex18)
class Tiger{
	//메소드(함수 : 자주사용하는 코드를 저장 후 불러서 사용한다.)
	void merry() {
		System.out.println('멍');
	}
	void happy(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println('왈');
		}
	}
	int turtle() {
		return 1;
	}
	int fish(int num) {
		num = num * 3;
		return num;
	}
}

public class Hello 
{
	public static void main(String[] args) {
		Tiger t = new Tiger();
		int i;
		t.merry();//함수 콜
		t.merry();
		t.merry();
		for(i = 0; i < 10; i++) {
			t.merry();
		}
		
		System.out.println(" ");
		t.happy(5);
		
		System.out.println(" ");
		int num = t.turtle();
		System.out.println(num);
		System.out.println(t.turtle());
		
		System.out.println(" ");
		int ct;
		ct = t.fish(7);
		System.out.println(ct);
		System.out.println(t.fish(7));
		//리턴 값    인수 전달
		//  X          X
		//  X          O
		//  O          X
		//  O          O
	}
}
*/


/*
//ex17)

class Tiger{
	// 필드(클래스 안에서 정의되는 변수)
	int a;
	int b = 20;
	int c, d = 30;
	// 생성자
	// 메소드
}


public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();// 객체 생성 - 인스턴스화, new 사용
		Tiger t2 = new Tiger();
		t1.a = 100;
		t1.c = t1.a + 30;
		System.out.println(t1.a);
		System.out.println(t1.b);
		System.out.println(t1.c);
		System.out.println(t1.d);
		System.out.println(t2.c);
		//모든 객체는 생성되면 고유번호를 지정한다.
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		Tiger t3;
		t3 = t2;//두 변수는 참조한다, 메모리를 공유한다.
		System.out.println(t3.hashCode());
		t3.a = 999;
		System.out.println(t2.a);
	}
}
*/

/*
//ex16)
public class Hello 
{
	public static void main(String[] args) {
		int a = 10, b;
		b = a++;//대입, 증가 순서로 일어난다.
		System.out.println(a + " " + b);
		
		int c = 10, d;
		d = ++c;//증가, 대입 순서로 일어난다.
		System.out.println(c + " " + d);
		
		int a1 = 10, a2 = 10;
		System.out.println(a1++);
		System.out.println(++a2);
		System.out.println(a1);
		System.out.println(a2);
		int ad = 10;
		System.out.println(++ad * (ad++));
		int ac = 10;
		System.out.println(++ac * ac++);
		int e = 10;
		System.out.println((e++) * ++e);
		int f = 10;
		System.out.println(f++ * ++f);
	}
}
*/

/*
//ex15)
public class Hello 
{
	public static void main(String[] args) {
		//(int)->타입 (a)->변수 (=)->대입연산자 (10)->리터럴
		int a = 10;
		int b = 20;
		short c = 30;
		//대입연산자는 왼쪽과 오른쪽의 타입이 동일해야한다.
		//b = c;
		b = (int)c;//이 라인에서는 int타입으로 변환
		c = (short)a;//타입 캐스팅
		
		int num = 10;
		num = num + 3;
		num += 3;//위의 코드보다 컴파일 속도가 더 빠름
		
		int a1 = 0;
		int a2 = 0;
		a1 = a2 + 3;
		
		int t = +1;
		int u = -1;
		
		int k = 10;
		k += 3;
		System.out.println(k);
		k =+ 3;
		System.out.println(k);
		
		int d = 0;
		d++;
		System.out.println(d);
		++d;
		System.out.println(d);
		d = d + 1;
		System.out.println(d);
		d += 1;
		System.out.println(d);
	}
}
*/

/*
//ex14) 
public class Hello 
{
	public static void main(String[] args) {
		//1)
		int n = 10;
		while(true) {
			System.out.println(n);
			n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
			//if(n % 2 == 0) {
				//n = n / 2;
			//}else {
				//n= n*3 + 1;
			//}
			if(n == 1) {
				System.out.println(n);
				System.out.println("탈출 직전");
				break;
			}
		}
		
		//2)
		int n2 = 1234;
		//각자리의 수를 더하는 경우
		int sum = 0 ;
		while(true) {
			int r = n2 % 10;
			n2 = n2 / 10;
			System.out.println(n2 + " " + n2);
			sum = sum + r;
			if(n2 == 0) {
				System.out.println(n2);
				break;
			}
		}
		System.out.println(sum);
		
		
	}
}
*/

/*
//ex13) while문
//프로그래머가 반복 횟수를 알고 프로그래밍을 할떄는 for문 사용
//반복 횟수를 모르면 while문 사용
public class Hello 
{
	public static void main(String[] args) {
		int num = 0;
		//while(true) {
			//System.out.print(); 출력이후 줄 바꿈 없음
		//	num++;
		//	System.out.println(num + " ");
		//}
		
		int n = 0;
		while(n < 10) {
			System.out.println(n);
			n++;
			
		}
		System.out.println("호랑이");
		//반복 횟수를 알기 때문에 for문 사용하자
		
		int a = 0;
		while(true) {
			System.out.println(a);
			if (a == 5) {
				System.out.println("탈출 직전");
				break;
			}
			a++;
		}
	}
}
*/

/*
//ex12) for문 사용 예시
public class Hello 
{
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
			System.out.println(sum);
		}
		System.out.println(sum);
		
		int n = 5;
		for (int i = 0; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}
}
*/

/*
//ex11) for문
//for( 초기 ; 조건 ; 증감){}
//for(int x = 0; x < 3; x++){}
public class Hello 
{
	public static void main(String[] args) {
		System.out.println(1000);
		int num = 10;
		num = num + 3;
		System.out.println(num);
		num = num + 1;
		System.out.println(num);
		num++;//단항 연산자 ++
		System.out.println(num);
		num--;//단항 연산자 --
		System.out.println(num);
		++num;
		System.out.println(num);
		--num;
		System.out.println(num);
		for (int i = 0; i < 3; i++) {
			System.out.println("호랑이 " + i);
		}
		
		//for (int i = 5; i > 4; i = i + 3) {	
		//}
		//초기 값이 0이나 1이 아닌경우 억지로 코딩하는 것
		//부등호 부호 신경쓰기 i < 0
		//증감값이 1이 아닌경우 억지로 코딩하는 것
		
		
		//정석 사용
		for (int i = 0; i < 5; i++) {
			//5번 
		}
		for (int i = 1; i <= 5; i++) {
			//5번
		}
		int n = 5;
		for (int i = -n; i <= n; i++) {
			//음수 양수의 좌표값 제어할 때 사용된다.
			//5*2+1만큼 
		}
		
	}
}
*/

/*
//ex10) switch문
public class Hello 
{
	public static void main(String[] args) {
		//1) case뒤에는 변수가 올 수 없다.
		//2) switch안에는 변수를 넣을 수 있다.
		//3) default, break는 필요 여부에 따라 생략 가능하다.
		//4) 의도적인 경우에는 break를 생략 가능하다.
		//5) case안에서 실행되는 문장이 1개 이상일 경우 일반적으로 블록처리를 한다.
		int num = 10;
		switch (num) {
		case 10:
			System.out.println(1);
			//break;
		case 20:{
			System.out.println(2);
			System.out.println(100);
		}break;
		case 30:
			System.out.println(3);
			break;
		default:
			System.out.println(4);
			break;
		}
		
		int jumsu = 83;
		int q = jumsu / 10;  
		if(q >= 9) {
			System.out.println('A');
		}else if(q >= 8) {
			System.out.println('B');
		}else if(q >= 7) {
			System.out.println('C');
		}else if(q >= 6) {
			System.out.println('D');
		}else {
			System.out.println('F');
		}//if else 같은 경우는 switch 치환을 할 필요없다.
		
		switch (q) {
		case 10:
			System.out.println("A+");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
	}
}
*/

/*
// ex9) if문 
public class Hello 
{
	public static void main(String[] args) {

		//1) if문
		System.out.println(1);
		if(true){
			System.out.println(2);
			System.out.println(4);
		};// ; 생략 가능
		System.out.println(3);

		//2) if else문 (삼항연산으로 바꿀 수 있으면 삼항연산 사용하는 것이 원칙)
		if(false){
			System.out.println(5);
		}
		else{
			System.out.println(6);
		}

		//3) 삼항연산의 예
		int a = 10;
		int b = 5, c;
		if(a > b){
			c = 7;
		}
		else{
			c = 8;
		}
		System.out.println(c);
		c = a>b ? 8 : 7;// 슈가 코드, 삼항연산
		System.out.println(c);
		
		if(a > b) {
			System.out.println("호랑이");
		}
		else {
			System.out.println("코끼리");
		}
		
		System.out.println(a > b ? "호랑이" : "코끼리");
		
		//4)
		int num = 83;
		if(num >= 90) {
			System.out.println('A');
		}else if(num >= 80) {
			System.out.println('B');
		}else if(num >= 70) {
			System.out.println('C');
		}else if(num >= 60) {
			System.out.println('D');
		}else {
			System.out.println('F');
		}// switch문 가능하면 변환
	}
}
*/


/*
// ex8)
public class Hello 
{
	public static void main(String[] args) {
		int a = 17, b = 3;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);
		
		System.out.println(a > b * 6);//논리연산 < 비교연산 < 산술연산
		System.out.println(a > b * 6 || a - 10 > b);
	}
}
*/

/*
// ex7)
public class Hello 
{
	public static void main(String[] args) {
		//1)
		int a;
		a = 10;
		System.out.println(a);
		
		//2)
		int b, c, d;
		b = 1;
		c = 2;
		d = 3;
		System.out.println(b + " " + c + " " + d);
		
		//3)
		int e = 10;
		int f = 20, g = 30;
		int h , i = 40, j;
		h = 50;
		j = 60;
		System.out.println(e + g);
		
		//4)
		int a10;//첫글자에 숫자 사용 X
		a10 = 10;
		System.out.println(a10);
		a10 = 20;
		System.out.println(a10);
		
		//5) swap프로그램(데이터 교환)
		int aa = 88, bb = 99;
		int temp;
		System.out.println(aa + " " + bb);
		temp = aa;// temp = 88
		aa = bb;// aa = 99
		bb = temp;// bb = 88
		System.out.println(aa + " " + bb);
		
		//6) 5번과 같은 교환 프로그램
		int cc = 100;
		int dd = 200;
		int tt = cc; 
		cc = dd; 
		dd= tt;
	}
}
*/

/*
// ex 6)대입연산
public class Hello 
{
	public static void main(String[] args) {
		
		byte apple; // 정수 , 1byte = 8bit
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		apple = 100;
		System.out.println(apple);
	
		short banana; // 정수 , 2byte
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		banana = 10000;
		System.out.println(banana);
		
		int orange; // 정수 , 4byte
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		orange = 1000000;
		System.out.println(orange);
		
		long melon; // 정수 , 8byte
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		melon = 100000000;
		System.out.println(melon);
		
		float tiger; // 실수 , 4byte
		tiger = 3.14f;
		System.out.println(tiger);
		
		double lion; // 실수 , 8byte
		lion = 3.14;
		System.out.println(lion);
		
		char cat; // 2byte , 양수만 사용가능()
		//cat = 1000; 이런식으로 사용 안함
		cat = '한';
		System.out.println();
		System.out.println();
		System.out.println(cat);
		
		boolean dog; // 1byte , true 또는 false만 기억
		dog = true;
		System.out.println(dog);
	}
}
*/
/*
// ex 5) 숫자 + 문자열
public class Hello 
{

	public static void main(String[] args) {
		System.out.println(10);//숫자
		System.out.println('한');//문자
		System.out.println("호랑이");//문자열
		System.out.println("1000");//문자열
		
		
		System.out.println(10 +20);//숫자 + 숫자
		System.out.println(10 + "호랑이");//숫자 + 문자열 = 문자열로 취급 연결
		System.out.println("호랑이" + 10);//문자열 + 숫자
		System.out.println("호랑이" + "코끼리");//문자열 + 문자열
		System.out.println(10 + "호랑이" + 20);
		System.out.println(10 + 20 + "호랑이");
		System.out.println("호랑이" + 10 + 20);
		System.out.println(10 + " " + 20);
	}
}
*/


/*
// ex4) 논리연산자
public class Hello 
{
	public static void main(String[] args) {
		// 논리 OR
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		// 논리 AND 
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);
		
		System.out.println(true && true && false);
		System.out.println(false || false || true);
		System.out.println(false || (false && true));
		//and 와 or이 섞였을 경우에는 괄호를 이용하여 순서를 정해주어야한다
		System.out.println(3 > 2 || false || 6 <= 3);
		// 부정연산자
		System.out.println(!true);
		System.out.println(!(3 > 2));
	}
}
*/

/*
// ex3) 비교연산자
public class Hello 
{
	public static void main(String[] args) {
		System.out.println(5 > 3);
		System.out.println(5 >= 3);
		System.out.println(5 < 3);
		System.out.println(5 <= 3);
		System.out.println(5 == 3);
		System.out.println(5 != 3);
	}
}
*/

/*
// ex2) 산술연산자
public class Hello 
{
	public static void main(String[] args) {
		System.out.println("1000");
		System.out.println(20 + 3);
		System.out.println(20 - 3);
		System.out.println(20 * 3);
		System.out.println(20 / 3); // 몫
		System.out.println(20 % 3); // 나머지
		System.out.println(3 + 2 * 4);
		System.out.println((3 + 2) * 4);
	}
}
*/
/*
// ex1)
public class Hello 
{
	public static void main(String[] args) {
		System.out.println("더존");
	}
}
*/