package javaIOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_sem {

	public static void main(String[] args) {
		
		String sourceFile = "d:/d_other/music2.jpg";
		String targetFile = "d:/d_other/연습용/music2_복사본.jpg";
		
		File file = new File(sourceFile);
		
		if(!file.exists()){ //복사할 파일이 있나 검사
			System.out.println(file.getName() + "파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다.");
			 return;
		}
		try {
			//복사할 원본 파일을 읽는데 사용될 스트림 객체 생성
			FileInputStream fin = new FileInputStream(sourceFile);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			//복사될 대상 파일을 저장하는데 사용될 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream(targetFile);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			
			int data; //읽어온 데이터가 저장될 변수

			//1byte씩 복사
/*			System.out.println("복사를 시작합니다.");
			while((data = fin.read()) != -1){
				fout.write(data);
			}
			fout.flush(); //작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력
*/			
			
			
			
			byte[] temp = new byte[1024]; //데이터가 저장될 배열 변수
			int len = 0;
			
/*			//배열을 이용한 복사(속도가 훨씬 빠르다)
			while((len = fin.read(temp)) > 0){
				fout.write(temp,0,len);
			}
			
			System.out.println("복사가 끝났습니다.");
			
			fin.close();
			fout.close();*/
			
			
			
			//버퍼 스트림을 이용한 복사
			while((data = bin.read(temp)) != -1){
				bout.write(data);
			}
			bout.flush();
			System.out.println("복사가 끝났습니다.");
			
			bin.close();
			bout.close();
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
