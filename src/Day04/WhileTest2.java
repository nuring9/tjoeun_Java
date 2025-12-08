package Day04;

import java.util.Scanner;

public class WhileTest2 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 숫자 입력 : ");
        int num = sc.nextInt();
        int hap = 0, count = 1; // int hap = 0 , int count = 1 를 단축
        while (count <= num) {
            hap = hap + count;
            count++;
        }
        System.out.println("1부터 " + num + "까지 합은" + hap + "입니다.");
    }
}
