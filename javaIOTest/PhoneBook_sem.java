package javaIOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_sem {
	private Map<String, Phone> phoneBookMap;
	private Scanner scan;
	private String fileName = "phoneData.dat"; //사용할 파일명이 저장될 변수 선언 및 초기화
	private boolean dataChange = false; //데이터가 변경돠었는지 여부를 나타내는변수, 데이터가 변경되면 true가 된다.
	/*
	 * Scanner 의 특징
	 * 
	 * next(), nextInt(), nextDouble(),....
	 * 		==>사이띄기, Tab키, Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다.
	 * 		ex) 11 22 가운데 띄어쓰기를 해도 데이터 2개로 인식함.
	 * 
	 * nextLine()
	 * 		==>한 줄 단위로 입력된 자료를 읽어간다. 즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어간다.
	 * 		ex) 11 22 가운데 띄어쓰기를 해도 하나의 데이터로 인식함.
	 * 
	 * Scanner는 사용자가 입력한 정보를 입력버퍼에 저장한 후 입력버퍼에서 차례로 꺼내와서 처리한다.
	 * 즉, 입력 버퍼에 데이터가 남아있으면 새로 입력 받는 것이 아닌 데이터를 다 쓴 후에 새로 입력 받는다. 그래서 일종의 버그 같은 게 일어나는 것.
	 * 
	 * 또한, nextLine전에 nextInt같은 입력이 있다면 nextLine전에 scan.nextLine()을 한번 써줘서 
	 * 입력 버퍼를 비워 주거나 Integer.parseInt(scan.nextLine())로 만들어 사용한다. 
	 */
	
	
	
	public PhoneBook_sem(){
		//프로그램이 시작되기전 셋팅!(생성자에서 이렇게 초기값을 만들어준다)
		phoneBookMap = load(); //파일 내용을 읽어와 Map에 셋팅
		
		if(phoneBookMap == null){ //파일이 없거나 잘못되었을 때
			phoneBookMap = new HashMap<>();
		}
		
		scan = new Scanner(System.in);
		
	}
	
	


	public static void main(String[] args) {
		new PhoneBook_sem().Start();
	}
	
	
	
	
	
	private void Start(){
		
		while(true){
			System.out.println("===========================");
			System.out.println("     전 화 번 호 관 리 프 로 그 램");
			int choice = displayMenu(); //메뉴 출력 및 번호 선택
			
			switch(choice){
			case 1 : insert(); //등록
				break;
			case 2 : update();//수정
				break;
			case 3 : delete(); //삭제
				break;
			case 4 : search();//검색
				break;
			case 5 : displayAll(); //전체 출력
				break;
			case 6 : save();
				break;
			case 0 : //프로그램 종료
				if(dataChange){ //데이터가 변경되었으면
					System.out.println("변경된 내용을 저장합니다.");
					save();
				}
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default : System.out.println("번호를 잘못 입력했습니다.");
			}
		}
	}
	//전화번호 정보가 저장된 파일을 읽어오는 메서드
	private Map<String, Phone> load(){
		HashMap<String, Phone> loadMap = null; //읽어온 Map객체가 저장될 변수 선언
		
		File file = new File("d:/d_other/" + fileName);
		
		if(!file.exists()){ //저장된 파일이 없으면?
			System.out.println("====================");
			System.out.println("등록된 정보가 하나도 없습니다.");
			System.out.println("====================");
			
			return null;
		}
		
		//저장된 파일이 있으면?
		ObjectInputStream oin = null; //읽어올 스트림 객체 변수 선언
		
		try {
			//입력용 스트림 객체 생성
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			//파일 내용을 읽어와 Map객체 변수에 저장한다.
			loadMap = (HashMap<String, Phone>)oin.readObject();
			
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		} finally{
			//사용한 스트림 닫기
			try {oin.close();} catch (IOException e2) { }
		}
		
		return loadMap;
		
	}
	
	
	
	
	
	
	
	//전화전보 정보를 파일로 저장하는 메서드
	private void save() {
		ObjectOutputStream oout = null; //객체를 저장할 스트림 객체 변수 선언 
		try {
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/d_other/PhoneBook/" + fileName)));
			
			//Map객체를 파일로 저장한다.
			oout.writeObject(phoneBookMap);
			
			System.out.println("저장이 완료 되었습니다.");
			
			dataChange = false;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//사용했던 스트림 객체 닫기
			try {oout.close();	} catch (IOException e2) {	}
		}
		
		
	}




	//메뉴를 출력하고 작업번호를 입력받아 반환 하는 메서드
	private int displayMenu(){
		System.out.println("==========================");
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("--------------------------");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체출력");
		System.out.println("6.전화번호 저장");
		System.out.println("0.프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		return num;
	}
	//전화번호 등록 메서드(이미 등록된 사람은 등록되지 않는다.)
	private void insert(){
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 :");
		String name = scan.nextLine();
		//입력한  사람의 이름이 이미 등록되었는지 여부 검사
		if(phoneBookMap.containsKey(name)){
			System.out.println(name +"님은 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("전화번호 :");
		String hp = scan.nextLine(); //next()는 띄어쓰기를 안한 문자열, nextLine()은 띄어쓰기를 한 문자열
		System.out.print("나이 :");
		String age = scan.nextLine();
		System.out.print("주소 :");
		String address = scan.nextLine();
		
		phoneBookMap.put(name, new Phone(name, hp, age, address));
		
		dataChange = true;
		
		System.out.println(name+"님은 정상적으로 등록 되었습니다.");
	}
	//전화번호 전체 출력 메서드
	private void displayAll(){
		System.out.println("==============================================");
		System.out.println("번호\t이름\t전화번호\t나이\t주소");
		System.out.println("----------------------------------------------");
		if(phoneBookMap.size() == 0){
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		}else{
			int cnt = 0; //맨 앞에 번호를 출력할 변수 선언
			Iterator<String> keyIt = phoneBookMap.keySet().iterator();
			while(keyIt.hasNext()){
				cnt++;
				String key = keyIt.next(); //key값 구하기
				Phone p = phoneBookMap.get(key); //key값에 해당하는 Phone객체 구하기
				System.out.println(cnt + "\t" + p.getName()+ "\t" + p.getHp()+ "\t" + p.getAge()+ "\t" + p.getAddress());
			}
			
		}
		System.out.println("==============================================");
	}
	
	//전화번호 수정 메서드
	private void update(){
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.print("이름 :");
		String name = scan.nextLine();
		
		//입력한  사람의 이름이 등록되어 있지 않으면 수정작업을 진행할 수 없다.
		if(!phoneBookMap.containsKey(name)){
			System.out.println(name +"님은 등록되지 않은 사람입니다.");
			return;
		}
		System.out.print("새로운 전화번호 :");
		String hp = scan.nextLine();
		System.out.print("새로운 나이 :");
		String age = scan.nextLine();
		System.out.print("새로운 주소 :");
		String address = scan.nextLine();
		
		phoneBookMap.put(name, new Phone(name, hp, age, address));
		
		dataChange = true;
		
		System.out.println(name+"님의 정보가 정상적으로 수정 되었습니다.");
		

	}
	//전화번호 삭제 메서드
	private void delete(){
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.print("이름 :");
		String name = scan.nextLine();
		
		//입력한  사람의 이름이 등록되어 있지 않으면 수정작업을 진행할 수 없다.
		if(!phoneBookMap.containsKey(name)){
			System.out.println(name +"님은 등록되지 않은 사람입니다.");
			return;
		}
		phoneBookMap.remove(name);
		
		dataChange = true;
		System.out.println(name+"님의 정보가 정상적으로 삭제 되었습니다.");
	}
	
	//전화번호 검색 메서드
	private void search(){
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.print("이름 :");
		String name = scan.nextLine();
		if(!phoneBookMap.containsKey(name)){
			System.out.println(name +"님은 등록되지 않은 사람입니다.");
			return;
		}
		System.out.println("==================================");
		System.out.println("이름 : ");
		Phone p = phoneBookMap.get(name);
		System.out.println("이름 :" + p.getName());
		System.out.println("전화번호 :" + p.getHp());
		System.out.println("나이 :" + p.getAge());
		System.out.println("주소 :" + p.getAddress());
		System.out.println("==================================");
		
	}

}
