package threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//은행의 입출금 작업을 쓰레드로 처리하는 예제
//(Lock객체를 이용한 동기화 처리 예제)

public class ThreadTest18 {
	
	private int balance; //잔액
	
	//Lock객체 생성 (Lock은 클레스가 아니라 인터페이스) => 되도록이면 private final로 만든다.
	private final Lock lock = new ReentrantLock();

	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	

	//입금하는 메서드
	public void deposit(int money){
		// Lock객체는 lock() 메서드로 락을 설정하고
		// 반드시 unlock()메서드로 락을 해제해 주어야 한다.
		
		lock.lock(); //락 설정 시작
		
		balance += money;
		
		lock.unlock(); //락 설정 해제.
	}
	
	
	
	
	//출금하는 메서드
	public boolean withdraw(int money){
		
		//만약 try-catch 블럭이 사용되는 부분에서 unlock()메서드를 호출할 때는 finally영역에서 호출하도록 한다.(무조건 반환해줘야하니까)
		
		boolean chk = false;
		
		try{
		lock.lock(); //lock설정 시작
		
		if(balance >= money){
			for(int i = 0; i <= 1000000000; i++){} //시간 지연용, 아무 의미 없음
			
			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance); //만약 balance가 아니라 getBalance()라면 getBalance메서드에 가서 동기화 처리를 해줘야함. 
			//return true;
			chk = true;
			
		}else{
			//return false;
			chk = false;
		}
		
		}catch(Exception e){
		
		}
		finally{ //무조건 반환해줘야하기 때문에
		lock.unlock(); //lock설정 해제
		}
		return chk;
		
	}


	
	
	public static void main(String[] args) {
		
		final ThreadTest18 acount =  new ThreadTest18();
		acount.setBalance(10000); //잔액을 10000원으로 설정한다.
		
		Runnable r1 = new Runnable() { //Runnable의 익명 구현체 안에서 지역변수를 사용하려면 변수앞에 final을 붙여줘야한다.
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); //6000원 출금
				System.out.println("쓰레드에서 result = " + result + ", balance = " + acount.getBalance());
				System.out.println();
			}
		};
		//익명 구현체 끝-------------------------------------------
		
		//두개의 쓰레드가 출금작업을 하려고 한다. (원래는 출금이 둘 쓰레드중 한번만 되서 4000원이 남아야 하지만 둘다 잔액을 빼가서 잔액이 -가 된다).
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1);
		
		th1.start();
		th2.start();

	}

}
