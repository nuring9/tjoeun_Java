package Day03;

import java.util.Scanner;

public class Q4 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 1 입력 : ");
        int num1 = sc.nextInt();

        System.out.print("숫자 2 입력 : ");
        int num2 = sc.nextInt();

        System.out.print("연산자 입력 : ");
        String operator = sc.next();

        int result;

//   switch문 사용.
//        switch (operator) {
//            case "+":
//                result = num1 + num2;
//                System.out.print("결과값 : " + result + " 입니다.");
//                break;
//            case "-":
//                result = num1 - num2;
//                System.out.print("결과값 : " + result + " 입니다.");
//                break;
//            case "*":
//                result = num1 * num2;
//                System.out.print("결과값 : " + result + " 입니다.");
//                break;
//            case "/":
//                result = num1 / num2;
//                System.out.printf("결과값 : %.1f 입니다.", (float)result);
//                break;
//            case "%":
//                result = num1 % num2;
//                System.out.printf("결과값 : %.1f 입니다.", (float)result);
//                break;
//            default:
//                System.out.println("잘못된 연산입니다.");
//                break;
//
//        }



        // if 문 사용
            if  (operator.equals("+")) {
                result = num1 + num2;
                System.out.print("결과값 : " + result + " 입니다.");
            }
            else if ( operator.equals("-")) {
                result = num1 - num2;
                System.out.print("결과값 : " + result + " 입니다.");
            }
            else if ( operator.equals("/")) {
                result = num1 / num2;
                System.out.printf("결과값 : %.1f 입니다.\n", (float)result);
            }
            else if ( operator.equals("%")) {
                result = num1 % num2;
                System.out.printf("결과값 : %.1f 입니다.\n", (float)result);
            }
            else {
                System.out.println("잘못된 연산입니다.");
            }





    }
}


