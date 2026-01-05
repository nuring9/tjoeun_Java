package Day21;

// interface를 태그처럼 사용.
// 추상화를 사용할때 interface를 많이 사용하고, 태그는 그냥 이런 기능이 있다는 것 정도만 알기.

// 기계라면 수리
interface Repairable {
}

// 생체면 힐
interface Heal {
}

// 유닛
class Unit {
    int attack;
    int hipPoint;
    final int MAX_HP;

    Unit(int hp, int attack) {
        MAX_HP = hp;
        this.attack = attack;
    }
}

// 기어다니는 유닛
class GroundUnit extends Unit {
    GroundUnit(int hp, int attack) {
        super(hp, attack);
    }
}

// 날아다니는 유닛
class AirUnit extends Unit {
    AirUnit(int hp, int attack) {
        super(hp, attack);
    }
}

// 탱크
class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150, 10);
        hipPoint = MAX_HP;
    }

    // Object class를 오버라이딩 함. 자바의 모든 클래스는 Object 클래스를 상속 받는다.
    @Override
    public String toString() {
        return "Tank";
    }
}

// 정비사, 기계를 수리도 가능한데, 힐이라는것도 받을 수 있다.
class SCV extends GroundUnit implements Repairable, Heal {
    SCV() {
        super(60, 5);
        hipPoint = MAX_HP;
    }

    void repair(Repairable r) {
        if (r instanceof Unit) {
            Unit u = (Unit) r;
            if (u != null && u.MAX_HP != u.hipPoint) {
                u.hipPoint += 2;
            }
        }
    }
}

class Marine extends GroundUnit implements Heal {
    Marine() {
        super(40, 4);
        hipPoint = MAX_HP;
    }
}


public class FinalTest {
    static void main() {
        Tank t = new Tank();
        SCV s = new SCV();
        Marine m = new Marine();
        s.repair(t);
        // s.repair(m); 마린은 Repairalble이 없다.
    }
}
