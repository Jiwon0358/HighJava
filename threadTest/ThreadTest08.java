package threadTest;

public class ThreadTest08 {

	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();

		
		th1.setPriority(9);
		th2.setPriority(3);
		
		System.out.println("th1의 우선순위 : " + th1. getPriority());//. getPriority() : 우선순위구하는 메서드
		System.out.println("th2의 우선순위 : " + th2. getPriority());
		//우선순위가 같다 : 우선순위가 같으면 시간분배를 비슷하게 해준다.
		th1.start();
		
/*		th1.setPriority(9);
		th2.setPriority(3);*/
		
		th2.start();
	}

}
//대문자를 출력하는 쓰레드
class UpperThread extends Thread{
	@Override
	public void run() {
		for(char c='A'; c <= 'Z'; c++){
			System.out.println(c);
			for(int i = 1; i <=1000000000; i++){} //아무것도 안하는 반복문 - 시간 때우기용(쓰레드가 멈춘게 아님)
		}
	}
}

//소문자를 출력하는 쓰레드
class LowerThread extends Thread{
	@Override
	public void run() {
		for(char c='a'; c <= 'z'; c++){
			System.out.println(c);
			for(int i = 1; i <=1000000000; i++){} //아무것도 안하는 반복문 - 시간 때우기용(쓰레드가 멈춘게 아님)
		}
	}
}