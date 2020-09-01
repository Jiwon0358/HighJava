package collectioneTest;

import java.util.LinkedList;

public class StackQueueTest {

	public static void main(String[] args) {
		/*
		   Stack ==> LIFO(후입선출)방식의 자료구조  
	 
		   │      │
		   │      │
		   └──────┘
		   Queue ==> FIFO(선입선출)방식의 자료구조
		   
		   │      │
		   │      │
		   
		   Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
		   LikedList => 삭제나 중간에 삽입할 때 빠르다.
		    
		 */
	//==================================================
		/*
		 Stack의 명령
		 1. 자료 입력 : push(추가할 데이터);
		 2. 자료 출력 : pop() ==> 자료를 꺼내온 후에 꺼내온 자려를 Stack에서 지운다.
		 			peek() ==> 삭제없이 자료를 꺼내온다. (보통 값을 사용하기 전 확인 하고 싶을 때 사용)
		 */
		
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack값: " + stack);
	
		System.out.println("꺼내온 값 :" + stack.pop()); //강감찬꺼내오고 삭제
		System.out.println("현재 stack값: " + stack); 
		
		System.out.println("꺼내온 값 :" + stack.pop()); //변학도꺼내오고 삭제
		System.out.println("현재 stack값: " + stack); 
		
		String temp = stack.peek();
		System.out.println("peek로 꺼내온 값 :" + stack.peek()); //삭제되지 않고 출력함 
		System.out.println("현재 stack값: " + stack); 
		
		stack.push("성춘향");
		System.out.println("추가한 후 stack값 :" + stack);
		
		System.out.println("꺼내온 값 :" + stack.pop()); //성춘향 꺼내오고 삭제
		System.out.println("현재 stack값: " + stack); 
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println();
		//----------------------------------------------------------
		/*
		 	Queue의 명령
		 	1. 자료 입력 : offer(추가할 데이터)
		 	2. 자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제
		 			   peek() ==> 삭제없이 자료 출력
		 */
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue값 : " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());//홍길동 꺼내오고 삭제
		System.out.println("현재 queue 값 :" + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue 값 :" + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll()); //일지매 꺼내오고 삭제
		System.out.println("현재 queue 값 :" + queue);
		
		System.out.println("peek로 꺼내온 값 :" + stack.peek()); //삭제없이 출력하고싶을 때
		System.out.println("현재 queue 값 :" + queue);
		
		
	}

}
