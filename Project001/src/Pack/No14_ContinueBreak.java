package Pack;

public class No14_ContinueBreak
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
