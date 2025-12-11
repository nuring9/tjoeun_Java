package Day07;

import java.util.Random;
import java.util.Scanner;

public class Q2_array_1 {
    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] com = new int[3];
        int[] user = new int[3];
        int strike = 0;
        int ball = 0;



        for (int i = 0; i < 3; i++) {
            com[i] = r.nextInt(9) + 1;  // 배열에 1~9까지 난수 생성
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                    break;
                }
            }
        }


        System.out.print("Com : ");
        for (int i = 0; i < 3; i++) {
            System.out.print(com[i]);
        }

        System.out.println();

        while (strike != 3) {
            strike = 0; // 다시 확인할 때 초기화
            ball = 0;   // 다시 확인할 때 초기화

            user[0] = 0;
            user[1] = 0;
            user[2] = 0;



            while (user[0] < 1 || user[0] > 9) {  // 0보다 작거나 9보다 크면 true 반복
                System.out.print("첫째자리 : ");
                user[0] = sc.nextInt();
            }

            while (user[1] < 1 || user[1] > 9 || user[0] == user[1]) { // 첫째자리랑 둘째자리 같으면 다시 반복
                System.out.print("둘째자리 : ");
                user[1] = sc.nextInt();
            }

            while (user[2] < 1 || user[2] > 9 || user[0] == user[2] || user[1] == user[2]) { // 첫째,셋째 / 둘째 셋째 자리 반복
                System.out.print("셋째자리 : ");
                user[2] = sc.nextInt();
            }
            System.out.println(user[0]+ "" + user[1]+ "" +user[2]);

            if(user[0] == com[0]) {
                strike++;
            }
            if(user[1] == com[1]) {
                strike++;
            }
            if(user[2] == com[2]) {
                strike++;
            }

            if(user[0] == com[1] || user[0] == com[2]) {
                ball++;
            }
            if(user[1] == com[0] || user[1] == com[2]) {
                ball++;
            }
            if(user[2] == com[0] || user[2] == com[1] ) {
                ball++;
            }

            if (strike == 3) {
                System.out.println("홈런 입니다.");
            } else if (strike == 0 && ball == 0) {
                System.out.println("Out 입니다.");
            } else {
                System.out.println("strike : " + strike + ", ball : " + ball);
            }
        }
    }
}