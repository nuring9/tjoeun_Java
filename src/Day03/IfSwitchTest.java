package Day03;

import java.util.Scanner;

public class IfSwitchTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("성적을 입력하세요 : ");
        int grede = sc.nextInt();
        // 점수를 입력받는다.
        // 0~100점
        // 0~100점 입력이 들어오면 90점 이상이면 훌륭합니다 출력
        // 80점 이상이면 준수합니다 출력
        // 70점 이상이면 보통입니다 출력
        // 그 밑에 점수는 공부하세요 출력
        // 0~100점 입력이 안들어오면 잘못된 입력입니다 출력
        if (0 <= grede && grede <= 100) {
           if(grede >= 90) {
               System.out.println("훌륭합니다");
           } else if (grede >= 80) {
               System.out.println("준수합니다");
           } else if (grede >= 70) {
               System.out.println("보통입니다");
           } else {
               System.out.println("공부하세요");
           }
        }
        else {
            System.out.println("잘못된 입력입니다");
        }
    }
}
