package Day10;

public class StaticTest {

    static int a;  // 전역변수 전체 사용 가능
    static int b;

    static void add() {
        System.out.println(a + b);
    }

    static void main() {
        add(); // 0
        a = 20;
        b = 30;
        add(); // 50
    }
}
