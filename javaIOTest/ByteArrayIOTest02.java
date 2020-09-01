package javaIOTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //입력용 데이터
		byte[] outSrc = null;
		byte[] temp = new byte[4]; //크기가 4인 byte배열 생성 => 입력데이터를 저장할 용도의 배열
				
		
		
		//입력용 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		//출력용 스트림 객체 생성
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while( input.available() > 0){ //읽어올 데이터가 있는지 여부 확인
				 /* input.read(temp);
				    output.write(temp);
				
				
				         반복문 안에서 temp => [0, 1, 2, 3]
					반복문 안에서 temp => [4, 5, 6, 7]
					반복문 안에서 temp => [8, 9, 6, 7]
					4바이트 배열이라 마지막 남는게 8,9. 그 전에 사용하던 데이터가 남아 있는데 거기에 덮어 씌워져서 8,9,6,7이 되버림.
				 */
				
				
				
				System.out.println("반복문 안에서 temp => " + Arrays.toString(temp));
				
				int len = input.read(temp); //read(배열)메서드의 반환값 : 실제 읽어온 데이터 수
				
				output.write(temp, 0, len); //temp배열의 내용 중에서 0번째부터 len개의 데이터를 출력한다.(즉, 실제로 읽어온 데이터만큼만 출력해라)
			
			}
			
			outSrc = output.toByteArray();
			System.out.println();
			System.out.println(" inSrc: " + Arrays.toString(inSrc));
			System.out.println(" outSrc: " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
