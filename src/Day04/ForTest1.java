package Day04;

public class ForTest1 {
    static void main() {
        int hap = 0;
        for (int count = 1; count<=10; count++){
            hap += count;
        }
        System.out.println("1부터 10까지의 합은 " + hap + "입니다.");
    }
}
