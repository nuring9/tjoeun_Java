package Day07;

import java.util.Random;
import java.util.Scanner;

public class Q2_array_2 {
    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] com = new int[3];


        // com 중복없이 난수 발생.
        for (int i = 0; i < 3; i++) {
            com[i] = r.nextInt(9) + 1;  // 배열에 1~9까지 난수 생성
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                    break;
                }
            }
        }

        // com 출력
        System.out.print("Com : ");
        for (int i = 0; i < 3; i++) {
            System.out.print(com[i]);
        }
        System.out.println();


        // 유저 입력 받을 배열생성
        // 0으로 초기화 해야 무한 루프를 막음
        int[] user = new int[3];
        int strike = 0;
        int ball = 0;

        // strike가 3이 아니면 반복
        while (strike != 3) {
            // 반복할 때 다시 0이 되야 while문 시작.
            strike = 0; // 다시 확인할 때 초기화
            ball = 0;   // 다시 확인할 때 초기화

            // user가 3자리 1~9 사이 숫자 중복없이 입력 생성
            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + "번 숫자 : ");
                user[i] = sc.nextInt();

                // 1 보다 작거나 9보다 크면 다시 입력해야하므로, i--를 함.
                // 애초에 범위 바깥 숫자라 중복확인 필요없어서 continue로 처음 for문으로 올라감. (아래 for문이 중복 확인하는 코드)
                if (user[i] < 1 || user[i] > 9) {
                    i--;
                    continue;
                }

                // 중복확인 하는 코드.
                // [0]일때 첫번째자리는 중복확인이 필요없음. 그러므로 j<i로 i가 1일때 j가 작아야하므로 0이랑 비교
                // 비교해서 값이 같으면 i를 --해서 다시 입력할수 있도록 돌아감. break를 만나서 처음 for문으로 이동.
                for (int j = 0; j < i; j++) {
                    if (com[i] == com[j]) {
                        i--;
                        break;
                    }
                }
            }


            // strike ball 계산
            // user가 0일때 com[0],com[1],com[2] 비교
            // user 1일때 com[0],com[1],com[2] 비교
            // user 2일때 com[0],com[1],com[2] 비교
            // user[i] com[j]랑 비교해서 숫자가 같으면 (회전이 돌면서 값이 같으면)
            // i랑j가(배열자릿수) 같으면 strike++, 틀리면 ball++
            for (int i = 0; i < 3; i++) {       // user
                for (int j = 0; j < 3; j++) {   // com
                    if (user[i] == com[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }


            // 출력
            if (strike == 3) {
                System.out.println("홈런 입니다.");
            } else if (strike == 0 && ball == 0) {
                System.out.println("Out 입니다.");
            } else {
                System.out.println("strike : " + strike + ", ball : " + ball);
            }

        }
    }
}