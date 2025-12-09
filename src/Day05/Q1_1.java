package Day05;

import java.util.Scanner;

public class Q1_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력 : ");
        int num = sc.nextInt();
        String jjak = "짝수 : ";
        String hol = "홀수 : ";

        // 짝수홀수 값을 나누고 담는 작업.
        for (int i = 1; i < num; i++) {
            if(i % 2 ==0) {
                jjak = jjak + i + " ";
            } else {
                hol = hol + i + " ";
            }
        }

        // 출력
        System.out.println(jjak);
        System.out.println(hol);
    }
}
