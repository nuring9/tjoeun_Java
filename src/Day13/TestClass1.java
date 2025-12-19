package Day13;

class PlusMinus {
    int plus;
    int minus;

    void plus(int x, int y) {
        plus = x + y;
    }

    String minus(int x, int y) {
        minus = x - y;
        return "두 수의 차는 " + minus;
    }
}


public class TestClass1 {
    static void main() {
        PlusMinus op = new PlusMinus();
        op.plus(50, 30); // 80
        System.out.println(op.plus);
        String str = op.minus(30, 40);
        System.out.println(str);       // -10
        PlusMinus op1 = new PlusMinus();
        System.out.println(op1.plus);   // 0
        System.out.println(op1.minus);  // 0
    }
}
