package Day09;

import java.util.Random;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        //1. 5X5 호수 만들기
        int[][] hosu = new int[5][5];

        //2. Random을 통해서 호수에 값을 세팅
        int fishcount = 0;

        // 0~2까지 반복, 3부터 빠져나옴, fish가 3마리이니까 0,1,2까지 1을 넣고 나머지는 다 0
        while (fishcount < 3) {
            int h = r.nextInt(5); // 행 랜덤 지역변수 0~4까지 난수발생
            int y = r.nextInt(5); // 열 랜덤 지역변수 0~4까지 난수발생

            if (hosu[h][y] == 0) {
                hosu[h][y] = 1;
                fishcount++;
            }
        }

        // 첫화면 = 호수와 물고기 출력
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

        //캐스팅
        int h; // 전역 변수
        int y; // 전역 변수
        while (true) {
            System.out.print("행 입력 : ");
            h = sc.nextInt();
            System.out.print("열 입력 : ");
            y = sc.nextInt();
            if (h > -1 && h < 5 && y > -1 && y < 5) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println(h + "," + y);


        // 내 위치 출력.
        /*
        h = 1, y = 1 일때
        i = 0 =>  j = 0 , j = 1 , j = 2 ,j = 3, j = 4
        i = 1 =>  j = 0, j = 1 !!! ❤
        */
        for (int i = 0; i < hosu.length; i++) {
            for (int j = 0; j < hosu[i].length; j++) {
                if (h == i && y == j) {
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

        // 처음 h, y 입력 후  물고기 확인
        if (hosu[h][y] == 1) {
            System.out.println("물고기를 잡았습니다.");
            hosu[h][y] = 0;
            // 이때 fishcount는 = 3임.
            fishcount--;
            // 물고기를 잡았으니  fishcount--;
        }

        // hosu[h][y] == 1 아니면 그대로 fishcount=3 이기 때문에 이동 반복.
        //위, 아래, 왼쪽, 오른쪽
        while (fishcount > 0) {
            System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
            int num = sc.nextInt();
            if (num == 1) {
                // 위로 올라가 행--
                h--;
                if (h < 0) {
                    // 행이 0보다 작으면 안됨
                    System.out.println("더이상 위로 움직일 수 없습니다.");
                    h = 0;  // 다시 원래 위치
                }
            } else if (num == 2) {
                // 아래로 내려가므로 행++
                h++;
                if (h > 4) {
                    // 행이 4이상 일 수 없음
                    System.out.println("더이상 아래로 움직일 수 없습니다.");
                    h = 4;
                }
            } else if (num == 3) {
                // 왼쪽으로 이동 y--
                y--;
                if (y < 0) {
                    // y 가 -1이 될수 없음.
                    System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
                    y = 0;
                }
            } else if (num == 4) {
                // 오른쪽으로 이동 y++
                y++;
                if (y > 4) {
                    // y는 4이상일 수 없음
                    System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
                    y = 4;
                }
            } else {
                // 1.2.3.4 범위 넘으면,
                System.out.println("잘못된 입력입니다.");
            }

            //움직이면 h++ h-- y++ y--로 변함 hosu[h][y]가 변함. 거기에 1이 있으면, 0으로 바꾸고 물고기카운트 --;
            if (hosu[h][y] == 1) {
                System.out.println("물고기를 잡았습니다.");
                hosu[h][y] = 0;
                fishcount--;
            }

            //출력
            for (int i = 0; i < hosu.length; i++) {
                for (int j = 0; j < hosu[i].length; j++) {
                    if (h == i && y == j) {
                        System.out.print("❤");
                    } else if (hosu[i][j] == 0) {
                        System.out.print("🟦");
                    } else {
                        System.out.print("🐟");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("물고기 게임을 종료합니다.");


    }
}
