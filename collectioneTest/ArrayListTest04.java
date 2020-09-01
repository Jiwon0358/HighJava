package collectioneTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		/*
		 * ����2) ����1���� ������ ���̰� ���� ���� �ߺ��� ��츦 ó���Ͻÿ�.
		 */
		

		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ����� ������ �Է��ϼ���");
		name.add(sc.nextLine());
		System.out.println("�ι�° ����� ������ �Է��ϼ���");
		name.add(sc.nextLine());
		System.out.println("����° ����� ������ �Է��ϼ���");
		name.add(sc.nextLine());
		System.out.println("�׹�° ����� ������ �Է��ϼ���");
		name.add(sc.nextLine());
		System.out.println("�ٹ�° ����� ������ �Է��ϼ���");
		name.add(sc.nextLine());
		System.out.print("5���� ���� �� ������ \t");
		
		//�����ؼ� Ǯ��
		for(int i = 0; i < name.size()-1; i++){
			if(name.get(i).length() < name.get(i+1).length()){
				String box = name.get(i);
				name.set(i, name.get(i+1));
				name.set(i+1, box);
			}
		}
		
		System.out.print(name.get(0) + "\t");
		for(int i = 1; i < name.size(); i++){
			
			if(name.get(0).length() == name.get(i).length()){
				System.out.print(name.get(i) + "\t");
			}
		}
		//==========================================================
		
		//�ε��� ��ȣ ����ؼ� Ǯ��
		int max = 0;
		for(int i = 0; i < name.size()-1; i++){
			if(name.get(i).length() < name.get(i+1).length()){
				max = i+1;
			}
		}
		System.out.print(name.get(max));
		
		for(int i = 0; i < name.size(); i++){
			if(name.get(max).length() == name.get(i).length()){
				System.out.print(name.get(i)+"\t");
			}
		}
		
		
		
		
		
	}

}
