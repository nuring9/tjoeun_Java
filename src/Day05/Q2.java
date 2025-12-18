package Day05;

import java.util.Scanner;

public class Q2 {
    static void main() {
//         1. 원하는 구구단 출력 2. 전체 구구단 출력 3. 종료 / 텍스트 반복
//         2. 1번을 선택 -> 원하는 구구단만 출력 , 잘못된 입력도 출력
//         3. 2번을 선택 -> 전체 구구단 출력 , 잘못된 입력도 출력
//         4. 3번을 선택 -> 종료
//         5. 1,2,3 이외의 숫자를 입력하면 잘못된 입력입니다. 출력 후 다시 첫화면으로 이동.
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 원하는 구구단 출력");
            System.out.println("2. 전체 구구단 출력");
            System.out.println("3. 종료");
            int num = sc.nextInt();
            if (num == 1 ) {
                System.out.print("원하는 구구단 : ");
                int dan = sc.nextInt();
                   System.out.println();
                if (dan >=2 && dan <= 9) {
                 for(int i = 1; i <= 9; i++){
                        System.out.println(dan + "X" + i +"=" + (dan * i));
                    }
                    System.out.println();
                }else {
                    System.out.println("잘못된 입력입니다.");
                }

            } else if(num == 2) {
                for(int dan = 2; dan <= 9; dan++) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(dan + "X" + i +"=" + (dan * i));
                    }
                    System.out.println();
                }
            }  else if(num == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }

/*
               if ( num1 == 2) {

                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 3 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 4 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 5 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 6 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 7 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 8 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
                } else if ( num1 == 9 ) {
                    for(int i = 1; i <= 9; i++){
                        System.out.println(num1 + "X" + i +"=" + (num1 * i));
                    }
                    System.out.println();
               } else {
                    System.out.println("잘못된 입력입니다.");
               }

 */
    }
}

