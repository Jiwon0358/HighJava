package threadTest;

//데몬 쓰레드 연습 ==> 자동저장하는 쓰레드
public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSaveThread auto = new AutoSaveThread();
		//데몬 쓰레드로 설정하기 ==> 반드시 start()메서드를 호출하기 전에 설정해야한다.
		//메인 쓰레드가 종료되면 데몬쓰레드는 알아서 종료되도록함.
		auto.setDaemon(true);
		
		auto.start();
		
		try {
			//작업시간을 20초로 제한을 둠.
			for(int i = 1; i <=20; i++){
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
		
		}
		
		System.out.println("main 쓰레드 종료.");
	}

}

//자동 저장하는 쓰레드(3초에 한번씩 저장하는 쓰레드)
class AutoSaveThread extends Thread{
	
	//지금까지의 작업 내용을 저장하는 메서드
	public void save(){
		System.out.println("작업내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save(); //저장하기
		}
	
	}
}