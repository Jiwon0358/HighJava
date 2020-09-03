package javaNetworkTest;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class DialogTest {
	
	public static void main(String[] args) {
		//파일만 선택해주지 전송을 해주진 않음
		JFileChooser fileChooser = new JFileChooser();
		
		//Dialog창에서 처음에 나타날 디렉토리 설정(열리거나 저장되는 기준 위치 정하기)
		fileChooser.setCurrentDirectory(new File("d:/d_other"));
		
		//열기용
//		int result = fileChooser.showOpenDialog(new JPanel());
		
		//저장용
		int result = fileChooser.showSaveDialog(new JPanel());
		
		if(result == JFileChooser.APPROVE_OPTION){// 열기해서 파일을 선택하면.
			File selectFile = fileChooser.getSelectedFile();
			System.out.println("선택한 파일은?" + selectFile); //선택한 파일의 경로가 나옴.(즉 파일객체로 나옴)
		}else{
			//엑스를 누르거나 취소를 누르면
			System.out.println("작업취소");
		}
		
		
		
	}
}
