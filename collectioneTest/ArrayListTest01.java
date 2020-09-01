package collectioneTest;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// 객체 생성
		ArrayList list1 = new ArrayList();
		
		//데이터 추가 : add(추가할 데이터) ==> 반환값 : 성공(true), 실패(false)
		list1.add("aaaaa");
		list1.add(123);
		list1.add(new Integer(123));
		list1.add('a');
		list1.add(true);
		list1.add(3.14f);
		
		System.out.println("size :" + list1.size());
		
		System.out.println("현재 list :" + list1);
		
		//데이터추가2 : add(index, 추가할 데이터)
		// ==> index번째에 '추가할 데이터'를 끼워 넣는다.
		list1.add(3, "ccc");
		
		System.out.println("List : " + list1);
		
		//데이터 변경 : set(index, 새로운 데이터)
		//    ==>index번째의 데이터를 새로운데이터 로 Ь杵눼?
		//	 ==> 반환값: 원래의 데이터 
		
		
		String temp =(String)list1.set(0, "zzzzz");
		System.out.println("List :" + list1);
		System.out.println("원래의 데이터 " +temp);
		
		//데이터 삭제 : remove(index)
		//    ==>index번째의 데이터를 삭제한다
		//	 ==> 반환값:삭제된 데이터 
		temp = (String)list1.remove(0);
		System.out.println("삭제 후 리스트 : " +list1 );
		System.out.println("삭제 된 데이터 ");
		
		//데이터 삭제2 : remove,(삭제할 데이터)
		//삭제할 데이터를 찾아서 삭제
		//삭제할 데이터가 여러개면 앞에서부터 삭제된다.
		//삭제할 데이터가 정수형이거나 char형 일 경우에는 반드시 격체로 변환해서 사용하여야한다
		// 반환값 : 삭제성공(true) 삭제실패(false)
		list1.remove( "cc");
		System.out.println("삭제 후 list :" + list1);
		
		//111데이터 삭제하기
		//list1.remove(111); //인덱스 번호로 들어간다 
		list1.remove(new Integer(111));
		
		System.out.println(list1);
		
		//'a'데이터 삭제하기
		list1.remove(new Character('a'));
		System.out.println(list1);
		
		//전체삭제 : clear();
		list1.clear();
		System.out.println("size :"+list1.size());
		System.out.println("clear 후 lit : " + list1);
		
		list1.add("AAAAA");
		list1.add("BBBBB");
		list1.add("CCCCC");
		list1.add("DDDDD");
		
		String data = (String)list1.get(1);
		System.out.println("1번째 데이터 :" +data);
		
		//======================================================
		/*
		 * 제네릭 타입(Generic Type) ==> 객체를 선언할 때 <> 안에 그 Collection이 사용할 데이터의 타입을
		 * 							정해주는 것을 말한다. 이런식으로 선언하게 되면 그 데이터 타입 이외의 다른 데이터는 자정할 수 없다.
		 * 							그리고, 제네릭으로 선언될 수 있는 데이터 타입은 클래스형 이어야한다.
		 * 							(ex : int = integer, boolean = Boolean, char = Character)
		 * 
		 *  제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		ArrayList<String> list2 =  new ArrayList<>(); //String만 저장할 수 있는 List
		
		list2.add("안녕하세요");
		//list2.add(123); //오류 : 다른 타입의 데이터를 저장할 수 없다.
		String temp2 = list2.get(0); 
		System.out.println("꺼내온 데이터 : " + temp2);
		System.out.println();
		
		list2.clear();
		//======================================================
		
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		list2.add("FFFF");
		
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("BBBB");
		list3.add("CCCC");
		list3.add("EEEE");
		
		System.out.println("List2 :" + list2);
		System.out.println("list3 :" + list3);
		
		//데이터 삭제 : removeAll(Collection객체)
		//	==>전체 데이터 중  'Collection 객체'가 가지고 있는 데이터 전체를 삭제한다.
		list2.removeAll(list3);
		System.out.println("삭제 후 list2 = " + list2);
		System.out.println();
		
		list2.clear();
		list2.add("AA");
		list2.add("BB");
		list2.add("CC");
		list2.add("DD");
		list2.add("EE");
		list2.add("FF");
		
		
		// list의 데이터를 순서대로 차례로 가져와 사용할 경우에는 반복문을 사용한다.
		System.out.println("=============================");
		for(int i = 0; i < list2.size(); i++){
			System.out.println(i +"번째 자료: " + list2.get(i));
		}
		System.out.println("=============================");
		
		//향상된 for문 사용
		for(String str : list2){
			System.out.println(str);
		}
		
		
		//데이터가 있는지 여부 검사 : contains(검색할 데이터)
		//                   ==> 검색할 데이터 가 있으면 true, 없으면 false 반환
		System.out.println("DD값 : " + list2.contains("DD"));
		System.out.println("KK값 : " + list2.contains("KK"));
		
		
		//검색할 데이터의 위치 구하기 : indexOf(검색할 데이터)
		//   ==> 리스트에 '검색할 데이터'가 있으면 '검색할 데이터'가 있는 index값을 반환하고 없으면 -1을 반환한다.
		System.out.println("DD의 위치값 :" + list2.indexOf("DD"));
		System.out.println("KK의 위치값 :" + list2.indexOf("KK"));
		
		
		
		//List의 데이터를 배열로 변환하기
		//방법1) toArray() ==> List안의 데이터를 Object형 배열로 변환해서 반환한다.
		Object[] objArr = list2.toArray();
		System.out.println("배열의 개수 :" + objArr.length);
		for(int i = 0; i < objArr.length; i++){
			String test = (String)objArr[i];
			System.out.println(i+"번째 자료 :"+objArr[i]);
		}
		System.out.println("===================================");
		
		//방법2) toArray(new 제네릭타입자료형[0]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		String[] strArr = list2.toArray(new String[0]);
		for(String str : strArr){
			System.out.println(str);
		}
		
		
	}

}
