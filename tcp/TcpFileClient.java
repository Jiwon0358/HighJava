package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

/*
 * 클라이언트가 서버에 접속하면 'd:/d_other'폴더에 있는 'music.jpg'파일을 서버로 전송한다.
 */

public class TcpFileClient {
	private Socket socket;
	private BufferedOutputStream bout; //소켓 전송용
	private DataOutputStream dout; 	  //문자 전송용
	private BufferedInputStream bin; //파일 읽기용
	
	
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}

	private void clientStart() {
/*		//전송할 파일을 이용한 File객체 생성
		File file = new File("d:/d_other/music.jpg");
		String fileName = file.getName(); //파일 이름 구하기
		
		if(!file.exists()){//전송할 파일이 있는지 검사
			System.out.println(fileName + "파일이 없습니다.");
			return;
		}*/
		
		String fileName = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("d:/d_other"));
		File file = null;
		
		int result = fileChooser.showOpenDialog(new JPanel());
		if(result == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			fileName = file.getName();
		}else{
			System.out.println("파일 전송을 취소합니다.");
			return;
		}
		
		
		try {
			socket = new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println("파일 전송 시작");
			
			//접속되면 '파일이름'을 소켓을 통해 전송한다.
			dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			//파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));
			
			//서버로 전송할 스트림 객체 생성
			bout = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024]; //한번에 1024byte씩 보내겠다
			int len = 0;
			//파일 내용을 읽어와 소켓을 통해서 전송한다.
			while((len = bin.read(temp)) > 0){//읽어서 temp에 저장
				bout.write(temp,0,len); //temp의 0번째부터 len번째까지 저장
			}
			bout.flush();
			
			System.out.println("파일 전송 완료");
			
		
		} catch (Exception e) { //여러가 Exception이 발생할 수 있어서.
			System.out.println("파일전송 실패");
			e.printStackTrace();
		} finally{
			//사용한 스트림 닫기
			if(dout != null) try { dout.close(); } catch (IOException e2) {}
			if(bin != null) try { bin.close(); } catch (IOException e2) {}
			if(bout != null) try { bout.close(); } catch (IOException e2) {}
			if(socket != null) try { socket.close(); } catch (IOException e2) {}
			
		}
		
	}
}