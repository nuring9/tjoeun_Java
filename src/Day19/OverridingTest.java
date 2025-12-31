package Day19;

class A {
    void abc() {
        System.out.println("abc");
    }
}

class B extends A {
    @Override
    void abc() {
        System.out.println("def");
    }
}

public class OverridingTest {
    static void main() {
        A a = new A();
        a.abc();
        B b = new B();
        b.abc();
        A a1 = new B();
        a1.abc();  // B객체를 생성하기때문에 A 자료형을 가지고 있지만, 재정의를 통해서 B의 abc를 호출
    /*
    변수의 타입(안경)은 부모인 A. 따라서 컴파일 단계에서는 A에 abc() 메서드가 있는지 확인.
    실제 메모리에 올라간 **실체(인스턴스)**는 B이다.
    자바는 변수의 타입보다 실제 생성된 객체의 재정의된 메서드를 우선순위로 둔다.

    컴파일 타임: 자바 컴파일러는 a1.abc()를 보고 "A 타입에 abc()가 있네? 오케이 통과!"라고 판단.
    런타임(실행 시): 프로그램이 실제로 돌아갈 때는 "어? a1이 가리키는 실제 몸체가 B네? 그럼 B가 새롭게 정의한 abc()를 써야겠다!" 하고 B의 메서드를 실행.
     */

    }
}
