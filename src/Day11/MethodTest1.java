package Day11;

public class MethodTest1 {
    static void a() {
        b();
        k();
        System.out.println("A");
    }

    static void b() {
        c();
        k();
        System.out.println("B");
    }

    static void c() {
        d();
        System.out.println("C");
    }

    static void d() {
        e();
        System.out.println("D");
    }

    static void e() {
        System.out.println("E");
    }

    static void k() {
        System.out.println("A");
    }


    static void main() {
        a();
    }
}

/*
E
D
C
A
B
A
A
 */