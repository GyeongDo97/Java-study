package Pack;

public class No11_Switch
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
