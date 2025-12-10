package Day06;

public class ArrayTest {
    static void main() {
        int[] a = new int[5];  // 5개 정수를 담을 수 있는 배열을 생성하고 이름이 a
        int b[] = new int[5];  //  되긴 되는데 사용하지 말것!


        int[] kor = new int[100];
        for(int i=0; i<100; i++) {
            kor[i] = i+1;
        }  // 1~100까지 생성
        for(int i=0; i<100; i++) {
            System.out.println(kor[i]);
        }  // 1~100까지 출력

        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 40;
        a[4] = 50;
        // a[4] = 60; 에러
        System.out.println(a[0]);  // 10출력

    }
}
