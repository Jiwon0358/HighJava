package tcp;
/*
 * 서버는 클라이언트가 보낸 파일을 받아서 'd:/d_other/download'폴더에 저장한다.
 */


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpFileServer {
	private ServerSocket server;
	private Socket socket;
	private DataInputStream din; //문자 수신용
	private BufferedInputStream bin; //파일 수신용
	private BufferedOutputStream bout; //파일 저장용
	
	
	private void serverStart(){
		File savedir = new File("d:/d_other/download"); //저장할 폴더
		if(!savedir.exists()){//저장할 폴더가 없으면 새로 만들겠다.
			savedir.mkdirs(); //중간다리까지 생성할 수 있는 폴더 생성
		}
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			
			socket = server.accept(); //클라이언트의 접속 요청을 기다린다.
			
			System.out.println("파일 다운로드 시작");
			
			//클라이언트가 처음으로 보내는 데이터받기 => 파일이름이 처음에 수신된다.
			din = new DataInputStream(socket.getInputStream());
			String fileName = din.readUTF();
			
			//저장할 파일의 위치와 파일 이름을 지정하여 file객체 생성
			//형식2) new file(File parent, String child) //parent 폴더 안에 있는 child 파일
			File saveFile = new File(savedir, fileName);
			
			//수신용 스트림 객체 생성
			bin = new BufferedInputStream(socket.getInputStream());
			
			//파일 저장용 스트림 객체 생성
			bout = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			//소켓으로 수신된 데이터를 파일로 저장한다.
			while((len = bin.read(temp)) > 0){
				bout.write(temp, 0 , len);
			}
			bout.flush();
			System.out.println("다운로드가 완료되었습니다.");
			
			
		} catch (Exception e) {
			System.out.println("다운로드가 실패하였습니다.");
			e.printStackTrace();
		} finally{
			
			//사용한 스트림 닫기(객체가 생성되어 있으면 닫아라 )
			if(din != null) try { din.close(); } catch (IOException e2) {}
			if(bin != null) try { bin.close(); } catch (IOException e2) {}
			if(bout != null) try { bout.close(); } catch (IOException e2) {}
			if(socket != null) try { socket.close(); } catch (IOException e2) {}
			if(server != null) try { server.close(); } catch (IOException e2) {}
			
		}
		
		
		
	}
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}
}