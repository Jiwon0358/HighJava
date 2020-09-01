package javaIOTest;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		//문자 기반의 BUffered스트림 사용 연습
		try {
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java"); //. : 현재 자바 프로그램이 실행되는 위치
			BufferedReader br = new BufferedReader(fr); //버퍼의 기본 크기(8192Byte)로 객체 생성
			
			String temp = "";
			
			//readLine()메서드 : 한 줄 씩 데이터를 읽어오는데 읽어올 데이터가 없으면 null을 반환한다.
			for(int i = 1; (temp = br.readLine())!= null; i++){
				System.out.printf("%4d : %s\n", i, temp);
			}
			br.close(); //스트림 닫기 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
