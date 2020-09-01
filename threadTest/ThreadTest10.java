package threadTest;

//쓰레드의 상태를 출력하는 프로그램
public class ThreadTest10 {

	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		
		th.start();
	}

}

//쓰레드의 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	
	@Override
	public void run() {
		for(long i=1L; i<=20000000000L; i++); //시간지연용
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		
		}
		for(long i=1L; i<=20000000000L; i++); //시간지연용
	}
}

//검사대상 쓰레드의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	public StatePrintThread(TargetThread target){
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true){
			//쓰레드의 상태값 구하기
			Thread.State state = target.getState(); //현재 상태를 보여줌
			System.out.println("TargetThread의 상태값 : " + state);
			
			if(state == Thread.State.NEW){ //쓰레드의 상태가 NEW상태이면
				target.start();
			}
			
			if(state == Thread.State.TERMINATED){//타겟쓰레드의 상태가 소멸상태면 현재 쓰레드도 빠져나가도록
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
		
		}
	}
}