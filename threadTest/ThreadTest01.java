package threadTest;

public class ThreadTest01 {

	public static void main(String[] args) {
		//싱글 쓰레드 프로그램
		//순서대로 작업을 한다. 두가지 작업을 한번에 못한다.
		
		for(int i = 1; i <= 200; i++){
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		
		for(int i = 1; i <= 200; i++){
			System.out.print("$");
		}
		
		
	}

}
