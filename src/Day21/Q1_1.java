package Day21;

import java.util.Random;

// 정답코드


//구조
//1. 원숭이
class Monkey1 {
    //1.색깔
    String color;
    //2.박스
    Box1 b;

    Monkey1(String color) {
        this.color = color;
    }

    //3.말하기
    void talk() {
        //상자가 있는지
        if (b != null) {
            System.out.println(color + "원숭이가 상자를 가지고 있습니다.");
        }
        //상자가 없는지
        else {
            System.out.println(color + "원숭이가 상자를 가지고 있지 않습니다.");
        }
    }
}

//2. 박스
class Box1 {
}


public class Q1_1 {
    static void main() {
        //난수 -> 1,0 1(우) 0(좌)
        // 1~5까지 상자 이동 상자가 이동시마다 talk
        Random r = new Random();
        Monkey1[] monkeys = new Monkey1[5];
        String[] colors = {"빨간색", "노랑색", "파랑색", "초록색", "검정색"};
        for (int i = 0; i < monkeys.length; i++) {
            monkeys[i] = new Monkey1(colors[i]);
            if (i == 0) {
                monkeys[i].b = new Box1();
            }
        }

        int direction = r.nextInt(2);
        int count = r.nextInt(5) + 1;
        System.out.println("direction : " + direction + ", count : " + count);
        for (int i = 0; i < monkeys.length; i++) {
            monkeys[i].talk();
        }
        if (direction == 1) {
            for (int i = 0; i < count; i++) {
                if (i == 4) {
                    monkeys[0].b = monkeys[4].b;
                    monkeys[4].b = null;
                } else {
                    monkeys[i + 1].b = monkeys[i].b;
                    monkeys[i].b = null;
                }
                for (int j = 0; j < monkeys.length; j++) {
                    monkeys[j].talk();
                }
            }
        } else {
            monkeys[4].b = monkeys[0].b;
            monkeys[0].b = null;
            for (int j = 0; j < monkeys.length; j++) {
                monkeys[j].talk();
            }
            // 3
            int temp = 4;
            for (int i = count - 1; i > 0; i--) {
                monkeys[--temp].b = monkeys[temp + 1].b;
                monkeys[temp + 1].b = null;
                for (int j = 0; j < monkeys.length; j++) {
                    monkeys[j].talk();
                }
            }
        }


    }
}
