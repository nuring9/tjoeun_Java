package Day04;

public class TwoForTest {
    static void main() {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if(j == 3) {
                    break;
                }
                System.out.println(i+j);
            }
            if(i > 3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
