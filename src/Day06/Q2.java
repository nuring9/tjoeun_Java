package Day06;

import java.util.Random;

public class Q2 {
    static void main() {
        // 3개의 변수의 1~9 랜덤 수를 부여
        // 각각의 변수의 숫자가 다르게 가질 수 있도록 구현
        // com 숫자 만들기
        //num1 == num2 || num1 == num3 || num2 == num3 다시재정의
        Random r = new Random();

        while (true) {
            int num1 = r.nextInt(9) + 1; // 1~9
            int num2 = r.nextInt(9) + 1; // 1~9
            int num3 = r.nextInt(9) + 1; // 1~9

            if (num1 != num2 && num2 != num3 && num1 != num3) {
                System.out.print(num1);
                System.out.print(num2);
                System.out.print(num3);
                break;
            }
        }
    }
}
