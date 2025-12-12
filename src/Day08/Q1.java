package Day08;

import java.util.Scanner;

public class Q1 {
    static void main() {
           /*
        1. 직사각형
        2. 정직삼각형
        3. 역직삼각형
        4. 피라미드
        5. 다이아몬드
        6. 종료 (종료 아니면 나머지 무한루프)
        숫자를 입력하세요: 10
         */
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (true) { //num1 < 0 || num1 > 6
            System.out.println("1. 직사각형");
            System.out.println("2. 정직삼각형");
            System.out.println("3. 역직삼각형");
            System.out.println("4. 피라미드");
            System.out.println("5. 다이아몬드");
            System.out.println("6. 종료");
            num = sc.nextInt();

            if (num == 1) {
                System.out.println("숫자 입력 : ");
                int star = sc.nextInt();
                if (star < 1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } else {
                    for (int i = 1; i <= star; i++) {
                        for (int j = 1; j <= star; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                }
            } else if (num == 2) {
                System.out.println("숫자 입력 : ");
                int star = sc.nextInt();
                if (star < 1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } else {
                    for (int i = 0; i < star; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                }
            } else if (num == 3) {
                System.out.println("숫자 입력 : ");
                int star = sc.nextInt();
                if (star < 1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } else {
                    for (int i = 0; i < star; i++) {
                        //스페이스를 4 3 2 1 0
                        for (int j = 0; j < star - 1 - i; j++) {
                            System.out.print(" ");
                        }
                        //별 1 2 3 4 5
                        for (int k = 0; k <= i; k++) { // 0 /0 1 2/ 0 1 2 3 4
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
            } else if (num == 4) {
                System.out.println("숫자 입력 : ");
                int star = sc.nextInt();
                if (star < 1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } else {
                    for (int i = 0; i < star; i++) {
                        for (int j = 0; j < star - 1 - i; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 0; k <= i * 2; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                }
            } else if (num == 5) {
                System.out.println("숫자 입력 : ");
                int star = sc.nextInt();
                if (star < 1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } else {
                    for (int i = 0; i < star / 2 + 1; i++) {
                        //스페이스를 4 3 2 1 0
                        for (int j = 0; j < (star / 2 + 1) - 1-i; j++) {
                            System.out.print("  ");
                        }
                        //별 1 2 3 4 5
                        for (int k = 0; k <= i * 2; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < star / 2; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("  ");
                        }
//                        for (int k = star-(i+1)*2; k>0; k--) {
//                            System.out.print("* ");
//                        }

//                        for (int k = star-2; k-(i*2)>0; k--) {
//                            System.out.print("* ");
//                        }
                        for (int k = 0; star - 2 * (i+1) > k; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                }
            } else if(num == 6){
                System.out.println("프로그램을 종료");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}


