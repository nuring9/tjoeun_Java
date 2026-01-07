package Day19;

abstract class A2 {
    int a;
    String str;

    void def() {
        System.out.println("def");
    }

    abstract void abc();
}

class B2 extends A2 {
    void abc() {
        System.out.println("abc");
    }
}


public class AbstractClassTest {
    static void main() {
        // A2 a2 = new A2(); 에러남
        A2 a2 = new B2();
        a2.abc();
    }
}
