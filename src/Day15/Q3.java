package Day15;
/*
풀다가 말았음. 다음에 마저 풀기.


A학생색열필 색깔 골라주세요 :
무지개색
잘못된 입력입니다.
B학생색열필 색깔 골라주세요 :
주황색
B학생학생이 샀습니다.
A학생색열필 색깔 골라주세요 :
주황색
팔렸습니다.
B학생색열필 색깔 골라주세요 :
노란색
B학생학생이 샀습니다.
A학생색열필 색깔 골라주세요 :
무지개색
잘못된 입력입니다.
A학생색열필 색깔 골라주세요 :
파란색
A학생학생이 샀습니다.
A학생색열필 색깔 골라주세요 :
초록색
A학생학생이 샀습니다.

A학생 -> 필통 = 색연필2, 지우개1, 펜2
B학생 -> 필통 = 색연필2, 지우개1, 펜2
현재 null

문방구 => 색연필4, 지우개2, 펜4
객체를 가지고 있음.

A학생 색연필을 색상을 골라주세요 :
입력(엔터)
샀습니다 or 팔렸습니다. -> 둘다 출력 후 일단 B 학생으로 넘어감.
B학생 색연필을 색상을 골라주세요 :
입력(엔터)
샀습니다 or 팔렸습니다. -> 둘다 출력 후 일단 B 학생으로 넘어감.
전부 팔렸으면 이제 지우개로 넘어감.
펜까지 다 넘어가고 문방구에 재고가 0이면 "물건이 없습니다." 프로그램 종료.
 */



class Person {
    String name = "A학생";
    Pencil_case p;

    Person(String name) {
        this.name = name;
        p = new Pencil_case();
     
    }
}

class Store {
    Pencil[] pencils = new Pencil[4];
    Eraser[] erasers = new Eraser[2];
    Pen[] pens = new Pen[4];

    Store() {
        String[] color1 = {"빨간색", "주황색", "노란색", "초록색"};
        String[] color2 = {"회색", "하얀색"};
        String[] color3 = {"파란색", "보라색", "핑크색", "하늘색"};

        for(int i =0; i<pencils.length; i++){
            pencils[i] = new Pencil(color1[i]);
            pens[i] = new Pen(color3[i]);
        }

        for(int i =0; i<erasers.length; i++){
            erasers[i] = new Eraser(color2[i]);
            System.out.println(erasers[i]);
        }
    }
}




class Pencil_case {
    Pencil pencil_1;
    Pencil pencil_2;
    Eraser eraser_1;
    Pen pen_1;
    Pen pen_2;

}



class Pencil {
    String color;

    Pencil(String col) {
        this.color = col;
        System.out.println(color + " 색연필");
    }
}

class Eraser {
    String color;

    Eraser(String col) {
        this.color = col;
        System.out.println(color + " 지우개");
    }
}

class Pen {
    String color;

    Pen(String col) {
        this.color = col;
        System.out.println(color + " 펜");
    }
}


public class Q3 {
    static void main() {



        Pencil_case case1 = new Pencil_case();
//        case1.make();

//        Pencil_case2 case2 = new Pencil_case2();
//        case2.all();

        Person person1 = new Person("학생A");



    }
}
