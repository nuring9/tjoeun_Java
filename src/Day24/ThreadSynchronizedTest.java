package Day24;

class A {
    synchronized void plus(int i) {
        // plus(int i)는 synchronized 메서드
        // synchronized 를 사용하면 하나의 객체만 사용
        // 여러 쓰레드가 동시에 호출해도 한 번에 한 쓰레드만 접근할 수 있음
        for (int j = 0; j < 5; j++) {
            System.out.println(j * i);
            try {
                Thread.sleep(400);
                // 계산된 결과 j * i를 0.4초 간격으로 출력.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    // B는 Thread를 상속
    A a;
    int i;

    B(A a, int i) {
        this.a = a;
        this.i = i;
    }

    public void run() {
        a.plus(i);
    }
    // 실행되면, a.plus(i)를 호출 → 쓰레드 작업
}

public class ThreadSynchronizedTest {
    static void main() {
        A a = new A(); // 공유 객체 1개 생성
        // 실 객체 하나 써서 사용.
        B b1 = new B(a, 3);  // 첫 번째 쓰레드: 3을 넘김
        B b2 = new B(a, 7);  // 두 번째 쓰레드: 7을 넘김
        b1.start();
        b2.start();
      /*
      b1이 작업하는 동안 b2는 대기
      b1이 끝난 후 b2가 실행됨 (혹은 반대)
      실행마다 순서는 바뀔 수 있지만, 절대 섞이지 않음!
       */
    }
}
