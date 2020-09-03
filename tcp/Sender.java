package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


//이 클래스는 소켓을 통해서 메세지를 보내는 역할을 담당한다.
public class Sender extends Thread{
	private Socket socket;
	private String name;
	private Scanner scan;
	private DataOutputStream dos;
	
	//생성자
	public Sender(Socket socket){
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		name = scan.nextLine();
		
		try {
			//발신용 스트림
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while(dos != null){
			try {
				dos.writeUTF(name + " : " + scan.nextLine()); //상대편에게 보내질 말
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}

}
