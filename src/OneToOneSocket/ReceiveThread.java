package OneToOneSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveThread extends Thread{

	private Socket m_Socket;
	
	public void run()
	{
		super.run();
		
		try
		{
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			// Socket을 이용한 BufferReader 생성
			String receiveString;
			
			while(true)
			{
				receiveString = tmpbuf.readLine();
				// BufferReader ReadLine 저장
				
				if(receiveString == null)
				{
					System.out.println("상대방 연결이 끊겼습니다.");
					break;
				}
				else
				{
					System.out.println("상대방: " + receiveString);
				}
			}
			tmpbuf.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// 메인문에서 Socket 객체 받아 내 변수에 대입
	
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}
}
