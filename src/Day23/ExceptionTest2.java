package Day23;

import java.io.FileReader;

public class ExceptionTest2 {
    static void main() throws Exception {
        // throws 예외를 던짐
        FileReader file = new FileReader("a.txt");
        int i;
        while ((i = file.read()) != -1) {
            System.out.print((char) i);
        }
        file.close();
    }
}
