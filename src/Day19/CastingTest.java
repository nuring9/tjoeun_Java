package Day19;


class C {
    int a=10;
}

class D extends C {
    int b=20;
}

class E extends C{

}

class F extends C{

}

class Controller {
    void abc(D d){

    }
    void abc(E e){

    }
    void abc(F f){

    }
    void king(C c){
        // C c 하나로 전부 받아올 수 있음.

        /*
        king(C c) 메서드 입장에서는 내부적으로 (D)c로 다시 돌려놓기(다운캐스팅) 전까지는,
        들어온 객체가 D인지 E인지 따지지 않고 오직 부모인 C의 모습으로만 바라봄.
        그래서 어떤 자식이든 다 받아줄 수 있는 것.

        추가 팁
        king(C c) 내부에서 실제로 이 객체가 D였는지 확인하고 싶다면,
        if (c instanceof D)와 같은 문법을 사용해 안전하게 다시 다운캐스팅해서 사용할 수 있다.
         */

        if ( c instanceof  D ){
            D d = (D)c;  // main 문에서 다운캐스팅한거랑은 상관이 없음. 메소드안에서 사용하는것.
        }

        if ( c instanceof  E ) {
            E e = (E)c;
        }

        if ( c instanceof F ) {
            F f = (F)c;
        }



    }
}

public class CastingTest {
    static void main() {
        C c = new D();
        System.out.println(c.a);
   //     System.out.println(c.b);  b를 사용할 수 없음. 업캐스팅 부모껏만 사용 가능
        D d = (D)c;  // 강제 형변환으로 원래대로 돌림,  다운 캐스팅
        // C를 부모를 가지고 태어난 D,E,F를 전부 쓰려고해서 업캐스팅했다가 다운캐스팅함.
        // 만약 D를 제외한 E,F 만 쓰려고하면 다운캐스팅을 할 필요가 없다.
        System.out.println(d.b); // 부모와 자식 둘다 사용 가능
        System.out.println(d.a); // 부모와 자식 둘다 사용 가능
    }
}
