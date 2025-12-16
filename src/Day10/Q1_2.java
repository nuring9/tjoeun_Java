package Day10;

import java.util.Scanner;

public class Q1_2 {

    static int[] input() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        System.out.print("숫자1 입력: ");
        nums[0] = sc.nextInt();
        System.out.print("숫자2 입력: ");
        nums[1] = sc.nextInt();
        return nums;
    }


    static int add(int a, int b) {
        return a + b;
    }

    static void minus(int num1, int num2) {
        System.out.println("결과값 : " + (num1 - num2));
    }

    static int times() {
        int[] nums = input();
        return nums[0]*nums[1];
    }

    static void divided() {
        int[] nums = input();
        System.out.printf("결과값 : %.1f", ((double)nums[0] / (double) nums[1]));
    }

    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.print("연산자 입력: ");
        String operator = sc.next();


        if (operator.equals("+")) {
            int[] nums = input();
            System.out.println("결과값 : " + add(nums[0],nums[1]));
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
