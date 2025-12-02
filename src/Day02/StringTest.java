package Day02;

public class StringTest {
    static void main() {
        String str = "안녕하세요";
        System.out.println(str);  // 안녕하세요
        String str1 = str + 5 + 6;
        System.out.println(str1);  // 안녕하세요56  str부터 시작이므로 뒤에도 전부 str로 형변환
        String str2 = 15 + 8 + str;
        System.out.println(str2);  // 23안녕하세요  int가 앞이여서 쭉 int로 계산 후 + 연산자와 문자열이므로, 추후 문자열로 형변환
        // char ch = (char)str1; 에러발생 형변환은 급이 맞아야 됨.

    }
}
