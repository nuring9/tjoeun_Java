package Day18;

import java.util.Scanner;

class Ramayon {
    String ramyon = "라면";
    String water = "물";
    String onion = "양파";

    void boilWater() {
        System.out.println(water + "을 끓인다.");
    }

    void cooking() {
        System.out.println(ramyon + "과 " + onion + "를 넣고 끓여 요리 완성 맛있게 드세요!!");
    }
}

class RiceRamyon extends Ramayon {
    String rice = "떡";

    void topping() {
        System.out.println(rice + "를 넣는다.");
    }
}

class CheeseRamyon extends Ramayon {
    String cheese = "치즈";

    void topping() {
        System.out.println(cheese + "를 넣는다.");
    }
}


public class InherTest2 {
    static void main() {

        int num;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1.일반라면 2.떡라면 3.치즈라면 99.종료");
            num = sc.nextInt();
            if(num == 1){
                Ramayon ramayon = new Ramayon();
                ramayon.boilWater();
                ramayon.cooking();
            } else if (num == 2) {
                RiceRamyon rice = new RiceRamyon();
                rice.boilWater();
                rice.topping();
                rice.cooking();
            } else if (num == 3) {
                CheeseRamyon cheese = new CheeseRamyon();
                cheese.boilWater();
                cheese.cooking();
                cheese.topping();
            }else if (num == 99) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력.");
            }
        }
    }
}
