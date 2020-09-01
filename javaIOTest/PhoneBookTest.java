package javaIOTest;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
	/*
	 * 문제 ) 이름, 주소, 나이, 전화번호를 멤버변수로 갖는 Phone클래스를 만들고, 
	 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	 * 	
	 * 		-이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
	 * 		- 삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
	 * 		- (Map의 구조는 key값으로 그사람의 '이름'을 사용하고,
	 * 					value값으로는 'Phone클래스의 인스턴스'로 한다.)
	 * 
	 * 		- 추가 조건)
	 * 			1) '6.전화번호저장' 메뉴를 추가하고 구현한다.
	 * 				(저장파일명 : 'phoneData.dat'로 한다.)
	 * 			2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 셋팅한다.
	 * 			3) 프로그램을 종료할 때 Map의 데이터가 변경되었거나 추가 또는 삭제 되면 새로 저장한 수 종료되도록한다.
	 * 
	 * 실행예시)
	 *  다음 메뉴를 선택하세요.
	 *  1.전화번호 등록
	 *  2.전화번호 수정
	 *  3.전화번호 삭제
	 *  4.전화번호 검색
	 *  5.전화번호 전체 출력
	 *  6.전화번호 저장
	 *  0.프로그램 종료
	 *  ---------------
	 *  번호 입력 : 1
	 *  
	 *  새롭게 등록한 전화번호 정보를 입력하세요
	 *  이름 : 홍길동
	 *  전화번호 : 010-1111-1111
	 *  나이 : 23
	 *  주소 : 대전시 서구 갈마동
	 *  
	 *  '홍길동' 전화 번호 입력완료!
	 *  
	 *  만약 이름을 입력할때 이미 등록된 사람이면
	 *  '홍길동'은 이미 등록된 사람입니다.
	 *  
	 *  
	 *  번호 입력 : 5
	 *  ========================================
	 *  번호		이름			전화번호		나이		주소
	 *  ----------------------------------------
	 *   1		홍길동	010-1111-1111 	23 	 대전시 서구 갈마동
	 *  =======================================
	 *  출력완료...
	 */
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Phone> phoneList = new HashMap<>();
	
	public static void main(String[] args) {
		
	while(true){
		System.out.println("====================");
		System.out.println("\t메     뉴");
		System.out.println("--------------------");
		System.out.println("   1. 전화번호 등록");
		System.out.println("   2. 전화번호 수정");
		System.out.println("   3. 전화번호 삭제");
		System.out.println("   4. 전화번호 검색");
		System.out.println("   5. 전화번호 전체 출력");
		System.out.println("   6. 전화번호 저장");
		System.out.println("   0. 프로그램 종료");
		System.out.println("====================");
		System.out.print("번호 입력 :");
		int input = Integer.parseInt(sc.nextLine());
		
		switch(input){
		case 1 :
			insertForm();
			break;
		case 2:
			updateForm();
			break;
		case 3:
			deleteForm();
			break;
		case 4:
			searchForm();
			break;
		case 5:
			listOutPut();
			break;
		case 0:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}
		
		
		
		
		
	}

	private static void listOutPut() {
		System.out.println("\n\n\n");
		System.out.println("===================================================");
		System.out.println("번호\t이름\t  전화번호\t  나이\t 주소");
		System.out.println("---------------------------------------------------");
		int count = 1;
		for(String userName : phoneList.keySet()){
			Phone user = phoneList.get(userName);
			System.out.println(count + "\t" + user.getName()+ "\t" + user.getHp()+ "\t" + user.getAge()+ "\t" + user.getAddress());
			count++;
		}
		System.out.println("===================================================");
		System.out.println("\n\n\n");
	
	
}

	private static void searchForm() {
		System.out.println("\n\n\n");
		System.out.println("====================");
		System.out.println("검색 할 사람의 이름을 입력하세요");
		System.out.println("====================");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(phoneList.containsKey(name)){
		System.out.println("\n\n\n");
		System.out.println("=====================");
		System.out.println("이름 : " + phoneList.get(name).getName());
		System.out.println("전화번호 : " + phoneList.get(name).getHp());
		System.out.println("나이 : " + phoneList.get(name).getAge());
		System.out.println("주소 : " + phoneList.get(name).getAddress());
		System.out.println("=====================");
		}else{
			System.out.println();
			System.out.println(name + "은 등록되지 않은 사람입니다.");
			System.out.println();
		}
		
	}

	private static void deleteForm() {
		System.out.println("\n\n\n");
		System.out.println("====================");
		System.out.println("삭제 할 사람의 이름을 입력하세요");
		System.out.println("====================");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(phoneList.containsKey(name)){
			System.out.println("\n\n\n");
			System.out.println("=====================");
			System.out.println("이름 : " + phoneList.get(name).getName());
			System.out.println("전화번호 : " + phoneList.get(name).getHp());
			System.out.println("나이 : " + phoneList.get(name).getAge());
			System.out.println("주소 : " + phoneList.get(name).getAddress());
			System.out.println("=====================");
			System.out.println("정말로 삭제하시겠습니까?");
			System.out.println("1. 예\t2.아니오");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 1){
				phoneList.remove(name);
				System.out.println();
				System.out.println("삭제가 완료 되었습니다.");
				System.out.println();
			}else{
				System.out.println();
				System.out.println("삭제가 취소 되었습니다.");
				System.out.println();
			}
			
		}
	
}

	private static void updateForm() {
		System.out.println("\n\n\n");
		System.out.println("====================");
		System.out.println("수정 할 정보를 입력하세요");
		System.out.println("--------------------");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(phoneList.containsKey(name)){
			System.out.print("전화번호 : ");
			String hp = sc.nextLine();
			System.out.print("나이 : ");
			String age = sc.nextLine();
			System.out.print("주소 : ");
			String address = sc.nextLine();
			System.out.println("====================");
			phoneList.put(name, new Phone(name, hp, age, address));
			System.out.println();
			System.out.println(name + " 정보 수정이 완료되었습니다.");
			System.out.println();
			
		}else{
			System.out.println();
			System.out.println(name +"은 등록된 사람이 아니라 수정이 불가합니다.");
			System.out.println();
		}
}

	private static void insertForm() {
		System.out.println("\n\n\n");
		System.out.println("====================");
		System.out.println("새로 등록할 정보를 입력하세요");
		System.out.println("--------------------");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(phoneList.containsKey(name)){
			System.out.println();
			System.out.println(name + "은 이미 등록된 사람입니다.");
			System.out.println();
		}else{
		System.out.print("전화번호 : ");
		String hp = sc.nextLine();
		System.out.print("나이 : ");
		String age = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.println("====================");
		System.out.println();
		System.out.println(name + " 전화번호 등록 완료!");
		System.out.println();
		phoneList.put(name, new Phone(name, hp, age, address));
	}

}
}
class Phone{
	private String name;
	private String hp;
	private String age;
	private String address;
	
	public Phone(String name, String hp, String age, String address) {
		super();
		this.name = name;
		this.hp = hp;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
		
}
