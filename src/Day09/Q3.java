package Day09;

import java.util.Random;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // 1. 5X5 호수 만들기
        int[][] hosu = new int[5][5];

        // 2. 물고기 개수를 저장할 변수 초기화
        int fishcount = 0;

        // 3. 물고기 3마리를 랜덤한 위치에 배치
        // 0~2까지 반복, 3부터 빠져나옴, fish가 3마리이니까 0,1,2까지 1을 넣고 나머지는 다 0
        while (fishcount < 3) {  // 물고기 총 3마리가 될때까지 반복
            int h = r.nextInt(5); // 행 랜덤 지역변수 0~4까지 난수발생
            int y = r.nextInt(5); // 열 랜덤 지역변수 0~4까지 난수발생

            if (hosu[h][y] == 0) { // 해당 위치에 물고기가 없을 경우만, 배열은 0으로 초기화 되기 때문에 즉, 아무것도 없다는걸 뜻함.
                // hosu[h][y] == null 을 사용할 수 없는건, int[][]이 참조자료형이긴 하지만 int[][]안의 값 자체는 기본자료형 int가 기본자료형이기때문,
                // 만약 참조자로형 즉 Integer[][] 또는 String[][] 사용할 수 있다.

                hosu[h][y] = 1;  // 물고기위치에 1를 배치 , 1이든 2이든 상관없이 그냥 값을 넣어주었다는걸 뜻함.
                // 보통 프로그래밍 관습상 "없음/거짓"은 0, "있음/참"은 1로 표현하는 경우가 많기 때문
                fishcount++;  // 물고기 수 증가
            }
        }

        // 4. 초기 호수 상태 출력 (물고기 위치 공개)
        // 첫화면 = 호수와 물고기 출력
        for (int i = 0; i < hosu.length; i++) {  // 행 반복
            for (int j = 0; j < hosu[i].length; j++) {  //  열 반복
                if (hosu[i][j] == 0) { // 물고기 없는 칸
                    System.out.print("🟦");  // 물 출력
                } else {
                    System.out.print("🐟"); // 물고기 출력, 물고기가 있는곳은 1이기때문에 0이 아닌 else문으로 들어옴.
                }
            }
            System.out.println();  // 개행
        }

        // 5. 사용자의 위치(좌표)를 저장하고 관리하기 위한 변수 선언.
        // 캐스팅
        int h; // 사용자 입력용 행 인덱스를 전역변수로 설정
        int y; // 사용자 입력용 열 인덱스를 전역변수로 설정

        // 6. 사용자 좌표 입력받기 (0~4 사이 유효성 검사 포함)
        // 잘못된 입력이면 반복해야하기 때문에 while문 사용.
        while (true) {
            System.out.print("행 입력 : ");
            h = sc.nextInt();  // 행
            System.out.print("열 입력 : ");
            y = sc.nextInt();  // 열
            if (h > -1 && h < 5 && y > -1 && y < 5) {  // 0~4까지 5x5배열이기 때문에 인덱스가 0,1,2,3,4
                break;   // 입력을 올바르게 했으니 입력 종료
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }


        System.out.println(h + "," + y);  // 입력 좌표 출력


        // 7. 사용자 현재 위치를 출력(하트로 표시)
        /*
        h = 1, y = 1 일때
        i = 0 =>  j = 0 , j = 1 , j = 2 ,j = 3, j = 4
        i = 1 =>  j = 0, j = 1 !!! ❤
        */
        for (int i = 0; i < hosu.length; i++) {  // 5x5 호수의 행 반복
            for (int j = 0; j < hosu[i].length; j++) {  // 5x5 호수의 열 반복
                if (h == i && y == j) {  // 사용자 현재 위치(행,열)와 i, j 가 같으면, 즉 사용자 위치와 호수의 행열이 같으면!
                    System.out.print("❤"); // 하트로 표시
                } else if (hosu[i][j] == 0) {  // 0이면 물만 있는 곳
                    System.out.print("🟦");
                } else {  // 물고기 있는곳
                    //  나머지는 hosu[h][y] = 1; 인곳에 물고기 출력
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }

        // 8. 게임을 시작하자마자 사용자가 입력한 첫 좌표에 우연히 물고기가 있을 경우, 즉 현재 입력한 위치에 물고기가 있는지 확인
        // 사용자가 입력한 h, y로 호수배열 위치에 물고기가 있는지,
        if (hosu[h][y] == 1) {    // 현재 위치에 물고기가 있다면
            System.out.println("물고기를 잡았습니다."); // 잡았다고 출력
            hosu[h][y] = 0;       // 물고기를 잡았으니 해당 위치에 0을 넣어 물고기 제거
            // 이때는 현재 fishcount는 = 3인데, 잡고나서는 fishcount를 --해야함.
            fishcount--;    // 남은 물고기 수 감소
            // 물고기를 잡았으니  fishcount--; 라는 뜻
        }

        // 9. 나머지 물고기 잡기 시작 (반복)
        // 물고기를 잡지 않았으면 여전히 fishcount=3 이기 때문에 이동 반복.
        // 위, 아래, 왼쪽, 오른쪽
        while (fishcount > 0) {  // 남은 물고기가 있을 동안 계속
            System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
            int num = sc.nextInt();  // 방향 입력

            // 10. 방향 이동 처리
            if (num == 1) { // 입력한 번호가 1이면 위로 
                // 위로 올라가 행--
                h--;
                if (h < 0) {  // 배열의 범위를 벗어났을 경우(호수 밖으로 나감) 처리 로직
                    // 행이 0보다 작으면 안됨
                    System.out.println("더이상 위로 움직일 수 없습니다.");
                    h = 0;  // 입력을 다시 원래 위치로이동하는 역할 (이동 제한)
                    // 즉, 넘어가지 못하게 경계선 끝에 딱 붙여놓는 것. h = 0이면 맨 위쪽
                }
            } else if (num == 2) { // 입력한 번호가 2이면 아래
                // 아래로 내려가므로 행++
                h++;
                if (h > 4) { // 배열의 범위를 벗어났을 경우(호수 밖으로 나감) 처리 로직
                    // 행이 4이상 일 수 없음
                    System.out.println("더이상 아래로 움직일 수 없습니다.");
                    h = 4; // 넘어가지 못하게 경계선 끝에 딱 붙여놓는 것. h = 4이면 맨 아래쪽
                }
            } else if (num == 3) {  // 입력한 번호가 3이면 왼쪽
                // 왼쪽으로 이동 y--
                y--;
                if (y < 0) { // 배열의 범위를 벗어났을 경우(호수 밖으로 나감) 처리 로직
                    // y 가 -1이 될수 없음.
                    System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
                    y = 0; // 넘어가지 못하게 경계선 끝에 딱 붙여놓는 것. y = 0이면 맨 왼쪽
                }
            } else if (num == 4) { // 입력한 번호가 4이면 오른쪽
                // 오른쪽으로 이동 y++
                y++;
                if (y > 4) { // 배열의 범위를 벗어났을 경우(호수 밖으로 나감) 처리 로직
                    // y는 4이상일 수 없음
                    System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
                    y = 4;  // 넘어가지 못하게 경계선 끝에 딱 붙여놓는 것.
                    // 호수의 마지막 칸을 넘어가지 못하게 막는 '안전장치' y = 4는 오른쪽 맨 끝 칸
                }
            } else {
                // 입력 번호 1.2.3.4 범위 넘으면,
                System.out.println("잘못된 입력입니다.");
            }


            // 11. 이동한 위치에 물고기 있는지 확인
            //움직이면 h++ h-- y++ y--로 변함 hosu[h][y]가 변함. 거기에 1이 있으면, 0으로 바꾸고 물고기카운트 --;
            if (hosu[h][y] == 1) { // 이동한 좌표(h, y) 칸의 값이 1(물고기)이라면
                System.out.println("물고기를 잡았습니다.");
                hosu[h][y] = 0; // 잡은 물고기는 호수에서 제거(0으로 변경)
                fishcount--; // 남은 전체 물고기 마릿수를 1 감소
            }

            // 12. 현재 호수 상태 출력
            // 사용자가 한 칸 이동할 때마다 호수의 전체 모습과 내 위치(❤)를 새로 그려줌
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
        // 13. 모든 물고기를 잡은 경우 프로그램 종료 출력
        System.out.println("물고기 게임을 종료합니다.");


    }
}
