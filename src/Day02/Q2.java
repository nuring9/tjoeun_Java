package Day02;

import java.util.Scanner;

public class Q2 {
    static void main() {
        // 문제 1
        // 숫자를 2개 입력받는다. 2개 입력 받은 숫자를 더하기, 빼기, 곱하기 ,나누기 나머지 연산자로 연산한 결과 값 출력.
        String str = "숫자 1 : ";
        String str1 = "숫자 2 : ";
        String str2 = "더하기 결과 값 : ";
        String str3 = "빼기 결과값 : ";
        String str4 = "곱하기 결과 값 : ";
        String str5 = "나누기 결과 값 : ";
        String str6 = "나머지 연산자 결과 값 : ";

        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        int num1 = sc.nextInt();
        System.out.println(str1);
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        int minus = num1 - num2;
        int multiplication = num1 * num2;
        int  division = num1 / num2;
        int remainder = num1 % num2;

        System.out.println(str2 + sum );
        System.out.println(str3 + minus );
        System.out.println(str4 + multiplication );
            System.out.println(str5 + division );
        System.out.println(str6 + remainder );

    }
}
