package Day10;

import java.util.Scanner;

public class MethodTest2 {
    static int d = 10;

    static int add (int a, int b) {
        d = 20;
        System.out.println("abc");
        return a+b;
    }
    static void main() {
        System.out.println(d);    // 10
        d = 50;
        System.out.println(d);   // 50
        int a = add(5,4);  // abc
        System.out.println(d);   // 20
        System.out.println(a);   // 9
        d = 30;
        System.out.println(d);   // 30


        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int b = add(num, 5);
        System.out.println(b);
        // 1 입력 시 abc 6 출력

        int c = add(scanner.nextInt(), 3);
        System.out.println(c);
        // 2 입력 시 abc 6 출력
    }
}
