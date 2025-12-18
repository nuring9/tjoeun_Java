package Day12;

import java.util.Random;
import java.util.Scanner;

public class Q3_1 {
    // 숫자 야구 게임 2



    static void makeRandom(int[] com, Random r) {
        // 1. 랜덤값 생성
        for (int i = 0; i < com.length; i++) {
            com[i] = r.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {  // 중복 없이
                if (com[i] == com[j]) {
                    i--;
                    break;
                }

            }
        }
    }

    static void randomPrint(int[] com) {
        // 2. 랜덤값 출력
        for (int i = 0; i < com.length; i++) {
            System.out.println(com[i] + " ");
        }
        System.out.println();
    }


    static int[] inputUser(Scanner sc) {
        // 3. 유저의 값 입력
        int[] user = new int[3];

        for (int i = 0; i < user.length; i++) {
            System.out.print((i + 1) + "번째 : ");
            user[i] = sc.nextInt();

            if (user[i] < 1 || user[i] > 9) {
                i--;
                continue; // 1~9까지 입력 시 올바르게 입력했기 때문에 continu로 for문 처음으로 감. 출력 ok.
            }



            for (int j = 0; j < i; j++) {
                if (user[i] == user[j]) {
                    i--;
                    break;
                    // i와 j를 비교하여 같으면 중복임, 그럼 i--로 되돌아가고 break로 안쪽 for문나오고 첫번째 for문으로 다시 감.
                    // i와 j가 같지 않으면 이 for문은 생략.
                }
            }
        }
        return user;
    }


    static int[] checkSB(int[] user, int[] com) {
        // com 은 main문의 com
// 4. strike ball
        int[] result = new int[2];
        // 0 으로 초기화 되있음.

        for(int i = 0; i<user.length; i++){
            for(int j = 0; j<com.length; j++){

                if(user[i] == com[j]) {
                    // user의 값과 com의 값을 비교해서 같으면,
                    if(i == j) {
                        // user와 com의 자릿 수가 같으면
                        result[0]++;
                        //result[0]에는 strike 값을 ++  1번 strike면 0 -> 1로 됨.
                    } else {
                        // 자릿수가 같지 않으면
                        result[1]++;
                        // result[1]에는 ball 값을 ++
                    }
                }
            }
        }
        return result;
        // 카운팅 된 스트라이크와 볼을 리턴.
    }


    static boolean resultPrint(int[] result) {
  // 5. 계산 결과 출력
        if (result[0] == 3) {
            // [0]에는 strike가 있고, 이 값이 3이면 홈런
            System.out.println("홈런입니다.");
            return false;
        } else if(result[0] == 0 && result[1] == 0) {
            // [0] strike가 0 이면서, [1] ball 이 0이면 Out.
            System.out.println("Out입니다.");
        } else {
            // strike가 3이 아니거나, 모두 0이여서 out 아니거나, 나머지는 전부 아래로 출력
            System.out.println("strike : " + result[0] + ", ball : " + result[1]);
        }
        return true;
    }


    static void main() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] com = new int[3];
        boolean check = true;
        makeRandom(com,r);
        // 랜덤값 생성
        randomPrint(com);
        // 랜덤값 출력

        while (check) {
            // true로 무한 루프 .
            int[] user = inputUser(sc);
            // user 입력 반복
            int[] result = checkSB(user, com);
            // 홈런, 볼 반복 카운팅
            check = resultPrint(result);
            // 홈런, 아웃 여부 와 카운팅 결과 출력 후
            //check에 resultPrint 값을 재정의로, 홈런이면 false로 바뀌기 때문에 while문 탈출.
        }
    }
}
