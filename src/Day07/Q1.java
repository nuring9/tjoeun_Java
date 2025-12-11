package Day07;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        // 랜덤숫자 1~100
        // 숫자 입력 1~100
        // 맞추면 축하합니다
        // 숫자가 더 많으면 다운, 낮으면 업.


        int com = r.nextInt(100) + 1;
        System.out.println("Com : " + com);
        System.out.print("숫자입력 : ");
        int user = sc.nextInt();



        while (user != com) {
            if (com < user) {
                System.out.println("다운");
            } else {
                System.out.println("업");
            }
            System.out.print("숫자입력 : ");
            user = sc.nextInt();
        }
        System.out.println("맞췄습니다. 축하합니다.");
    }

}




