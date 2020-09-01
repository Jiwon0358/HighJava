package threadTest;

/*
 * wait(), notify()메서드를 이용하여 두 쓰레드가 번갈아 한번씩 실행되는 예제
 * 
 * wait(), notify(), notifyAll()메서드는 동기화 영역에서만 사용 가능하다.
 */



public class ThreadTest20 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}

}

//공통으로 사용할 클래스 작성
class WorkObject{
	public synchronized void test1(){
		System.out.println("test1()메서드 실행 중");
		
		notify(); //wait()가 앞에 있으면 다 잠들어 버려서 깨우는 메서드인 notify()가 먼저 와야한다.
		
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void test2(){
		System.out.println("++++++ test2()메서드 실행중 ++++++");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
		}
	
	}
	
}

//WorkObject의 test1() 메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){ //10번만 호출하도록
			workObj.test1();
		}
		
		synchronized (workObj) { //마지막에 깨워줄 사람이 없어서 멈춰있기 때문에 상대방을 깨워주는 역할을 해줘야함.
			workObj.notify();
		}
		
	}
	
}

//WorkObject의 test2() 메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){ //10번만 호출하도록
			workObj.test2();
		}synchronized (workObj) { //마지막에 깨워줄 사람이 없어서 상대방을 깨워주는 역할을 해줘야함.
			workObj.notify();
		}
	}
	
}



