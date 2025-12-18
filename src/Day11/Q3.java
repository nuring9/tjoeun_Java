package Day11;

import java.util.Random;
import java.util.Scanner;

public class Q3 {

    // 낚시 문제 메소드화 하기
    //  직접 풀다가 중단함 . 

//    static void wrongCheck(int[] score){
//        if(score[0] >=0 && score[0] <=100 && score[1] >=0 && score[1] <=100
//                && score[2] >=0 && score[2] <=100 ){
//            double avg = hakjumOP(score[0],score[1],score[2]);
//            String hakjum = grade(avg);
//            resultPrint(avg,hakjum);
//        }
//        //2. 올바르지 않은 입력
//        else{
//            wrongPrint();
//        }
//    }

    //1. 5X5 호수 만들기
    static int[][] hosu() {
        return new int[5][5];
    }


    static int  fishcount() {
        int fish = 0;
        return fish;
    }

    //2. Random을 통해서 호수에 값을 세팅
    static int[][] random(int fish) {
        int[][] ren_hosu = hosu();
        Random r = new Random();

        while (fish < 3) {
            int h = r.nextInt(5); // 행 랜덤 지역변수 0~4까지 난수발생
            int y = r.nextInt(5); // 열 랜덤 지역변수 0~4까지 난수발생

            if (ren_hosu[h][y] == 0) {
                ren_hosu[h][y] = 1;
                fish++;
            }
        }
        return ren_hosu;
    }

    // 첫화면 = 호수와 물고기 출력
    static void output() {
        int[][] hosu = random(fishcount());
        for (int i = 0; i < hosu.length; i++) {
            for (int j = 0; j < hosu[i].length; j++) {
                if (hosu[i][j] == 0) {
                    System.out.print("🟦");
                } else {
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }
        input();
    }

    // 행열 입력, 잘못된 입력 확인
    static void input() {
        Scanner sc = new Scanner(System.in);
//        boolean roop = tf;
        int[] hy = new int[2];
        while (true) {
            System.out.print("행 입력 : ");
            hy[0] = sc.nextInt();
            System.out.print("열 입력 : ");
            hy[1] = sc.nextInt();
            // 잘못된 입력
            if (hy[0] > -1 && hy[0] < 5 && hy[1] > -1 && hy[1] < 5) {
                // user(hy);
                break;
            }
            //2. 올바르지 않은 입력
            else {
                wrongPrint();
            }
        }

    }

    // 내 위치 출력.
    static void user(int[] hy, int fish) {
        int[][] hosu = random(fishcount());

        for (int i = 0; i < hosu.length; i++) {
            for (int j = 0; j < hosu[i].length; j++) {
                if (hy[0] == i && hy[1] == j) {
                    System.out.print("❤");
                } else if (hosu[i][j] == 0) {
                    // 전부 0이면
                    System.out.print("🟦");
                } else {
                    //  hosu[h][y] = 1;
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }
        get(hy,fish);
    }


    // h, y 입력 후  물고기 확인
    static void get(int[] hy, int fish) {
        user(hy,fish);
        int[][] hosu = random(fishcount());
        System.out.println("물고기를 잡았습니다.");
        hosu[hy[0]][hy[1]] = 0;
        fish--;
    }








    // 캐스팅
    static void move() {
        //위, 아래, 왼쪽, 오른쪽
        // 위로 올라가 행--
        // 아래로 내려가므로 행++
        // 왼쪽으로 이동 y--
        // 오른쪽으로 이동 y++
    }




    static void wrongPrint() {
        System.out.println("잘못된 입력입니다.");
    }

    // 종료
    static void end() {
        System.out.println("물고기 게임을 종료합니다.");
    }

    public static void main(String[] args) {
//      wrongCheck(input());
        output();

    }
}

