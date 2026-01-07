package Day23;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int flag = 0;
        while (flag == 0) {
            flag = 1;
            try {
                System.out.println("숫자 입력 = ");
                num = sc.nextInt();   // 숫자 입력
                System.out.println("입력 받은 숫자는 = " + num);
            } catch (InputMismatchException e) {
               flag = 0;
               sc.nextLine();
                System.out.println("정상적인 숫자를 입력하세요.");
            }
        }
    }
}
