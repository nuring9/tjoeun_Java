package Day24;

class Account1 {
    private int total = 0;

    synchronized void deposit(){
        total += 1000;
    }

    int getTotal() {
        return total;
    }
}

class  Customer1 extends Thread {
    Account1 a;

    Customer1(Account1 a, String s){
        this.a = a;
        setName(s);
    }

    public void run(){
        int i = 0;

        while (true){
            System.out.println(getName() + " : " + ++i + "번째");
            a.deposit();

            if (a.getTotal() >= 500000) {
                break;
            }

        }
    }

}

public class Q1_1 {
    static void main() throws InterruptedException {

        Account1 a = new Account1();
        Customer1 c1 = new Customer1(a, "1번째 성금자");
        Customer1 c2 = new Customer1(a, "2번째 성금자");
        Customer1 c3 = new Customer1(a, "3번째 성금자");
        Customer1 c4 = new Customer1(a, "4번째 성금자");
        Customer1 c5 = new Customer1(a, "5번째 성금자");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();

        System.out.println("성금 총액은 : " + a.getTotal());
    }
}
