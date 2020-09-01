package collectioneTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {
	
	static Map<Integer, Book> bookList = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Library().mainMenu();
	}

	private void mainMenu() {
		while(true){
		System.out.println("\n\n");
		System.out.println("============================");
		System.out.println("\t도  서  관  메  뉴");
		System.out.println("----------------------------");
		System.out.println("\t1.도서 정보 등록");
		System.out.println("\t2.도서 정보 수정");
		System.out.println("\t3.도서 정보 삭제");
		System.out.println("\t4.도서 정보 검색");
		System.out.println("\t5.전체 도서 정보 출력");
		System.out.println("\t6.도서 반납 및 대여");
		System.out.println("\t0.프로그램 종료");
		System.out.println("============================");
		System.out.print("메뉴 선택 :");
		int input = Integer.parseInt(sc.nextLine());
		switch(input){
		case 1 : 
			insertForm();
			break;
		case 2 :
			updateForm();
			break;
		case 3 : 
			deleteForm();
			break;
		case 4 :
			searchForm();
			break;
		case 5 : 
			outputForm();
			break;
		case 6 : 
			checkInOut();
			break;
		case 0 : 
			System.out.println();
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
		}
		
	}

	
	private void checkInOut() {
		System.out.println("\n\n\n");
		System.out.println("======================");
		System.out.println("     반 납  및  대 여");
		System.out.println("----------------------");
		System.out.print("도서 번호 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(bookList.containsKey(bookNum)){
			Book book = bookList.get(bookNum);
			boolean check = book.isCheckOut();
			if(check){
				System.out.println("======================");
				System.out.println("도서번호 : " + book.getBookNum());
				System.out.println("제목 : " + book.getBookName());
				System.out.println("지은이 : " + book.getWritter());
				System.out.println("장르 : " + book.getGenre());
				System.out.println("======================");
				System.out.println(bookNum+"번 책을 정상적으로 대여하였습니다.");
				check = false;
				bookList.get(bookNum).setCheckOut(check);
			}else{
				System.out.println("======================");
				System.out.println("도서번호 : " + book.getBookNum());
				System.out.println("제목 : " + book.getBookName());
				System.out.println("지은이 : " + book.getWritter());
				System.out.println("장르 : " + book.getGenre());
				System.out.println("======================");
				System.out.println(bookNum+"번 책을 정상적으로 반납하였습니다.");
				check = true;
				bookList.get(bookNum).setCheckOut(check);
			}
		}else{
			System.out.println(bookNum + "번호로 등록된 도서 없습니다.");
		}
	}

	//전체 출력 메서드
	private void outputForm() {
		List<Integer> booksort = new ArrayList<>(bookList.keySet());
		Collections.sort(booksort); //오름차순 정렬
		System.out.println("\n\n\n");
		System.out.println("==================================");
		System.out.println("도서번호\t 제목\t 지은이\t장르\t대출여부");
		System.out.println("----------------------------------");
		for(int bookNum : booksort){
			Book book = bookList.get(bookNum);
			System.out.print(book.getBookNum()+"\t"+book.getBookName()+"\t"+ book.getWritter()+"\t"+ book.getGenre()+"\t");
			boolean check = book.isCheckOut();
			if(check){
			System.out.println("O");
			}else{
			System.out.println("X");
			}
		}
		
	}

	private void searchForm() {
		System.out.println("\n\n\n");
		System.out.println("======================");
		System.out.println("     도 서 정 보 검 색");
		System.out.println("----------------------");
		System.out.print("검색 할 도서 번호 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(bookList.containsKey(bookNum)){
			Book book = bookList.get(bookNum);
			System.out.println("======================");
			System.out.println("도서번호 : " + book.getBookNum());
			System.out.println("제목 : " + book.getBookName());
			System.out.println("지은이 : " + book.getWritter());
			System.out.println("장르 : " + book.getGenre());
			boolean check = book.isCheckOut();
			if(check){
			System.out.println("대출가능여부 : O");
			}else{
			System.out.println("대출가능여부 : X");
			}
			
			boolean checkIn = true;
			System.out.println("======================");
			
			System.out.println();
		}else{
			System.out.println(bookNum + "번호로 등록된 도서 없습니다.");
		}
	}

	private void deleteForm() {
		System.out.println("\n\n\n");
		System.out.println("======================");
		System.out.println("     도 서 정 보 삭 제");
		System.out.println("----------------------");
		System.out.print("삭제 할 도서 번호 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(bookList.containsKey(bookNum)){
			System.out.println("======================");
			bookList.remove(bookNum);
			System.out.println();
			System.out.println(bookNum+"번의 도서가 정상적으로 삭제되었습니다.");
		}else{
			System.out.println(bookNum + "번호로 등록된 도서 없습니다.");
		}
	}

	private void updateForm() {
		System.out.println("\n\n\n");
		System.out.println("======================");
		System.out.println("     도 서 정 보 수 정");
		System.out.println("----------------------");
		System.out.print("수정 할 도서 번호 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(bookList.containsKey(bookNum)){
			System.out.print("수정할 제목 : ");
			String bookName = sc.nextLine();
			System.out.print("수정할 지은이 : ");
			String writter = sc.nextLine();
			System.out.print("수정할 장르 : ");
			String genre = sc.nextLine();
			boolean checkIn = true;
			System.out.println("======================");
			bookList.put(bookNum, new Book(bookNum, bookName, writter, genre, checkIn));
			System.out.println();
			System.out.println(bookNum+"번의 도서가 정상적으로 수정되었습니다.");
		}else{
			System.out.println(bookNum + "번호로 등록된 도서 없습니다.");
		}
	}

	//도서 정보 등록 메서드
	private void insertForm() {
		System.out.println("\n\n\n");
		System.out.println("======================");
		System.out.println("     도 서 정 보 등 록");
		System.out.println("----------------------");
		System.out.print("도서 번호 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(bookList.containsKey(bookNum)){
			System.out.println(bookNum + "번호는 이미 등록된 도서 번호로 등록이 불가합니다.");
		}else{
			System.out.print("제목 : ");
			String bookName = sc.nextLine();
			System.out.print("지은이 : ");
			String writter = sc.nextLine();
			System.out.print("장르 : ");
			String genre = sc.nextLine();
			boolean checkIn = true;
			System.out.println("======================");
			bookList.put(bookNum, new Book(bookNum, bookName, writter, genre, checkIn));
			System.out.println();
			System.out.println(bookNum+"번의 도서가 정상적으로 등록되었습니다.");
		}
		
	}

}
class Book{
	private int bookNum;
	private String bookName;
	private String writter;
	private String genre;
	private boolean checkOut;
	
	
	public Book(int bookNum, String bookName, String writter, String genre,
			boolean checkOut) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.writter = writter;
		this.genre = genre;
		this.checkOut = checkOut;
	}


	public int getBookNum() {
		return bookNum;
	}


	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getWritter() {
		return writter;
	}


	public void setWritter(String writter) {
		this.writter = writter;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public boolean isCheckOut() {
		return checkOut;
	}


	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
}
