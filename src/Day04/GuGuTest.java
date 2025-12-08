package Day04;

public class GuGuTest {
    static void main() {
        for(int dan = 2; dan <= 9; dan++) {
            for(int times = 1; times<=9; times++){
                System.out.println(dan + "X" + times +"=" + (dan * times));
            }
            System.out.println();
        }
    }
}
