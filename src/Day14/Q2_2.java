package Day14;

import java.util.Random;

/*
클래스 배열 사용
 */


class Player1 {
    int num; //레인번호
    String country;//나라
    int distance;

    Player1(int num, String country) {
        this.num = num;
        this.country = country;
    }
    // 객체 생성시 반드시 호출되는 생성자 메서드, Playre1에는 num과 country를 갖음.

    void checkAndMove(boolean check) {
        // 돌발상황 발생 여부에 따른 로직
        // 턴마다 행동 결정.
        
        Random r = new Random();
        //check true : 돌발상황 발생 -> 멈춤
        //check false : 돌발상황 발생 X -> 이동
        if (check) {
            System.out.println(this.country + "돌발상황 입니다.");
            // 멈춤, distance 변화 없음.
        } else {
            distance += r.nextInt(10) + 1;
            // 움직일때 distance에 누적값 저장으로 움직임.
            System.out.println(this.num + "레인" + this.country + " : " + this.distance + "M 입니다.");
        }
    }
}

public class Q2_2 {
    static void main() {
        Random r = new Random();
        // 랜덤

        Player1[] players = new Player1[4];
        // Player1 객체 4개 생성
        // 모두 null

        String[] countrys = {"한국", "중국", "미국", "러시아"};
        // 국가 이름 4개를 문자열 배열로 저장

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player1(i + 1, countrys[i]);
        }
        // player[0] = new player(1, countrys[0]);  // 한국
        // player[1] = new player(2, countrys[1]);  // 중국
        // player[2] = new player(3, countrys[2]);  // 미국
        // player[3] = new player(4, countrys[3]);  // 러시아
        // 즉, 각 Player1에 num과, country를 갖음.


        boolean check = true;
        // check 가 true일 경우 반복.
        // 돌발 상황(정지 상태) 여부 판별.

        while (check) {
            int ran = r.nextInt(4) + 1;
            // 1~4중에 랜덤 생성

            for (int i = 0; i < players.length; i++) {
                if (players[i].num == ran) {
                    players[i].checkAndMove(true);
                } else {
                    players[i].checkAndMove(false);
                }
            }
            // player[0]~[3]까지 돌면서 num이랑 ran 같으면 true(정지), 아니면 false(움직임)


            // 경기의 종료 여부 결정
            for (int i = 0; i < players.length; i++) {
                if (players[i].distance >= 100) {
                    check = false;
                    break;
                }
            }
            // distance  거리가 100보다 같거나 크면  check = false;후 break로 반복 빠져나옴.

        }

        int max = 0;
        // 최대값 찾기

        for (int i = 0; i < players.length; i++) {
            if (players[i].distance > max) {
                max = players[i].distance;
            }
        }
        // players[i]의 distance가 max보다 크면 max에 덮어씌움

        for (int i = 0; i < players.length; i++) {
            if (players[i].distance == max) {
                System.out.println("우승국은 " + players[i].country + "입니다.");
            }
        }
        // 전체 객체의 distance 중에 현재 max(최대값)와 같으면 우승국

    }
}
