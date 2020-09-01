package threadTest;

import javax.swing.JOptionPane;
/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 * 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력을 받는다.
 * 
 * 입력시간은 5초로 제한하고, 카운트 다운을 진행한다.
 * 5초안에 입력이 없으면 게임에 진 것으로 처리한다.
 * 
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 * 
 * 결과 예시)
 * 		-- 결 과 --
 * 	컴퓨터 : 가위
 * 	사용자 : 바위
 * 	결과 : 당신이 이겼습니다.
 */



public class ThreadTest07 {
	
	public static void main(String[] args) {
		
		Thread th1 = new CountDown();
		Thread th2 = new input();
		
		th1.start();
		th2.start();
		
		try {
			th2.join();
		} catch (InterruptedException e) {
		
		}
		
		String user = input.str;
		String random = new ThreadTest07().random();
		String result = null;
		if(user.equals(random)){
			result =" 비겼습니다.";
		}else if(user.equals("가위")){
			if(random.equals("바위")){
				result = "당신은 졌습니다.";
			}else{
				result = "당신이 이겼습니다.";
			}
		}else if(user.equals("바위")){
			if(random.equals("보")){
				result = "당신은 졌습니다.";
			}else{
				result = "당신이 이겼습니다.";
			}
		}else if(user.equals("보")){
			if(random.equals("가위")){
				result = "당신은 졌습니다.";
			}else{
				result = "당신이 이겼습니다.";
			}
		}
		System.out.println("==================");
		System.out.println("\t결  과");
		System.out.println("------------------");
		System.out.println("컴퓨터 : "+random);
		System.out.println("사용자 : "+user);
		System.out.println("------------------");
		System.out.println(result);
		System.out.println("==================");
		
		
		
	}
	//난수를 발생시켜 가위 바위 보 중 하나를 출력하는 메서드
	public String random(){
		String computer = null;
		int random = (int)Math.random()*3 +1;
		if(random == 1){
			computer = "가위";
		}else if(random == 2){
			computer ="바위";
		}else{
			computer = "보";
		}
		
		return computer;
	
	}
	
	
}
//카운트 다운 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {

	for(int i=5; i >= 1; i--){
		if(input.inputCheck){
			return;
		}
		
		System.out.println(i);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
	}System.out.println("입력시간을 초과하여 당신이 졌습니다.");
	System.exit(0);
	
	}
}

//입력받는 쓰레드
class input extends Thread{
	public static boolean inputCheck;
	public static String str = null;
	
	@Override
	public void run() {
		str = JOptionPane.showInputDialog("가위 바위 보 중 하나를 입력해주세요");
		if(!(str.equals("가위") || str.equals("바위") || str.equals("보"))){
			System.out.println("다른값을 입력하여 당신이 졌습니다.");
			System.exit(0);
		}
		inputCheck = true;
	}
}


