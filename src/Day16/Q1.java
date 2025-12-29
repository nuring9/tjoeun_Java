package Day16;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    static void main() {
        /*
        업다운 31
        컴퓨터가 랜덤으로 1~31 출력
        유저가 1~31까지 입력, 1~31값이 아니면 잘못된 입력 출력 이후 다시 입력

        컴퓨터 12
        유저 10 => 업
        유저 20 => 다운

        컴퓨터의 랜덤 숫자를 맞추면 게임 종료
         */

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int user;
        int com;

        com = r.nextInt(31)+1;
        System.out.println("컴퓨터 " + com);
        System.out.print("User : ");
        user = sc.nextInt();

        while (true) {
        if(user >= 1 && user <= 31) {
            if( com > user) {
                System.out.println("업");
            } else if ( com < user){
                System.out.println("다운");
            } else {
                System.out.println("맞췄습니다. 프로그램을 종료합니다.");
               break;
            }
            System.out.print("User : ");
            user = sc.nextInt();
        }else {
            System.out.println("잘못된 입력입니다.");
            System.out.print("User : ");
            user = sc.nextInt();
        }
        }

    }
}
