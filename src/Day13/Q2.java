package Day13;

import java.util.Random;
import java.util.Scanner;

public class Q2 {
    
    // 낚시문제 정답코드
    static int fishMake(int[][] hosu, int fishcount){
        Random r = new Random();
        while(fishcount < 3) {
            int h = r.nextInt(5); // 행 랜덤
            int y = r.nextInt(5); // 열 랜덤
            if(hosu[h][y] == 0) {
                hosu[h][y] = 1;
                fishcount++;
            }
        }
        return fishcount;
    }
    static void printHosu(int[][] hosu,int[] user){
        for (int i = 0; i < hosu.length; i++)
        {
            for (int j = 0; j < hosu[i].length; j++)
            {
                if(user[0] == i && user[1] == j) {
                    System.out.print("❤");
                }
                else if (hosu[i][j] == 0)
                {
                    System.out.print("🟦");
                }
                else
                {
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }
    }
    static void fisherCasting(Scanner sc, int[]user){
        while(true) {
            System.out.print("행 입력 : ");
            user[0] = sc.nextInt();
            System.out.print("열 입력 : ");
            user[1] = sc.nextInt();
            if(user[0]>-1 && user[0]<5 && user[1]>-1 && user[1]<5) {
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        System.out.println(user[0]+","+user[1]);
    }

    static int fishCheck(int[][] hosu, int[] user, int fishcount){
        if(hosu[user[0]][user[1]] == 1) {
            System.out.println("물고기를 잡았습니다.");
            hosu[user[0]][user[1]] = 0;
            fishcount--;
        }
        return fishcount;
    }
    static void fisherMove(Scanner sc, int[] user){
        System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
        int num = sc.nextInt();
        if(num == 1) {
            user[0]--;
            if(user[0] < 0) {
                System.out.println("더이상 위로 움직일 수 없습니다.");
                user[0] = 0;
            }
        }
        else if(num == 2) {
            user[0]++;
            if(user[0] > 4) {
                System.out.println("더이상 아래로 움직일 수 없습니다.");
                user[0] = 4;
            }
        }
        else if(num == 3) {
            user[1]--;
            if(user[1]<0) {
                System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
                user[1]=0;
            }
        }
        else if(num == 4) {
            user[1]++;
            if(user[1]>4) {
                System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
                user[1]=4;
            }
        }
        else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //1. 5X5 호수 만들기
        int[][] hosu = new int[5][5];
        int[] user = {-1,-1};
        //2. Random을 통해서 호수에 값을 세팅
        int fishcount = 0;
        fishcount = fishMake(hosu,fishcount);
        printHosu(hosu,user);
        fisherCasting(sc, user);
        printHosu(hosu,user);
        fishcount=fishCheck(hosu,user,fishcount);
        //위, 아래, 왼쪽, 오른쪽
        while(fishcount > 0) {
            fisherMove(sc,user);
            //물고기 체크
            fishcount=fishCheck(hosu,user,fishcount);
            //출력
            printHosu(hosu,user);
        }
        System.out.println("물고기 게임을 종료합니다.");
    }
}
