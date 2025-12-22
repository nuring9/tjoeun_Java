package Day14;

class D{
    int a;
    D(int a){
        this.a =a;
        // this -> 나 자신을 가르킴
    }
}

public class ThisTest {
    static void main() {
        D d = new D(10);
        System.out.println(d.a); // 10
    }
}
