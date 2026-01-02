package Day20;
/*
유닛 = 가격, 에너지, 공격력, 방어력, 타겟 이동속도, 유형
저글링 = 50, 35, 5, 0, 지상, 2.612, "지상,소형,생체"
히드라 = 100, 80, 10, 0, "지상,공중", 1.741, "지상,중형,생체"
마린 = 50, 50, 6, 0, "지상,공중", 1.875, "지상,소형,생체"
저글링과 히드라 마린은 프린트 함수가 있습니다.
처음 시작 시 출력
System.out.println("히드라의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + ", 방어력 " + super.defence + ", 공격대상 " + super.target + ", 이동속도 " + super.speed + ", 유닛 특성 " + super.characteristic + "입니다." );

문제 못풀겠으면
마린 3마리 객체 생성 후 프린트만 출력
저글링 객체 생성후 프린트만 출력
히드라 객체 생성후 프린트만 출력

테란 공격을 하면 (마린 1번이 저글링을 공격함)
저그 공격을 하면 (저글링이 마린 1번을 공격)
마린 3마리를 생성, 저글링 1마리 히드라 1마리 생성.

마린 3마리와 저글링과 히드라가 턴으로 싸움을 함.
그리고 누가 이기는지 출력.

마린의 첫 타켓은 저글링, 저글링이 죽으면 히드라로 타겟을 바꿈(즉, 턴)


 */
abstract class Unit {
    int price;
    int hp;
    int attack;
    int defence;
    String target;
    double speed;
    String characteristic;

    Unit(int price, int hp, int attack, int defence, String target, double speed, String characteristic) {
        this.price = price;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.target = target;
        this.speed = speed;
        this.characteristic = characteristic;
    }

    abstract void print();
}

class Juggling extends Unit {
    Juggling() {
        super(50, 35, 5, 0, "지상", 2.612, "지상,소형,생체");
    }

    void print() {
        System.out.println("저글링의 생산비용은 미네랄 :" + price + ", 체력: " + hp + ", 공격력: " + attack + " 방어력: " + defence +
                "\n, 공격대상: " + target + ", 이동속도: " + speed + ", 유닛특성: " + characteristic);
    }
}

class Hydra extends Unit {
    Hydra() {
        super(100, 80, 10, 0, "지상,공중", 1.741, "지상,중형,생체");
    }

    void print() {
        System.out.println("히드라의 생산비용은 미네랄 :" + price + ", 체력: " + hp + ", 공격력: " + attack + " 방어력: " + defence +
                "\n, 공격대상: " + target + ", 이동속도: " + speed + ", 유닛특성: " + characteristic);
    }
}

class Marine extends Unit {
    Marine() {
        super(50, 50, 6, 0, "지상,공중", 1.875, "지상,소형,생체");
    }

    void print() {
        System.out.println("마린의 생산비용은 미네랄 :" + price + ", 체력: " + hp + ", 공격력: " + attack + " 방어력: " + defence +
                "\n, 공격대상: " + target + ", 이동속도: " + speed + ", 유닛특성: " + characteristic);
    }
}

public class Q1 {
    static void main() {
//        Juggling j = new Juggling();
//        Hydra h = new Hydra();
//        Marine[] m = new Marine[3];
//        for(int i = 0;i<m.length;i++){
//            m[i] = new Marine();
//        }
//        j.print();
//        h.print();
//        for(int i = 0;i<m.length;i++){
//            m[i].print();
//        }
        Unit[] u = new Unit[5];
        for (int i = 0; i < u.length; i++) {
            if (i == 0) {
                u[i] = new Juggling();
            } else if (i == 1) {
                u[i] = new Hydra();
            } else {
                u[i] = new Marine();
            }
        }
        for (int i = 0; i < u.length; i++) {
            u[i].print();
        }
    }
}
