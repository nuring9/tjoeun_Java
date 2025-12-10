package Day06;

import java.util.Random;
import java.util.Scanner;

public class Q3_1 {
    static void main() {
        // 정답 코드
        // 단일 if로 해야함.
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        int com1 = r.nextInt(9) + 1; // 1~9
        int com2 = r.nextInt(9) + 1; // 1~9
        int com3 = r.nextInt(9) + 1; // 1~9

        while (com1 == com2 || com1 == com3 || com2 == com3) {
            com1 = r.nextInt(9) + 1; // 1~9
            com2 = r.nextInt(9) + 1; // 1~9
            com3 = r.nextInt(9) + 1; // 1~9  1번과 2번만 중복인데 3번까지 같이 랜덤이라 자원 낭비
        }

        System.out.println("Com " + com1 + " " + com2 + " " + com3);


        while (strike != 3) {
            strike = 0; // 다시 확인할 때 초기화
            ball = 0;   // 다시 확인할 때 초기화
            // 1. 유저 입력
            int user1 = 0;
            int user2 = 0;
            int user3 = 0;

            while (user1 < 1 || user1 > 9) {
                System.out.println("첫째자리 : ");
                user1 = sc.nextInt();
            }

            while (user2 < 1 || user2 > 9 || user1 == user2) {
                System.out.println("둘째자리 : ");
                user2 = sc.nextInt();
            }

            while (user3 < 1 || user3 > 9 || user1 == user3 || user2 == user3) {
                System.out.println("셋째자리 : ");
                user3 = sc.nextInt();
            }
            System.out.println(user1+" "+ user2+" "+user3);


            if (user1 == com1) {
                strike++;
            }
            if (user2 == com2) {
                strike++;
            }
            if(user3 == com3) {
                strike++;
            }

            if(user1 == com2 || user1 == com3) {
                ball++;
            }
            if(user2 == com1 || user2 == com3) {
                ball++;
            }
            if(user3 == com1 || user3 == com2 ) {
                ball++;
            }

            if (strike == 3) {
                System.out.println("홈런 입니다.");
            } else if (strike == 0 && ball ==0) {
                System.out.println("Out 입니다.");
            } else {
                System.out.println("strike : " + strike + ", ball : " + ball);
            }
           // 여기에 초기화 넣으면 계속 무한루프
        }

    }
}
