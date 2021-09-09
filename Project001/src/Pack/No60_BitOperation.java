package Pack;
/*
public class No60_BitOperation{
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
//				System.out.println(j + "¹øÀÌ ÄÑÁü");
//			}else {
//				System.out.println(j + "¹øÀÌ ²¨Áü");				
//			}
//		}
		
		System.out.println("");
		char c5 = 0x00dc;
		int mask = 0x80;
		String[] st = new String[] {"³ÃÀå°í", "ÄÄÇ»ÅÍ", "TV", "¼¼Å¹±â", "¹ä¼Ü", "Á¤¼ö±â", "È÷ÅÍ", "¿¡¾îÄÁ"};
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