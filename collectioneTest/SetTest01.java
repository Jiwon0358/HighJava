package collectioneTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest01 {
	/*
	 	Set의 특징(List와 비교)
	 1. List
	 	- 데이터의 순서(index)가 있다.
	 	- 중복되는 데이터를 저장할 수 있다.
	 2. Set
	 	- 데이터의 순서(index)가 없다.
	 	- 중복되는 데이터를 저장할 수 없다.
	 */
	public static void main(String[] args) {
		HashSet hs1 = new HashSet();
		
		//데이터 추가 : add()메서드 이용
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 개수 : "+hs1.size());
		System.out.println("Set 데이터 : "+ hs1);
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 :" + isAdd);
		System.out.println("Set 데이터 : "+ hs1);
		
		isAdd = hs1.add("CC");
		System.out.println("중복瑛?때 :" + isAdd);
		System.out.println("Set 데이터 : "+ hs1);
		
		//Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 자료를 삭제한 후 추가해주는 방법을 사용한다.
		//삭제하기 : remove(삭제할 자료) => 반환값 : 삭제성공(true), 삭제실패(false)
		//		  clear() =>전체 삭제
		
		
		//'FF'문자열을 'EE'문자열로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 Set :" + hs1);
		hs1.add("EE");
		System.out.println("Set 데이터 : "+hs1);
		
		hs1.clear();
		System.out.println("clear 후 set :" +hs1);
		
		HashSet<Integer> intSet = new HashSet<>();
		intSet.add(10);
		intSet.add(7);
		intSet.add(9);
		intSet.add(3);
		intSet.add(5);
		
		//Set의 모든 데이터의 합계 구하기
		/*
		 *  Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 *  그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해서 사용해야 한다. 
		 *  컬렉션 객체들은 모두 Iterator로 변환 가능하다
		 *  
		 *  -Set형의 데이터를 Iterator형 객체로 변환해 주는 메서드 => iterator()
		 */
		Iterator<Integer> it = intSet.iterator(); //Set데이터를 Iterator로 변환하기
		
		//Iterator의 hasNext()메서드 ==> Iterator의 데이터를 가리키는 포인터를 다음번째의 데이터 위치로 이동시킨 후 그자리에  데이터가 있으면 true,
		//			없으면 false. (rs.next() 처럼 다음행으로 넘어간다 생각하면됨)
		int sum = 0;
		while(it.hasNext()){ //포인터위치(끝을 가리킬때까지 반복)
			// Iterator의 next() =>포인터를 다음번째 위치로 이동한 후 그자리의 데이터를 반환한다
			int num = it.next();//포인터위치를 넘겨줌
			sum += num;
			
		}
		System.out.println("총합 : " + sum);
		
		
		//우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자
		//번호는 1부터 25까지 있고, 추첨할 인원은 3명이다.
		//당첨자를 출력해보자.
		
		int[] numArr = new int[3];
		
		
		for(int i = 0; i < numArr.length; i++){//집어 넣을 위치
			//최소값~최대값 사이의 난수 만들기
			//(int)(Math.random() * (최대값-최소값+1)+최소값);
			numArr[i] = (int)(Math.random() * (25-1+1)+1); //랜덤한 값을 for문 돌동안 계속 재생성
			for(int j = 0; j < i; j++){
				if(numArr[i] == numArr[j]){//같으면 그 값이 저장되지 않도록 i의 값을 빼서 전으로 돌아가서 다시 랜덤한 값을 부여 받음.
					i--;
					continue;
				}
			}
		}
		System.out.println(Arrays.toString(numArr));
		
		HashSet<Integer> numSet = new HashSet<>();
		
		while(numSet.size() < 3){
			numSet.add((int)(Math.random() * 25+1)); //set은 중복이 되지 않으니 중복 비교 필요 없음.
		}
		System.out.println("당첨자 번호 : " + numSet);
		
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(numSet); //numset에 있는 데이터를 리스트로 만듬
		
		System.out.println("List데이터 출력");
		for(int i = 0; i <testList.size(); i++){
			System.out.println(testList.get(i));
		}
		
		
	}

}
