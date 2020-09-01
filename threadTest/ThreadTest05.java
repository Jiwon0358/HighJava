package threadTest;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		//이렇게하게되면 싱글 쓰레드
		
		//사용자로부터 데이터 입력받기 (입력을 하고 확인을 눌러야만 null값이 안나온다)
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		
		System.out.println("입력값 : " + str);
		
		for(int i=10; i>=0; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초동안 잠시 멈춘다.
			} catch (Exception e) {
			
			}
		}
		
		System.out.println("지정된 시간이 경과했습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}
