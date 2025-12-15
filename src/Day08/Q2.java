package Day08;

import java.util.Random;

public class Q2 {
    static void main() {
        /*
        배열크기가 10개인 배열을 만듦.
        그리고 각각의 배열안에 값이 0~10까지 랜덤수 추출
        배열안의 값 중에 가장 큰 값이 몇번째 index에 있는지 출력.
        단, 가장 큰 값이 같은 값이 있으면 index를 같이 출력.
         */
        Random r = new Random();
        int[] array = new int[10];
        int max = 0;





// 난수 발생
        for (int i = 0; i < array.length; i++){
            array[i] = r.nextInt(10);
            System.out.print(array[i]+ " ");
        }


        System.out.println();
        for (int i = 0; i < array.length; i++) {
                if ( array[i] > max) {
                    max = array[i];
                }
        }

        for (int i =0; i<array.length; i++) {
            if(max == array[i]) {
                System.out.println("index : " + i);
            }
        }




    }
}
