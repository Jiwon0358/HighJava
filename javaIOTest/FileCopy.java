package javaIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 'd:/d_other/호랑이.jpg'파일을 
 * 'd:/d_other/연습용 폴더에 '호랑이_복사본.jpg' 파일로 저장하시오.
 * 
 * 
 */
public class FileCopy {

	public static void main(String[] args) {
		
		
		File file = new File("d:/d_other/호랑이.jpg");
		
		try {
			FileInputStream fin = new FileInputStream(file);
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/호랑이_복사본.jpg");
			
			int c;
			
			while((c = fin.read()) != -1){
				fout.write(c);
			}
			System.out.println("읽어오기 완료");
			System.out.println("저장완료");
			
			fin.close();
			fout.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
		
		
	}

}
