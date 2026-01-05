package Day21;
/*
원숭이가 총 5마리가 있다.
원숭이는 상자를 가지고 있다.
그리고 원숭이는 각각 5마리가 있고, 색상이 있다.
1번 원숭이 : 빨간 / 2번 원숭이 : 노란 / 3번 원숭이 : 파란
4번 원숭이 : 초록 / 5번 원숭이 검정
처음 상자는 빨간 원숭이가 가지고 있음.
그리고 원숭이가 스스로 " 무슨 원숭이가 물건을 가지고 있습니다"
또는 " 무슨 원숭이가 물건을 가지고 있지 않습니다." 가 출력.
원숭이는 상자를 가질 수가 있어야 함.

2가지 랜덤수를 받는다. 하나는 좌우 0 (좌) / 1 (우) 
또 하나는 횟수. 1~5까지 

게임을 시작.
우선 제일 먼저 빨간 원숭이가 상자를 가지고 있다.
랜덤값이 0/1 이면
빨 -> 노 -> 파 -> 초 -> 검 (1) 우측으로 상자이동
노 <- 파 <- 초 <- 검 <- 빨 (0) 좌측으로 상자이동
*/

import java.util.Random;

class Monkey {
    String color;
    Box box;

    Monkey(String color) {
        this.color = color;
    }


    void haveBox() {
        if (box != null) {
            System.out.println(color + " 원숭이가 물건을 가지고 있습니다.");
        } else {
            System.out.println(color + " 원숭이가 물건을 가지고 있지 않습니다.");
        }
    }
}

class Box {

}


public class Q1 {
    static void around(int round, Monkey[] monkeys, Box box) {

    }


    static void main() {

        Random r = new Random();


        Monkey[] monkeys = new Monkey[5];
        Box box = new Box();
        String[] color = {"빨강", "노랑", "파랑", "초록", "검정"};

        for (int i = 0; i < monkeys.length; i++) {
            monkeys[i] = new Monkey(color[i]);
            if (i == 0) {
                monkeys[i].box = new Box();
            }
        }

        int num = r.nextInt(2);  // 0,1
        int round = r.nextInt(5) + 1;  // 1~5

        System.out.println("좌0 우1: " + num + " / 횟수: " + round);

        for(int i = 0;i<monkeys.length;i++){
            monkeys[i].haveBox();
        }

        if (num == 1) {
            for (int i = 0; i < round; i++) {  // 5가 나오면 안됨.
                if (i == 4) {
                    monkeys[0].box = monkeys[4].box;
                    monkeys[4].box = null;
                } else {
                    monkeys[i + 1].box = monkeys[i].box;
                    monkeys[i].box = null;
                }
                for (int j = 0; j < monkeys.length; j++) {
                    monkeys[j].haveBox();
                }
            }
        } else {

            monkeys[4].box = monkeys[0].box;
            monkeys[0].box = null;
            for (int j = 0; j < monkeys.length; j++) {
                monkeys[j].haveBox();
            }
            // 3
            int temp = 4;
            for (int i = round - 1; i > 0; i--) {
                monkeys[--temp].box = monkeys[temp + 1].box;
                monkeys[temp + 1].box = null;
                for (int j = 0; j < monkeys.length; j++) {
                    monkeys[j].haveBox();
                }
            }
        }


    }
}
