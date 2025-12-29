package Day17;

public class MethodOverloadingTest {
    static int add (int a, int b) {
        System.out.println("1");
        return a+b;
    }

//    int add (int c, int d) {
//        return c+d;
//    }
// 위에 메소드명과 매개변수 자료형이 같아서 이건 실행이 안됨.


    static double add(double a , int b){
        System.out.println("2");
        return a+b;
    }

    static void add() {
        System.out.println("3");
        System.out.println("a");
    }

    static int add(int a) {
        System.out.println("4");
        return a;
    }

    // return 타입은 상관없이 메소드명,매개변수 자료형만 상관있음.

    static void main() {
        add(5,6);
        System.out.println(add(5,6));  // 메서드출력
        add(2.0,6);
        add();
        add(10);
    }
}
