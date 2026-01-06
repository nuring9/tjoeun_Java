package Day22;

import java.util.HashSet;
import java.util.Iterator;

class A {
    int a;
    int b;

    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class SetTest2 {
    static void main() {
        HashSet<A> set = new HashSet<A>();
        set.add(new A(5, 6));
        set.add(new A(7, 8));
        Iterator<A> it = set.iterator();
        int num = 1;
        while (it.hasNext()) {
            A a = it.next();
            if (a.a == 8 || a.b == 8) {
                System.out.println(num + "번째에 있습니다.");
            }
            num++;
        }
    }
}
