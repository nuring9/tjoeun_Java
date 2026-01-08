package Day24;

class Factory {
    // Factory는 P 클래스와 C 클래스가 공유하는 자원(창고) 역할을 하는 클래스
    private int value;
    // P 클래스가 보낸 데이터를 저장하는 변수
    private boolean check = false;
    // 현재 value에 데이터가 들어 있는지 표시하는 플래그
    // false면 데이터 없음 → P가 보낼 수 있음.
    // true면 데이터 있음 → C가 가져갈 수 있음.

    synchronized void send(int value) {
        // 이 메서드는 P 클래스에서 호출함
        // synchronized → 한 번에 하나의 스레드만 들어올 수 있게 lock 설정


        while (check == true) {
            // 만약 check == true라면, 아직 C가 데이터를 안 가져간 거니까 대기 (wait())
            //그렇지 않으면 데이터를 저장 (value)
            try {
                wait(); // 소비자가 값을 꺼낼 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        System.out.println("만드는 사람 : 만든다 : " + this.value);
        notify(); // C 클래스 쪽을 깨움.
        check = true; // true로 바꿔서 이제 C가 데이터를 가져갈 수 있게 함.
    }

    synchronized int get() {
        // 이 메서드는 C 클래스에서 호출함

        while (check == false) {
            // check == false이면 아직 P가 데이터를 보내지 않았으므로 대기 (wait())
            // 그렇지 않으면 콘솔에 출력

            try {
                wait(); // 생산자가 값을 넣을 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("사는 사람 : 산다 : " + this.value);
        notify();  // notify()로 P 클래스 쪽을 깨움
        check = false; // check = false로 다시 데이터를 보낼 수 있도록 함
        return this.value; // Factory 클래스 내부에서 호출된 get() 메서드가 현재 저장되어 있는 값을 호출한 쪽(C 클래스)에게 반환하는 부분
         // 결국 return의 값은 C 클래스에서 get()으로 읽은 값을 전달해주는 역할.
    }
}

class P extends Thread {
    // P는 Thread를 상속한 클래스, 생성자에서 전달받은 Factory 객체를 사용함.
    // P 클래스는 Factory에게 데이터를 보내고 send())
    Factory f;

    P(Factory f) { // Factory 객체를 받아서 필드에 저장
        this.f = f;
    }

    public void run() {
        // start()가 호출되면 run()이 실행됨.
        for (int i = 0; i < 10; i++) {
            f.send(i);
        }
        // 0부터 9까지 숫자를 Factory의 send() 메서드로 전달.
        // 즉, 10개의 데이터를 Factory에 보냄.
    }
}


class C extends Thread {  // 소비자
    // C도 Thread를 상속한 클래스
    // C 클래스는 Factory로부터 데이터를 받는다 get()

    Factory f;
    // 생성자에서 동일한 Factory 객체를 전달받음

    C(Factory f) {
        // Factory 객체 저장
        this.f = f;
    }

    public void run() {
        // start()가 호출되면 run()이 실행됨
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = f.get();  // 여기서 Factory의 get()이 return한 값을 받음
        }
        // Factory의 get() 메서드를 10번 호출해서 값을 받아옴
    }
}


public class ExThredadTest4 {
    public static void main() {
        Factory f = new Factory(); // 공유 자원
        // Factory 객체 생성

        P p = new P(f);  // 생산자
        C c = new C(f);  // 소비자
        // P와 C 객체 생성하면서 같은 Factory를 전달함.

        p.start(); // 생산자 스레드 시작
        c.start(); // 소비자 스레드 시작
        // P 클래스의 run() 실행됨 → send() 10번 호출
        // C 클래스의 run() 실행됨 → get() 10번 호출
        // 이 둘은 같은 Factory 인스턴스를 공유하면서 번갈아 동작

        /*
        실행 흐름 정리
        1. P가 Factory.send(0) 호출 → 저장
        2. C가 Factory.get() 호출 → 꺼냄
        3. P가 send(1) → 저장
        4. C가 get() → 꺼냄
        5. 반복...
         */
    }
}
