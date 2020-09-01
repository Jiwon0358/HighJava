package collectioneTest;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		/*
		 * Properties객체는 Map객체보다 축소된 기능의 객체라고 할 수 있다.
		 * 
		 * Map은 key값과 value값에 모든 형태의 객체를 사용 할 수 있다.
		 * Properties는 key와 value에 String만 사용 할 수 있다.
		 * 
		 * Map은 put(), get()메서드를 사용하여 데이터를 입출력하지만,
		 * Properties는 setProperty(), getProperty()메서드를 통해서 데이터를 입출력한다.
		 * 
		 * Properties는 데이터를 파일로 입출력할 수있다.(나중에 DB연동할 때 사용 할 수있다)
		 * 
		 */
		
		Properties prop = new Properties();
		
		//데이터 입력
		prop.setProperty("name", "홍길동");
//		prop.setProperty("age", 23); 이렇게 int형을 넣으면 오류가 난다.
		prop.setProperty("age", "23");
		prop.setProperty("address", "대전");
		
		//데이터 출력
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age")); 
		//이렇게 int형이 필요할 때는 string을 int형으로 바꿔 사용한다.
		String address = prop.getProperty("address");
		
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + address);
		
		
		
	}

}
