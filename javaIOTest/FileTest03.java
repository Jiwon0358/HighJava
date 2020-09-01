package javaIOTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		File file = new File("D:/B_Util/2.java/JDK1.8");
		test.displayFileList(file);
	}
	
	//디렉토리를 매개변수로 받아서 해당 디렉토리에 있는 모든 파일과 디렉토리 목록을 출력하는 메서드
	public void displayFileList(File dir){
		if(!dir.isDirectory()){
			System.out.println(dir.getName() + "은 디렉토리(폴더)가 아닙니다.");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리안의 파일과 디렉토리 목록");
		
		//해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files = dir.listFiles(); //디렉토리 안에 있는 모든 것을 파일로 가져온다.
//		String[] filestr = dir.list(); //반환 값이 string으로 가지고 오고 싶으면
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm"); //a : 오전, 오후
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복
		for(int i = 0; i<files.length; i++){
			String fileName = files[i].getName();
			String attr = ""; //파일의 속성이 저장될 변수(읽기, 쓰기, 히든(숨겨진), 디렉토리 구분)
			String size = ""; //파일의 크기
			
			if(files[i].isDirectory()){
				attr = "<DIR>"; //폴더일때
			}else{//폴더가 아니라면(파일)
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			//printf : %s = 문자열을 출력해라 앞에, 숫자는 자리수(그만큼의 공간확보)
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())), attr, size, fileName ); 
			
		}
	}
	
}
