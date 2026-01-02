package Day20;

class Terran {
    //1. 마린 배열 객체 3마리
    Marine[] m = new Marine[3];
    //턴 변수
    int turn = 0;

    Terran() {
        for (int i = 0; i < m.length; i++) {
            m[i] = new Marine();
        }
    }

    //1. 공격
    Marine attackZerg() {
        if (m[0] != null || m[1] != null || m[2] != null) {
            // 마린 null 체크
            while (m[turn % 3] == null) {
                turn++;
            }
            System.out.println("마린의 " + turn % 3 + "번째가 공격을 합니다.");// 0 1 2
            return m[turn++ % 3];
        } else {
            return null;
        }
    }

    //2. 방어
    Marine beAttackedTerran() {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.println("마린 " + i + "번째가 공격을 당합니다.");
                return m[i];
            }
        }
        return null;
    }

    //3. hp -> null 작업
    void energyCheck() {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].hp <= 0) {
                System.out.println("마린 " + i + "번째가 사망했습니다.");
                m[i] = null;
            }
        }
    }

    //4. 종료체크
    boolean gameOverCheck() {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                return true;
            }
        }
        return false;
    }
}

class Zerg {
    //1. 저글링 , 히드라
    Juggling j;
    Hydra h;
    int turn = 0;

    Zerg() {
        j = new Juggling();
        h = new Hydra();
    }

    //1. 공격
    Unit attackZerg() {
        if (j != null || h != null) {
            // 마린 null 체크
            if (j == null) {
                return h;
            }
            if (turn % 2 == 0) {
                System.out.println("저글링이 공격을 합니다.");// 0 1 2
                turn++;
                return j;
            } else {
                System.out.println("히드라가 공격을 합니다.");// 0 1 2
                turn++;
                return h;

            }
        } else {
            return null;
        }
    }

    //2. 방어
    void beAttackedZerg(Marine m) {
        if (j != null) {
            System.out.println("저글링을 공격합니다.");
            j.hp -= m.attack;
        } else {
            System.out.println("히드라를 공격합니다.");
            h.hp -= m.attack;
        }
    }

    //3. hp -> null 작업
    void energyCheck() {
        if (j != null && j.hp <= 0) {
            System.out.println("저글링이 사망했습니다.");
            j = null;
        }
        if (h != null && h.hp <= 0) {
            System.out.println("히드라가 사망했습니다.");
            h = null;
        }
    }

    //4. 종료체크
    boolean gameOverCheck() {
        if (j != null) {
            return true;
        }
        if (h != null) {
            return true;
        }
        return false;
    }
}

public class Q1_1 {
    static void main() {
        Terran t = new Terran();
        Zerg z = new Zerg();
        boolean check = true;
        int count = 1;
        while (check) {
            //테란공격
            System.out.println((count++) + "턴 테란 공격");
            Marine m = t.attackZerg();
            z.beAttackedZerg(m);
            z.energyCheck();
            check = z.gameOverCheck();
            if (check == false) {
                System.out.println("테란이 승리했습니다.");
                break;
            }
            //저그공격
            System.out.println((count++) + "턴 저그 공격");
            Unit u = z.attackZerg();
            Marine bm = t.beAttackedTerran();
            bm.hp -= u.attack;
            t.energyCheck();
            check = t.gameOverCheck();
            if (check == false) {
                System.out.println("저그가 승리했습니다.");
            }
        }
    }
}
