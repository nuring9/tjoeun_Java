package Day13;

class Dog {
    String color;
    int weight;

    String skill;  // 인스턴스 변수
    // new Dog()로 객체가 생성될 때 만들어져서, 그 객체가 사라질 때까지 메모리에 유지.
    // Dog라는 객체의 **상태(데이터)
    // 한 번 bark()를 실행해서 skill에 값이 저장되면, 나중에 다른 메서드에서도 그 값을 꺼내 쓰거나 수정가능.

    void bark() {
       skill = "짖는다"; // 인스턴스 변수의 값 업데이트

        String sound = "멍멍";  // 지역변수
        //bark() 메서드가 실행될 때 잠깐 만들어졌다가, 메서드가 끝나면 메모리에서 바로 삭제.
        // run()를 새로 만든다면, 그 안에서는 이 skill을 사용할 수 없다.
        // Dog 객체의 것이 아니라, 오직 bark()라는 행위(메서드) 안에서만 유효.

        System.out.println(color + " 개 " + "몸무게: " + weight + "kg " + skill +" " +sound);
    }

}

class Cat {
    String color;
    int weight;
    String skill;

    Cat(String col, int wei, String ski) {
        color = col;
        weight = wei;
        skill = ski;
    }

    void print() {
        System.out.println(color + " 고양이 " + "몸무게: " + weight + "kg " + skill);
    }

}

class Bird {
    String color;
    int weight;

    Bird(String col, int wei) {
        color = col;
        weight = wei;
    }

    void fly() {
        System.out.println(color + " 새 " + "몸무게: " + weight + "kg 날아다닌다");
    }
}


public class Q4 {

    static void main() {
        Dog dog1 = new Dog();
        dog1.color ="하양";
        dog1.weight = 7;
        dog1.bark();
        Dog dog2 = new Dog();
        dog2.color ="검정";
        dog2.weight = 15;
        dog2.bark();
        Cat cat1 = new Cat("갈색", 6, "잔다");
        cat1.print();
        Cat cat2 = new Cat("회색", 10, "뛰어간다");
        cat2.print();
        Bird bird1 = new Bird("노랑", 4);
        bird1.fly();

    }
}
