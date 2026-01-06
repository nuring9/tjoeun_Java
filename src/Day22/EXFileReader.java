package Day22;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EXFileReader {
    static void main() throws IOException {
        Scanner stdin = new Scanner(System.in);
        FileReader fr = new FileReader("a.txt");
        // 객체 생성 읽을때 파일 a.txt
        int i;
        // i = fr.read(); 정수값이 옴.
        while ((i = fr.read()) != -1){
            // 올때 -1이 아니면 반복, -1은 문자열을 끝.
            System.out.print((char) i);
            // 형변환이 하면서 출력
        }
        fr.close();
    }
}
