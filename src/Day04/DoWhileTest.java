package Day04;

public class DoWhileTest {
    static void main() {
        int hap =0, count = 11;
       /*
        do {
            hap = hap + count;
            count++;
        } while (count<=10);
        */
        while(count<=10) {
            hap = hap + count;
            count++;
        }
        System.out.println(hap);
    }
}
