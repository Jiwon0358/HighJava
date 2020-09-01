package collectioneTest;

import java.util.LinkedList;


public class StackTest {

	public static void main(String[] args) {
		/*
		 * 뒤로가기 앞으로가기 기능 구현
		 */
		
		Browser b = new Browser();
		
		b.goURL("1.네이버");
		b.goURL("2.야후");
		b.goURL("3.구글");
		b.goURL("4.다음");
		
		b.history();
		
		System.out.println("뒤로가기 후....");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후....");
		b.goBack();
		b.history();
		
		System.out.println("앞으로 가기 후....");
		b.goforward();
		b.history();
		
		System.out.println("앞으로 가기 후....");
		b.goforward();
		b.history();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5.네이트");
		b.history();
	}

}

class Browser{
	private LinkedList<String> back; 	//이전 방문 내역이 저장될 스택 변수
	private LinkedList<String> forward; //다음 방문 내역이 저장될 스택변수
	private String currentURL;  //현재페이지
	
	public Browser(){
		back = new LinkedList<>();
		forward =  new LinkedList<>();
		currentURL = "";
	}
	
	//사이트를 방문하는 메서드 ==> 매개변수에 방문할 URL을 넣는다.
	public void goURL(String url){
		if(currentURL != null && !"".equals(currentURL)){ //현재 페이지가 있으면 
			back.push(currentURL); //현재 페이지를 back 스택변수에 추가한다.
		}
		currentURL = url; //새로운 현재 페이지로 변경한다.
	}
	
	//뒤로가기 
	public void goBack(){
		//isEmpty() ==> List가 비어있으면 true, 그렇지 않으면 false
		if(!back.isEmpty()){
			forward.push(currentURL); //현재 페이지를 forward 스택에 추가한다
			currentURL = back.pop(); // back스택에서 1개의 데이터를 꺼내와 현재 페이지로 설정한다.
		}
	}
		
	//앞으로가기
	public void goforward(){
		if(!forward.isEmpty()){
		back.push(currentURL); //현재 페이지를 back 스택에 추가한다
		currentURL = forward.pop(); // forward스택에서 1개의 데이터를 꺼내와 현재 페이지로 설정한다.
		}
	}
		
	public void history(){
		System.out.println("===============================");
		System.out.println("        방  문   기  록");
		System.out.println("-------------------------------");
		System.out.println("back ==>" + back);
		System.out.println("현재페이지 ==>" + currentURL);
		System.out.println("forward ==>" + forward);
		System.out.println("===============================");
	}
	
}