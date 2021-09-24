package Pack;


class Tiger{
	void m1() {System.out.println(1);}
	void m2() {System.out.println(2);}
	void m3() {System.out.println(3);}
	void m4() {System.out.println(4);}
	void m5() {System.out.println(5);}
}
interface Delegate1{
	void delegage1(Tiger t);
}
class Proxy1{
	void command1(Delegate1 d) {
		Tiger t = new Tiger();
		t.m1();
		d.delegage1(t);
		t.m5();		
	}
}
public class World {

	public static void main(String[] args) {
		Proxy1 proxy1 = new Proxy1();
		proxy1.command1(new Delegate1() {
			public void delegage1(Tiger t) {
				t.m2();
			}
		});
		System.out.println("=============================");
		proxy1.command1(new Delegate1() {
			public void delegage1(Tiger t) {
				t.m3();
			}
		});
		
		System.out.println("=============================");
		proxy1.command1(new Delegate1() {
			public void delegage1(Tiger t) {
				t.m4();
			}
		});
	}

}
