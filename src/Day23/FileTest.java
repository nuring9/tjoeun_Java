package Day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileTest {
    static void main() throws IOException {
        FileReader fr = new FileReader("경로");
        BufferedReader br = new BufferedReader(fr);
        String line1;
        while ((line1 = br.readLine()) != null){
            // 이름, 전화번호, 주소
            // 홍길동, 010, 인천시
            String[] array = line1.split(",");
            // array[0] = 홍길동
            // array[1] = 010
            // array[2] = 인천시

            FileWriter fw = new FileWriter("경로", true);
            // true 새로운 내용을 쓰면 기존 내용 뒤에 추가됩니다. (이어쓰기)
            FileWriter fw1 = new FileWriter("경로", false);
            // false 새로운 내용을 쓰면 기존 내용은 사라지고 새 내용만 남습니다. (덮어쓰기)
        }
    }
}
