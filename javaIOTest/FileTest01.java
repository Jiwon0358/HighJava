package javaIOTest;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		//File객체 만들기 연습
		
		//형식1) new File(String 파일 또는 경로)
		//		==>디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 '\'를 사용하거나 '/'를 사용할 수 있다.
		
//		File file1 = new File("D:/D_Other/test.txt");  //구분문자를 '/'로 사용한 경우
		File file1 = new File("D:\\D_Other\\test.txt"); //구분문자를 '\'로 사용한 경우(역슬레쉬는 두개를 써줘야 된다)
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("path(경로) : " + file1.getPath());
		System.out.println("디렉토리일까?(폴더) : " + file1.isDirectory());
		System.out.println("파일일까? : " +file1.isFile());
		
		System.out.println("------------------------------------------");
		File file2 = new File("D:/d_other"); //대소문자 구분안함.(윈도우는 안함)
		System.out.println("파일명 : " + file2.getName());
		System.out.println("path(경로) : " + file2.getPath());
		System.out.println("디렉토리일까?(폴더) : " + file2.isDirectory());
		System.out.println("파일일까? : " +file2.isFile());
		
		
		//형식2) new file(File parent, STring child) //parent 폴더 안에 있는 child 파일
		//			==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file3 = new File(file2,"test.txt"); //file1과 같은말
		System.out.println("------------------------------------------");
		System.out.println("파일명 : " + file3.getName());
		System.out.println("path(경로) : " + file3.getPath());
		System.out.println("디렉토리일까?(폴더) : " + file3.isDirectory());
		System.out.println("파일일까? : " +file3.isFile());
		
		
		//형식3) new file(String parent, STring child) //parent 폴더 안에 있는 child 파일
		//			==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다. 
		File file4 = new File("D:/d_other","test.txt"); //file1과 같은말
		System.out.println("------------------------------------------");
		System.out.println("파일명 : " + file4.getName());
		System.out.println("path(경로) : " + file4.getPath());
		System.out.println("디렉토리일까?(폴더) : " + file4.isDirectory());
		System.out.println("파일일까? : " +file4.isFile());
		System.out.println("------------------------------------------");
		
		
		//디렉토리(폴더) 만들기
		//- mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		//			==> 반환값 : 만들기 성공(true), 만들기 실패(false)
		//			==> 경로의 중간부분의 폴더(디렉토리)들이 모두 만들어져 있어야 마지막 위치의 폴더를 만들 수 있다.
		
		//- mkdirs() ==> 중간 부분의 경로가 없으면 해당 경로도 같이 만들어 준다.
		File file5 = new File("D:/D_Other/연습용"); //연습용이란 폴더를 만들겠다.
		System.out.println(file5.getName() + "의 존재 여부 : " + file5.exists()); //exists : 해당 파일 or 폴더 등이 있다(true), 없다(false)
		if(!file5.exists()){ //존재하지 않을 때만 만들어라
			if(file5.mkdir()){
				System.out.println(file5.getName() + "폴더 만들기 성공");
			}else{
				System.out.println(file5.getName() + "폴더 만들기 실패");
			}
		}else{
			System.out.println("이미 폴더가 있습니다.");
		}
		
		System.out.println();
		
		
		//-mkdir()
		File file6 =  new File("D:/D_Other/test/java/src"); //d_other까지는 있는데 그 아래부터는 해당하는 폴더가 없어서 만들기 실패가 나온다.(즉, 상위 폴더가 다 만들어져 있어야 함)
		if(!file6.exists()){
			if(file6.mkdir()){
				System.out.println(file6.getName() + "폴더 만들기 성공");
			}else{
				System.out.println(file6.getName() + "폴더 만들기 실패");
			}
		}
		System.out.println();
		
		//-mkdirs()
		File file7 =  new File("D:/D_Other/test/java/src"); //mkdirs() : 중간부분의 경로까지 만들어 준다
		if(!file7.exists()){
			if(file7.mkdirs()){
				System.out.println(file7.getName() + "폴더 만들기 성공");
			}else{
				System.out.println(file7.getName() + "폴더 만들기 실패");
			}
		}
		
		
		
	}

}
