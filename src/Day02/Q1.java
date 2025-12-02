package Day02;

import java.util.Scanner;

public class Q1 {
    static void main() {
        /*
        Scanner sc = new Scanner(System.in);  // 입력문 실행 준비
        int a = sc.nextInt();

        int sum = a+a;

        String str = "숫자 1 : ";
        String str1 = "숫자 2 : ";
        String str2 = "결과값 : ";



        System.out.println(str + a);
        System.out.println(str1 + a);
        System.out.println(str2 + sum);
        System.out.printf("결과값 : %d 입니다.", sum);
        */

        String str = "숫자 1 : ";
        String str1 = "숫자 2 : ";
        String str2 = "결과값 : ";

        Scanner sc = new Scanner(System.in);  // 입력문 실행 준비

        System.out.println(str);
        int num1 = sc.nextInt();
        System.out.println(str1);
        int num2 = sc.nextInt();
        int result = num1 + num2;

        System.out.println(str2 + result + " 입니다.");
        System.out.printf("결과값 : %d 입니다.", result);

    }
}

