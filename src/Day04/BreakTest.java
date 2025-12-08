package Day04;

public class BreakTest {
    static void main() {
        int a = 0;

        /*
        while (true) { // 무한 루프
            while (true) {
                System.out.println("a : " + a);
                if (a == 10) {
                    break;
                }
                a++;
            }
        }
        */

     /* 무한루프 0만 계속 찍힌다.
        while (true) {
            switch (a) {
                case 0:
                    System.out.println(a);
                    break;
                default:
                    System.out.println("값이 없습니다.");
            }
        }

       */

 // 위 코드 무한루프 해결, 0 한번만 찍힘.
        boolean check = true;
        while (check) {
            switch (a) {
                case 0:
                    System.out.println(a);
                    check = false;
                    break;
                default:
                    System.out.println("값이 없습니다.");
            }
        }
    }
}
