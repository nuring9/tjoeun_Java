package Day05;

import java.util.Random;

public class RandomTest {
    static void main() {
        Random r = new Random();
        int num = r.nextInt(10);  // 0 ~ 9
        System.out.println(num);
        int num1 = r.nextInt(16)+30;  // 30~45
        System.out.println(num1 );
    }
}
