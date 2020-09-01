package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 클래스로 구성한다.(이 각각의 말들은 하나의 경기를 진행하는 쓰레드가 된다.)
 * 이 클래스는 말이름(String), 등수(int), 말의 현재위치(int)(말이 몇 구간을 달리고 있나를 나타냄)를 멤버변수로 갖는다.
 * 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.(Comparable인터페이스 구현하기)
 * 
 * 경기 구간은 1 ~ 50구간으로 되어 있다.
 * 
 * 경기중 중간 중간에 각 말들의 위치를 나타내시오.
 * 
 * ex)
 * 말이름1-->------------------------------
 * 말이름2-------->------------------------
 * 말이름3->-------------------------------
 * ...
 * 말이름9---->----------------------------
 * 말이름10-->-----------------------------
 * 
 * ============
 * 경기가 끝났을 때
 * 말이름1-------------------------------->
 * 말이름2-------------------------------->
 * 말이름3-------------------------------->
 * ...
 * 말이름9-------------------------------->
 * 말이름10------------------------------->
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 */
public class ThreadTest13 {

	public static void main(String[] args) {
		
		List<Horse> horses = new ArrayList<>();
				horses.add(new Horse("말1"));
				horses.add(new Horse("말2"));
				horses.add(new Horse("말3"));
				horses.add(new Horse("말4"));
				horses.add(new Horse("말5"));
				horses.add(new Horse("말6"));
				horses.add(new Horse("말7"));
				horses.add(new Horse("말8"));
				horses.add(new Horse("말9"));
				horses.add(new Horse("말10"));
				
		Display dis = new Display(horses);
		
/*		//방법2)
		//Runnable인터페이스를 구현한 Class를 작성하고, 이 클래스의 인스턴스를 생성하고
		//이 인스턴스를 Thread객체를 생성할 때 생성자의 매개값으로 넘겨준다.
		//이 때 생성된 Thread의 인스턴스의 start()메서드를 호출해서 실행한다.
		Runnable r1 = new MyRun();
		Thread th2 = new Thread(r1);
		th2.start();*/
		for(Horse horse : horses){
			horse.start();
		}
			dis.start();
		
		for(Horse horse : horses){
			try {
				horse.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			dis.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n");
		System.out.println("========*========");
		System.out.println("     경 기 결 과");
		System.out.println("-----------------");
		System.out.println("  등수          말 이름");
		System.out.println("-----------------");
		
		Collections.sort(horses);
		for(Horse horse : horses){
			                                                                                                                                 
			System.out.println(horse.getRank()+"\t"+horse.getHorsename());
		}
		
		
		
	}

}

class Horse extends Thread implements Comparable<Horse>{
	private String horsename;
	private int rank = 0;
	private int now;
	private String result = "";
	public static int ranknum = 1;
	
	public Horse(String name){
		this.horsename = name;
	}
	
	public String getHorsename() {
		return horsename;
	}

	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}


	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {

		for(int j = 1; j <= 50; j++){
			now = j;
			//3초에서 8초 사이의 랜덤 값 나오게 하기	
			try {
				Thread.sleep((int)(Math.random() * 300)+ 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}rank = ranknum++;
		
	
	}
	
	//등수를 오름 차순으로 정렬하는 내부정렬 기준
	@Override
	public int compareTo(Horse horse) {
		return new Integer(this.rank).compareTo(horse.getRank());
	}
	
	
}

class Display extends Thread{
	private List<Horse> horses;
	
	
	public Display(List<Horse> horses) {
		this.horses = horses;
	}

	@Override
	public void run() {
		while(true){
			System.out.println("\n\n\n\n");	
		for(Horse horse : horses){
			horse.setResult("");
			for(int i = 1; i <=50; i++){
				if(horse.getNow() == i){
				horse.setResult(horse.getResult()+"🐎"); 
				}else{
					horse.setResult(horse.getResult()+"-");
				}
				}
			if(horse.getRank() != 0){
				System.out.println(horse.getHorsename() + horse.getResult() + horse.getRank());
			}else{
			System.out.println(horse.getHorsename() + horse.getResult());
		}
		}
		if(Horse.ranknum == horses.size()+1){
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}





