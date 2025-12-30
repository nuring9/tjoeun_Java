package Day18;

class A {
    int a;
    protected int c;
    private int k;

    A() {
        System.out.println("A 생성");
    }
}

class B extends A {
    String str;

    B() {
        System.out.println("B 생성");
    }
}

class C {

    C() {

        System.out.println("C 생성");
    }
}

public class InherTest {
    static void main() {
        B b = new B();
        b.a = 10;
        b.str = "안녕";
        System.out.println(b.a);
        System.out.println(b.str);
        A a = new A();
        a.c = 20;
        System.out.println(a.c);

    }
}
