package javaIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		//파일에 데이터를 출력하는 예제
		try {
			
			File f = new File("D:/D_Other/out.txt");
			
			//파일 출력용 스트림 객체 생성
			//파일이 없으면 새로 만들고, 있으면 그 내용을 덮어 쓰기 한다.
			FileOutputStream fout = new FileOutputStream(f);
			
			for(char ch = 'A'; ch<='Z'; ch++){
				fout.write(ch); //ch변수의 데이터를 파일로 출력한다.
			}
			System.out.println("작업완료");
			
			fout.close(); //스트림 닫기
			
			//------------------------------------------------
			//저장된 파일 내용을 읽어와 출력하기
			FileInputStream fin = new FileInputStream(f);
			int c;
			System.out.print(f.getName() + "파일에서 읽어온 내용 : ");
			while((c=fin.read()) != -1){
				System.out.print((char)c);
			}
			
			fin.close();
			
		} catch (IOException e) {
			
		}
	}

}
