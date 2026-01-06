package Day22;

import java.util.Random;

/*
동물클래스가 있다.
동물 클래스에는 이름과 색상을 가지고 있다.
(get set 함수를 사용. 모든 속성은 private)
동물 클래스를 상속받는 개, 고양이, 새 가 있다.
개는 짖는 기능, 고양이는 야옹하는 기능, 새는 날으는 기능이 있다.

동물원에 개가 3마리 고양이 2마리 새 1마리가 있다.
이름표가 있다
개: "말티즈", "요크셔테리어", "포메라이안", "시바", "웰시코기"
고양이: "먼치킨", "스핑크스", "뱅갈", "샴", "폴드"
새: "앵무새", "참새", "닭", "까마귀", "비둘기"
색상관련 표: "갈색", "검은색", "흰색", "노란색", "점박이"
(랜덤 0~4로 해서 객체 생성시마다 랜덤 값을 추출 해주세요.)
여기있는 이름표와 색상을 랜덤으로 골라서
개, 고양이, 새의 객체를 만든 이후에 3마리에 개는 짖고 2마리 고양이는 야옹하고 새는 날아갑니다.

예)
개 짖다 (갈색의 시바는 짖는다.)
고양이 야옹하다 (흰색의 밸갈은 야옹한다.)
새는 날아간다 (점박이의 까마귀가 날아간다.)
*/

class Animal{
    private String type;
    private String color;
    Animal(String type){
        Random r = new Random();
        this.type = type;
        String[] colors = {"갈색","검은색","흰색","노란색","점박이"};
        this.color = colors[r.nextInt(5)];
    }
    String getType(){
        //로그
        return type;
    }
    String getColor(){
        //로그
        return color;
    }
}

class Dog extends Animal{
    Dog(){
        Random r = new Random();
        String[] types = {"말티즈","요크셔테리어","포메라니안","시바","웰시코기"};
        super(types[r.nextInt(5)]);
    }
    void wangwang(){
        System.out.println(super.getColor()+"의 "+super.getType()+"은(는) 짖는다.");
    }
}
class Cat extends Animal{
    Cat(){
        Random r = new Random();
        String[] types = {"먼치킨","스핑크스","뱅갈","샴","폴드"};
        super(types[r.nextInt(5)]);
    }
    void yayong(){
        System.out.println(super.getColor()+"의 "+super.getType()+"은(는) 야옹한다.");
    }
}
class Bird extends Animal{
    Bird(){
        Random r = new Random();
        String[] types = {"앵무새","참새","닭","까마귀","비둘기"};
        super(types[r.nextInt(5)]);
    }
    void fly(){
        System.out.println(super.getColor()+"의 "+super.getType()+"은(는) 날아다닌다.");
    }
}

public class Q2 {
    static void main() {
        Dog[] dogs = new Dog[3];
        Cat[] cats = new Cat[2];
        Bird b = new Bird();
        for(int i = 0;i< dogs.length;i++){
            dogs[i] = new Dog();
            dogs[i].wangwang();
        }
        for(int i = 0;i< cats.length;i++){
            cats[i] = new Cat();
            cats[i].yayong();
        }
        b.fly();
    }
}
