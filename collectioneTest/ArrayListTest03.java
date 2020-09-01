package collectioneTest;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		/*
		 문제1)5명의 별명을 입력받아 ArrayList에 저장한 후
		 	  이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
		 	 (단, 입력한 각각의 별명의 길이는 모두 다르다.)
		 	 
		 문제2) 문제1에서 별명의 길이가 같은 것이 중복될 경우를 처리하시오.
		 
		 */
		
		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 사람의 별명을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("두번째 사람의 별명을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("세번째 사람의 별명을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("네번째 사람의 별명을 입력하세요");
		name.add(sc.nextLine());
		System.out.println("다번째 사람의 별명을 입력하세요");
		name.add(sc.nextLine());
		System.out.print("5명중 가장 긴 별명은  ");
		
		for(int i = 0; i < name.size()-1; i++){
			if(name.get(i).length() < name.get(i+1).length()){
				String box = name.get(i);
				name.set(i, name.get(i+1));
				name.set(i+1, box);
			}
		}
		System.out.println(name.get(0));
		
		//=========================================
		
		int max = 0;
		for(int i = 0; i < name.size()-1; i++){
			if(name.get(i).length() < name.get(i+1).length()){
				max = i+1;
			}
		}
		System.out.println(name.get(max));
		
		//==========================================
		//선생님 버전
		ArrayList<String> aliasList = new ArrayList<>();
		System.out.println("서로 다른 길이의 별명 5개를 입력하세요");
		for(int i = 1; i <= 5; i++){
			System.out.print(i+"번째 별명 : ");
			aliasList.add(sc.nextLine());
		}
		String maxAlias = aliasList.get(0);
		
		for(int i = 0; i <aliasList.size(); i++){
			if(aliasList.get(i).length() > maxAlias.length()){
				maxAlias = aliasList.get(i);
			}
		}
		System.out.println("제일 긴 별명 :" + maxAlias);
		
	}

}
