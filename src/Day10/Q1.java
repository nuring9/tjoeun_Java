package Day10;

import java.util.Scanner;

public class Q1 {
    /*
    계산기 함수화
    연산자 입력 : +
    숫자 1 입력 : 9
    숫제 2 입력 : 6
    결과 값 : 15입니다.
    단, 연산자가 잘못 입력되면 잘못된 연산자 입니다. (출력)
    연산자 입력 : a (엔터)
    잘못된 연산자입니다. (출력)
    단, 나눗셈은 소수점 첫째자리까지 출력.
     */

    static int x, y;

    // 주고 받고
    static int add(int num1, int num2) {
        return num1 + num2;
    }

    // 주고 안받고
    static int times() {
     return x*y;
    }

    // 안주고 받고
    static void minus(int num1, int num2) {
        System.out.println("결과값 : " + (num1 - num2));
    }

    // 안주고 안받고
    static void divided() {
        System.out.printf("결과값 : %.1f", ((double)x/x));
    }


    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("연산자 입력: ");
        String operator = sc.next();
        System.out.print("숫자1 입력: ");
        int num1 = sc.nextInt();
        System.out.print("숫자2 입력: ");
        int num2 = sc.nextInt();

        if (operator.equals("+")) {
            System.out.println("결과값 : " + add(num1, num2));
        } else if (operator.equals("*")) {
            x = num1;
            y = num2;
            int result = times();
            System.out.println("결과값 : " + result);
        } else if (operator.equals("-")) {
            minus(num1, num2);
        } else if (operator.equals("/")) {
            x = num1;
            y = num2;
            divided();
        } else {
            System.out.println("잘못된 연산자 입니다");
        }


/*
switch 사용

        switch ( operator ) {
            case "+" :
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                System.out.println(add(num1, num2));
                break;
            case "*":
                int result = times();
                System.out.println(result);
                break;

            case "-":
                num1 = sc.nextInt();
                num2 = sc.nextInt();
                break;

            case "/":
                divided();
                break;

            default:
                System.out.println("잘못된 연산자 입니다.");
        }

 */

    }
}
