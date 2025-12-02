package Day02;

public class OPTest {
    static void main() {
        int a = 10; //   대입연산자
        int b = a + 5; //   + 더하기
        int c = b - 3; //   - 빼기
        int d = c * 4; //   * 곱하기
        int e = d / 2;  //   / 몫
        int f = 5 % 3;  //  % 나머지
        System.out.println(f);  // 2
        System.out.println(a++);  // 10
        // 11
        System.out.println(++a);  // 12
        System.out.println(a--);  // 12
        // 11
        System.out.println(--a);  // 10
    }
}
