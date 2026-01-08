package Day24;

// Runnable은 쓰레드로 실행할 수 있는 작업 단위를 정의하는 인터페이스

class RunableTeest implements Runnable {
    public void run() {
        // run() 메서드에 스레드가 해야 할 일을 작성
        for (int i = 1; i <= 10; i++) {
            System.out.println("재미있는 자바 : " + i);
            // "재미있는 자바 : i"를 1~10까지 출력하는 코드가 실행
        }
    }
}

public class ExRunable1 {
    static void main() {
        RunableTeest r = new RunableTeest(); // 실행할 작업 정의/
        Thread t = new Thread(r);  // 실행 흐름 + 작업 결합.

        // RunableTeest 객체를 생성하고, 이를 Thread의 생성자에 전달함

        t.start(); // 새로운 쓰레드가 run() 실행/
        // 그런 다음 start()를 호출하여 쓰레드를 시작
    }
}
