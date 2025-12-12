package Day08;

import java.util.Scanner;

public class Q3 {
    static void main() {
/*
두 수를 입력 받아서 구하시요.
최소공배수와 최대공약수를 구하시요.

유클리드 호제법을 사용.

48과 18의 최대공약수 구하기
48 % 18 = 2(몫) ...12(나머지)
18 % 12 = 1(몫) ...6(나머지)
12 % 6 = 2(몫) ...0(나머지)
나머지가 0이 되었으므로, 마지막 나눈 수인 6이 최대 공약수이다.

최소공배수 = 120*36/최대공약수
*/

        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하세요 : ");

        System.out.print("숫자 1: ");
        int num1 = sc.nextInt();

        System.out.print("숫자 2: ");
        int num2 = sc.nextInt();


        int temp1 = num1;
        int temp2 = num2;

        int gcd = 0; // 최대공약수
        int lcm = 0; // 최소공배수

        int r = 1;
        while (r > 0) {
            r = temp1 % temp2;
            temp1 = temp2;
            temp2 = r;
        }

        gcd = temp1;
        lcm = num1 * num2 / gcd;
        System.out.println("최대공약수 : " + gcd);
        System.out.println("최소공배수 : " + lcm);


    }
}
