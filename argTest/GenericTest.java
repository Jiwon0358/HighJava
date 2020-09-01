package argTest;

/*
 * 제네릭 클래스 만드는 방법
 * 형식) class 클래스명<제네릭타입글자>{
 * 		제네릭타입글자 변수명;   //변수 선언에 제네릭을 사용할 경우
 * 		...
 * 
 * 		제네릭타입글자 메서드명(파라미터변수들...){ //반환값이 있는 메서드에서 사용할 경우
 * 			...
 * 			return 값;	
 * 		}
 * 		
 * 		반환값타입 메서드명(제네릭타입글자 변수명, ...){//메서드의 파라미터변수에 사용할 경우
 * 			...
 * 		}
 * 
 * }
 * 
 */

//제네릭을 사용하지 않는 클래스 작성
class NongenericClass{
	private Object val;
	
	public void setVal(Object val){ 
		this.val = val;
	}
	public Object getVal(){
		return val;
	}
}

//제네릭을 사용하는 클래스 작성
class MyGeneric<T>{ //T : 객체를 생성할 때 타입을 정하겠다는 의미
	private T val;
	
	public void setVal(T val){ 
		this.val = val;
	}
	public T getVal(){
		return val;
	}
	
}

public class GenericTest {

	
	public static void main(String[] args) {
		NongenericClass ngc1 = new NongenericClass();
		ngc1.setVal("가나다라"); //자식에서 조상으로 형변환 할때는 생략가능하다.
		
		NongenericClass ngc2 = new NongenericClass();
		ngc2.setVal(123);
		
		String resultStr = (String)ngc1.getVal();//조상에서 자식으로 형변환 할때는 반드시 형변환을 해야한다.
		System.out.println("문자열 반환값 :" + resultStr);
		int resultInt = (int)ngc2.getVal();
		System.out.println("정수형 반환값 :" + resultInt);
		System.out.println();
		
//		int resultInt2 = (int)ngc1.getVal();
		//이렇게 오브젝트형을 자식으로 변환 할때 컴파일 상으로는 문제가 전혀 되지 않지만, 막상 실행을 해보면 문자열을 정수형으로 바꾸는거라
		//에러가 난다. 그래서 안에 들어 있는 값이 뭔지 몰라 나는 런타임에러를 보안하기 위해 제네릭을 사용한 클래스를 만들어 사용한다.
		
		System.out.println("----------------------------------");
		MyGeneric<String> mgc1 = new MyGeneric<>();
		mgc1.setVal("우리나라");
		
		MyGeneric<Integer> mgc2 = new MyGeneric<>();
		mgc2.setVal(1234);
		
		resultStr = mgc1.getVal();
		resultInt = mgc2.getVal();
		
		System.out.println("문자열 반환값 :" + resultStr);
		System.out.println("정수형 반환값 :" + resultInt);
		
//		resultInt2 = mgc1.getVal();
		//그래서 이렇게 리턴하는 값의 타입과 객체생성할때 입력해준 타입이 입력하지 않으면 컴파일 에러라고 표시해줘서 에러나는 것을 미연에 방지 할 수 있다.
		
		
	}

}
