package Pack;
/*
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
public class No64_Ramda1 
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