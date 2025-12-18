package Day12;

import java.util.Scanner;

public class Q2 {
    /*
    내가 풀다 중단한 것. 나중에 다시 코드 만들어보기.

      첫화면
      1. 구구단 출력
      2. 별찍기 출력
      3. 종료

      1번 입력시
      1. 원하는 구구단 출력
      원하는 구구단을 입력하세요 :
      2. 전체 구구단 출력

      2번 입력시
      1. 네모
      2. 직삼각형 정방향
      3. 직삼각형 역방향
      4. 피라미드
      5. 다이아몬드

      무조건 실행 이후에 첫화면 이동
      잘못된 번호 입력시 잘못된 입력 출력 함수화
      => 메인문 1~2줄 입력 출력 연산 관련 분기
       */

    static void first() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 구구단출력");
            System.out.println("2. 별찍기 출력");
            System.out.println("3. 종료");
            int num = sc.nextInt();
            if (num == 1) {
                gugu();
            } else if (num == 2) {
                star();
            } else if (num == 3) {
                end_print();
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    static void gugu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 원하는 구구단 출력: ");
        System.out.println("2. 전체 구구단 출력: ");
        int num = sc.nextInt();

        while (true) {
            if (num == 1) {
                choice_gu();
                break;
            } else if (num == 2) {
                full_gu();
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                first();
            }
        }
    }


    static void choice_gu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 구구단을 입력하세요: ");
        int dan = sc.nextInt();
        if (dan >= 2 && dan <= 9) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + "X" + i + "=" + (dan * i));
            }
        } else {
            System.out.println("잘못된 입력입니다.");
            gugu();
            first();

        }
        System.out.println();

    }

    static void full_gu() {

        for (int dan = 2; dan <= 9; dan++) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + "X" + i + "=" + (dan * i));
            }
            System.out.println();
        }

    }


    static void end_print() {
        System.out.println("프로그램을 종료합니다.");
    }


    static int star() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 네모");
        System.out.println("2. 직삼각형 정방향");
        System.out.println("3. 직삼각형 역방향");
        System.out.println("4. 피라미드");
        System.out.println("5. 다이아몬드");
        int num2 = sc.nextInt();
        return num2;
    }

    static void square() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void right_triangle1() {
        for (int i = 0; i < 5; i++) { // 0 1 2 3 4
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void right_triangle2() {
        for (int i = 0; i < 10; i++) {
            //스페이스를 4 3 2 1 0
            for (int j = 0; j < 10 - 1 - i; j++) {
                System.out.print(" ");
            }
            //별 1 2 3 4 5
            for (int k = 0; k <= i; k++) { // 0 /0 1 2/ 0 1 2 3 4
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pyramid() {
        for (int i = 0; i < 10; i++) {
            //스페이스를 4 3 2 1 0
            for (int j = 0; j < 10 - 1 - i; j++) {
                System.out.print(" ");
            }
            //별 1 2 3 4 5
            for (int k = 0; k <= i; k++) { // 0 /0 1 2/ 0 1 2 3 4
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void diamond() {
        for (int i = 0; i < 11 / 2 + 1; i++) {
            //스페이스를 4 3 2 1 0
            for (int j = 0; j < (11 / 2 + 1) - 1 - i; j++) {
                System.out.print(" ");
            }
            //별 1 2 3 4 5
            for (int k = 0; k <= i * 2; k++) { // 0 // 2(0,1,2) // 4(0,1,2,3,4)  // 6(0,1,2,3,4,5,6) // 8(0,1,2,3,4,5,6,7,8)
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 11 / 2; i++) { // 4
            for (int j = 0; j <= i; j++) { // 0 // 0 1
                System.out.print(" ");
            }

            for (int k = 0; 11 - 2 * (i + 1) > k; k++)//9   0  9 - 2*1 7 9 - 2*2 5
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void shape(int num2) {
        int choo = num2;
        if (choo == 1) {
            square();
        }  else if (choo == 2) {
            right_triangle1();
        } else if (choo == 3) {
            right_triangle2();
        } else if (choo == 4) {
            pyramid();
        } else if (choo == 5) {
            diamond();

        } else {
            System.out.println("잘못된 입력입니다.");
        }

    }

    static void main() {

        first();

    }
}
