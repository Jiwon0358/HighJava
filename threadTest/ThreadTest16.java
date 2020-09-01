package threadTest;

public class ThreadTest16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
	}
	
	//

}

class TestThread extends Thread{
	
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name); //쓰레드의 name설정 (Thread 안에 member변수에 name이 있다)
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <10; i++){
			sObj.add();
		}
	}
	
	
}


class ShareObject{ //공통으로 사용하는 쓰레드
	//공통으로 사용하기 때문에 lock(동기화)을 걸어주지 않으면 메서드를 다 끝내지 못하고 중간중간 쓰레드의 권한이 넘어가면 결과값이 이상하게 나온다.
	private int sum = 0;
	
/*	//동기화(lock) 처리하기 (먼저 사용하는 쓰레드가 끝날 때까지 다음 쓰레드가 기다린다.)
	public synchronized void add(){ //방법1 : 메서드 자체에 동시화 설정을한다.(synchronized 만 붙여주면됨)
		int n = sum;
		
		n += 10; //10 증가
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName() +" 합계 :" + sum);
	}						//currentThread() : 현재 실행되는 쓰레드*/
	
	public void add(){ 
		
		synchronized (this) { //동기화 방법2 : 동기화 블럭으로 설정한다.
			
		int n = sum;
		
		n += 10; //10 증가
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName() +" 합계 :" + sum);
		}
		
	}
	
	

	
	
}