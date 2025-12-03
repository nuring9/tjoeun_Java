package Day03;

import java.util.Scanner;

public class SwitchTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("랭킹을 입력하세요 : ");
        int ranking = sc.nextInt();
//        int ranking = 1;
        char medalColor;
        switch (ranking) {
            case 1:
                medalColor = 'G';
                break;
            case 2:
                medalColor = 'B';
                break;
            default:
                medalColor = 'A';
                break;
        }
        System.out.println(ranking + "등 메달의 색깔은" + medalColor + "입니다.");
    }
}
