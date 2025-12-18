package Day12;

public class SelfMethodTest {

    static  int abc(int num){
        if(num ==0) {
            return 0;
        } else {
            return abc(num-1) + num;
        }
    }

    static void main() {
        int result = abc(5);
        System.out.println(result);
    }
}
