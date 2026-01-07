package Day23;

import java.io.FileReader;

public class ExceptionTest1 {
    static void main() {
        FileReader file;
        try {
            file = new FileReader("a.txt");
            int i;
            while ((i = file.read())!= -1){
                System.out.print((char) i);
            }
            file.close();
        } catch (Exception e) {
            System.out.println("예외 처리 루틴 : " + e + " 파일이 존재하지 않는다.");
        }
    }
}
