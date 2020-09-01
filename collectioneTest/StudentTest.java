package collectioneTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {
	
	
	public void setRanking(ArrayList<Student> studentList){//등수를 세팅하는 메서드
		
		for(Student std1 : studentList){//등수를 구할 데이터를 위한 반복문
			int rank = 1; //처음에는 1등으로 설정해놓고 시작한다.
			for(Student std2 : studentList){ //비교대상을 나타내기 위한 반복문
				
				//등수 구할 데이터보다 큰 값을 만나면 rank를 증가시킨다.
				if(std1.getSum() > std2.getSum()){
					rank++;
				}
			}std1.setRank(rank); //구해진 등수를 Student객체의 rank변수에 저장한다.
		}
	}
	
	public static void main(String[] args) {
		
		StudentTest stdTest = new StudentTest();
		
		/*문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
		  	이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
		  	
		  	이 Student객체는 List에 저장하여 관리한다.
		  	
		  	List에 저장된 데이터들을 학번의 오름차순 정렬이 될 수 있는 내부 정렬 기준을 구현하고, 
		  	총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를 작성하여
		  	정렬된 결과를 출력하시오.
		  	
		  	(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
		 */
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		name.add("장성보");
		name.add("강지원");
		name.add("김인혁");
		name.add("이지향");
		name.add("이나정");
		
		
		
		for(int i = 0; i < 5; i++){
		int kor =(int)(Math.random()*101);
		int Eng = (int)(Math.random() *101);
		int Mat = (int)(Math.random() *101);
		studentList.add(new Student(i+1, name.get(i), kor, Eng, Mat));
		}
		
		
		stdTest.setRanking(studentList); //등수를 메겨주는 메서드 호출
		
		for(Student std : studentList){
			System.out.println(std);
		}
		
		//학번의 오름차순으로 정렬하기
		Collections.sort(studentList);
		System.out.println("오름차순 정렬 후");
		for(Student std : studentList){
			System.out.println(std);
		}
		
		Collections.shuffle(studentList);
		//총점으로 내림차순 정렬 후 같으면 이름으로 오름차순 정렬
		System.out.println("===================================");
		System.out.println("총점으로 내림차순 정렬 후 같으면 이름으로 오름차순 정렬");
		Collections.sort(studentList, new DescSumAscName());
		System.out.println("오름차순 정렬 후");
		for(Student std : studentList){
			System.out.println(std); //.toString이 생략되어있다.
		
		}
	
		
	}

}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private int rank;
	
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = kor + eng + mat;
		
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMat() {
		return mat;
	}


	public void setMat(int mat) {
		this.mat = mat;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", mat=" + mat + ", sum=" + sum + ", rank="
				+ rank + "]";
	}

	@Override
	public int compareTo(Student std) {
		return new Integer(this.num).compareTo(std.getNum());
	}

}
//총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름 차순으로 정렬하는 외부 정렬
class DescSumAscName implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getSum() == std2.getSum()){
			return std1.getName().compareTo(std2.getName());
		}else{
			return new Integer(std1.getSum()).compareTo(new Integer(std2.getSum())) *-1;
		}
	}
	
}







