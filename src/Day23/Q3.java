package Day23;
/*
내가 풀다 만 문제

<클래스>
<추상, 일반> 탈것 vehicle : 주행거리, 게이지, 이동함수
자동차 탈것을 상속, 주행거리를 출력함수 구현, 게이지 출력함수 구현, 이동함수 오버라이딩
자전거 탈것을 상속, 주행거리를 출력함수 구현, 게이지 출력함수 구현, 이동함수 오버라이딩
오토바이 탈것을 상속, 주행거리를 출력함수 구현, 게이지 출력함수 구현, 이동함수 오버라이딩

<인터페이스>
부스트 (아무것도 없습니다.)
자동차, 자전거, 오토바이가 상속을 받습니다.

main문
부스터 실행하는 함수 구현

1턴씩 자동차 자전거 오토바이가 진행이 됩니다.
랜덤으로 1~3중
1: 자동차 움직이지 못합니다.  2: 자전거 움직이지 못합니다.  3: 오토바이가 움직이지 못합니다.

자동차: 0~20  /  자전거 0~10  / 오토바이: 0~15 까지

2턴마다 자전거는 부스터 발동 부스터 발동을 하면 주행거리에 +5를 추가로 이동합니다.
3턴마다 오토바이는 부스터 발동 부스터 발동을 하면 주행거리에 +3를 추가로 이동합니다.
4턴마다 자동차는 부스터 발동 부스터 발동을 하면 주행거리에 +2를 추가로 이동합니다.
(단, 부스터 인터페이스를 이용해서 구현이 되도록 하면 함수는 한개를 만들어서 동작을 하게 합니다.)

이렇게 경주를 하여서 먼저 도착하는 탈것이 무엇인지 출력이 되면 됩니다.
(모든 탈것은 주행거리 와 게이지는 턴마다 출력이 되야합니다.)
게이지는 턴마다 하나씩 증가합니다. 자전거 같은 경우에는 3턴이 진행시 게이지가 0으로 초기화 됩니다.

500m를 먼저 들어오는 탈것이 우승입니다.

 */

import java.util.Random;

abstract class Vehicle {
    String name;
    int distance, fuelLevel, move;  // 주행거리, 게이지, 이동거리

    Vehicle(String name) {
        this.name = name;
    }

    abstract void moveSum();

    abstract void print();
}

interface Booster {
// 부스터 인터페이스로 태그화.
}

class Car extends Vehicle implements Booster {
    // 자동차

    Car() {
        super("자동차");
        Random r = new Random();
        move = r.nextInt(21);
        distance = move;
    }

    void moveSum() {
        fuelLevel = 5;
        distance += fuelLevel;
    }

    void print() {
        System.out.println(name + "의 게이지 : " +  fuelLevel + ", 자동차 주행거리 : " + distance+ " " + move);
    }
}

class Bicycle extends Vehicle implements Booster {
    // 자전거
    Bicycle() {
        super("자전거");
        Random r = new Random();
        move = r.nextInt(11);
        distance += move;
    }

    void moveSum() {
        fuelLevel = 2;
        distance += fuelLevel;
    }

    void print() {
        System.out.println(name + "의 게이지 : " +  fuelLevel + ", 자전거 주행거리 : " + distance+ " " + move);
    }
}

class Motorcycle extends Vehicle implements Booster {
    // 오토바이
    Motorcycle() {
        super("오토바이");
        Random r = new Random();
        move = r.nextInt(16);


    }

    void moveSum() {
        fuelLevel = 3;
        distance += fuelLevel;
    }

    void print() {
        System.out.println(name + "의 게이지 : " +  fuelLevel + ", 오토바이 주행거리 : " + distance +  " " +move);
    }
}





public class Q3 {
    static void main() {
        Random r = new Random();
        Vehicle vehi1 = new Car();
        Vehicle vehi2 = new Bicycle();
        Vehicle vehi3 = new Motorcycle();

        int carTurn = 2;
        int biyTurn = 3;
        int motoTurn = 4;
        boolean check = true;



            int turn = r.nextInt(3);  // 0,1,2
            if(turn == 0 ){
                vehi1.fuelLevel += 0;
                vehi2.fuelLevel += 2;
                vehi3.fuelLevel += 3;
            } else if ( turn == 1 ) {
                vehi1.fuelLevel += 5;
                vehi2.fuelLevel += 0;
                vehi3.fuelLevel += 3;
            } else {
                vehi1.fuelLevel += 5;
                vehi2.fuelLevel += 2;
                vehi3.fuelLevel += 0;
            }

            vehi1.print();
            vehi2.print();
            vehi3.print();


    }
}
