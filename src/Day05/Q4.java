package Day05;

import java.util.Random;

public class Q4 {
    static void main() {
        Random r = new Random();

        // 내가 푼거
        int numA = 65;
        char numStr;

        for (int i=0; i<10; i++) {
            int num = r.nextInt(26);  // 0~25까지
            numStr = (char)(numA + num);
            System.out.print(numStr);
        }
        System.out.println();


        // 정답
        String result = "";
        for (int i = 0; i<10; i++) {
        char ch = (char)(65 + r.nextInt(26));
            result += ch;

        }
        System.out.println(result);
    }
}
