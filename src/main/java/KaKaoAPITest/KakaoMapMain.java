package KaKaoAPITest;

import org.apache.log4j.BasicConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KakaoMapMain {
    public static void main(String[] args) {
        try {
            //log4j 로그 설정
            BasicConfigurator.configure();
            // 입력
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // 출력
            System.out.print("주소를 입력하세요: ");
            // 입력 -> adrdress
            String address = reader.readLine();
            // getAddressCoordinate 보낸 double[] 값을 받아서 coordinates에 대입
            double[] coordinates = KakaoAPI.getAddressCoordinate(address);
            // coordinates null이 아닌 경우 실행
            if (coordinates != null) {
                System.out.println("주소: " + address); // 주소 출력
                //("y").getAsDouble()
                System.out.println("위도: " + coordinates[0]); // double 배열 0번째 인덱스 출력
                //("x").getAsDouble()
                System.out.println("경도: " + coordinates[1]); // double 배열 0번째 인덱스 출력
            } else { // coordinates null인 경우 실행
                System.out.println("주소를 찾을 수 없습니다.");// 주소 찾을 수 없다고 출력
            }
        } catch (IOException e) { // 예외처리
            e.printStackTrace();
        }

    }
}