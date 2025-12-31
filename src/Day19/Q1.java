package Day19;
/*
공룡클래스가 있음
공룡 클래스에는 키와 무게를 가지고 있고, "나는 공룡이다"를 외치는 함수가 있다.
티라노사우르스는 공룡을 상속받고 오버라이딩 해서 "나는 키 2m 몸무게 1톤인 티라노사우르스다."를 외침.
티리케라톱수는 공룡을 상속 받고 오버라이디을 해서  "나는 키 3m 몸무게 2톤인 티리케라톱수다."를 외침.
부경사우르스는 공룡을 상속 받고 오버라이디을 해서  "나는 키 5m 몸무게 3톤인 부경사우르스다."를 외침.

main문이 있는 클래스에서는 static 함수를 하나 만들어서 그 함수에서 외치는 함수가 호출되도록 구현.
단, 함수 인자도 하나만 받는다. 그리고 3공룡을 외치게 하려면 main문에서 위의 함수 3번을 호출.


 */

import java.util.Arrays;

class Dinosaur {
    int height;
    int weight;

    void shout() {
        System.out.println("나는 공룡이다.");
    }
}

class Tyrannosaurus extends Dinosaur {
    String name = "티라노사우르스";
    int height = 2;
    int weight = 1 ;

    void shout() {
        System.out.println("나는 키 " + height + "m 몸무게 " + weight+ "톤인 "+name+"다.");
    }
}

class Triceratops extends Dinosaur {
    String name = "티리케라톱수";
    int height = 3;
    int weight = 2 ;
    void shout() {
        System.out.println("나는 키 " + height + "m 몸무게 " + weight+ "톤인 "+name+"다.");
    }
}

class Pukyon extends Dinosaur {
    String name = "부경사우르스";
    int height = 5;
    int weight = 3 ;
    void shout() {
        System.out.println("나는 키 " + height + "m 몸무게 " + weight+ "톤인 "+name+"다.");
    }
}




public class Q1 {

    static void all_shout(Dinosaur d){
        d.shout();
       /*
       다운캐스팅을 넣을 필요없음.
       잘못된 코드지만 나중에 예시코드 위해서 주석처리
       if ( d instanceof  Tyrannosaurus ){
            Tyrannosaurus tyranno = (Tyrannosaurus)d;  // main 문에서 다운캐스팅한거랑은 상관이 없음. 메소드안에서 사용하는것.
            tyranno.shout();
        }

        if ( d instanceof  Triceratops ) {
            Triceratops tricera = (Triceratops)d;
            tricera.shout();

        }

        if ( d instanceof Pukyon ) {
            Pukyon pu = (Pukyon)d;
            pu.shout();
        }
        */
    }
    static void main() {
        Dinosaur[] d = new Dinosaur[3];
        d[0] = new Triceratops();
        d[1] = new Tyrannosaurus();
        d[2] = new Pukyon();
        all_shout(d[0]);
        all_shout(d[1]);
        all_shout(d[2]);

    }
}
