package Day03;

import java.util.Scanner;

public class StringTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        /*
        if(name == "호랑이") {
            System.out.println("호랑이 입니다.");
        } else {
            System.out.println("호랑이가 아닙니다.");
        }
        */
        if(name.equals("호랑이") ) {
        // 문자열이 일치하는지 볼때는 equals로 비교 한다.
            System.out.println("호랑이 입니다.");
        } else {
            System.out.println("호랑이가 아닙니다.");
        }
    }
}
