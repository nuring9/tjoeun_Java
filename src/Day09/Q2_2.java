package Day09;

import java.util.Scanner;

public class Q2_2 {
    static void main() {
  /*
        좌석 총 18자리, 두 값을 입력 받음. 9행2열, 예약좌석이 0이되면 프로그램 종료
        아무도 예약을 하지않을 시 예약 완료 (배열이 비어있을 경우?)

        "예약하실  좌석을 입력해주세요 (총 18석) : "
        1 입력하면, "1행"
        1 입력하면, "1열"
        "[i]행, [j]열 예약이 완료되었습니다."


        "[i]행, [j]열 예약이 완료된 자리입니다. 다시 예약해주세요."
        "비어있는 좌석 : [i]행[j]열 "
        "예약하실  좌석을 입력해주세요 (총 18석) : "
        1 입력하면, "1행"
        1 입력하면, "1열"
        "[i]행, [j]열 예약이 완료되었습니다."


        "범위가 벗어 났습니다. "
        "프로그램 종료!!"
         */
        int[][] seat = new int[9][2];
        Scanner sc = new Scanner(System.in);
        int count = 18;


        while (count > 0) { // 0이 될때까지 반복.
            System.out.println("예약하실 좌석을 입력해주세요 (총" + count + "석) : ");
            int h = sc.nextInt();  // 행 1~9
            System.out.println( h + "행");
            int y = sc.nextInt();  // 열 1~2
            System.out.println( y + "열");

            if (h > 0 && h <= seat.length && y > 0 && y <= seat[0].length) {
                if (seat[h - 1][y - 1] == 0) {
                    // 예약
                    seat[h - 1][y - 1]++; //  seat[h-1][y-1] = 1;
                    count--;
                    System.out.println(h + "행, " + y + "열 예약이 완료되었습니다.");
                } else {
                    // 비어있는 좌석
                    for (int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat[j].length; j++) {
                            if (seat[i][j] == 0) {
                                System.out.println("비어있는 좌석 : " + (i + 1) + " 행 " + (j + 1) + "열");
                            }
                        }
                    }
                }
            } else {
                // h < 1 거나 h > 9  또는 y < 1 거나 y > 2
                System.out.println("잘못된 입렵입니다.");
            }

        }
        // while문을 탈출하면 예약이 끝나기 때문에 프로그램 종료 출력.
        System.out.println("프로그램을 종료합니다.");
    }
}
