package Day23;
// 정답문제
import java.util.Random;

abstract class Vehicle1{
    int distance;
    int gauge;

    abstract void Move(int stop, Random r, int count);
}

interface Booster1{
    void Boost();
}


class Car1 extends Vehicle1 implements Booster1{
    void gaugePrint(int count) {
        gauge = count % 4;
        System.out.print("자동차의 게이지 : "+super.gauge+",");
    }
    void distancePrint() {
        System.out.println("자동차 주행 거리 : "+super.distance);
    }

    @Override
    void Move(int stop, Random r, int count) {
        int move = r.nextInt(21);

        if(stop == 1) {
            distance += 0;
        }
        else {
            distance += move;
        }
        gaugePrint(count);
        distancePrint();
    }
    @Override
    public void Boost() {
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
    public void Boost() {
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
    public void Boost() {
        distance += 3;
    }
}


public class Q3_1 {

    static void boosterRun(int stop, Vehicle1 v) {
        if(v instanceof Car1) {
            if(stop != 1 && v.gauge == 3) {
                ((Car1) v).Boost();
            }
        }
        if(v instanceof Bicyle1) {
            if(stop != 2 && v.gauge == 1) {
                ((Bicyle1) v).Boost();
            }
        }
        if(v instanceof Motocycle1) {
            if(stop != 3 && v.gauge == 2) {
                ((Motocycle1) v).Boost();
            }
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Random r = new Random();
        Car1 c = new Car1();
        Bicyle1 b = new Bicyle1();
        Motocycle1 m = new Motocycle1();

        int count = 0; // 턴
        int stop;

        while(true) {
            stop = r.nextInt(3)+1;

            boosterRun(stop, c);
            boosterRun(stop, b);
            boosterRun(stop, m);

            c.Move(stop, r, count);
            b.Move(stop, r, count);
            m.Move(stop, r, count);

            c.gauge++;
            b.gauge++;
            m.gauge++;

            if(c.distance >=500 || b.distance >= 500 || m.distance >= 500) {
                break;
            }

            count++;

        }

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
