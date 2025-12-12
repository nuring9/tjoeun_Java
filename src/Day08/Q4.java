package Day08;

import java.util.Random;

public class Q4 {
    static void main() {
        /*
         배열의 크기가 5인 배열
         랜덤으로 1~9까지 값을 각 배열에 저장.
         같이 값이 들어갈 수 없음
         각각 다른 값으로 배열 5개의 값을 랜덤으로 채움.
         이렇게 랜덤 값을 채워 준 뒤에 값을 오름차순으로 정렬
         */

        Random r = new Random();
        int[] array = new int[5];
        int max = 0;
        int min = 0;

        // 중복없이 난수 발생
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(9) + 1;  // 1~9까지
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.print("정렬 전 : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

// 삽입정렬 알고리즘 사용. 선택한 i와 돌아가는 j를 비교

// j = i+1; 했을 경우
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i+1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    max = array[i];
//                    array[i] = array[j];
//                    array[j] = max;
//                }
//            }
//        }

// j = 0; 했을 경우
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) { // 현재 값(i)이 더 작은데 뒤에 있으므로 앞쪽(j)과 교환해
                    min = array[i];
                    array[i] = array[j];
                    array[j] = min;
                }
            }
        }
        System.out.println();

        System.out.print("정렬 후 : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }
}
