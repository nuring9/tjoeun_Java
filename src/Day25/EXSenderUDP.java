package Day25;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EXSenderUDP {
    static void main() throws IOException {
        DatagramSocket ds = new DatagramSocket(); // UDP DatagramSocket
        // UDP 통신용 소켓 생성, 포트 지정 안 하면 OS가 임의 포트 할당
        // TCP처럼 연결 개념 X


        InetAddress ia = InetAddress.getByName("192.168.40.194"); // InetAddress 객체를 받아고
        // 목적지 IP 주소 객체
        // DNS 이름도 가능 (localhost, www.xxx.com)


        int port = 8888; // 포트번호, 받는 쪽(Receiver)이 열어둔 포트

        Scanner sc = new Scanner(System.in);
        System.out.println("입력 : ");
        String str = sc.next();
        // 사용자 입력 문자열 받기

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, port);
        // UDP의 핵심 객체 = 보낼 데이터 + 목적지(IP, 포트)를 한 번에 묶음
        // TCP처럼 스트림 없음

        // 보내기 위해서 DatagramPacket 객체 생성 str.getBytes()(문자열 바이트)
        // str.getBytes().length(문자열 바이트 길이)
        // ia 인터넷 ip
        // port 포트번호

        ds.send(dp);
        // 패킷 전송 , 상대가 받았는지 확인 안 함
    }
}
