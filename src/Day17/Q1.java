package Day17;
/*
마트에 컴퓨터, 에어콘, 냉장고, 공기청정기가 각 10대씩 있다.
컴퓨터는 제조사 삼성 / CPU i7 / 가격 200 / 5대
컴퓨터는 제조사 LG / CPU i5 / 가격 150 / 5대
사용기능 ( 예 : "제조사가 " + 삼성 + "인 " + i7 + "컴퓨터를 사용한다")

에어콘은 제조사는 삼성 / 에어콘 종류 벽걸이 / 가격 100 / 5대
에어콘은 제조사는 LG / 에어콘 종류 스탠드 / 가격 250 / 5대
시작기능 ( 예 : "제조사가 " + 삼성 + "인 " + 벽걸이 + "에어컨을 사용한다")

냉장고는 제조사는 삼성 / 냉장고 문은 양문 / 크기 600L / 가격은 200 / 5대
냉장고는 제조사는 LG / 냉장고 문은 4도어 / 크기 800L / 가격은 350 / 5대
시작기능 ( 예 : "제조사가 " + 삼성 + "인 " + 양문 + "형 " + 600 + "L 냉장고가 식품을 관리한다")

공기청정기는 제조사는 LG / 가격 80 / 5대
공기청정기는 제조사는 다이슨 / 가격 60 / 5대
시작기능 ( 예 : "제조사가 " + LG + "인 " + "공기청정기가 공기를 깨끗하게 한다")

소비자는 돈을 가지고 있고 물건들을 살 수가 있다. 기능 X

소비자는 총 3명
소비자는 각각의 돈을 입력 받아서 각자의 돈이 입력됨.
1번 소비자부터 차례대로 물건을 구매
1번 소비자 상품을 선택 해주세요.
1.컴퓨터 2.에어콘 3.냉장고 4.공기청정기 :
1번 입력시
"제조사 및 사양을 선택해주세요 1.삼성(i7) 2.LG(i5) : "
1번 입력시
1번 소비자 돈에서 200원 차감하고 바이어가 컴퓨터 객체를 자기가 가지고 가야 함.
이때 돈이 부족하면 구매를 할 수가 없고 또한 상품이 없다면 구매를 할 수 가 없음.
(단, 잘못된 입력이 들어오면 잘못된 입력을 알려주어야 함)

구매를 한 이후에는 현재 소비자의 남은 금액을 출력
그리고 나서 그 다음 소비자가 물건을 구매
(단, 소비자 순서가 됐을 경우에 돈이 60원 보다 적게 된다면 그 소비자는 더 이상 구매를 할 수 없기 때문에 다음 사람으로 이동.)

모든 소비자가 더 이상 구매를 할 수 없게 되면
각각의 소비자들의 구매한 물건들을 모두 사용하는 기능을 사용해서
몇 번째 소비자의 제조사가 삼성인 i7 컴퓨터를 사용한다. 가 출력이 될 수 있도록 한다.
출력이 끝나면 프로그램을 종료.
*/


import java.util.Scanner;

class Consumer {
    //소비자
    int money;
    int name;

    Consumer(int name) {
        this.name = name;
        System.out.print(name + "번째 소비자 : ");
        Scanner sc = new Scanner(System.in);
        this.money = sc.nextInt();

        Computer[] com = new Computer[10];
        Aircon[] airC = new Aircon[10];
        Refrigerator[] refri = new Refrigerator[10];
        AirPurifier[] airP = new AirPurifier[10];

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                com[i] = new Computer("삼성", "CPU i7", 200);
                airC[i] = new Aircon("삼성", "벽걸이", 100);
                refri[i] = new Refrigerator("삼성", "양문", 600, 200);
                airP[i] = new AirPurifier("LG", 80);

            } else {
                com[i] = new Computer("LG", "CPU i5", 150);
                airC[i] = new Aircon("LG", "스탠드", 250);
                refri[i] = new Refrigerator("LG", "4도어", 800, 350);
                airP[i] = new AirPurifier("다이슨", 60);
            }
        }
    }

}


class Basket {
    // 장바구니
    Computer[] com = new Computer[10];
    Aircon[] airC = new Aircon[10];
    Refrigerator[] refri = new Refrigerator[10];
    AirPurifier[] airP = new AirPurifier[10];

    Basket() {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                com[i] = new Computer("삼성", "CPU i7", 200);
                airC[i] = new Aircon("삼성", "벽걸이", 100);
                refri[i] = new Refrigerator("삼성", "양문", 600, 200);
                airP[i] = new AirPurifier("LG", 80);

            } else {
                com[i] = new Computer("LG", "CPU i5", 150);
                airC[i] = new Aircon("LG", "스탠드", 250);
                refri[i] = new Refrigerator("LG", "4도어", 800, 350);
                airP[i] = new AirPurifier("다이슨", 60);
            }
        }

    }
}

class Computer {
    // 컴퓨터
    String manufacturer;
    String kind;
    int price;

    Computer(String manufacturer, String kind, int price) {
        this.manufacturer = manufacturer;
        this.kind = kind;
        this.price = price;
    }

    void use_print() {
        System.out.println("제조사가 " + manufacturer + "인 " + kind + " 컴퓨터를 사용한다");
    }
}

class Aircon {
    // 에어콘
    String manufacturer;
    String kind;
    int price;

    Aircon(String manufacturer, String kind, int price) {
        this.manufacturer = manufacturer;
        this.kind = kind;
        this.price = price;
    }

    void use_print() {
        System.out.println("제조사가 " + manufacturer + "인 " + kind + " 에어컨을 사용한다");
    }
}

class Refrigerator {
    // 냉장고
    String manufacturer;
    String kind;
    int size;
    int price;

    Refrigerator(String manufacturer, String kind, int size, int price) {
        this.manufacturer = manufacturer;
        this.kind = kind;
        this.size = size;
        this.price = price;
    }

    void use_print() {
        System.out.println("제조사가 " + manufacturer + "인 " + kind + "형 " + size + "L 냉장고가 식품을 관리한다");
    }
}

class AirPurifier {
    // 공기청정기
    String manufacturer;
    int price;

    AirPurifier(String manufacturer, int price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }

    void use_print() {
        System.out.println("제조사가 " + manufacturer + "인 " + " 공기청정기가 공기를 깨끗하게 한다 ");
    }

}


public class Q1 {

//        static void buyCom(Basket bas, String k, Consumer con) {
//            // 컴퓨터 구매 메소드
//            int i;
//            for (i = 0; i < bas.com1.length; i++) {
//                if (bas.com1[i] != null) {
//                    if (bas.com1[i].kind.equals(k)) {
//                        if (con.com1 == null) {
//                            con.com1 = bas.com1[i];
//
//                        } else {
//                            con.com2 = bas.com1[i];
//                        }
//                        bas.com1[i] = null;
//                        System.out.println(con.name + "번째 소비자 구매 상품");
//
//                        break;
//                    }
//                }
//            }


    static void main() {
        Scanner sc = new Scanner(System.in);
        Basket bas = new Basket();

        Consumer consumer1 = new Consumer(1);
        Consumer consumer2 = new Consumer(2);
        Consumer consumer3 = new Consumer(3);

        int money1 = consumer1.money;
        int money2 = consumer2.money;
        int money3 = consumer3.money;

        System.out.println("1번째 소비자 : " + money1);
        System.out.println("2번째 소비자 : " + money2);
        System.out.println("3번째 소비자 : " + money3);


        int[] com_price = {200, 150};
        int[] airC_price = {100, 250};
        int[] ref_price = {200, 350};
        int[] airP_prise = {80, 60};
        int num;

        String[] kind1 = {"CPU i7", "CPU i5"};
        String[] kind2 = {"벽걸이", "스탠드"};
        String[] kind3 = {"양문", "4도어"};


        Computer[] computer1 = new Computer[5];
        // 삼성 5대
        for (int i = 0; i < computer1.length; i++) {
            computer1[i] = new Computer("삼성", kind1[0], 200);
        }

        Computer[] computer2 = new Computer[5];
        // LG 5대
        for (int i = 0; i < computer2.length; i++) {
            computer2[i] = new Computer("LG", kind1[1], 150);
        }

        Aircon[] aircon1 = new Aircon[5];
        // 삼성 5대
        for (int i = 0; i < aircon1.length; i++) {
            aircon1[i] = new Aircon("삼성", kind2[0], 100);
        }

        Aircon[] aircon2 = new Aircon[5];
        // LG 5대
        for (int i = 0; i < aircon2.length; i++) {
            aircon2[i] = new Aircon("LG", kind2[1], 250);
        }


        Refrigerator[] refrigerators1 = new Refrigerator[5];
        // 삼성 5대
        for (int i = 0; i < refrigerators1.length; i++) {
            refrigerators1[i] = new Refrigerator("삼성", kind3[0], 600, 100);
        }

        Refrigerator[] refrigerators2 = new Refrigerator[5];
        // LG 5대
        for (int i = 0; i < refrigerators2.length; i++) {
            refrigerators2[i] = new Refrigerator("LG", kind3[1], 800, 250);
        }

        AirPurifier[] airPurifiers1 = new AirPurifier[5];
        // LG 5대
        for (int i = 0; i < airPurifiers1.length; i++) {
            airPurifiers1[i] = new AirPurifier("LG", 80);
        }

        AirPurifier[] airPurifiers2 = new AirPurifier[5];
        // 다이슨 5대
        for (int i = 0; i < airPurifiers2.length; i++) {
            airPurifiers2[i] = new AirPurifier("다이슨", 60);
        }


        System.out.print(consumer1.name + "번째 소비자 상품을 선택해주세요 : ");
        System.out.println("1.컴퓨터 2.에어콘 3.냉장고 4.공기청정기");
        num = sc.nextInt();
        if (num == 1) {
            System.out.println("제조사 및 사양을 선택해주세요. 1.삼성(CPU i7) 2.LG(CPU i5) ");
            String[] kind = {"삼성(CPU i7)", "LG(CPU i5)"};
            num = sc.nextInt();
            if (num == 1) {
                money1 = money1 - com_price[0];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
//                buyCom(bas, kind[0], consumer1);
            } else if (num == 2) {
                money1 = money1 - com_price[1];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
//                buyCom(bas, kind[1], consumer1);
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        } else if (num == 2) {
            System.out.println("제조사 및 사양을 선택해주세요. 1.삼성(벽걸이) 2.LG(스탠드 ) ");
            num = sc.nextInt();
            if (num == 1) {
                money1 = money1 - airC_price[0];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else if (num == 2) {
                money1 = money1 - airC_price[1];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else {
                System.out.println("잘못된 입력입니다.");

            }
        } else if (num == 3) {
            System.out.println("제조사 및 사양을 선택해주세요. 1.삼성(양문) 2.LG(4도어) ");
            num = sc.nextInt();
            if (num == 1) {
                money1 = money1 - ref_price[0];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else if (num == 2) {
                money1 = money1 - ref_price[1];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else {
                System.out.println("잘못된 입력입니다.");

            }
        } else if (num == 4) {
            System.out.println("제조사 및 사양을 선택해주세요. 1.LG 2.다이슨 ");
            num = sc.nextInt();
            if (num == 1) {
                money1 = money1 - airP_prise[0];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else if (num == 2) {
                money1 = money1 - airP_prise[1];
                System.out.println(consumer1.name + "번째 남은 금액 " + money1);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } else {
            System.out.println("잘못 입력했습니다. 다시 입력하세요");
        }

/*
장바구니 마지막 출력.

        Basket bas = new Basket(computer1[0], aircon1[0], refrigerators1[0] ,airPurifiers1[0], consumer1);

 */

//            money - prise

//        Computer computer1 = new Computer("삼성", "CPU i7", 200 );
//        computer1.use_print();


    }
}
