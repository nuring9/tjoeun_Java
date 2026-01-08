package Day23;

import java.util.Random;

// 너무 어렵죠
// 자지말고 공부해요 -> 새벽 2시까지 했어요 강남 다니면서

abstract class Vehicle1{
    int distance;
    int gauge;
    //이동 관련된 추상메소드
    //                     돌발상황   랜덤       턴
    abstract void Move(int stop, Random r, int count);
}

interface Booster1{
    void boost();
}


class Car1 extends Vehicle1 implements Booster1{
    // 게이지 프린트 턴이 -> 나머지 여산자 % 4 잡고
    // 출력
    void gaugePrint(int count) {
        gauge = count % 4;
        System.out.print("자동차의 게이지 : "+super.gauge+",");
    }
    // 자동차 주행거리 출력
    void distancePrint() {
        System.out.println("자동차 주행 거리 : "+super.distance);
    }

    @Override
    void Move(int stop, Random r, int count) {
        // 0~21까지 난수 생성
        int move = r.nextInt(21);
        // 1이면 나 돌발상황
        if(stop == 1) {
            distance += 0;// 그냥 0 더해
        }
        // 나 돌발 상황 아니네
        else {
            distance += move; // 난수만큼 이동해
        }
        // 게이지 출력
        gaugePrint(count);
        // 이동거리 출력
        distancePrint();
    }
    // 부스터 발동 + 2 증가
    @Override
    public void boost() {
        distance += 2;
    }
}

class Bicyle1 extends Vehicle1 implements Booster1{
    void gaugePrint(int count) {
        gauge = count % 2;
        System.out.print("자전거의 게이지 : "+super.gauge+",");
    }
    void distancePrint() {
        System.out.println("자전거 주행 거리 : "+super.distance);
    }

    @Override
    void Move(int stop, Random r, int count) {
        int move = r.nextInt(11);

        if(stop == 2) {
            distance += 0;
        }
        else {
            distance += move;
        }
        gaugePrint(count);
        distancePrint();
    }
    @Override
    public void boost() {
        distance += 5;
    }
}

class Motocycle1 extends Vehicle1 implements Booster1{
    void gaugePrint(int count) {
        gauge = count % 3;
        System.out.print("오토바이의 게이지 : "+super.gauge+",");
    }
    void distancePrint() {
        System.out.println("오토바이 주행 거리 : "+super.distance);
    }

    @Override
    void Move(int stop, Random r, int count) {
        int move = r.nextInt(16);

        if(stop == 3) {
            distance += 0;
        }
        else {
            distance += move;
        }
        gaugePrint(count);
        distancePrint();
    }
    @Override
    public void boost() {
        distance += 3;
    }
}


public class Q3_1 {
    // 부스터 발동을 시키는 메소드
    // 돌방상황 번호, 탈것 객체(추상화 클래스) -> 실제 자동차, 자전거, 오토바이
    static void boosterRun(int stop, Vehicle1 v) {
        //    Vehicle    Booster
        //    Car , Bicyle, Motocycle
        if(v instanceof Car1) { // 차야
            if(stop != 1 && v.gauge == 3) { // 게이지랑 돌발상황 확인
                ((Car1) v).boost(); // 부스터 온
            }
        }
        if(v instanceof Bicyle1) { // 자전거야
            if(stop != 2 && v.gauge == 1) { // 게이지랑 돌발상황 확인
                ((Bicyle1) v).boost(); // 부스터 온
            }
        }
        if(v instanceof Motocycle1) {// 오토바이야
            if(stop != 3 && v.gauge == 2) { // 게이지랑 돌발 상황 확인
                ((Motocycle1) v).boost(); // 부스터 온
            }
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Random r = new Random(); // 돌발 상황 때문에 랜덤 객체 생성
        Car1 c = new Car1(); // 자동차 객체 생성
        Bicyle1 b = new Bicyle1(); // 자전거 객체 생성
        Motocycle1 m = new Motocycle1(); // 오토바이 객체 생성

        int count = 0; // 턴
        int stop; // 돌발 상황을 담을 변수 선언
        // 무한 루프
        while(true) {
            stop = r.nextInt(3)+1; // 누가 멈출지 정하는 난수
            // 부스터 실행
            boosterRun(stop, c);
            boosterRun(stop, b);
            boosterRun(stop, m);
            // 실제 런 실행
            c.Move(stop, r, count);
            b.Move(stop, r, count);
            m.Move(stop, r, count);
            // 게이지 1씩 계속증가
            c.gauge++;
            b.gauge++;
            m.gauge++;
            // 승자 확인
            // 누구든 500 넘으면 종료
            if(c.distance >=500 || b.distance >= 500 || m.distance >= 500) {
                break;
            }
            // 턴 증가
            count++;
        }
        // 우승 확인해주는 기능
        if(c.distance>b.distance && c.distance > m.distance) {
            System.out.println("자동차 우승입니다.");
        }
        else if(b.distance > c.distance && b.distance > m.distance) {
            System.out.println("자전거 우승입니다.");
        }
        else {
            System.out.println("오토바이 우승입니다.");
        }
    }
}


// 게이지는 증가는 되어있지만 쓸수는 없다.

// 여기서 게이지 초기화?

// 공동우승 만들게되면 최대수 빼기