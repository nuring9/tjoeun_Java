package Day06;

import java.util.Random;
import java.util.Scanner;

public class Q3_array {
    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
//        int strike = 0;
//        int ball = 0;
        int com1 = r.nextInt(9) + 1; // 1~9
        int com2 = r.nextInt(9) + 1; // 1~9
        int com3 = r.nextInt(9) + 1; // 1~9

        while (com1 == com2 || com1 == com3 || com2 == com3) {
            com1 = r.nextInt(9) + 1; // 1~9
            com2 = r.nextInt(9) + 1; // 1~9
            com3 = r.nextInt(9) + 1; // 1~9  1번과 2번만 중복인데 3번까지 같이 랜덤이라 자원 낭비
        }

        System.out.println("Com " + com1 + " " + com2 + " " + com3);
    }
}
