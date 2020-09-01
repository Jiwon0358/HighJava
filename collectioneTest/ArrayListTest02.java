package collectioneTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayListTest02 {

	public static void main(String[] args) {
		/*
		 * 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에 이름중 '김'씨성의 이름을 모두 출력하시오.
		 * (단, 입력은 Scanner 객체를 사용한다)
		 */
		
		ArrayList<String> name = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 사람의 이름을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("두번째 사람의 이름을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("세번째 사람의 이름을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("네번째 사람의 이름을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("다번째 사람의 이름을 입력하세요");
		name.add(sc.nextLine());
		System.out.print("5명중 김씨성을 가진 사람은  " );
		
		for(int i = 0; i < name.size(); i++){
			if(name.get(i).charAt(0) == '김'){
				System.out.print(name.get(i) + "\t");
			}	
		}
		
		for(int i = 0; i < name.size(); i++){
			if(name.get(i).indexOf("김") == 0){
				System.out.print(name.get(i) + "\t");
			}	
		}
		
		
		for(int i = 0; i < name.size(); i++){
			if(name.get(i).startsWith("김")){
				System.out.print(name.get(i) + "\t");
			}	
		}
		
		
		String rex = "^김.{1,}";
		for(int i = 0; i < name.size(); i++){
			Pattern pid = Pattern.compile(rex);
			Matcher mid = pid.matcher(name.get(i));
			if(mid.matches()){
				System.out.println(name.get(i));
			}
		}
	}

	
	
	
}
