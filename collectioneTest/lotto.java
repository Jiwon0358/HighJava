package collectioneTest;

import java.util.HashSet;
import java.util.Scanner;

public class lotto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	while(true){
		System.out.println("=============================");
		System.out.println("\tLotto 프로그램");
		System.out.println("-----------------------------");
		System.out.println("\t1.로또 구입");
		System.out.println("\t2.프로그램 종료");
		System.out.println("=============================");
		System.out.print("메뉴 선택 :");
		int input = Integer.parseInt(sc.nextLine());
		
		switch(input){
		
		case 1:
			new lotto().startLotto();
			
			break;
		case 2:
			System.out.println();
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
			}
		}
	}
	
	public void startLotto(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("1000원에 로또한장입니다.");
		System.out.print("금액 입력 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		if(money < 1000){
			System.out.println();
			System.out.println("입력 금액이 너무 적습니다. 로또 번호 구입 실패!");
		}else if(money > 100000){
			System.out.println();
			System.out.println("입력 금액이 너무 많습니다. 로또 번호 구입 실패!");
		}else{
			int res = new lotto().buyLotto(money);
			System.out.println();
			System.out.println("받은금액은 " + money + "원 거스름돈은 " + res + "원 입니다.");
		}
		
	}
	
	public int buyLotto(int money){
		System.out.println();
		System.out.println("행운의 로또 번호는 다음과 같습니다.");
		for(int i = 1; i < (money / 1000) + 1 ; i++){
		HashSet<Integer> lottonum = new HashSet<>();
		while(lottonum.size() < 6){
			lottonum.add((int)(Math.random() * 45 +1));
			}System.out.println("로또번호"+i+":"+lottonum);
		}
		
		return money%1000;
		
	}

}
