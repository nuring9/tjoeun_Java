package Day20;

import java.util.Random;

//동물 -> 강아지, 고양이, 미어캣, 판다
//동물 추상클래스

/*
동물 : 색상 기능
강아지 : 오버라이딩 기능(나는 + 색상 + 강아지 입니다.);
고양이 : 오버라이딩 기능(나는 + 색상 + 고양이 입니다.);
미어캣 : 오버라이딩 기능(나는 + 색상 + 미어캣 입니다.);
판다 : 오버라이딩 기능(나는 + 색상 + 판다 입니다.);

색깔은 빨, 주, 노, 초, 파, 남, 보

총 동물 우리에는 10마리가 들어갈 수 있습니다.
랜덤을 통해서 색상과 동물을 우리안에 넣어주세요.

색상 0~6 / 동물 0~3까지 랜덤을 통해 동물 우리안에 넣어주세요.

동물우리안에 동물이 다 들어가면 각각의 동물의 기능을 호출을 해주세요.
 */

abstract class Animal {
    String color;

    Animal() {
        Random r = new Random();
        String[] colors = {"빨간색", "주황색", "노란색", "초록색", "파랑색", "남색", "보라색"};
        this.color = colors[r.nextInt(7)];
    }

    abstract void print();
}

class Dog extends Animal {
    void print() {
        System.out.println("나는 " + color + "강아지 입니다.");
    }
}

class Cat extends Animal {
    void print() {
        System.out.println("나는 " + color + "고양이 입니다.");
    }
}

class Mia extends Animal {
    void print() {
        System.out.println("나는 " + color + "미어캣 입니다.");
    }
}

class Panda extends Animal {
    void print() {
        System.out.println("나는 " + color + "판다 입니다.");
    }
}

public class Q2 {
    static void main() {
        Animal[] woori = new Animal[10];
        Random r = new Random();
        for (int i = 0; i < woori.length; i++) {
            int select = r.nextInt(4);
            if (select == 0) {
                woori[i] = new Dog();
            } else if (select == 1) {
                woori[i] = new Cat();
            } else if (select == 2) {
                woori[i] = new Mia();
            } else {
                woori[i] = new Panda();
            }
        }
        for (int i = 0; i < woori.length; i++) {
            woori[i].print();
        }
    }
}