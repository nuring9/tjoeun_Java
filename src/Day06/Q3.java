package Day06;

import java.util.Random;
import java.util.Scanner;

public class Q3 {

    // 내가 짠 코드 틀린 코드임. esle if를 사용해서 망함. 단일if로 해야함.

    // 숫자 야구 게임
    // 3 자릿수와 숫자가 전부 일치하면 "홈런 입니다."
    // 숫자가 전부 맞지 않으면 "out 입니다."
    // 자리수와 숫자가 맞으면 "1 Strike 입니다."
    // 자릿수는 달라도 숫자가 2개 맞으면 "2 ball 입니다." 1개만 맞으면 "1 ball 입니다."




    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        int num1 = r.nextInt(9) + 1; // 1~9
        int num2 = r.nextInt(9) + 1; // 1~9
        int num3 = r.nextInt(9) + 1; // 1~9

        while (num1 == num2 || num1 == num3 || num2 == num3) {
            num1 = r.nextInt(9) + 1; // 1~9
            num2 = r.nextInt(9) + 1; // 1~9
            num3 = r.nextInt(9) + 1; // 1~9  1번과 2번만 중복인데 3번까지 같이 랜덤이라 자원 낭비
        }

        System.out.println("Com " + num1 + " " + num2 + " " + num3);

        while (true) {
            System.out.print("첫째자리 : ");
            int user_num1 = sc.nextInt();
            System.out.print("둘째자리 : ");
            int user_num2 = sc.nextInt();
            System.out.print("셋째자리 : ");
            int user_num3 = sc.nextInt();

            System.out.println("User " + user_num1 + " " + user_num2 + " " + user_num3);

            if (num1 == user_num1 && num2 == user_num2 && num3 == user_num3) {
                System.out.print("홈런 입니다.");
                break;
            } else if (num1 == user_num1 || num2 == user_num2 || num3 == user_num3) {
                // num1 num2 num3 랑 user_num1 user_num2 user_num3 랑 비교해서 1나라도 있으면 ++

                strike = strike + 1;

                System.out.println(strike + " Strike 입니다");
                if (strike == 3) {
                    System.out.println("홈런 입니다.");
                }
            } else if (num1 != user_num2 || num1 != user_num3) {
                ball = ball + 1;

                System.out.println(ball + " Ball 입니다");
                if (ball == 3) {
                    System.out.println("아웃 입니다.");
                }
            } else {
                System.out.print("아웃 입니다.");
            }

        }

    }
}
