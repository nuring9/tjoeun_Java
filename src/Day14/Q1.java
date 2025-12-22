package Day14;

/*
 자동차가 존재. 자동차는 색깔과 제조사 최고속력을 가지고 있고 운전하는 기능을 가지고 있다.

 자전거가 존재. 자전거는 제조사와 어떤기능의 자전거인 종류와 타다의 기능을 가지고 있다.

 오타바이 존재. 오토바이는 색깔과 제조사 최고속력을 가지고 있다. 자동차와 똑같이 운전하는 기능을 가지고 있다.

 자동차 색깔 : 은, 검정, 하얀, 형광
 자동차 제조사: Ford, BMW, 삼성, 현대
 최고속력 : 220, 240, 200, 180

 자전거 제조사: 삼천리, 자이언트
 자전거 기능 : 산악용, 접이식용

 오토바이 제조사 : 대림
 오토바이 색깔 : 빨간
 오토바이 최고속력 : 180

 사람이 두명 존재합니다.
 첫번째 사람은 자동차를 두대가지고 있습니다.
 두번째 사람은 자전거와 오토바이를 가지고 있습니다.

 첫번째 사람
 1번차 : 검정, BMW, 240
 2번차 : 형광, 현대, 180

 두번째 사람
 자전거 : 삼천리, 산악용
 오토바이: 대림, 빨간, 180

  */
class Car {
    String color;
    String brand;
    int speed;


    Car(String col, String br, int sp) {
        color = col;
        brand = br;
        speed = sp;
    }

    void ride(String user) {
        System.out.println(user + "이(가) " + brand + "제조사의 " + color + "색의 최고 속력이 " + speed + "인 자동차를 운전합니다.");
    }

}


class Bicycle {
    String color, brand;
    String function;

    Bicycle(String br, String fn) {
        brand = br;
        function = fn;

    }

    void ride(String user) {
        System.out.println(user + "이(가) " + brand + "제조사의 " + function + "기능의 자전거를 탑니다.");
    }
}

class Bike {
    String color;
    String brand;
    int speed;


    Bike(String col, String br, int sp) {
        color = col;
        brand = br;
        speed = sp;
    }

    void ride(String user) {
        System.out.println(user + "이(가) " + brand + "제조사의 " + color + "색의 최고속력이 " + speed + "인 오토바이를 운전합니다.");
    }
}

class Human1 {
    String name = "사람1";
    Car c1;
    Car c2;

    void carRide() {
        c1.ride(name);
        c2.ride(name);
    }
}

class Human2 {
    String name = "사람2";
    Bicycle b1;
    Bike k;

    void BBride() {
        b1.ride(name);
        k.ride(name);
    }
}


public class Q1 {

    static void main() {
        Car c1 = new Car("은", "Ford", 220);
        Car c2 = new Car("검정", "BMW", 240);
        Car c3 = new Car("하얀", "삼성", 200);
        Car c4 = new Car("형광", "현대", 180);
        Bicycle b1 = new Bicycle("삼천리", "산악용");
        Bicycle b2 = new Bicycle("자이언트", "접이식용");

        Bike k = new Bike("빨간", "대림", 180);

        c1.ride("테스트1");
        c2.ride("테스트2");
        c3.ride("테스트3");
        c4.ride("테스트4");

        b1.ride("테스트5");
        b2.ride("테스트6");

        k.ride("테스트7");

        Human1 h1 = new Human1();
        h1.c1 = c2;
        c2 = null;
        h1.c2 = c4;
        c4 = null;
        Human2 h2 = new Human2();
        h2.b1 = b1;
        b1 = null;
        h2.k = k;
        k = null;

        //h1.c1.ride("사람1");
        h1.carRide();
        h2.BBride();
    }
}
