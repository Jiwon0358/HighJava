package threadTest;

public class ThreadTest03 {

	public static void main(String[] args) {
		//쓰레드가 수행되는 시간 체크해보기
		/*Runnable r1 = new MyRun();
		Thread th2 = new Thread(r1);*/
		//두단개를 하나로 줄인것 
		Thread th = new Thread(new MyRunner());
		
		//1970년 1월 1일 0시0분0초(표준시간)로 부터 경과한 시간을 밀리 세컨드 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start(); //얘는 준비작업만 해주고 끝이라서 걸린 시간은 안나오고 계속 0초가 나온다.
		
		try {
			th.join(); //그래서 join메서드를 호출해서 현재 실행중인 쓰레드에서 대상이 되는 쓰레드(변수 th)가 종료될때까지 기다린다. 
		} catch (InterruptedException e) {
			
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
		
		
	}

}
class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		//정수형일때는 _로 자리수를 나타내도 상관없다.
		for(long i = 1L; i <=1_000_000_000L; i++){
			sum += i;
		}
		System.out.println("합계 :" + sum);
	}
}