package Day24;

/*
강의에서는 index를 0으로 시작하여서, 출력할때 0으로 출력됨.
나는 1부터 출력되고 싶어서 변경함.
그래서 출력 먼저하고 index를 ++ 함.
 */
import java.util.Random;

class Present {
    // 진짜 선물의 존재 자체를 표현하는 클래스.
    // null 이면 꽝, new Present()면 진짜 선물
}

class TreasurBox {
    Present[] p = new Present[100];
    // Present 객체 100개를 담을 배열
    //기본값은 전부 null → 전부 꽝 상태

    TreasurBox() {
        Random r = new Random();
        int num = r.nextInt(p.length);
        // 0 ~ 99 중 랜덤 숫자 하나 선택.

        p[num] = new Present();
        // 딱 한 칸에만 Present 객체 생성
        // 나머지 99칸은 null → 꽝
        System.out.println("보물의 위치는 : " + num);
        // 디버깅용 출력
        // 실제 게임이면 없어야 정상
    }

    synchronized Present openBox(int index) {
        // 여러 사람이 동시에 열기 때문에 synchronized
        // 한 순간에 한 스레드만 열 수 있음

        if (index <= 99) {
            return p[index];
            // 유효한 인덱스면 해당 선물 반환
            // null → 꽝
            // Present 객체 → 진짜 선물
        } else {
            return null;
            // 범위 초과 시 무조건 꽝 처리
        }
    }
}

class Joiner extends Thread {
    // 각 참가자를 스레드로 표현
    static int index = 1; // 여러명이 하나의 index를 사용할 수 있게 static 으로 index 만듦.
    // 모든 Joiner가 공유하는 번호
    // static → 하나만 존재
    // 1부터 시작 → 출력이 1~100
    // “누가 열든 다음 상자는 이어서 연다”

    TreasurBox t;
    Present p = null;
    // t : 공유 보물상자
    // p : 이 사람이 마지막으로 연 결과

    Joiner(TreasurBox t, String s) {
        this.t = t;  // 같은 TreasurBox를 모든 사람이 공유
        setName(s);  // 스레드 이름 설정 (출력용)
    }


    public void run() {
        while (true) {
            // 계속 상자를 열다가 조건이 되면 break
            p = t.openBox(index - 1);
            // 출력은 1부터지만, 배열은 0부터 → index - 1
            System.out.println(index + " " + getName() + " 보물확인");
            // 출력
            index++;
            // 다음 사람이 열 상자로 이동, 다음 번호 준비

            if (p != null) {  // 선물 오픈됨.
                // 객체가 있으면 진짜 선물, null이 아니면 객체가 있음.
                System.out.println("보물이 있습니다.");
            } else {
                // 없으면 꽝
                System.out.println("보물이 없습니다.");
            }

            if (index > 100 || p != null) {
                // 100개 다 열었거나, 누군가 선물을 찾았으면 게임 종료
                break;
            }
        }
    }
}


public class Q2 {
    static void main() throws InterruptedException {
        TreasurBox t = new TreasurBox();
        // 보물 100개 중 1개 랜덤 배치
        Joiner j1 = new Joiner(t, "홍길동");
        Joiner j2 = new Joiner(t, "호랑이");
        Joiner j3 = new Joiner(t, "강아지");
        // 참가자 3명 생성

        j1.start();
        j2.start();
        j3.start();
        // 동시에 게임 참여

        j1.join();
        j2.join();
        j3.join();
        // 메인 스레드가 끝날 때까지 기다림


        // 누가 선물을 찾았는지 확인
        if (j1.p != null) {
            System.out.println(j1.getName() + " 최종 보물을 찾았습니다.");
        }
        if (j2.p != null) {
            System.out.println(j2.getName() + " 최종 보물을 찾았습니다.");
        }
        if (j3.p != null) {
            System.out.println(j3.getName() + " 최종 보물을 찾았습니다.");
        }
    }
}
