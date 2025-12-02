package Day02;

public class OPTest3 {
    static void main() {
        int a = 10;
        a += 5;
        System.out.println(a);
        a -= 5;
        System.out.println(a);
        a *= 5;
        System.out.println(a);
        a /= 5;
        System.out.println(a);
        a %= 5;
        System.out.println(a);

        int b = 8;
        int c = b == 10 ? 1 : 0;
        System.out.println(c);

        int d = b == 10 ? c > 3 ? 1 : 0 : 3;
        // b == 10
        // t -> c >3
        // t -> 1
        // f -> 0
        // f -> 3
        System.out.println(d);
    }
}
