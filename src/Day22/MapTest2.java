package Day22;

import java.util.HashMap;

class C{
    int k;
}

class D{
    String str;

    @Override
    public String toString() {
        return "D";
    }
}

public class MapTest2 {
    static void main() {
        HashMap<C, D> map = new HashMap<C, D>();
        C c = new C();
        C c1 = new C();
        map.put(c, new D());
        map.get(c1); // null
        map.get(c);  // 객체 D를 리턴
        System.out.println(map.get(c));  // 객체를 toString해야 D출력 아니면 객체문자나옴.
        System.out.println(map.get(c1));
    }
}
