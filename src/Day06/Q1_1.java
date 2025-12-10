package Day06;

import java.util.Random;
import java.util.Scanner;

public class Q1_1 {
    static void main() {
        /*
        1. 게임시작 2. 종료 <첫화면>
        게임시작인 경우
        1. 가위 2. 바위 3. 보 :
        올바르게 1~3까지 입력 한 경우
        computer 난수와 비교해서
        User 승, 무승부, Com 승이 출력
        다시 <첫화면>으로 이동
        1~3 입력을 하지 않은 경우
        잘못된 입력 출력 후 <첫화면>으로 이동
        종료를 입력한 경우
        프로그램 종료
        그 외의 숫자를 입력하면 잘못된 입력 출력
        */

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        while (true) {
            System.out.println("1. 게임시작 2. 종료 : ");
            int select = sc.nextInt();
            if (select == 1) {
                System.out.println("1. 가위 2. 바위 3. 보");
                // user가 이길 경우의 수
                // result = user - com 을 이용.
                // 1(가위) - 3(보) = -2
                // 2(바위) - 1(가위) = 1
                // 3(보) - 2(바위) = 1
                // 그럼 -2거나 1이면 승
                // 1 - 1 = 0 가위-가위 = 무승부 2-2 = 0, 3-3 = 0 전부 0이면 무승부.
                // 나머지는 com 이 승

                int user = sc.nextInt();
                if(user > 0 && user < 4) {
                    int com = r.nextInt(3)+1;
                    System.out.println("user : " + user + " com : " + com);
                    int result = user - com;
                   if (result == -2 || result == 1) {
                       System.out.println("게임결과: User 승");
                   }else if (result == 0) {
                       System.out.println("게임결과: 무승부");
                   }else {
                       System.out.println("게임결과: Com 승");
                   }
                    System.out.println();
                } else {
                    System.out.println("잘못된 입력입니다.");
                    System.out.println();
                }
            } else if ( select == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                System.out.println();
            }
        }

    }
}
