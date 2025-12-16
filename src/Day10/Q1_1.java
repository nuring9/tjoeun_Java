package Day10;

import java.util.Scanner;

public class Q1_1 {
    static int add(int a, int b) {
        return a + b;
    }

    static void minus(int num1, int num2) {
        System.out.println("결과값 : " + (num1 - num2));
    }

    static int times() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1 입력: ");
        int num1 = sc.nextInt();
        System.out.print("숫자2 입력: ");
        int num2 = sc.nextInt();
        return num1*num2;
    }

    static void divided() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1 입력: ");
        int num1 = sc.nextInt();
        System.out.print("숫자2 입력: ");
        int num2 = sc.nextInt();
        System.out.printf("결과값 : %.1f", ((double)num1/num2));
    }

    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.print("연산자 입력: ");
        String operator = sc.next();


        if (operator.equals("+")) {
            System.out.print("숫자1 입력: ");
            int num1 = sc.nextInt();
            System.out.print("숫자2 입력: ");
            int num2 = sc.nextInt();
            System.out.println("결과값 : " + add(num1, num2));
        } else if (operator.equals("*")) {
            System.out.println("결과값 : " + times());
        } else if (operator.equals("-")) {
            System.out.print("숫자1 입력: ");
            int num1 = sc.nextInt();
            System.out.print("숫자2 입력: ");
            int num2 = sc.nextInt();
            minus(num1, num2);
        } else if (operator.equals("/")) {
            divided();
        } else {
            System.out.println("잘못된 연산입니다.");
        }

    }
}
