package collectioneTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hotel_sem {
	private Map<Integer, Room_sem> hotelMap;
	private Scanner sc;
	
	
	public Hotel_sem() {
		hotelMap = new HashMap<Integer, Room_sem>();
		sc = new Scanner(System.in);
		
		//객실 초기화
		for(int i = 2; i <=4; i++){
			String roomType = null;
			switch(i){
			case 2 : roomType = "싱글룸"; break;
			case 3 : roomType = "더블룸"; break;
			case 4 : roomType = "스위트룸"; break;
			
			}
			for(int j = 1; j <=9; j++){
				int roomnum = i * 100+j;
				Room_sem room = new Room_sem(roomnum, roomType);
				hotelMap.put(roomnum, room);
			}
		}
			
		}



	public static void main(String[] args) {
		new Hotel_sem().hotelStart();
	}
	
	//객실 상태를 출력하는 메서드
	private void nowRoomList() {
		System.out.println();
		
		//방번호 순서대로 출력하기 위해 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		List<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());
		Collections.sort(roomNumList); //방번호를 오름 차순으로 정렬한다.
		
		System.out.println("\n\n\n");
		System.out.println("-----------------*------------------");
		System.out.println("\t현 재 객 실 상 태");
		System.out.println("-----------------*------------------");
		System.out.println("방 번호\t방 종 류\t투숙객 이름");
		System.out.println("------------------------------------");
		//List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 해당하는 Room객체를 구해서 출력한다.
		for(int roomNum : roomNumList){
			Room_sem room = hotelMap.get(roomNum);
			System.out.print(room.getRoomNum() + "\t"+ room.getRoomType() + "\t");
			String name = null;
			if(room.getUsernm() != null){ //투숙객이 있으면
				name = room.getUsernm(); //투숙객 이름으로 출력
				room.setUsernm(name);
				System.out.println(room.getUsernm());
			}else{
				name = "-";
				room.setUsernm(name);
				System.out.println(room.getUsernm());
			}
		}
		System.out.println("------------------------------------");
		
	}



	private void chechOut() {
		System.out.println("\n\n\n");
		System.out.println("-----------------*------------------");
		System.out.println("\t\t체  크  아  웃");
		System.out.println("-----------------*------------------");
		System.out.println();
		System.out.println("체크아웃 할 방 번호를 입력해주세요.");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.print("방번호 입력 : ");
		int roomnum = Integer.parseInt(sc.nextLine());
		if(!hotelMap.containsKey(roomnum)){
			System.out.println(roomnum + "호 객실은 존재하지 않습니다.");
			return;
		}
		if(hotelMap.get(roomnum).getUsernm() == null){
			System.out.println(roomnum + "호 객실에는 체크인한 사람이 없습니다.");
			return;
		}
		String name = hotelMap.get(roomnum).getUsernm(); //현재 투숙객 이름 구하기
		
		hotelMap.get(roomnum).setUsernm(null); //투숙객 이름을 null로 변경
		
		System.out.println(roomnum + "호 객실의" + name + "님 체크아웃을 완료했습니다.");
	}



	private void checkIn() {
		
		System.out.println("\n\n\n");
		System.out.println("-----------------*------------------");
		System.out.println("\t\t체  크  인");
		System.out.println("-----------------*------------------");
		System.out.println(" \t* 201~209 : 싱 글 룸");
		System.out.println(" \t* 301~309 : 더 블 룸");
		System.out.println(" \t* 401~409 : 스 위 트 룸");
		System.out.println("------------------------------------");
		System.out.print("방 번호 입력 :");
		int roomnum = Integer.parseInt(sc.nextLine());
		
		//입렵한 방번호가 Map에 없으면 잘못 입력한 방번호이다.
		if(!hotelMap.containsKey(roomnum)){
			System.out.println(roomnum + "호 객실은 존재하지 않습니다.");
		}else if(hotelMap.get(roomnum).getUsernm() != null){ //해당 객실에 다른 투숙객이 있는지 검사
			System.out.println(roomnum + "호 객실에는 이미 손님이 있습니다.");
		}else{
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			//입력받은 투숙객 이름을 해당 객실의 투숙객 명단에 저장한다.
			hotelMap.get(roomnum).setUsernm(name);
			
			System.out.println(name +"씨가" + roomnum + "호 객실에 체크인 되었습니다.");
		}
		
	}


	private void hotelStart(){
		
		System.out.println("호텔문을 열었습니다. 어서 오십시오.");
		System.out.println();
		while(true){
		System.out.println("-----------------*------------------");
		System.out.println("\t어떤 업무를 하시겠습니까?");
		System.out.println("-----------------*------------------");
		System.out.println("\t1.체크인");
		System.out.println("\t2.체크아웃");
		System.out.println("\t3.객실상태");
		System.out.println("\t0.업무종료");
		System.out.println("------------------------------------");
		System.out.print("선택 : ");
		String input = sc.nextLine();
		switch(input){
		case "1" :
			checkIn();
			break;
		case "2" :
			chechOut();
			break;
		case "3" :
			nowRoomList();
			break;
		case "0" :
			System.out.println();
			System.out.println("업무를 종료합니다");
			System.exit(0);
		default :
			System.out.println("번호를 잘못 입력 했습니다. 다시 입력해주세요.");
	}
	

}
		
	}
}
class Room_sem{
	private int roomNum;
	private String roomType;
	private String usernm;
	
	public Room_sem(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	
}
	

