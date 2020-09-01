package javaIOTest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIOTest06 {

	public static void main(String[] args) {

		try {

			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileOutputStream fout = new FileOutputStream("D:/d_other/outTest.txt");
			
			//저장할 파일의 인코딩방식을 변경해서 저장하기 
			OutputStreamWriter osw = new OutputStreamWriter(fout, "utf-8");
			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("입력의 마지막은(입력을 끝내고 싶으면) Ctrl+z 입니다.");
			int c;
			
			
			while((c = isr.read()) != -1){
				osw.write(c);
			}
			
			
			//스트림 닫기
			osw.close();
			isr.close();
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
