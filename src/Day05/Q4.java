package Day05;

import java.util.Random;
// 컴퓨터는 문자로 메모리 X
// 숫자로 관리 된다. 'A' 65다
// 10개의 랜덤한 문자 -> 문자열 출력
// 'A'~'Z' 26 -> 25
// 65 + 2 -> 67 'C'
// 2 -> 난수
// 10 -> 반복문 10번


public class Q4 {
    static void main() {
        Random r = new Random();
// 랜덤 객체 생성 난수 준비 끝

        // 내가 푼거
        int numA = 65;
        char numStr;

        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(26);  // 0~25까지
            numStr = (char) (numA + num);
            System.out.print(numStr);
        }
        System.out.println();


        // 정답
        String result = "";  // 문자 10개 담을 변수 문자열 변수 준비 끝
        for (int i = 0; i < 10; i++) { // 10번 반복 하기 위해서 for 10번 돌게 구현 끝
            // 'A' 65
            // 65 + 난수 값 25 r.neextInt 26을 넣으면 뭔가 A~Z 나오겠네
            // 결과 나오면 char 변수 ch에 넣으면 되겠네
            // ! 그냥 정수 넣으면 int니까 char 형변환 필요하겠네
            char ch = (char) (65 + r.nextInt(26));
            // 문자 결과 나왔네 그걸 result 문자열에 넣어주면 되겠네
            result += ch;
            // 값이 유지가 되야 하니까 result + ch -> result


        }
        System.out.println(result);
        //반복문 끝났네 출력
    }
}
