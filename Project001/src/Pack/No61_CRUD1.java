package Pack;
/*
import java.util.LinkedList;

//속도 <-> 메모리
//일반적인 경우 메모리를 절약하고 속도를 조금 떨어트려 사용한다.
//CRUD는 속도를 우선시하여 빠른 속도 선호.

//속도를 우선시 하다보니 CRUD 전체 중에 일부는 모자람
//그래서 자주사용하는 범위에 포함되어있는 것을 사용 

//Collection
//Link the list

public class No61_CRUD1
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
