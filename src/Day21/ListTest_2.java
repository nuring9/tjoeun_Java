package Day21;

import java.util.ArrayList;
// 메모리라는 긴 띠 형태의 공간에 가로로 칸을 나누어 데이터를 채워 넣는 모양
// 가로로 나열된 기차 칸 모양.


class A {
    int a;
    int b;

    A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void print() {
        System.out.println("a : " + a + " , b " + b);
    }
}


public class ListTest_2 {
    static void main() {
        ArrayList<A> list = new ArrayList<A>();
        for (int i = 0; i < 10; i++) {
            list.add(new A(i, i + 1));
            // 10개 객체 생성
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
        }
    }
}
