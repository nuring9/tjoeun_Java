package Day19;


class Z {
    int a = 1;
   void use() {
       System.out.println("use Z");
   }
}

class Y extends Z {
    int a = 10;
    void use() {
        System.out.println("usd Y");
    }
}

class K extends Z {
    void use() {
        System.out.println("usd K");
    }
}

class V extends Z {
    void use() {
        System.out.println("usd V");
    }
}

class Con1 {
    Z[] z = new Z[10];

    void usePrint(Z z) {
        z.use();
    }
}


public class KingTest {
    static void main() {

        Con1 c = new Con1();
        c.z[0] = new Y();
        c.z[1] = new K();
        c.z[2] = new V();

        c.usePrint(c.z[0]);


        // Y의 a를 사용하고 싶을 때,
        if (c.z[0] instanceof Y) {
            Y y = (Y)c.z[0];
            System.out.println(y.a); // 여기서 비로소 10이 출력됨
        }


    }
}
