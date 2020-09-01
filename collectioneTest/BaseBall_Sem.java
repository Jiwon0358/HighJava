package collectioneTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBall_Sem {
	
	ArrayList<Integer> numList;
	ArrayList<Integer> userList;
	int Strike;
	int Ball;
	
	Scanner sc = new Scanner(System.in);
	
	public void gameStart(){
		System.out.println("숫자 야구 게임을 시작합니다 \n\n");
		getNum(); //난수만드는 메서드 호출
		
		int cnt = 0; //몇번만에 맞는지를 저장하는 변수
		
		do{
			cnt++;
			//사용자 입력 메서드 호출
			inputNum();
			
			//볼카운트 구하는 메서드 호출
			ballCount();
			
		}while(Strike != 3); //3 스트라이크가 될 때까지 반복
		
		System.out.println();
		System.out.println("축하합니다! 당신은" +  cnt + "번만에 맞췄습니다.");
	}
	
	public void inputNum(){
		int n1, n2, n3;
		
		do{
		System.out.print("숫자입력 : ");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		
		if(n1==n2|| n2==n3|| n3==n1){
			System.out.println("중복되는 숫자는 입력할 수 없습니다. \n다시입력해주세요");
			}
		}while(n1==n2|| n2==n3|| n3==n1);
		
		
		//입력한 값을 리스트에 저장한다.
		userList = new ArrayList<>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
	}
	
	//컴퓨터의 볼 넘버
	public void getNum(){
		
		Set<Integer> numSet = new HashSet<>();
		
		//1~9사이의서로다른 난수 3개를 만들어서 리스트에 저장하는 메서드
		while(numSet.size() <3){
			numSet.add((int)(Math.random() *9+1));
		}
		
		//만들어진 난수 리스트에 저장
		numList = new ArrayList<>(numSet);
		
		//List의 데이터를 섞어준다.
		Collections.shuffle(numList);
		
	}
	
	//스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	public void ballCount(){
		Strike = 0;
		Ball = 0;
		
		for(int i = 0; i<userList.size(); i++){
			for(int j = 0; j < numList.size(); j++){
				if(userList.get(i) == numList.get(j)){
					if(i == j){
						Strike++;
					}else{
						Ball++;
					}
				}
			}
		}
		
		//볼 카우트의 결과를 출력한다.
		System.out.println(userList.get(0)+","+userList.get(1)+"," + userList.get(2)
							+ "==>"+Strike + "S"+Ball+"B");
		
	}

	public static void main(String[] args) {
	/*	BaseBall_Sem test = new BaseBall_Sem();
		test.gameStart();*/
		new BaseBall_Sem().gameStart();
	}

}
