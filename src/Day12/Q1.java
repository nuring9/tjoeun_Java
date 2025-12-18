package Day12;

import java.util.Random;

public class Q1 {
    // 1. 주고 안받고 랜덤 값 추출
    static int randomMake(){
        Random r = new Random();
        return r.nextInt(26);
    }
    // 2. 주고 받고 더하기 연산
    static int plus(int ran){
        return 65 + ran;
    }
    // 3. 주고 받고 문자 만들기
    static char makeChar(int result){
        char ch =(char)(result);
        return ch;
    }
    // 4. 안주 안받고 10실행
    static void run(){
        String result = "";
        for(int i = 0;i<10;i++){
//            int ran = randomMake();
//            int mc = plus(ran);
//            char ch = makeChar(mc);
//            result = makeString(result,ch);
            result=makeString(result,makeChar(plus(randomMake())));
        }
        printString(result);
    }
    // 5. 주고 받고 10개 문자 더하기 연산
    static String makeString(String result, char ch){
        result = result + ch;
        return result;
    }
    // 6. 안주고 받고 10개의 문자 출력
    static void printString(String result){
        System.out.println(result);
    }
    static void main() {
        run();
    }
}
