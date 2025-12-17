package Day11;

import java.util.Scanner;

public class Q1 {

    static int rectangle(int w, int h) {
        return w * h;
    }

    static void riangle(int w, int h) {
        System.out.println("삼각형 넓이: " + ((w * h) / 2));
    }

    static int[] input() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        System.out.println("1. 가로 : ");
        nums[0] = sc.nextInt();
        System.out.println("2. 세로 : ");
        nums[1] = sc.nextInt();
        return nums;
    }



    static void main() {
        /*
        1. 사각형 넓이
        넓이 = 가로 × 세로
        2. 삼각형 넓이
        넓이 =  밑변 × 높이 ÷ 2
        3. 종료 <첫화면>
        만약에 1번 또는 2번 입력시 다시 1. 가로 :   2. 세로 :
        결과값 출력     사각형 넓이 : 25
        첫화면으롱 이동.
        1~3이외의 값을 입력하면 잘못된 입력
        사각형넓이 : 1번 주고받고
        삼각형넓이 3번 안주고받고 ( 매개변수만 )
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("1. 사각형넓이 2.삼각형 넓이 3.종료 ");
        int num1 = sc.nextInt();


        if (num1 > 0 && num1 < 4) {

            while (true) {
                if (num1 == 1) {
                    int[] nums = input();
                    System.out.println( "사각형 넓이 : " +  rectangle(nums[0],nums[1]));
                } else if (num1 == 2) {
                    int[] nums = input();
                    riangle(nums[0],nums[1]);
                }
                else {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                System.out.println();
                System.out.println("1. 사각형넓이 2.삼각형 넓이 3.종료 ");
                num1 = sc.nextInt();
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
