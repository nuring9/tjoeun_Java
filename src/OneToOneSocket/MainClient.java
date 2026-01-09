package OneToOneSocket;


import java.io.IOException;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			Socket c_socket = new Socket("localhost",9000); // Socket 생성
			System.out.println("서버 연결");
			ReceiveThread receive_thread = new ReceiveThread(); // Receive Thread 객체 생성
			receive_thread.setSocket(c_socket); // Receive Thread Socket 전달
			ClientThread send_thread = new ClientThread(); // Client Send Thread 객체 생성
			send_thread.setSocket(c_socket); // Client Send Thread Socket 전달
			send_thread.start(); // Send Thread 시작
			receive_thread.start(); // Receive Thread 시작
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}

