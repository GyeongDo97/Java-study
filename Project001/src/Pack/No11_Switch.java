package Pack;

public class No11_Switch
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
