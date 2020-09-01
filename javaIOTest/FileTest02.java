package javaIOTest;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("D:/D_Other/test.txt");
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "bytes"); //단위가 바이트이다.
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		File f2 = new File("."); //현재 자바 클래스가 실행되는 현재 위치
		System.out.println("path : " + f2.getPath()); //상대경로
		System.out.println("absolutePath : " + f2.getAbsolutePath()); //절대경로
		System.out.println();
		
		if(f1.isFile()){
			System.out.println(f1.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()){
			System.out.println(f1.getName() + "은 디렉토리(폴더)입니다.");
		}else{
			System.out.println(f1.getName() + "은 뭘까?");
		}System.out.println();
		
		
		
		if(f2.isFile()){
			System.out.println(f2.getName() + "은 파일입니다.");
		}else if(f2.isDirectory()){
			System.out.println(f2.getName() + "은 디렉토리(폴더)입니다.");
		}else{
			System.out.println(f2.getName() + "은 뭘까?");
		}System.out.println();
		
		
		File f3 = new File("D:/D_Other/sample.exe"); //존재하지 않는 
		if(f3.isFile()){
			System.out.println(f3.getName() + "은 파일입니다.");
		}else if(f3.isDirectory()){
			System.out.println(f3.getName() + "은 디렉토리(폴더)입니다.");
		}else{
			System.out.println(f3.getName() + "은 뭘까?");
		}System.out.println();
	}

}
