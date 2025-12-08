package Day04;

public class WhileTest1 {
    static void main() {
        int hap = 0, count = 1; // int hap = 0 , int count = 1 를 단축
        while (count <= 10) {
            hap = hap + count;
            count++;
        }
        System.out.println("1부터 10까지 합은 " + hap + "입니다.");
    }
}



