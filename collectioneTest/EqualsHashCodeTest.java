package collectioneTest;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("이순신");
		p2.setId(1);
		p2.setName("홍길동");
		
		System.out.println(p1 == p2); //p1과 p2가 참조값이 달라서 false
		System.out.println(p1.equals(p2)); //equals는 참조값만 비교한다 그래서 안에 값이 같아도 false 
										   //그래서 equals를 재정의 해서 같은 데이터 값이 나올때 참이 나올 수 있도록 만들어줌 
		System.out.println("====================");
		
		Set<Person> testSet = new HashSet<>();
		//값을 비교할 때 hash code를 가지고 비교함.(참조값과 비슷)
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("Set 크기 :" + testSet.size()); 
		System.out.println("p1 : " + p1.hashCode()+"p2 : " + p2.hashCode());
		
		/*
		 * - equals() ==> 두 객체의 내용이 같은지 검사하는 연산자
		 * - hashCode() ==> 두 객체의 동일성을 검사하는 연산자 
		 * 
		 * - HashSet, HashTable, HashMap과 같이 Hash로 시작하는 컬렉션들은
		 * 	객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출하여 비교한다.
		 * 	그러므로, 객체가 같은지 여부를 결정하려면 hashCode()메서드를 재정의 해야한다.
		 * 
		 * - hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서
		 * 	같은 hashCode를 나타낼 수도 있다.(확률은 굉장히 낮음)
		 */
		
	}

}

class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/*
	//두 데이터 값이 같으면 참이 되도록 equals()메서드 재정의 (오버라이딩)
	@Override
	public boolean equals(Object obj) {//오버라이딩은 매개변수 같이 선언부는 못바꿈
		if(obj == null) //{}는 생략 가능하나 구분을 위해서 넣어주는 것임. 짧아서 딱봐도 보이면 생략 가능
			return false;
		//같은 유형의 클래스인지 검사
		if(this.getClass() != obj.getClass())
			return false;
		//참조값이 같은지 비교
		if(this == obj)
			return true;
		
		Person myPerson = (Person)obj;//매개변수 값을 현재 객체 유형으로 형변환 한다.
		
		if(this.name == null && myPerson.getName() != null){
			return false;
		}
		
		//id가 같고 name이 모두 null일 경우
		if(this.id == myPerson.getId() && this.name == myPerson.getName()){ 
			return true;
		}
		
		if(this.id == myPerson.getId() && this.name.equals(myPerson.getName())){
			return true;
		}
		
		return false;
		
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
}