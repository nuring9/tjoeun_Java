package Day24;


class ThreadTest extends Thread {
    // 클래스 ThreadTest 는 Thread 클래스를 상속하고, run() 메서드를 오버라이드함
    public void run() {
        // run() 안에서 1~10까지 "재미있는 자바 : i" 출력
        // 별도의 쓰레드에서 실행됨
        for(int i = 1; i<=10; i++){
            System.out.println("재미있는 자바 : " + i);
        }
    }
}

public class ExThread1 {
    static void main() {
        ThreadTest t =  new ThreadTest();
        // ThreadTest 객체 생성.
        t.start();
        // start() 호출 → 새로운 쓰레드가 run() 실행 시작.

        for(int i = 0; i<10; i++){
            System.out.println("aaaaaaaaaaaa");
            // start() 호출 -> 그와 동시에, main() 메서드의 반복문에서 "aaaaaaaaaaaa" 출력
            // 원래 start() 호출하면 run()메소드가 실행되어야 하기때문.

        }
        //이 둘은 병렬적으로 실행되므로, 출력 결과가 섞여 나옴
    }
}
