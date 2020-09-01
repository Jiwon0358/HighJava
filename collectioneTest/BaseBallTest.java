package collectioneTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BaseBallTest {
	/*
	 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
	 * 		컴퓨터의 숫자는 난수를 이용하여 구한다.(1~9사이의 서로 다른 난수 3개)
	 * 		(스트라이크 S, 볼은 B로 나타낸다)
	 * 
	 * 
	 * 	예시) 컴퓨터 ==> 9 5 7
	 * 		 사람 ==> 7 8 9
	 * 			
	 * 		결과 : 0S 2B
	 * 
	 * 		
	 * 		
	 */

	public static void main(String[] args) {
		
		BaseBallTest ballListMake = new BaseBallTest();
		
		ArrayList<Integer> ballList = ballListMake.ballList();
		System.out.println(ballList);
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int strike = 0;
			int ball = 0;
			System.out.println("3개의 숫자를 입력하세요");
			String input = sc.nextLine();
			String[] split = input.split(" ");
			ArrayList<Integer> answer = new ArrayList<>();

			for (int i = 0; i < split.length; i++) {
				answer.add(Integer.parseInt(split[i]));
			}
			
			for(int i = 0; i < ballList.size(); i++){
				if(ballList.get(i) == answer.get(i)){
					strike++;
				}
				for(int j = 0; j < answer.size(); j++){
					if(ballList.get(i) == answer.get(j) && i != j){
						ball++;
					}
				}
			}
			
			if(strike == 3){
				System.out.println("축하합니다! 정답입니다!");
				break;
			}else if(strike > 0 || ball > 0){
				System.out.println(strike+"S"+ball+"B");
				System.out.println();
			}else{
				System.out.println("일치하는 것이 없습니다.");
				System.out.println();
			}
		
			}
		
	
	}
	
	public ArrayList<Integer> ballList(){
		
		HashSet<Integer> ballnum = new HashSet<>();
		
		while(ballnum.size() < 3){
			ballnum.add((int)(Math.random() * 9 + 1));
		}
				
		//1자리 숫자는 정렬이 되서 나오니, List로 변환하여 섞어주기
		
		ArrayList<Integer> ballList = new ArrayList<>(ballnum);
		
		Collections.shuffle(ballList); //섞어주기
		
		return ballList;
		
	}
	
	
	
	
		

	}


