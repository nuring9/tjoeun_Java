package Day25;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ExClientTCP {
    static void main() throws IOException {
        String server = "192.168.40.194"; // 접속할 서버 IP
        // ip는 cmd에서 ipconfig로 ip주소 알아보고 넣기.

        int port = 7777; // 서버 포트 (서버와 동일해야 함)
        // 소켓 객체를 생성 server ip, port번호를 넣어서

        Socket c = new Socket(server,port);  // 서버로 TCP 연결 요청, 성공 시 서버의 accept()가 풀림


        InputStream is = c.getInputStream();
        // 서버가 보내는걸 받으려고 InputStream 객체를 생성
        // 서버가 보내는 데이터를 받을 통로


        DataInputStream dis = new DataInputStream(is);
        // InputStream -> DataInputStream 객체를 생성
        // 기본 InputStream → 데이터 처리용


        for(int i =1;i<=10;i++) {  // 서버가 보낸 1~10 수신 후 출력
            // j  = 서버에서 보낸걸 읽고
            int j = dis.read();
            System.out.println("서버로 부터 받은 데이터 "+ j + "출력");
        }
        c.close();
        // 서버와 연결 종료
    }
}
