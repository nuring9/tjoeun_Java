package Day16;

import java.util.Scanner;

/*
     핸드폰 번호판 만들기
      1. 입력
      2. 연산작업
      3. 출력

      결과
      입력 : 1122335*#66
      출력 : BEHM*#Q

      1 : ABC
      2 : DEF
      3 : GHI
      4 : JKL
      5 : MNO
      6 : PQR
      7 : STU
      8 : VWX
      9 : Y
      * : *
      0 : Z
      # : #
      A~Z(65~90)
       */
public class Q2 {
    /*
    1. 입력
    2. 연산작업(문자 카운팅) -> 문자로 변환
    3. 출력
     */
    static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        return sc.next(); // 1122335*#66
    }

    static String charCounting(String str) {
        String result = "";
        // 1. 같은 숫자 나올때까지 카운팅
        // 2. 다른 숫자 나오면 멈춰 이게 바로 이전 문자에 카운팅
        // 3. 다른 숫자 확인하기위 변수 값을 바꿔야 한다.
        int count = 0;
        char ch = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            } else {
                //문자를 추출 연산 메소드 -> result 변수에 담기
                result += changeChar(ch, count);
                //ch 변경
                ch = str.charAt(i);
                //count 변경
                count = 1;
            }
        }
        //문자를 추출 연산 메소드 -> result 변수에 담기
        result += changeChar(ch, count);
        return result;
    }

    static char changeChar(char ch, int count) {
        char result;
        char[][] key = {
                {'A', 'B', 'C'},  //1
                {'D', 'E', 'F'},  //2
                {'G', 'H', 'I'},  //3
                {'J', 'K', 'L'},  //4
                {'M', 'N', 'O'},  //5
                {'P', 'Q', 'R'},  //6
                {'S', 'T', 'U'},  //7
                {'V', 'W', 'X'},  //8
                {'Y'}, // 9
                {'*'},
                {'Z'}, //0
                {'#'}
        };
        if (ch == '9') {
            result = key[8][0];
        } else if (ch == '*') {
            result = key[9][0];
        } else if (ch == '0') {
            result = key[10][0];
        } else if (ch == '#') {
            result = key[11][0];
        } else {
            if (count <= 3) {
                count--;
            } else {
                count = (count - 1) % 3;
            }
            result = key[(ch - '0') - 1][count];
        }
        return result;
    }

    static void outputPrintn(String str) {
        System.out.println("결과 : " + str);
    }

    static void main() {
        //outputPrintn(charCounting(input()));
        String temp = input();
        String result = charCounting(temp);
        outputPrintn(result);
    }
}
