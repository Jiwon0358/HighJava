package argTest;

import java.util.Scanner;

public class ArgTest {

	//배열을 이용한 메서드
	public int sumArr(int[] data){
		int total = 0;
		for(int i = 0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}
	
	/*
	 * 가변형 인수(int...data) - 메서드의 매개변수의 개수가 호출될 때마다 다를 경우에 사용한다.
	 * 		 				- 이 가변형 인수는 메서드 내에서는 배열로 처리된다.
	 * 						- 가변형 인수는 하나의 메서드에 하나만 사용할 수 있다. 
	 * 						- 가변형 변수와 일반 변수를 같이 사용할 경우에는 가변형 변수를 제일 뒤에 배치해야 한다.(데이터 분배가 쉬워짐)
	 */
	
	//가변형 인수를 이용한 메서드
	public int sumArg( int...data){
		
		int total = 0;
		for(int i = 0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}
/*	이렇게 하나의 메서드에 가변형 인수 2개이상 쓰는 것은 불가능 하다.
	public int argTest( int...t, int...r){
		return 0;
	}
	*/
	
	//가변형 변수와 일반 변수를 같이 사용할 경우에는 가변형 변수를 제일 뒤에 배치해야 한다.
	//왜? (int...data, int n)으로 사용했을 때  메서드를 호출할때 (1,2,3,4)를 입력하면 1~4를 모두 가변형인수가 가져 갈 수 있다.
	//그래서 그렇게 쓰지 않도록 규칙으로 정해 놓음
	public void argTest(String name, int...data){
		
	}
	
	public static void main(String[] args) {
		ArgTest test = new ArgTest();
		
//		int[] nums = {1,2,3,4,5,6,7,8,9}; 선언과 초기화를 따로 하면 에러가 난다.
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9};//위의 경우에는 선언한 후에 초기화를 따로 해도 상관 없다.
		int result = test.sumArr(nums);
		
		System.out.println("result : " + result);
		
		//이렇게 해도 상관 없음.
		System.out.println(test.sumArr(new int[]{10,20,30,40}));
		
		System.out.println("===================================");
		System.out.println(test.sumArg(1,2,3,4,5,6,7,8,9));
		System.out.println(test.sumArg(10,20,30,40));
		//호출할때마다 매개변수 값이 달라져도 적용 가능.
		
		
		
		
		
	}

}
