package Day04;

import java.util.Scanner;

public class ScannerTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        // 입력 : 안녕 하세요.
//        String str1 = sc.next(); // 안녕
//        String str2 = sc.next(); // 하세요.

        String str3 = sc.nextLine(); // 안녕 하세요.
//
//        System.out.println(str1);
//        System.out.println(str2);
        System.out.println(str3);
    }
}
