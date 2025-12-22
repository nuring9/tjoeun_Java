package Day14;

class X {
    int a;

    int getA() {
        return a;
    }

    void setA(int a) {
        this.a = a;
    }
}
// X클래스는 정수형 인스턴스 변수 a를 가짐.
// getA()와 setA()는 각각 a의 getter, setter


public class ClassArrayTest {
    static void main() {
        X[] x = new X[5];
        // X타입의 배열을 생성 크기5, 참조 공간5개만 생성되므로 현재 각 요소는 null
        // x[0].a = 10; 을 실행하면 null

        for (int i = 0; i < x.length; i++) {
            x[i] = new X();
        }
        // 배열의 각 요소에 new X() 객체를 할당 -> 이제 x[0]~x[4]는 각각 X객체를 참조함.
        // 배열의 각 인덱스에 실제 객체를 생성하는 구간.

        x[0].a = 10;
        System.out.println(x[0].a);
        // x[0]의 a에 10을 할당,  출력결과 10

        X x1 = x[0];
        // x1은 x[0]이 가리키는 X 객체를 참조, 객체 참조 복사
        x[0] = null;
        // 그 후 x[0]을 null로 설정해도 x1은 여전히 해당 객체를 참조, 즉 배열의 참조만 끊음
        System.out.println(x1.a);
        // 출력결과 10
    }
}
