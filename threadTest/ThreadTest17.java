package threadTest;

//은행의 입출금 작업을 쓰레드로 처리하는 예제
//(synchronized를 이용한 동기화 처리 예제)


public class ThreadTest17 {
	
	private int balance; //잔액이 저장돨 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금을 처리하는 메서드
	public void deposit(int money){
		balance += money;
	}
	
	//출금을 처리하는 메서드
	//출금이 성공하면 true, 실패하면 false를 반환한다.
	//동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야한다.
	public synchronized boolean withdraw(int money){	//동기화 메서드 사용, 동기화 블록을 사용해도 상관 없다.
//		public boolean withdraw(int money){
		if(balance >= money){ //잔액이 출금할 금액보다 커야한다.
			for(int i = 0; i <= 1000000000; i++){ //시간 지연용, 아무 의미 없음
			}
			
			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance); //만약 balance가 아니라 getBalance()라면 getBalance메서드에 가서 동기화 처리를 해줘야함. 
			return true;
		}else{
			return false;
		}
	}





	public static void main(String[] args) {
		final ThreadTest17 acount =  new ThreadTest17();
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
