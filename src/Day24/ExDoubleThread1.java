package Day24;

class ThreadTest1 extends Thread {
    // 클래스 ThreadTest1 는 Thread 클래스를 상속함으로써 이 클래스 자체가 쓰레드 역할을 함.
    public ThreadTest1(String str) {  // 생성자
        setName(str);    // str은 ← 매개변수 (parameter)
        // Thread 클래스의 setName() 메서드 사용 → 쓰레드 이름 설정
        // 즉, 생성자에서 setName(str) 호출해서 쓰레드 이름을 지정.
        // setName() 메서드는 Thread 클래스에 원래부터 존재하는 메서드
    }

    public void run() {
        // run() 메서드는 쓰레드가 실행할 코드 → 0~10까지 숫자를 출력하면서 이름도 같이 출력.
        // start()를 하면 run() 메서드가 실행됨.
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + getName());
            // getName()도 Thread 클래스에 원래부터 있는 메서드.
            // 현재 쓰레드의 이름을 반환하는 역할

        }
        System.out.println("끝" + getName());
    }
}


public class  ExDoubleThread1 {
    static void main() {
        ThreadTest1 t1 = new ThreadTest1(" : 배우기 쉬운 자바");  // " : 배우기 쉬운 자바"는 ThreadTest1 생성자의 인자/인수(argument)
        // 즉 인자가 쓰레드의 이름이 됨.
        ThreadTest1 t2 = new ThreadTest1(" : 배우기 어려운 자바");
        t1.start();  // 1번 쓰레드 실행
        t2.start();  // 2번 쓰레드 실행

     /*
      타이밍이 예측이 안됨.
  
      ThreadTest1 인스턴스를 2개 생성 (t1, t2) 하여
      각각 start() 호출 → 두 개의 쓰레드가 동시에 실행됨
      출력 순서는 비동기적으로 섞임
      (즉, 실행 타이밍마다 출력 순서가 바뀜)
    */
    }
}
