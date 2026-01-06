package Day22;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EXFileWriter {
    static void main() throws IOException {
        Scanner stdin = new Scanner(System.in);
        String source = "비어 있어야 비로소 가득해지는 사랑\n" + "영원히 살아한다는 것은 \n" + "평온한 마음으로 아침을 맞는다는 것입니다.\n";

        char input[] = new char[source.length()];
        // source를 문자열 값을 char[] input에 넣어주는 기능
        source.getChars(0, source.length(), input, 0);
        // 문자열을 캐릭터로 하겠다. 0 인덱스부터 source 길이까지 input의 0부터 넣는다.
        // 대상시작인덱스, 대상어디까지, 목적변수, 시작인덱스

        System.out.println("파일명을 입력하세요 : ");
        String s = stdin.next();  // a.txt라고 입력하면
        FileWriter fw = new FileWriter(s);  // a.txt 파일 생성
        // FileWriter 객체를 생성 파일명 -
        fw.write(input); // a.txt 파일 안에 source가 문자 배열로 된 input가 들어가있다.
        // 그 파일에 쓴다 char[] input 데이터를 쓴다
        fw.close(); // 파일 닫기
        System.out.println(s + "파일이 생성되었습니다."); // 생성후 출력.
    }
}
