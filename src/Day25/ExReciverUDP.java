package Day25;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ExReciverUDP {
    static void main() throws IOException {
        int port = 8888; // 포트번호, Sender가 보낸 포트와 반드시 동일해야 함
        int times = 10; //  반복할 횟수
        DatagramSocket ds = new DatagramSocket(port); // UDP 객체 생성 포트번호를 가지고
        // UDP 수신 대기, 해당 포트로 들어오는 모든 UDP 패킷 수신

        int i = 1;  // 횟수 계산을 위한 변수
        while (i <= times) { // 반복 10번
            byte[] buffer = new byte[30];  // 30byte 배열 생성
            // 데이터를 받을 공간, UDP는 고정 크기 버퍼 필요

            // buffer 30 byte 배열
            // buffer.length buffer 배열에 길이
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            // DatagramPacket 객체생성
            // 수신용 패킷, 내부에 buffer가 채워짐


            ds.receive(dp);
            // Sender에서 보낸 데이터 받기
            // 데이터 도착할 때까지 대기 (Blocking)
            // 도착하면 buffer에 복사됨

            String str = new String(dp.getData());
            // 받은 데이터를 getData() 이 메소드를 이요해서 문자열 받기
            // 받은 byte → String 변환 (실제 데이터 길이보다 길 수 있음)

            System.out.println("수신된 데이터 : " + str);
            // 출력
            ++i;
            // 1증가
        }
    }
}
