package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		try {
			//ServerSocket을 만들고, 클라이언트가 접속해 오면 소켓을 만들어서
			//메세지를 받는 쓰레드와 메세지를 전송하는 쓰레드에 이 소켓을 넘겨준다.
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비중입니다.");
			
			//접속 요청을 기다린다.
			Socket socket = server.accept();
			System.out.println("클라이언트가 접속했습니다");
			System.out.println("지금부터 메세지를 주고 받을 수 있습니다.");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
