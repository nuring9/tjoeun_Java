package Day25;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExServerTCP {
    static void main() throws IOException {
        // 네트워크는 IOException 발생 가능 → throws 처리
        int port = 7777; // 서버가 열 포트 번호 , 클라이언트는 이 포트로 접속.
        int times = 10; // 최대 10명의 클라이언트 접속 허용
        ServerSocket ss = new ServerSocket(port); //서버 소켓 생성, 이 순간부터 7777 포트를 열고 대기.
        int i = 1; // times와 비교를 위한 변수 (접속 횟수 카운트용)
        while(i<= times) { // 반복문 times와 같아질때까지 반복, 10명 들어올 때까지 반복
            Socket s = ss.accept(); // accept함수를 통한 소켓 생성
           // 클라이언트가 접속할 때까지 대기 (Blocking)
            // 접속되면 통신용 Socket 생성

            OutputStream os = s.getOutputStream(); // 소켓으로 out 밖으로 보내는 스트림을 생성
            // 클라이언트로 데이터를 보내기 위한 통로

            DataOutputStream dos = new DataOutputStream(os);
            // 기본 OutputStream → 데이터 타입 처리 가능한 스트림
            // OutputStrema을 인자로 넣어서 DataoutputStream의 객체를 생성

            for(int j = 1; j<=10;j++) { // 클라이언트에게 1~10까지 숫자 전송
                dos.write(j); // DataOutputStream을 이용해서 쓰기 실행 1~10
                // 1바이트 전송
            }
            s.close();
            // 해당 클라이언트와의 연결 종료
            ++i;
            // i를 1증가로 다음 클라이언트 대기.
        }
        ss.close();
        // 서버 종료
    }
}
