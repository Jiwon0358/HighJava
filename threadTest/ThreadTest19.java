package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 * Vector, HashTable등의 예전부터 존재하던 Collection객체들은 내부에 동기화 처리가 되어 있다.
 * 그런데, 최근에 새로 구성된 Collection들은 동기화 처리가 되어 있지 않다.
 * 그래서, 동기화가 필요한 프로그램에서 이런 Collection객체들을 사용하려면 동기화 처리를 한 후에 사용해야 한다.
 * 
 * Vector : ArrayList와 비슷, 차이점은 내부에 동기화 처리가 되어 있음.
 * HashTable : map과 비슷, 차이점은 내부에 동기화 처리가 되어 있음.
 * 
 * 두개다 초기의 ArrayList, map이라서 동기화 처리는 되어 있지만, 실행 속도라던지 성능이 안좋아서 안쓰는 것을 권장한다.
 * 
 */


public class ThreadTest19 {
	private static Vector<Integer> vec = new Vector<>();
	
	//동기화 처리가 되어 있지 않은 List
	private static List<Integer> list = new ArrayList<>();
	
	//동기화 처리를 한 후의 List
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>()); //제너릭을 정확하게 써줘야한다.
	
	
	
	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i< 10000; i++){
//					vec.add(i); vector
//					list.add(i); 동기화 처리 하지 않은 List
					list2.add(i); //동기화 처리한 List
				}
			}
			
		};
		
		//------------------------------------------------
		Thread[] ths = new Thread[]{
				new Thread(r), new Thread(r),
				new Thread(r), new Thread(r),
				new Thread(r) 
		};
		
		for(Thread th : ths){
			th.start();
		}
		
		for(Thread th : ths){
			try {
				th.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
//		System.out.println("vec의 개수 : " + vec.size()); //50000개가 정상적으로 뜬다. 동기화 처리가 이미 되어 있기 때문.
//		System.out.println("list의 개수 : " + list.size()); //정상적으로 데이터가 저장되지 않는다. 동기화 처리가 안되어 있어서.
		System.out.println("list의 개수 : " + list2.size()); //동기화 처리한 List
		
	}

}
