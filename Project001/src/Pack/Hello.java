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
//ex69)UI���� Thread ����ϱ�
class ConnectThread extends Thread{
	Hello hello;
	ConnectThread(Hello hello){
		this.hello = hello;
	}
	public void run() {
		System.out.println(2);
		Platform.runLater(
				()->{
					hello.btn1.setText("ȣ����");
				});
	}
}
public class Hello extends Application{
	Button btn1 = new Button("�׽�Ʈ1");
	Button btn2 = new Button("�׽�Ʈ2");
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
					//Thread�� ����� ���� �ٷ� �����Ű�°� �Ϲ���
					//��ü�� ���� �����ʿ����.
					public void run() {
						System.out.println(1);

						//btn2.setText("ȣ����");
						//Thread�ȿ��� �������ҷ����ϸ� ���� �߻�
						//����ҷ��� runLater�̿��ؾ���
						
						Platform.runLater(
								()->{
									btn2.setText("ȣ����");
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
//				�Ʒ�ó�� ���氡��
				
//				new ConnectThread().start();
				
				new ConnectThread(Hello.this).start();
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
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
		Button btn1 = new Button("�׽�Ʈ1");
		Button btn2 = new Button("�׽�Ʈ2");

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("ȣ����");
				//btn2�� �ؽ�Ʈ ����
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
//				btn1.setVisible(false);
				//����/����
				btn1.setDisable(true);
				//�ؽ�Ʈ Ȱ��ȭ/��Ȱ��ȭ
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
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
		Button btn1 = new Button("�׽�Ʈ1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("ȣ����");
			}
		});
		TextArea textArea = new TextArea();
		//�ؽ�Ʈ���� ����
		
		TextField textField = new TextField();
		//�Է�â ����
		
		textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("�ڳ���");
				String s = textField.getText();
				
				textArea.appendText(s + "\n");
				//textArea�� �Էµ� ���ڿ��� ����
				//\n�� �̿��Ͽ� ���ڿ��� ���۹��� ���� ���� �ٷ� ����
				
//��Ʈ�� �ȿ� �����̳� �Ӽ��̳� ��� ��� ����, ������ �ҷ��� �� �� ������ �ȿ��� �ϸ� �� �ȴ�.
//������ �ȿ��� �ۿ� �� �� ���� ��Ȳ�� �߻��ϸ� 
//run later�� �̿��Ͽ� �� �� �ִ�.
				
				textField.setText("");
				//textField�� �Է¿��� ���� ������ â�� ����� ��
			}
		});
		root.getChildren().addAll(btn1, textArea, textField);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
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
		Button btn1 = new Button("�׽�Ʈ1");
		Button btn2 = new Button("�׽�Ʈ2");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("ȣ����");
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("����");
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
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
		//VBox ����ϸ� ���η� ����
		//HBox ����ϸ� ���η� ����
		root.setPrefSize(400, 300);
		
		root.setSpacing(10);
		//��ư������ ����
		
		//------------------------------------
		// �� ���� �ȿ� ��� �ڵ尡 ����.
		
		// ���1)
//		Button btn1 = new Button("�׽�Ʈ1");
//		root.getChildren().add(btn1);
//		//root������ ��ư�� �߰��ϰڽ��ϴ�.
//		Button btn2 = new Button("�׽�Ʈ2");
//		root.getChildren().add(btn2);
		
		// ���2)
		Button btn1 = new Button("�׽�Ʈ1");
		Button btn2 = new Button("�׽�Ʈ2");
		root.getChildren().addAll(btn1, btn2);
		
		//------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
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
//ex64-4)Thread ����3
public class Hello 
{
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				System.out.println(1);
			}
		};
		t.start();//Thread�� �ߵ��ȴٰ� ����

		new Thread() {
			public void run() {
				System.out.println(2);
			}
		}.start();//Thread�� �ߵ��ȴٰ� ����
		//call�� ��� ���ٰ� �ٽ� ���ƿ��µ� 
		//�� ���� run�� start�� ���� ���
	}
}
*/

/*
//ex64-3)Thread ����2
class Tiger extends Thread{
	public void run() {
		System.out.println("Tiger start");
		Thread t = new Lion();
		t.start();
		Scanner sc = new Scanner(System.in);
//		sc.nextInt();//���ŷ �Լ�
		System.out.println("tiger"+sc.nextInt());
		System.out.println("Tiger end");
	}
}
class Lion extends Thread{
	public void run() {
		System.out.println("Lion start");
		Scanner sc = new Scanner(System.in);
//		sc.nextInt();//���ŷ �Լ�1
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
//		sc.nextInt();//���ŷ �Լ�
		System.out.println("main"+sc.nextInt());
		//Window - Show View - Other - Debug - Debug
		
		System.out.println("main end");
	}
}
*/

/*
//ex64-2)Tread ����1
//������ ��� �����𸦋� ��, �Դٰ����ҋ�
//���μ����� 2�� ���ٶ����
class Tiger extends Thread{
	public void run() {
		System.out.println(2);
		for (int i = 0; i < 10; i++) {
			System.out.println("ȣ����" + i);
			try {Thread.sleep(0);} catch (Exception e) {}
			//0�� �־����� �� ���� ���� �ƴ϶�
			//������ �ּ����� �ð��� ����.
		}
		System.out.println("����");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Thread t = new Tiger();
		t.start();
		System.out.println(1);
		for (int i = 0; i < 10; i++) {
			System.out.println("����" + i);
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
		System.out.println("������ ����");
		System.out.println("B run call");
		System.out.println("������ ����");
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
//ex63-2) ���׸� ����
class A <T> {
	//type�� �ٲ𶧸��� ������ �ٲٴ� ��찡 �ִµ�
	//����ɶ����� �ڵ����� �޾��ִ� ����
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
		b.setData("ȣ����");
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
		b.setData("ȣ����");
		System.out.println(b.getData());
	}
}
*/

/*
//ex62-3)����������.��Ŀ������(Decorator)
class Ŀ��{
	int ���� = 30;
	int ���() {
		System.out.println("Ŀ�� �ֹ�");
		return ����;
	}
}
class ���� extends Ŀ��{
	int ���� = 20;
	Ŀ�� a; // �� ������� �� ��ü�� ����޴´�.
	����(Ŀ�� a){
		this.a = a;
	}
	int ���() {
		System.out.println("���� �߰�");
		return ���� + a.���();
	}
}
class ���� extends Ŀ��{
	int ���� = 10;
	Ŀ�� a; // �� ������� �� ��ü�� ����޴´�.
	����(Ŀ�� a){
		this.a = a;
	}
	int ���() {
		System.out.println("���� �߰�");
		return ���� + a.���();
	}
}


public class Hello 
{
	public static void main(String[] args) {
		Ŀ�� a = new Ŀ��();
		System.out.println(a.���());
		System.out.println("---------------");
		a = new ����(a);
		a = new ����(a);
		System.out.println(a.���());
		System.out.println("---------------");
		a = new ����(a);
		a = new ����(a);
		a = new ����(a);
		System.out.println(a.���());
	}
}
*/


/*
//ex62-2)����������.��Ŀ������(Decorator)
//B��ü�� A�� ����ϰ� �ְ� C��ü�� B��ü�� �����̰� �ִ�.

class A{
	int num = 10;
	int run() {
		System.out.println("A Run");
		return num;
	}
}
class B extends A{
	int num = 20;
	A a; // �� ������� �� ��ü�� ����޴´�.
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
	A a; // �� ������� �� ��ü�� ����޴´�.
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
			//Package Explorer���� project
			//������ ���콺 Properties
			//Location���� ��������
			Reader r = new FileReader("test02.txt", StandardCharsets.UTF_8);
			while(true) {
				int data = r.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			r.close();
			System.out.println("\n���� ����� ����");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(1000);
	}
}
*/

/*
 //ex 60)���� ����� ���׿�����
public class Hello 
{
	public static void main(String[] args) {
		try {
			//Package Explorer���� project
			//������ ���콺 Properties
			//Location���� ��������
			Writer w = new FileWriter("test01.txt");
			for (int i = 0; i <8; i++) {
				for (int j = 0; j < 10; j++) {
					w.write((i+j)%2==0 ?"o ":"x ");
				}
				w.write("\n");
			}
			w.close();
			System.out.println("���� ����� ����");
		}catch(Exception e) {
			
		}
	}
}
/*

/*
//ex59)���� ����� �ڵ�
public class Hello 
{
	public static void main(String[] args) {
		try {
			//Package Explorer���� project
			//������ ���콺 Properties
			//Location���� ��������
			Writer w = new FileWriter("test01.txt");
			
			w.write("apple");
			w.write("\n\n");
			w.write("����ȭ");
			
			w.close();
			System.out.println("���� ����� ����");
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
//ex58)����������.�̱���(only one)
//��ü�� �Ѱ��� ��������� class�� ����� ���
//��ü �Ѱ��� ������ �Ǿ����� ����� ���� �� ��� �̱��� ������ ���
//��ü�� 2���� �ʿ���� ���
class Tiger{
	int num;
	private static Tiger instance = null;//��� ����
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
		//t.a = 10; private�� ��� �Ұ�
		t.setName("��浵");
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
	// �⺻������ default�� �����Ǿ��ִµ� ����ϸ� ����
	// ���� ���� ������ ����� ������ public ���
	
	private int num;
	public void setNum(int num) {
		this.num = num;
	}
	//�� �Լ��� �� ����� �б� ����
	public int getNum() {
		return this.num;
	}
	//�� �Լ��� �� ����� ���� ����
	
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
		//t.a = 10; private�� ��� �Ұ�
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
		//���� ��� ���
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
		System.out.println(t5.m1(101, "ȣ����"));
		
		//6)
		Test5 t6 = () -> 100;
		//return 100 ���ٸ� ������� 
		//{return 100;};�� ���� ���� �� �� �ִ�.
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
		
		//ex4) ���� �Լ� ��� 
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
				System.out.println(i + "���� ã�Ҵ�");
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
		//�����̳�(���׸� ����< >) - �Ѱ����� ���빰�� ��� �ִ� ��
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
			//for������ mm.size()�� ���Եɰ�� ��� ȣ���Ű�� ������ ��뿡 ������ �����
			int data = mm.get(i);
			System.out.print(data + " ");
		}System.out.println(" ");
		
		//3. foreach�� ��� x, item, data, value�� �ַ� ���
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
//				System.out.println(j + "���� ����");
//			}else {
//				System.out.println(j + "���� ����");				
//			}
//		}
		
		System.out.println("");
		char c5 = 0x00dc;
		int mask = 0x80;
		String[] st = new String[] {"�����", "��ǻ��", "TV", "��Ź��", "���", "������", "����", "������"};
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
//		s1.insert(4, '��');
//		System.out.println(s1);
//		s1.insert(9, '��');
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
		int b = 991087961;// 2���� -> 1001000110100
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
		String s = "����ȭ�����Ǿ����ϴ�.";
		// 1)
		System.out.println(s.length());
		//s�� ����

		// 2)
		System.out.println(s.charAt(3));
		//s�� 3���� �ܾ�

		// 3)
		System.out.println(s.indexOf("ȭ"));
		//"ȭ"�� ������� �ֳ�
		System.out.println(s.indexOf("��"));
		//������ -1
		
		int n = s.indexOf("ȭ����");
		if(n != -1) {
			System.out.println(n + "�������� find");
		} else {
			System.out.println("not find");
		}
		
		// 4)
		System.out.println(s.replace("����", "������"));
		//�ܾ ã�� ����
		System.out.println(s.replace("�ɱ�", "������"));
		//������ ���� s ���
		System.out.println(s);
		//replace�� ����Ͽ��� ���� �����ʹ� ����
		
		//s = "���ѹα�";
		//System.out.println(s);
		//���� ���� ���� ������ �ƴ϶� ��ü�� ���ְ� ���� ���� ��
		//String�� �����͸� ������ �� ����.
		
		// 5) slicing
		System.out.println(s.substring(5));
		//5������ ������ ���
		System.out.println(s.substring(3, 6));
		//3������ 6�� �ձ��� ���
	
		// 6)
		String s2 = "   App   le   ";
		System.out.print(s2.trim());
		//�յ��� ������ ����
		//ID, PW �Է¹����� �ַ� ���
		System.out.println("ȣ����");
		
		// 7) 
		String s3 = "APple";
		System.out.println(s3.toUpperCase());
		//�빮�ڷ� ����
		System.out.println(s3.toLowerCase());
		//�ҹ��ڷ� ����

		// 8)
		byte[] data = new byte[] {65, 'B', 'C', 'D'};
		String s4 = new String(data, 0, data.length);
		System.out.println(s4);
		//���� �������� ���ڸ� ���ڿ��� ��ȯ
		String s5 = "Banana";
		byte[] data1 = s5.getBytes();
		for (byte value : data1) {
			System.out.println((char)value);
		}
		//�����͸� �����ҋ� 
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
			System.out.println("�ͼ��ǹ߻���");
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
		
		String s = "����ȭ�����Ǿ����ϴ�";
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
		System.out.println("�뱹�� �����մϴ�.");
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
//google���� ����
class Alpago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ���� ����� �մϴ�.");
	}
}
//�Ƹ������� ����
class Betago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ���� ����� �մϴ�.");
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
		System.out.println("�뱹�� �����մϴ�.");
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
//google���� ����
class Alpago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ���� ����� �մϴ�.");
	}
}
//�Ƹ������� ����
class Betago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ���� ����� �մϴ�.");
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
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(Ai ai) {
		ai.play();
	}
}
interface Ai{
	void play();
}
//google���� ����
class Alpago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
//�Ƹ������� ����
class Betago implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
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
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(Alpago alpago) {
		alpago.play();
	}
	void play(Betago betago) {
		betago.play();
	}
}
//google���� ����
class Alpago{
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
//�Ƹ������� ����
class Betago{
	void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
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
//�ΰ������� �ٲ�� �Ǹ� ��� �� ���ΰ�
class Baduk{
	Baduk() {
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
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
			//�͸� class
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
		//�͸� ��ü
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
	//this�� �̿��Ͽ� �ڱ� class �ȿ��� �ٸ� �����ڸ� ȣ�� �Ҷ�
	Tiger(){
		System.out.println(1);
	}
	
	Tiger(int a){
		this();//�μ��� ���� ������ ��
		System.out.println(a);
	}
	
	Tiger(int a, int b){
		this(a + b);//������ ȣ���� �� ���
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
			System.out.println("�����մϴ�");
		}else {
			System.out.println("�Ф�");
		}
	}
	int m2() {
		System.out.println("�������ִ� �����");
		return 50;
	}
	String m3() {
		return "����";
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
			case "�¼�":
				return true;
			case "����":
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
	//this�� ����Ͽ� chaining�� �̿�
	//chaining�� ���� this ���
	//Tiger this;
	//Tiger(Tiger t - t1�� �μ����޷� �Ѿ��, int a, int b){
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
		System.out.println("ȣ����");
		//�Ϲ����� ��� m1~3�����۾��� �ϰԵǸ� ���� ����ϰ� �Ǵ� ��찡 ����µ� 
		//"ȣ����"�� ���� �߰��� ���� �Ǹ� ���� �Ǿ��ٰ� �Ѵ�.
		//chaining�� ����ϰԵǸ� ������ ������ �� �ִ�.
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
	int a, b;//��� ����
	int size;
	Tiger(int a, int b, int size){
		//��� ������ �ʱ�ȭ�ϱ����� ������ ���
		//�������� ���� ������ �̸� ������ ����
		this.a = a;//�ʵ��� a = �μ�����a, �̸��� �����ɶ� this ���
		this.b = b;//this�� ����ϰԵǸ� ��� ������ ����ų �� �ִ�.
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
		num = num;//self ����, �ڱ� ����, �ǹ̾��� �ڵ�
		t1.show();
	}
}
*/

/*
//ex43-1)
class Tiger{
	//Tiger this;
	//Tiger(Tiger t - t1�� �μ����޷� �Ѿ��, int a, int b){
		//this = t;
	//}
	// ���� �Ʒ��� Tiger �����ڸ� ���ϸ� �ڵ����� �����Ǿ��ִ� �κ��� Ȯ���� �� �ִ�.
	// ������ ���� �ۼ��� ����
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
// final�� 3������ ��� ����
final class Animal{
	//class�տ� final�� ����ϰԵǸ� ����� ���� �� ���� �ȴ�.
	final int NUM = 10;
	//final�� ����ϸ� ���� ������ �� ����.
	//��� - �޸� �ȿ� ������ ������ �� ���� ���
	//���� - �޸� �ȿ� ������ ���氡���� ���
	final void m1() {
		//�Լ� �տ� final�� ������ �������̵�(�θ�� �ڽ��� �Ȱ��� �̸�)�� �������̴�.

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
interface B{//�Լ� ����
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
@FunctionalInterface  // ����Ű�� �������̽� �ȿ��� �Լ��� 1�� �ִ�.
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
interface �ѱ�����{
	void �Ա�();
	void ���();
	void ��ü();
	void ����();
}
class �������� implements �ѱ�����{
	@Override
	public void �Ա�() {
		System.out.println("������ : 3%");
	}
	@Override
	public void ���() {
	}
	@Override
	public void ��ü() {
	}
	@Override
	public void ����() {
	}
}
class �츮����  implements �ѱ�����{
	@Override
	public void �Ա�() {
		System.out.println("������ : 5%");
	}
	@Override
	public void ���() {		
	}
	@Override
	public void ��ü() {		
	}
	@Override
	public void ����() {		
	}
}
public class Hello 
{
	public static void main(String[] args) {
		�������� t1 = new ��������();
		�츮���� t2 = new �츮����();
		t1.�Ա�();
		t2.�Ա�();
	}
}
*/

/*
//ex39)
class ��������{
	void Į() {
		System.out.println("Į�� �� ����ϴ�.");
	}
	void ����() {};
}
class ���׳�1 extends ��������{
	void ����() {
		System.out.println("���� �� ����ϴ�.");
	}
}
class ���׳�2 extends ��������{
	//������̼� - ���α׷��Ӱ� �Ǽ��� �� �ִ� ��Ȳ�� �����ϱ� ����
	@Override
	void ����() {
	}
}
public class Hello 
{
	public static void main(String[] args) {
		���׳�1 t1 = new ���׳�1();
		���׳�2 t2 = new ���׳�2();
		t1.Į();
		t1.����();
		t2.Į();
		t2.����();
	}
}
*/

/*
//ex38)
//abstract class Animal{
//	abstract void m1(); 
//} �������� ���̵忪Ȱ�� ���������� class�μ� ��Ȱ�� ����.
interface Animal{
	//void m1();  -  {}���� "�̿ϼ� �ڵ�"
	abstract void m1();
	//abstract - �߻�, �̿ϼ�
	//abstract�� �� ���� ��� �ڵ����� �����ȴ�.
}
class Tiger implements Animal{
	//�������̽��� ��� extends�� �ƴ� implements�� ���
	//Ŭ������ �������̽��� �ΰ� �� ��밡���� ��� �������̽��� �ϴ°��� ����.
	public void m1() {
		//implements�� ��� public���
		System.out.println(2);
	}//�θ� Ŭ������ abstract�̸� Tiger Ŭ������ �ƹ��͵� ���� ��� ������ ����
	
}
public class Hello 
{
	public static void main(String[] args) {
		Animal a = new Tiger();
		a.m1();
		//Animal t2 = new Animal(); �̿ϼ��ڵ��̱⿡ ��ü ���� �Ұ�
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
		System.out.println("��! ��!");
	}
}
class Cat extends Animal{
	void cry() {
		System.out.println("�̾߿�~");
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
		System.out.println(rn.nextInt());//int �����ȿ� ���� �����´�
		for (int i = 0; i < 10; i++) {//�������� ����
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
		int a = 10;//4����Ʈ �μ� �Ѱ� �ּ���
		int [] ar = new int[5];
		int [] br = new int[] {1, 2, 3, 4, 5};
		int [] cr = {10, 20, 30, 40, 50};
		System.out.println(ar.length);
		for (int i = 0; i < br.length; i++) {
			System.out.print(br[i] + " ");
			//�Ϲ������� �迭�̳� ���ӵ� ���� ����Ҷ� println�� �ַ� ��� ����
		}
		System.out.println("");
		System.out.println("ȣ����");
		//i��� ���� ���� : x, data, value
		for (int x : cr) {
			//for���� ����ȭ ����, �迭���� �տ������� x������ �־��ش�
			//foreach���� ����ҋ� ������ index�� �� �� ����.
			System.out.print(x + " ");
		}
		System.out.println("");
		//cr�� ��� �޸𸮸� 5�� �޶�� �Ͽ���
		//�迭�� ���� - 1 �� ũ�⸦ ��밡��
		cr[0] = 100;
		cr[4] = 200;
		//cr[5] = 300; ��ȿ ���Ǹ� ����� ������ ���� �߻�
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
		//�迭�� ��ȿ ���� : 0 ~ (�迭�� ���� - 1)
		System.out.println("\n------------------");
		
		boolean[] dr = {true, false, true, false};
		for (boolean x : dr) {
			System.out.print(x + " ");
		}
		System.out.println("-------------------");
		
		String[] ss = new String[4];
		ss[0] = "ȣ����";
		ss[1] = "�����";
		ss[2] = "��";
		ss[3] = "�Ǵ�";
		
		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i] + " ");
		}
		System.out.println("");
		for (String x : ss) {
			System.out.print(x + " ");
		}
		System.out.println("");
		
		String [] st = new String[] {"���", "ƫ��", "�عٶ��"};
		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		String s1 = "ȣ����";
		String s2 = new String("ȣ����");
		
		String [] su = new String[] {new String("���")};
		
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
		System.out.println("��! ��!");
	}
}
class Cat extends Animal{
	void cry() {
		System.out.println("�̾߿�~");
	}
}
class Snake extends Animal{
	
}
class Zoo{
	//Ȯ���ؼ� �����ִ�. (����) ���� ����Ҽ��ְ��Ѵ� 
	//�ڵ庯���� �������� (�����)
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
//��ü���� ���� 5���� ���� : SOILD
//SRP(����å���� ��Ģ)
//ex)������ å �����ҋ� �����Ϳ� ������ ���ܵ� ������ å ������ å���� ����.
//�����Ϳ� ������ ����µ� ������ å ���� ���α׷��� �ǵ���� �ǹ̰� ����.
//OCP(��������� ��Ģ)
//LSP(�����ں� ġȯ�� ��Ģ)
//ISP(�������̽� �и��� ��Ģ)
//DIP(������������ ��Ģ)
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
		Animal t3 = new Tiger(); //case 3) �� ĳ����, ���ڰ���
		//Tiger(����) t4 = new Animal(�޸�)(); case 4) �ڹٿ����� ��� �� �Ѵ�. �ٿ� ĳ����
		t3.m1();
		//t3.m2(); Tiger�� �޸𸮸� �޾ƿ����� Animal ������ ��밡���Ͽ� m2�� ����Ҽ� ����.
		t3.m3();
		//�޸𸮸� �޾ƿԱ⶧���� Animal ������ ������ �ڽ�class�� ���� �Լ��� ������ �ڽ� �Լ��� ����Ѵ�.
	}
}
*/

/*
//ex32) 
class Animal{
	Animal(){
		System.out.println("�θ������ ��");
	}
	Animal(int n){
		System.out.println(n);
	}
}
class Tiger extends Animal{
	Tiger(){
		//���� ������ �ڵ尡 ������ �����Ǿ��ִ�. �ؿ� ��ɹ�
		super();//�θ��� �����ڸ� ���ϴ� ��ɹ�
		System.out.println("�ڽĻ����� ��");
	}
	Tiger(int num){
		super(num + 100);//�̰� ��� ��� �Ȱ���(������ �ڵ����� ����� ��)
		//���ϴ� �θ� �����ڰ� ������ �μ��� �����ָ� �ȴ�.
		System.out.println(num);
	}
	Tiger(int a, int b){
		super(a * b);
		System.out.println("3���� ������");
		//super();  -->  super()�� �Լ��� ���� ù��° �;��Ѵ�
		//�ڿ� ����ϸ� ���� �߻�
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
//ex31) ���
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
		super.m3();//super�� ����Ͽ� �θ�class���� m3�� ȣ�Ⱑ��
		System.out.println(4);
	}
}
public class Hello 
{
	public static void main(String[] args) {
		Animal t1 = new Animal();
		Tiger t2 = new Tiger();
		t2.m1();
		t2.m2();//�ڽ� class�� Ȯ�� ���� ã�� �Լ��� ���� ��� �θ� class���� ã�Ƽ� ���
		t2.m3();//���� �̸��� �Լ��� ���� ��� �ڽ��� class���� �Լ� ���
		t2.m4();//���� class���� �Լ��� ���� ����� �� �ִ�.
	}
}
*/

/*
//ex30 math�Լ�)
public class Hello 
{
	public static void main(String[] args) {
		//���밪
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);

		//�ø���
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);

		//������
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5 = " + v5);
		System.out.println("v6 = " + v6);
		
		//�ִ밪
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.7);
		System.out.println("v7 = " + v7);
		System.out.println("v8 = " + v8);

		//�ּҰ�
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.7);
		System.out.println("v9 = " + v9);
		System.out.println("v10 = " + v10);
		
		//����� ������ �Ǽ� ��
		double v11 = Math.rint(5.3);
		double v12 = Math.rint(5.74343);
		System.out.println("v12 = " + v11);
		System.out.println("v13 = " + v12);

		//�ݿø�
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
		t.m1();//new�� ���� �����Ǿ��⶧���� ��� ����
		//m1(); static m1()�� �ƴϱ� ������ ����� �� ����.
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
		//static �Լ� �ȿ����� static ������ ��� �����ϴ�.
		m1();//���
		Hello h = new Hello();
		h.m1();//��� m1�� static�� ���ؼ� ���� �����⶧���� ���� h.m1()�� �� �ʿ䰡 ����.
		h.m2();//���
		Hello.m1(); // class�̸����� �ҷ��鿴���� static�� ���� ����ϸ� ��� ����
		//Hello.m2(); static m2()�� �ƴϱ� ������ ����� �� ����.
	}
	void m2() {
		System.out.println(2);
	}
}
*/

/*
//ex28)
class Tiger{//�������� ����ϴ� ������ ����� ������ ���, ��ü���� ���� ����
	int num1;
	static int num2 = 100;
	static void m1() {
		System.out.println("static �Լ� ����");
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
		name = "����";
	}//default ����
	Car(String n,int f){//�μ�����
		fuel = f;
	}
	void Move() {	
		System.out.println("�ڵ����� �޸���.");
		fuel -= 30;
		System.out.println("�޸���" + name);
	}
	void Stop() {
		System.out.println("��ž");
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
		Car car2 = new Car("�����ڵ���", 50);
		
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
	Tiger(){}//�ȿ� �ƹ��͵� ���ٴ� �����Ͽ� ���ٷ� ����
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
//ex25) ������
// 1) �����ڴ� �Լ��̴�. ������ �Լ��� �Ѵ�.
// 2) �Լ� �̸��� Ŭ���� �̸��� �ݵ�� �����ؾ��Ѵ�.
// 3) ������ �Լ��� return���� ���� ���� ����.�׷��� void�� �����Ѵ�.
// 4) ������ �Լ��� �����ε��� �����ϴ�.
// 5) ������ �Լ��� ��ü�� ������ �� �� �ѹ��� ȣ��ȴ�.(���Ƿ� ȣ���� �� ����.)
// 6) �����ڸ� ����ϴ� ������ ��� �޼ҵ带 �ʱ�ȭ��Ű�� ���� ���ȴ�.
// 7) ������ �Լ��� �ۼ����� �����ÿ��� �ڵ����� default�����ڰ� ���������.

class Tiger{
	int age = 20;
	String name = "ȫ�浿";
	Tiger(){//�μ� ������ ���� ������ - defualt ������
		System.out.println("������ ����");
		System.out.println("�����ڰ� ȣ��Ǿ���.");
		//age = 20;
		//name = "ȫ�浿";
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
		Tiger t3 = new Tiger(100, "������");
		Tiger t4 = new Tiger(200, "�޹���");
		//System.out.println(t1.age + t1.name);
		//System.out.println(t2.age + t2.name);
		//System.out.println(t3.age + t3.name);
		//System.out.println(t4.age + t4.name); �Ʒ��� ���� ��Ȱ
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
	//�Լ��� ���޵Ǵ� �μ��� ������ �ٸ��ų� Ÿ���� �ٸ��� �Լ��� �̸��� �����ϰ� ����� �� �ִ�.
	//�̰��� �Լ� �����ε�, �����Ƕ�� �Ѵ�.
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
		t1.method01("ȣ����", 0);
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
		System.out.println("ȣ����");
		int num = 0;
		while(true) {
			num++;
			if(num % 2 != 0) {
				System.out.println("ȣ����" + num);
				continue;
			}
			if(num == 10) {
				System.out.println("�ڳ���" + num);
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
				System.out.println("ã�Ҵ�");
				return ;
			}
		}
		System.out.println("�˻� ������ ã�� ����.");
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
      
      return "������";
   }
   Rion m2() {
      //return new Rion(); �Ʒ��� ����
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
	//���� - �μ� ���� 2�� �̻� �� ��� int a, b�� �ȵȴ�.
	//������ ������ Ÿ���� �����־���Ѵ�.
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
	void m3(Lion a) {//����ڰ� ������ Ŭ������ �޾� ��밡���ϴ�.
		System.out.println(a.hashCode());
		a.sound();
	}
}

class Lion{
	void sound() {
		System.out.println("����");
	}
}
public class Hello 
{
	public static void main(String[] args) {
		String s1 = "ȣ����";//�ڹٿ��� �����ϴ� ǥ�� Ŭ���� - String
		System.out.println(s1.length());
		Tiger t1 = new Tiger();
		t1.m1(3, 4);
		t1.m2(10, '��', true, 3.14f, "ȣ����");
		
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
	//�޼ҵ�(�Լ� : ���ֻ���ϴ� �ڵ带 ���� �� �ҷ��� ����Ѵ�.)
	void merry() {
		System.out.println('��');
	}
	void happy(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println('��');
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
		t.merry();//�Լ� ��
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
		//���� ��    �μ� ����
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
	// �ʵ�(Ŭ���� �ȿ��� ���ǵǴ� ����)
	int a;
	int b = 20;
	int c, d = 30;
	// ������
	// �޼ҵ�
}


public class Hello 
{
	public static void main(String[] args) {
		Tiger t1 = new Tiger();// ��ü ���� - �ν��Ͻ�ȭ, new ���
		Tiger t2 = new Tiger();
		t1.a = 100;
		t1.c = t1.a + 30;
		System.out.println(t1.a);
		System.out.println(t1.b);
		System.out.println(t1.c);
		System.out.println(t1.d);
		System.out.println(t2.c);
		//��� ��ü�� �����Ǹ� ������ȣ�� �����Ѵ�.
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		Tiger t3;
		t3 = t2;//�� ������ �����Ѵ�, �޸𸮸� �����Ѵ�.
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
		b = a++;//����, ���� ������ �Ͼ��.
		System.out.println(a + " " + b);
		
		int c = 10, d;
		d = ++c;//����, ���� ������ �Ͼ��.
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
		//(int)->Ÿ�� (a)->���� (=)->���Կ����� (10)->���ͷ�
		int a = 10;
		int b = 20;
		short c = 30;
		//���Կ����ڴ� ���ʰ� �������� Ÿ���� �����ؾ��Ѵ�.
		//b = c;
		b = (int)c;//�� ���ο����� intŸ������ ��ȯ
		c = (short)a;//Ÿ�� ĳ����
		
		int num = 10;
		num = num + 3;
		num += 3;//���� �ڵ庸�� ������ �ӵ��� �� ����
		
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
				System.out.println("Ż�� ����");
				break;
			}
		}
		
		//2)
		int n2 = 1234;
		//���ڸ��� ���� ���ϴ� ���
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
//ex13) while��
//���α׷��Ӱ� �ݺ� Ƚ���� �˰� ���α׷����� �ҋ��� for�� ���
//�ݺ� Ƚ���� �𸣸� while�� ���
public class Hello 
{
	public static void main(String[] args) {
		int num = 0;
		//while(true) {
			//System.out.print(); ������� �� �ٲ� ����
		//	num++;
		//	System.out.println(num + " ");
		//}
		
		int n = 0;
		while(n < 10) {
			System.out.println(n);
			n++;
			
		}
		System.out.println("ȣ����");
		//�ݺ� Ƚ���� �˱� ������ for�� �������
		
		int a = 0;
		while(true) {
			System.out.println(a);
			if (a == 5) {
				System.out.println("Ż�� ����");
				break;
			}
			a++;
		}
	}
}
*/

/*
//ex12) for�� ��� ����
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
//ex11) for��
//for( �ʱ� ; ���� ; ����){}
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
		num++;//���� ������ ++
		System.out.println(num);
		num--;//���� ������ --
		System.out.println(num);
		++num;
		System.out.println(num);
		--num;
		System.out.println(num);
		for (int i = 0; i < 3; i++) {
			System.out.println("ȣ���� " + i);
		}
		
		//for (int i = 5; i > 4; i = i + 3) {	
		//}
		//�ʱ� ���� 0�̳� 1�� �ƴѰ�� ������ �ڵ��ϴ� ��
		//�ε�ȣ ��ȣ �Ű澲�� i < 0
		//�������� 1�� �ƴѰ�� ������ �ڵ��ϴ� ��
		
		
		//���� ���
		for (int i = 0; i < 5; i++) {
			//5�� 
		}
		for (int i = 1; i <= 5; i++) {
			//5��
		}
		int n = 5;
		for (int i = -n; i <= n; i++) {
			//���� ����� ��ǥ�� ������ �� ���ȴ�.
			//5*2+1��ŭ 
		}
		
	}
}
*/

/*
//ex10) switch��
public class Hello 
{
	public static void main(String[] args) {
		//1) case�ڿ��� ������ �� �� ����.
		//2) switch�ȿ��� ������ ���� �� �ִ�.
		//3) default, break�� �ʿ� ���ο� ���� ���� �����ϴ�.
		//4) �ǵ����� ��쿡�� break�� ���� �����ϴ�.
		//5) case�ȿ��� ����Ǵ� ������ 1�� �̻��� ��� �Ϲ������� ���ó���� �Ѵ�.
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
		}//if else ���� ���� switch ġȯ�� �� �ʿ����.
		
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
// ex9) if�� 
public class Hello 
{
	public static void main(String[] args) {

		//1) if��
		System.out.println(1);
		if(true){
			System.out.println(2);
			System.out.println(4);
		};// ; ���� ����
		System.out.println(3);

		//2) if else�� (���׿������� �ٲ� �� ������ ���׿��� ����ϴ� ���� ��Ģ)
		if(false){
			System.out.println(5);
		}
		else{
			System.out.println(6);
		}

		//3) ���׿����� ��
		int a = 10;
		int b = 5, c;
		if(a > b){
			c = 7;
		}
		else{
			c = 8;
		}
		System.out.println(c);
		c = a>b ? 8 : 7;// ���� �ڵ�, ���׿���
		System.out.println(c);
		
		if(a > b) {
			System.out.println("ȣ����");
		}
		else {
			System.out.println("�ڳ���");
		}
		
		System.out.println(a > b ? "ȣ����" : "�ڳ���");
		
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
		}// switch�� �����ϸ� ��ȯ
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
		
		System.out.println(a > b * 6);//������ < �񱳿��� < �������
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
		int a10;//ù���ڿ� ���� ��� X
		a10 = 10;
		System.out.println(a10);
		a10 = 20;
		System.out.println(a10);
		
		//5) swap���α׷�(������ ��ȯ)
		int aa = 88, bb = 99;
		int temp;
		System.out.println(aa + " " + bb);
		temp = aa;// temp = 88
		aa = bb;// aa = 99
		bb = temp;// bb = 88
		System.out.println(aa + " " + bb);
		
		//6) 5���� ���� ��ȯ ���α׷�
		int cc = 100;
		int dd = 200;
		int tt = cc; 
		cc = dd; 
		dd= tt;
	}
}
*/

/*
// ex 6)���Կ���
public class Hello 
{
	public static void main(String[] args) {
		
		byte apple; // ���� , 1byte = 8bit
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		apple = 100;
		System.out.println(apple);
	
		short banana; // ���� , 2byte
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		banana = 10000;
		System.out.println(banana);
		
		int orange; // ���� , 4byte
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		orange = 1000000;
		System.out.println(orange);
		
		long melon; // ���� , 8byte
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		melon = 100000000;
		System.out.println(melon);
		
		float tiger; // �Ǽ� , 4byte
		tiger = 3.14f;
		System.out.println(tiger);
		
		double lion; // �Ǽ� , 8byte
		lion = 3.14;
		System.out.println(lion);
		
		char cat; // 2byte , ����� ��밡��()
		//cat = 1000; �̷������� ��� ����
		cat = '��';
		System.out.println();
		System.out.println();
		System.out.println(cat);
		
		boolean dog; // 1byte , true �Ǵ� false�� ���
		dog = true;
		System.out.println(dog);
	}
}
*/
/*
// ex 5) ���� + ���ڿ�
public class Hello 
{

	public static void main(String[] args) {
		System.out.println(10);//����
		System.out.println('��');//����
		System.out.println("ȣ����");//���ڿ�
		System.out.println("1000");//���ڿ�
		
		
		System.out.println(10 +20);//���� + ����
		System.out.println(10 + "ȣ����");//���� + ���ڿ� = ���ڿ��� ��� ����
		System.out.println("ȣ����" + 10);//���ڿ� + ����
		System.out.println("ȣ����" + "�ڳ���");//���ڿ� + ���ڿ�
		System.out.println(10 + "ȣ����" + 20);
		System.out.println(10 + 20 + "ȣ����");
		System.out.println("ȣ����" + 10 + 20);
		System.out.println(10 + " " + 20);
	}
}
*/


/*
// ex4) ��������
public class Hello 
{
	public static void main(String[] args) {
		// �� OR
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		// �� AND 
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);
		
		System.out.println(true && true && false);
		System.out.println(false || false || true);
		System.out.println(false || (false && true));
		//and �� or�� ������ ��쿡�� ��ȣ�� �̿��Ͽ� ������ �����־���Ѵ�
		System.out.println(3 > 2 || false || 6 <= 3);
		// ����������
		System.out.println(!true);
		System.out.println(!(3 > 2));
	}
}
*/

/*
// ex3) �񱳿�����
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
// ex2) ���������
public class Hello 
{
	public static void main(String[] args) {
		System.out.println("1000");
		System.out.println(20 + 3);
		System.out.println(20 - 3);
		System.out.println(20 * 3);
		System.out.println(20 / 3); // ��
		System.out.println(20 % 3); // ������
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
		System.out.println("����");
	}
}
*/