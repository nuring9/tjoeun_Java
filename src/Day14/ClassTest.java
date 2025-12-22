package Day14;

class A {
    B b;

    B makeB() {
        b = new B();
        return b;
    }
}
// A 클래스는 멤버 변수 b를 가지고 있고,
// makeB()메서드를 호출하면 새로운 B객체를 만들고, 그것을 자신의 b 필드에 저장한 뒤 반환

class B {
    int k;
}
// B클래스에 단순하게 int k 하나만 가지고 있음.

class C {
    B b = new B();

    B makeB() {
        return b;
    }
}
// 생성자 호출 시점에서 이미 b라는 B객체를 만들고 저장
// 이후 makeB()는 단순히 그 b를 반환하는 메서드
// 따라서 makeB()를 몇번 호출하든, 항상 같은 B객체를 반환


public class ClassTest {
    static void main() {
        A a = new A();  // A 객체 생성
        // a.b는 아직 null인 상태
        B b = a.makeB(); // a의 b 필드에 새 B 객체 생성 후 참조 저장
        // 새 B 객체 생성 -> a.b에 저장 -> 반환
        b.k = 20;  // b 객체의 k 값 설정
        // b의 k에 20 저장
        // a.b, b는 동일한 B 객체를 참조, 즉 a.b == b

        B b1 = a.makeB(); // 새로 생성, 새 B 객체를 또 만들고, a.b는 이 새로운 객체를 참조
        // 새 B 객체 생성 -> a.b 업데이트 -> 반환
        // a.b, b1는 새로운 B 객체를 가르키미
        // b는 여전히 첫번째 B 객체를 참조중
        a.b.k = 30; // 새로 만든 B 객체의 k 값을 설정
        // b1.k = 30 과 동일, a.b와 b1은 같은 객체를 참조

        System.out.println(b1.k);   //30  B b1 = a.makeB();를 생성 후 호출이기때문에 b1과, a의 b는 같은곳을 바라봄.
        System.out.println(b.k);    // 20
        System.out.println(a.b.k);  // 30

        C c = new C();     // b가 생성 B b = new B();
        // c.b -> B 객체 (k = 0)
        B b2 = c.makeB();  // 위에꺼랑 연결
        // b2 -> c.b
        c.b.k = 30;
        // B 객체의 k = 30
        B b3 = c.makeB(); // 이것도 같은걸 연결
        // b3 -> c.
        // 모든 참조는 같은 B 객체를 가르킴, b2 == b3 == c.b

        System.out.println(b3.k); //  즉 c안의 b랑 b2의 b랑 b3의 b 전부 같은 b를 가르킴.
    }
}
