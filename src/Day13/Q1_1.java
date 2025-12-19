package Day13;

import java.util.Scanner;
// 정답 코드
public class Q1_1 {
    static int[] inputUser(Scanner sc, int count){
        int[] user = new int[2];
        System.out.println("예약하실 좌석을 입력하세요(총 "+count+"석) : ");
        user[0] = sc.nextInt(); //행
        user[1] = sc.nextInt(); //열
        return user;
    }
    static int setRV(int[][] seat,int[] user, int count){
        //예약
        //seat[h-1][y-1] = 1;
        // seat[h-1][y-1] = seat[h-1][y-1] + 1;
        seat[user[0]-1][user[1]-1]++;
        count--;
        System.out.println(user[0]+"행, "+user[1]+"열 예약이 완료 됐습니다.");
        return count;
    }
    static void emptySeatPrint(int[][] seat){
        //비어있는 좌석
        for(int i = 0;i<seat.length;i++){ // 행 9
            for(int j = 0;j<seat[i].length;j++){ // 열 2
                if(seat[i][j] == 0){
                    System.out.println("비어있는 좌석 : "+(i+1)+" 행 "+(j+1)+"열");
                }
            }
        }
    }
    static int checkSeat(int[][] seat, int[] user,int count){
        if(user[0]>0 && user[0]<= seat.length && user[1]>0 && user[1]<= seat[0].length){
            if(seat[user[0]-1][user[1]-1] == 0){
                count=setRV(seat,user,count);
            }
            else{
                emptySeatPrint(seat);
            }
        }
        else{ // h < 1 거나 h >9  또는 y < 1 거나 y >2
            System.out.println("잘못된 입력입니다.");
        }
        return count;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        int[][] seat = new int[9][2]; // 초기값 0
        int count = 18;
        while(count > 0){
            count=checkSeat(seat,inputUser(sc,count),count);
        }
        //while을 탈출하면 예약이 끝나기 때문에 프로그램 종료 출력
        System.out.println("프로그램을 종료합니다.");
    }
}
