package javaNetworkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress클래스 => IP주소를 다루기 위한 클래스
		
		//www.naver.com 사이트의 IP정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : " + naverIp.getHostName());
		//네이버는 많은 사람이 이용하는 사이트라 속도향상을 위해  IP주소가 여러개 있다.
		System.out.println("Host Address : " + naverIp.getHostAddress());
		System.out.println();
		
		
		//자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name : " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address : " + localIp.getHostAddress());
		System.out.println();
	
		
		//IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : ipArr){
			System.out.println(ip.toString());
		}
	}

}
