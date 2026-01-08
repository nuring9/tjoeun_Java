package Day24;

// Thread 클래스를 상속해서 멀티스레딩을 구현한 간단한 스레드 실행 예제

class DoubleThreadTest1 extends Thread {
    // Thread 클래스를 상속했기 때문에 이 클래스 자체가 하나의 스레드 객체 역할을 함.
    public DoubleThreadTest1(String str) {
        setName(str);  // 쓰레드 이름 설정
        // 생성자에서 setName(str) 호출 → 쓰레드의 이름을 지정.
    }

    public void run() {
        // run() 메서드는 쓰레드가 실행할 코드 블록 (반복문 + 종료 메시지)
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + getName());
        }
        System.out.println("끝" + getName());
    }
}

public class ExDoubleThread2 {
    static void main() throws InterruptedException {
        // main() 메서드에서 두 개의 쓰레드(t1, t2)를 생성하고 start()로 실행.
        DoubleThreadTest1 t1 = new DoubleThreadTest1(" : 배우기 쉬운 자바");
        DoubleThreadTest1 t2 = new DoubleThreadTest1(" : 배우기 어려운 자바");
        System.out.println("*********** 스레드 시작 전 ***********");
        t1.start(); // 쓰레드 시작 → t1.run() 실행됨
        t2.start(); // 쓰레드 시작 → t2.run() 실행됨

        /*
        start() = 새로운 스레드(실행 흐름) 를 시작
        start()를 호출하면, JVM이 새 스레드를 생성하고, 내부적으로 run() 메서드를 호출함.
        즉, run()을 직접 호출하는 게 아니라, 별도의 실행 흐름으로 동작.
        run() 메서드가 거의 동시에 실행되고, 결과는 섞여서 출력.
         */



        t1.join(); // 메인 쓰레드가 t1이 끝날 때까지 대기
        t2.join(); // 메인 쓰레드가 t2가 끝날 때까지 대기

        /*
        join() = 해당 스레드가 끝날 때까지 기다림.
        t1.join(); ➜ 현재 실행 중인 메인 쓰레드는 t1이 끝날 때까지 멈춘다.
        t2.join(); ➜ t1 끝난 후, 메인 쓰레드는 t2가 끝날 때까지 멈춘다.
         */

        // 멀티스레드이므로 t1, t2의 출력은 동시에 섞여서 나올 수 있음. 실행할 때마다 출력 순서는 다를 수 있음.
        System.out.println("*********** 스레드 종료 후 ***********");

        /*
        즉,
        메인 쓰레드(main thread)는 t1.start()와 t2.start()를 호출해서 두 스레드를 비동기로 실행해 놓고,
        그 다음엔 t1이 끝날 때까지 기다림 → t2가 끝날 때까지 기다림
        그런 다음에야 마지막 문장 "*********** 스레드 종료 후 ***********" 을 실행
         */
    }
}
