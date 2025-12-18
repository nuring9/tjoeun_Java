package Day12;

public class StaticTest {
   static int a;
   static int b;
   // 전역변수



    static void main() {
        int a;
        int b;
        a = 10;  // main
        // 이름이 같으면 전역변수 a는 main 안에서 사용할 수 없다.
        // 그러므로 같은 이름의 변수를 사용하지 말아야 한다.
    }
}
