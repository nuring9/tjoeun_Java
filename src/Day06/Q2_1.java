package Day06;

import java.util.Random;

public class Q2_1 {
    static void main() {
        Random r = new Random();
        int num1 = r.nextInt(9) + 1; // 1~9
        int num2 = r.nextInt(9) + 1; // 1~9
        int num3 = r.nextInt(9) + 1; // 1~9

        while (num1 == num2 || num1 == num3 || num2 == num3) {
            num1 = r.nextInt(9) + 1; // 1~9
            num2 = r.nextInt(9) + 1; // 1~9
            num3 = r.nextInt(9) + 1; // 1~9  1번과 2번만 중복인데 3번까지 같이 랜덤이라 자원 낭비
        }

        System.out.print(num1 + " " + num2 + " " + num3);

    }
}