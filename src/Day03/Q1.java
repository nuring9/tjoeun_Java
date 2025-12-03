package Day03;

import java.util.Scanner;

public class Q1 {
    static void main() {
        /* 문제.
        String id = “korea”
        String passwd = “1234”


        Id 입력 : XXXX
        패스워드 입력 : XXXXX

//        Id와 패스워드가 맞으면  -> “환영합니다. Korea님”

        Id와 또는 패스워드가 틀리면
         id가 틀린경우 패스워드 맞고 -> id가 올바르지 않습니다.
         id가 맞고 패스워드가 틀린경우 -> 패스워드가 올바르지 않습니다.
        id 패스워드 모두 틀린경우 -> id와 패스워드가 올바르지 않습니다
         */

       //내가 푼 문제.
        Scanner sc = new Scanner(System.in);
        System.out.println("Id 입력 : ");
        String id = sc.next();
        System.out.println("패스워드 입력 : ");
        String passwd = sc.next();

        if (id.equals("korea") && passwd.equals("1234")) {
            System.out.println("환영합니다. Korea님");
        }
        else if (id.equals("korea")) {
                    System.out.println("패스워드가 올바르지 않습니다.");
        } else if (passwd.equals("1234")) {
                    System.out.println("id가 올바르지 않습니다.");
        } else {
                    System.out.println("id와 패스워드가 올바르지 않습니다.");
        }
 /*
        // 강사님 답변
        String id = "korea";
        String passwd = "1234";
        Scanner sc = new Scanner(System.in);
        System.out.println("Id 입력 : ");
        String userId = sc.next();
        System.out.println("패스워드 입력 : ");
        String userPw = sc.next();

        if (id.equals(userId) && passwd.equals(userPw)) {
            System.out.println("환영합니다. Korea님");
        }
        else if (!id.equals(userId) && passwd.equals(userPw)) {
            System.out.println("id가 올바르지 않습니다.");
        } else if (id.equals(userId) && !passwd.equals(userPw)) {
            System.out.println("패스워드가 올바르지 않습니다.");
        } else {
            System.out.println("id와 패스워드가 올바르지 않습니다.");
        }

*/
    }
}