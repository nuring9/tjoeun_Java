package Day10;

public class MethodTest1 {

    // 1. 주고 받고
    static String printHello(String name) {
        return "안녕하세요 " + name + "님";
    }

    // 2. 주고 안받고
    static int sum() {
        int a = 10;
        int b = 20;
        return a + b;
    }

    // 3. 안주고 받고
    static void outputName(String name) {
        System.out.println("안녕하세요 " + name + "님");
    }

    // 4. 안주고 안받고
    static void printBye() {
        System.out.println("바이!!!");
    }


    static void main() {

        // 1번 호출
        String str = printHello("홍길동");
        System.out.println(str);

        System.out.println(printHello("홍길동"));
        // 위 코드 2줄을 줄임.

        // 2번 호출
        int result = sum();
        System.out.println(result);

        // 3번 호출
        outputName("강아지");

        // 4번 호출
        printBye();
    }

}


/*
안녕하세요 홍길동님
30
안녕하세요 강아지님
바이!!!
*/