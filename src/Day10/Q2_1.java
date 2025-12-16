package Day10;

import java.util.Scanner;

public class Q2_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 입력 : ");
        int num = sc.nextInt();

        int[][] arr = new int[num][num];

        int R = 0; // 행
        int C = -1; //열
        int K = num; // 반복횟수
        int SW = 1; // 증감
        int N = 1; // 값

        while(true) {
            //1. 열
            for(int i =0; i<K; i++) {
                C += SW;
                arr[R][C] = N++;
            }

            K--;
            //탈출
            if (K == 0) {
                break;
            }

            //2. 행
            for(int j = 0; j<K; j++) {
                R += SW;
                arr[R][C] = N++;
            }
            SW *= -1;
        }



        for(int i =0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
