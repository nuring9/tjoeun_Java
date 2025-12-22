package Day14;

import java.util.Random;
// Q2_1과 같은 코드임. 다시 해봄.

class Player2 {
    int num, distance;
    String country;


    Player2(int num, String country) {
        this.num = num;
        this.country = country;

    }

    void battle(boolean check) {
        Random r = new Random();

        if (check) {
            System.out.println(this.country + " 돌발상황 입니다.");
        } else {
            distance += r.nextInt(10) + 1; // 1~10
            System.out.println(this.num + "레인 " + this.country + " : " + this.distance + "M 입니다.");
        }
    }
}


public class Q2 {
    static void main() {
        Random r = new Random();
        Player2 kor = new Player2(1, "한국");
        Player2 chi = new Player2(2, "중국");
        Player2 ame = new Player2(3, "미국");
        Player2 rus = new Player2(4, "러시아");

        while (true) {
            int dobbal = r.nextInt(4) + 1; // 1~4
            if (kor.num == dobbal) {
                kor.battle(true);
                chi.battle(false);
                ame.battle(false);
                rus.battle(false);
            } else if (chi.num == dobbal) {
                kor.battle(false);
                chi.battle(true);
                ame.battle(false);
                rus.battle(false);
            } else if (ame.num == dobbal) {
                kor.battle(false);
                chi.battle(false);
                ame.battle(true);
                rus.battle(false);
            } else {
                kor.battle(false);
                chi.battle(false);
                ame.battle(false);
                rus.battle(true);
            }

            if (kor.distance >= 100 || chi.distance >= 100 || ame.distance >= 100 || rus.distance >= 100) {
                break;
                // 100이상이면 while문 반복 해제
            }
        }


        int max = kor.distance; // max에 kor distance 를 일단 넣어둠.
        // 최대값을 찾을 때는 모든 변수를 한 번씩 전부 검사해야 하므로, 단일 if 써야함.
        //else if를 쓰면: 첫 번째 조건이 참이 되는 순간 나머지 조건들은 아예 확인하지 않고 건너뜀.
        // 만약 chi.distance가 kor.distance보다 커서 첫 번째 if가 실행되면, 그 뒤에 있는 미국이나 러시아가 더 멀리 갔더라도 확인조차 하지 않게 됨.
        // 단일 if를 쓰면: 한국 vs 중국, 그 결과 vs 미국, 그 결과 vs 러시아 식으로 순차적으로 모든 대상을 비교하여 확실한 최대값을 남길 수 있다.
        if (max < chi.distance) {
            max = chi.distance; //  max 재정의
        }
        if (max < ame.distance) {
            max = chi.distance; //  max 재정의
        }
        if (max < rus.distance) {
            max = chi.distance; //  max 재정의
        }



        // 공동 우승자 처리
        // 단일 if를 여러 번 사용하는 진짜 이유는 "공동 1위"*를 출력하기 위해서
        if (max == kor.distance) {  // 최대값이 한국이면
            System.out.print("한국 ");
        }
        if (max == chi.distance) {  // 최대값이 한국이면
            System.out.print("중국 ");
        }
        if (max == ame.distance) {  // 최대값이 한국이면
            System.out.print("미국 ");
        }
        if (max == rus.distance) {  // 최대값이 한국이면
            System.out.print("러시아 ");
        }


        System.out.println("우승입니다.");


    }
}




