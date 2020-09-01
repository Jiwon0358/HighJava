package threadTest;
//쓰레드에서 객체를 공동으로 사용하는 예제 

/*
 * 
 * 원주율을 계산만 하는 프로그램과 원주율을 출력만 하는 쓰레드가 있다.
 * 원주율을 저장하는 객체가 필요하다
 * 이 객체를 두쓰레드에서 공통으로 사용해소 지운다
 * 
 */


public class ThreadTest15 {
public static void main(String[] args) {
	//공통으로 사용할 객체 생성
	ShareData sd = new ShareData();
	
	//각각의 쓰레드 객체를 생성할때 공통으로 사용할 객체를 쓰레드에 주입한다.
	CalcPIThread calc = new CalcPIThread(sd);
	PrintPIThread print = new PrintPIThread(sd);

	calc.start();
	print.start();
	
	
	
}
}
//원주율을 관리하는 클래스 작성(공통으로 사용할 쓰레드)
class ShareData{
	
	public double result;//계산된 원주율을 저장할 변수
	public volatile boolean isOk; //계산이 완료되었는지 여부를 나타내는 변수(계산이 완료되면 true가된다)
	//	   volatitle = 이 키워드가 붙은 변수는 컴파일러의 최적화 대상에서 제외 된다. (무조건 캐시를 쓰지말고 ram에 있는 정보를 가지고 와서 사용해라)
	//					즉, 값이 변경되는 즉시 변수에 적용시킨다. 
	
}
//원주율을 계산만 하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		/*
		 * 원주율 = (1/1 - 1/3 + 1/5-1/7+1/9-....)*4;
		 		분모만 보면 1-3+5-7+9......
		 		2로 나누면  0 1 2 3 4....
		 			홀수 번째만 -가 된다.
		 *
		 */
		
		double sum = 0.0;
		for(int i=1; i<=1000000000; i+=2){//2씩 증가해서 1,3,5,7,9...되도록/ 반복하는 횟수가 많아질수록 정확도에 가까워진다. 
			if((i/2) %2 == 0){//짝수번째면 0
				sum += (1.0/i); //둘다 정수면 정수가 나오니까 실수로 바꿔주기위해 1.0이라고씀
				
			}else{
				sum -= (1.0/i);
			}
		}
		sd.result = sum * 4; //계산된 결과를 저장(계산 완료)
		sd.isOk = true;
		System.out.println("계산완료..");
		
		
	
	}
	
}

//원주율 계산이 완료되면 출력만 하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;

	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true){
			if(sd.isOk == true){
				break;
			}
		}
		System.out.println();
		System.out.println("결과 :" + sd.result);
		System.out.println("PI :" + Math.PI);
	}	
}