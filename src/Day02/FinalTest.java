package Day02;

public class FinalTest {
    static void main() {
        final int MAX_NUM = 100;  // 변수와 값을 넣으면 초기화
        final  int MIN_NUM;  // 변수 선언

        MIN_NUM = 0;  // 값 대입

        System.out.println(MAX_NUM);
        System.out.println(MIN_NUM);

        // MAX_NUM = 1000; 상수는 값을 변경할 수 없으므로, 이코드를 입력하면 오류 발생
        // MIN_NUM = 30;
    }
}
