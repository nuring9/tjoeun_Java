package Day13;

import java.util.Scanner;
/*
   비행기 예약 시스템 만들기 함수화 해주세요.
   함수화를 진행 해 주세요.
   단, 배열관련 함수가 하나 이상 존재해야 합니다.

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
   "프로그램 종료!!
*/
public class Q1 {
// 내가 푼 문제 나중에 해결하기 카운팅이 안됨 input에서
    /*
    해결
    first_sc 첫화면을 분리했고, input에 first_sc(count) 호출만하고 user를 재정의를 못했음
    user = first_sc(count); 이렇게 해야함.
     */

    static int[] first_sc( int count  ) {
        Scanner sc = new Scanner(System.in);
        int[] user = new int[2];
        System.out.println("예약하실 좌석을 입력 해주세요 (총 " + count + "석)");
        System.out.print("행 : ");
        user[0] = sc.nextInt();
        System.out.print("열 : ");
        user[1] = sc.nextInt();

        // 좌석 행,열
       return user;
    }


    static void input( int[][] seat, int count ) {
        int[] user; // user 배열을 생성, 빈값(0)으로 초기화

        // 좌석 행,열
        while (count > 0) {
            user = first_sc(count);  // 매번 새 값을 저장
            System.out.println(count);
            if (user[0] > 0 && user[0] <= seat.length && user[1] > 0 && user[1] <= user.length) {
             if(seat[user[0]-1][user[1]-1] == 0) {
                 count =  reservation(user,seat,count);
             }else{
                 empty(seat);
             }
            } else {
                wrong();
            }

        }
        System.out.println("프로그램을 종료합니다.");
    }


    static int reservation(int[] user,  int[][] seat, int count ) {

            // 예약
            seat[user[0] - 1][user[1] - 1]++;
            count--;
            System.out.println(user[0] + "행, " + user[1] + "열 예약이 완료 되었습니다.");

        return count;
    }


    static void empty( int[][] seat  ) {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[j].length; j++) {
                if (seat[i][j] == 0) {
                    System.out.println("비어있는 좌석 : " + (i + 1) + "행 " + (j + 1) + "열");
                }
            }
        }
    }

    static void wrong() {
        System.out.println("잘못된 입력입니다.");
    }


    static void main() {
        int[][] seat = new int[9][2];
        int count = 18;

        input(seat, count);


    }
}
