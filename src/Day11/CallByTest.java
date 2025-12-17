package Day11;

public class CallByTest {

    // call by value
    static void abc (int a) {
        a = 20;
    }

    // call by reference
   static void def(int[] b) {
        b[0] = 20;
    }
    // 정의하다(define) def

    static void main() {
        int a = 10;
        abc(a);
        System.out.println(a);

        int[] b = new int[2];
        def(b);
        System.out.println(b[0]);
    }
}
