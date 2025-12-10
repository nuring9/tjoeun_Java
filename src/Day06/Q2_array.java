package Day06;

import java.util.Random;

public class Q2_array {
    static void main() {
        // 정답

        int[] num = new int[3];
        Random r = new Random();

        num[0] = r.nextInt(9) + 1;
        num[1] = r.nextInt(9) + 1;
        num[2] = r.nextInt(9) + 1;

        while (num[0] == num[1] || num[0] == num[2] || num[1] == num[2]) {

            num[0] = r.nextInt(9) + 1;
            num[1] = r.nextInt(9) + 1;
            num[2] = r.nextInt(9) + 1;
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(num[i] + " ");
        }


        // for문으로 중복 제거 하는 방법.

        int[] com1 = new int[3];
        for (int i = 0; i < 3; i++) {
            com1[i] = r.nextInt(9) + 1;
            for(int j = 0; j<i; j++) {
                if(com1[i] == com1[j]) {
                  i--;
                  break;
                }
            }
        }
    }
}
