package Pack;
/*
//1) �����ڴ� �Լ��̴�. ������ �Լ��� �Ѵ�.
//2) �Լ� �̸��� Ŭ���� �̸��� �ݵ�� �����ؾ��Ѵ�.
//3) ������ �Լ��� return���� ���� ���� ����.�׷��� void�� �����Ѵ�.
//4) ������ �Լ��� �����ε��� �����ϴ�.
//5) ������ �Լ��� ��ü�� ������ �� �� �ѹ��� ȣ��ȴ�.(���Ƿ� ȣ���� �� ����.)
//6) �����ڸ� ����ϴ� ������ ��� �޼ҵ带 �ʱ�ȭ��Ű�� ���� ���ȴ�.
//7) ������ �Լ��� �ۼ����� �����ÿ��� �ڵ����� default�����ڰ� ���������.

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

public class No26_Constructor
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
