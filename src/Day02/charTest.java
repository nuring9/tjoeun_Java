package Day02;

public class charTest {
    static void main() {
        char ch1 = 'A';
        System.out.println(ch1);  // 'A'
        System.out.println((int)ch1);  // 65 형변환 -> 자료형 변경

        char ch2 = 66;  // 66
        System.out.println(ch2);  // 'B'

        int ch3 = 67;
        System.out.println(ch3);  // 67
        System.out.println((char)ch3);  // 67 -> 형변환 char 'C'
        
       // char ch4 = -67; // 아스키코드에는 음수가 없어서 에러
    }
}
