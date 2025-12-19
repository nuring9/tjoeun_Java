package Day13;

class A{
    A() {

    }
}

class C{
 C(int a, int b) {

 }
}

public class TestClass2 {
    static void main() {
        A a = new A();   // 객체 생성
        A a1 = new A();  // 객체 생성
        C c = new C(5, 7);  // 객체 생성하면서 생성자를 호출.
        // 생성자에 매개변수를 맞춰서 넣어야 됨.
    }
}
