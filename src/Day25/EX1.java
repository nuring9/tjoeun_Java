package Day25;

import java.net.InetAddress;  // InetAddress : IP / 호스트명 관련
import java.net.MalformedURLException;
import java.net.URL;  // URL : 웹 주소 분석
import java.net.UnknownHostException;

public class EX1 {
    static void main() throws UnknownHostException, MalformedURLException {
        // 네트워크 관련 오류를 throws로 처리 (예외:DNS 못 찾음 / URL 문법 오류)
        InetAddress address = InetAddress.getLocalHost();
        // 내 컴퓨터의 네트워크 정보
        // 로컬 PC의 IP, 호스트명 포함

        System.out.println("로컬 컴퓨터의 이름 : " + address.getHostName());
        // 컴퓨터 이름 (호스트명)
        System.out.println("로컬 컴퓨터의 IP 주소 : " + address.getHostAddress());
        // 로컬 IP 주소 (예: 192.168.x.x)

        InetAddress[] all = InetAddress.getAllByName("www.naver.com");
        // DNS 조회, 도메인 → IP 주소들
        // 서버는 여러 IP를 가질 수 있음 (로드밸런싱)

        for(int i = 0; i < all.length; i++){
            System.out.println(all[i]);
        }  // 네이버에 연결 가능한 모든 IP 출력


        URL starbuks = new URL("https://www.starbucks.co.kr/index.do");
        // 문자열 URL → 구조화된 URL 객체
        // 문법 틀리면 MalformedURLException


        System.out.println("프로토콜 : " + starbuks.getProtocol());
        // https

        System.out.println("포트 : " + starbuks.getPort());
        // 포트 번호 ,  지정 안 하면 -1
        // (https 기본 443)

        System.out.println("호스트 : " + starbuks.getHost());
        // www.starbucks.co.kr

        System.out.println("파일(경로포함) : " + starbuks.getFile());
        // /index.do

        System.out.println("전체 URL : " + starbuks.toExternalForm());
        // 원본 URL 전체 문자열

    }
}
