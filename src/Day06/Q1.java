package Day06;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    static void main() {
        // 1. 게임시작 2. 종료:1(엔터) <첫화면>
        //1.가위 2.바위 3.보를 선택해주세요 : 2(바위)엔터
        // com이 만약에 1(가위)이면 User(바위) user승
        // com이 만약에 2(바위)이면 User(바위) 무승부
        // com이 만약에 3(보)이면 User(바위) Com승
        // 게임이 끝난 후에는 첫화면 이동
        // Com의 가위바위보는 랜덤으로 구해서 가위바위보를 정하면 됨.
        // 예) 게임결과: User 승
        // 종료가 되기 전까지 게임이 계속
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        while (true) {
            System.out.println("1. 게임시작");
            System.out.println("2. 종료");
            int num1 = sc.nextInt();
            int com = r.nextInt(3)+1;

            if(num1 == 1) {
                System.out.print("1.가위 2.바위 3.보를 선택해주세요 : ");
                int user = sc.nextInt();
                System.out.println("Com " + com);
                switch (user) {
                    case 1:
                        if( com == 1 ){
                            System.out.println("게임결과: 무승부");
                        }else if( com == 2 ){
                            System.out.println("게임결과: Com 승");
                        } else {
                            System.out.println("게임결과: User 승");
                        }
                        System.out.println();
                        break;

                    case 2:
                        if( com == 1 ){
                            System.out.println("게임결과: User 승");
                        }else if( com == 2 ){
                            System.out.println("게임결과: 무승부");
                        } else {
                            System.out.println("게임결과: Com 승");
                        }
                        System.out.println();
                        break;
                    case 3:
                        if( com == 1 ){
                            System.out.println("게임결과: Com 승");
                        }else if( com == 2 ){
                            System.out.println("게임결과: User 승");
                        } else {
                            System.out.println("게임결과: 무승부");
                        }
                        System.out.println();
                        break;
                }
            }else if(num1 == 2){
                System.out.println("게임을 종료합니다.");
                break;
            }else{
                System.out.println("잘못된 입력입니다.");
            }

        }
    }
}
