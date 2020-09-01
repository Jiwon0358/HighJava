package collectioneTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ListSortTest02 {

	public static void main(String[] args) {
		//내부정렬 기준
		
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"홍길동", "010-1111-1111"));
		memList.add(new Member(7,"이순신", "010-2222-1111"));
		memList.add(new Member(3,"성춘향", "010-3333-1111"));
		memList.add(new Member(8,"강감찬", "010-4444-1111"));
		memList.add(new Member(4,"일지매", "010-5555-1111"));
		memList.add(new Member(2,"변학도", "010-6666-1111"));
		memList.add(new Member(6,"장성보", "010-7777-1111"));
		
		System.out.println("정렬전..");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("-------------------");
		Collections.sort(memList);
		
		System.out.println("정렬후..");
		for(Member mem : memList){
			System.out.println(mem);
		}
		
		Collections.sort(memList, new DescTel());
		
		System.out.println("핸드폰 번호로 내림차순 정렬후..");
		for(Member mem : memList){
			System.out.println(mem);
		}
		
		
		
		
		
	}

}
//내부 정렬 기준을 포함할 클래스는 Comparable인터페이스를 구현해야한다.
// 	(Collection에 추가되는 데이터 자체에 정렬기준을 넣어주는 것을 말한다)
//Comparable을 구현하는 클래스에서는 compareTo()메서드를 재정의해야한다.
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	//alt+shift+s => vo객체 (생성자 등) 단축키
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}


	//Member의 이름을 오름차순으로 정렬하는 내부 정렬 기준 구현하기
/*	@Override
	public int compareTo(Member mem) {
		
		return this.name.compareTo(mem.getName());
	}*/
	
	
	//Member의 번호를 내림차순으로 정렬하는 내부 정렬 기준 구현하기
	@Override
	public int compareTo(Member mem) {
		/*if(this.num > mem.getNum()){
			return -1;
		}else if(this.num == mem.getNum()){
			return 0;
		}else{
			return 1;
		}
	}*/
	
		//비교방법2 ==> Wrapper클래스를 이용하는 방법
		return new Integer(this.num).compareTo(mem.getNum()) * -1;
		//compareTo는 객체만 비교 가능.
	}
	
	
}


//전화번호를 내림차순으로 정렬할 수 있는 외부 정렬 기준을 만들고 정렬한 결과를 출력하시오.
 class DescTel implements Comparator<Member>{
	 
	@Override
	public int compare(Member m1, Member m2) {
		/*
		if(m1.getTel().compareTo(m2.getTel()) < 0){
			return 1;
		}else if(m1.getTel().compareTo(m2.getTel()) == 0){
			return 0;
		}else{
			return -1;
		}*/
		
		return m1.getTel().compareTo(m2.getTel()) * -1;
	}
	
	 
 }
 
 /*
  * 내부정렬과 외부정렬
  * 1. 가장 많이 하는 정렬을 내부정렬로 놓고(내부정렬은 1개만 지정가능), 추가로 정렬을 추가하고 싶을 때 외부정렬을 사용한다.
  * 2. String은 직접만든 객체가 아니라 내부를 건들 수 없고, 내부에는 이미 오름차순으로 지정되어 있다. 그래서 내림차순 정렬을 하고 싶을땐
  *    외부정렬을 사용하여 내림차순정렬을 해준다.
  * 3. Member 같이 직접만든 객체는 내부에서도 정렬이 가능하지만, 이미 내부에 번호로 내림차순 정렬하는 것을 만들어 놓았으니, 외부정렬로 
  * 	핸드폰 번호로 내림차순하는 정렬을 만들어주는 것이다.
  */








