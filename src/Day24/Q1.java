package Day24;
// 5명의 스레드가 동시에 Account에 1000원씩 계속 더하다가 총액이 50만원 이상 되면 각자 멈추고, 메인은 다 끝나길 기다렸다가 최종 총액을 출력
// 여러 명의 성금자가 “동시에” 돈을 넣는 상황을 만들기 위해서 Thread 사용.


class Account {
    // 여러 스레드(Customer)들이 공유하는 객체.
    private int total = 0;

    // 성금 총액(잔액).
    // private라서 밖에서는 직접 접근 못하고 메서드로만 접근.
    synchronized void deposit() {
        // deposit() : 1000원씩 추가.
        total += 1000;
    }
    // synchronized : 한 번에 한 스레드만 이 메서드에 들어오게 잠금.
    // 이유, 여러 스레드가 동시에 total += 1000 하면 “덮어쓰기/누락”이 생길 수 있음(경쟁 상태).
    // synchronized 덕분에 deposit() 실행 중에는 다른 스레드가 못 들어옴.

    int getTotal() {
        // getTotal() : 현재 총액 리턴.
        return total;
    }
    // getTotal()은 synchronized가 아님
    // 읽기만 하지만, 멀티스레드에서 “최신 값 보장” 관점에선 애매할 수 있음.
    //실전이면 synchronized int getTotal() 또는 volatile/AtomicInteger 등을 고려.

}

class Customer extends Thread {  // 성금자 = 스레드
    // Customer는 Thread를 상속 → start()로 실행 가능.
    Account a;
    // Account a; 이 스레드가 입금할 “공유 통장” 참조.

    Customer(Account a, String s) {
        // Customer 생성자.
        this.a = a;
        // 전달받은 Account를 저장(모든 Customer가 같은 Account를 공유하게 됨).
        setName(s);
        // 스레드 이름 지정 → 출력에 사용.
    }

    @Override
    public void run() {
        // run() 스레드가 실제로 수행할 작업.
        int i = 0;
        // 이 스레드가 몇 번 입금했는지 카운트.

        while (true) {
            //무한 반복하면서 계속 입금.
            System.out.println(getName() + " : " + ++i + "번째");
            // ++i : 먼저 1 증가시킨 뒤 출력(1번째, 2번째…).
            a.deposit();
            // 공유 Account에 1000원 입금.
            // deposit()이 synchronized라서 동시 입금 충돌을 막음.

            if (a.getTotal() >= 500000) {
                // 총액이 50만원 이상이면 반복 종료하고 스레드 끝냄.
                break;
                /*
                deposit()은 잠금인데, if(a.getTotal()>=...) 체크는 잠금 밖이라
                여러 스레드가 거의 동시에 입금하고 체크하면서 50만원을 “넘겨서” 끝날 수 있음
                (예: 500,000 딱 맞추기보다 501,000 / 503,000처럼 더 커질 수 있음)
                 */
            }
        }
    }
}


public class Q1 {
    static void main() throws InterruptedException {
        // join()이 인터럽트 될 수 있어서 예외를 던지게 함.

        Account a = new Account();
        // 공유 Account 객체 1개 생성. 모든 스레드가 이 객체 하나를 공유함.
        Customer c1 = new Customer(a, "1번째 성금자");
        Customer c2 = new Customer(a, "2번째 성금자");
        Customer c3 = new Customer(a, "3번째 성금자");
        Customer c4 = new Customer(a, "4번째 성금자");
        Customer c5 = new Customer(a, "5번째 성금자");
        // 성금자 스레드 5개 생성. 스레드는 배열로 할 경우 에러가 발생하기 때문에 각자 생성.

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        // 새 스레드를 만들어서 run()을 병렬 실행.
        // run()을 직접 호출하면 병렬이 아니라 그냥 메인 스레드에서 실행됨(중요).

        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        // 메인 스레드가 각 스레드가 끝날 때까지 기다림.
        // join 없으면, 메인이 먼저 끝나서 총액 출력 전에 프로그램이 종료될 수도 있음(상황에 따라).

        System.out.println("성금 총액은 : " + a.getTotal());
        // 모든 스레드가 끝난 뒤 최종 총액 출력.
    }
}
