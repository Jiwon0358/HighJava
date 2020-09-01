package threadTest;
/*
 * Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
 * 이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어 나중에 실행되는 프로그램에
 * 영향을 줄 수 있다. 그래서 stop()메서드는 비추천으로 되어있다.
 */
public class ThreadTest14 {

	public static void main(String[] args) {
/*		ThreadStopTest1 th1 = new ThreadStopTest1();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		th1.stop(); //가운데에 선이 그어져있는건 사용하지마라 라는 의미.(앞으로 없어질 가능성이 있음) 자원정리등을 하지못하고 비정상적으로 프로그램이 종료되어, 교착상태에 빠질 위험 있음.
		th1.setStop(true); //안전하게 자원정리까지 완료 한 후 종료한다.
*/	
		
		
		//interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		th2.interrupt();
	
	
	}

}

//쓰레드를 멈추게하는 연습용 쓰레드
class ThreadStopTest1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행 중...");
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	}
	
}


//interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 연습용 쓰레드
class ThreadStopTest2 extends Thread{
	@Override
	public void run() {
		
/*		//방법1 => interrupt()메서드와 sleep()메서드를 이용하는 방법
		try {
			while(true){
				System.out.println("쓰레드 실행중..");
				Thread.sleep(1); //굉장히 작은 시간이지만 잠깐 잠깐 멈추긴함 
			}
		} catch (InterruptedException e) {
		
		}System.out.println("자원 정리중..");
		System.out.println("쓰레드 종료..");*/
		
		//방법2
		while(true){
			System.out.println("쓰레드 실행중..");
			
			//interrupt()메서드가 호출되었는지 여부를 검사한다.
			
			//검사방법1 ==> 인스턴스메서드인 isInterrupted()메서드를 이용해서 검사한다. (인스턴스)
			//			isInterrupted()메서드는 interrupt()메서드가 호출되면 true를 반환한다.
/*			if(this.isInterrupted()){
				break;
				
			}*/
			
			//인스턴스냐 static이냐 그 차이로 is와 in으로 나눔 
			
			
			//검사방법2==> Thread의 정적 메서드인 interrupted()메서드를 이용해서 검사한다. (static)
			//			interrupt()메서드가 호출되면 true를 반환한다.
			if(Thread.interrupted()){
				break;
			}
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	
	}
	

}


















