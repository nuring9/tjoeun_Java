package Day13;
/*
      연필, 지우개, 펜이 있다
      연필은 각각 빨강, 파란, 주황, 노란 색을 가지고 있다.
      그리고 연필은 쓰는 기능(출력)이 있다
      예 ) 쓰는 기능은 빨간색 연필로 적습니다. 출력
      지우개는 각각 잠자리, 모닝글로리의 제조사가 있다.
      그리고 지우개는 지우는 기능(출력)이 있다.
      예 ) 지우개를 잠자리의 제품으로 지웁니다. 출력
      펜은 검정색 - 모나미 / 초록 - 제트스트림 / 베이비블루 - 워터맨 을 가지고 있습니다.
      그리고 펜은 쓰는 기능(출력)이 있습니다
      예 ) 펜을 모나미 제품의 검정색으로 씁니다. 출력
      먼저 4개의 연필을 쓰고 그 다음 2개의 지우개로 지우고 마지막으로 3개의 펜을 쓰는 프로그램
*/

class Pencil {
    String color;
    Pencil(String col){
        color = col;
    };
    void write() {
        System.out.println("쓰는 기능은 " + color + "색 연필로 적습니다." );
    }
}

class Eraser {
    String menu;
    Eraser(String m){
        menu = m;

    }
    void erase() {
        System.out.println("지우개를 " + menu + " 제품으로 지웁니다.");
    }
}

class Pen {

    String kind;
    String color;

    void pen_product() {
        System.out.println( "펜을 " + kind + " 제품의 " + color +"으로 씁니다.");
    }
}


public class Q3 {
    static void main() {

        // 클래스 안에 생성자 만들고 호출
        Pencil red = new Pencil("빨간");
        Pencil blue = new Pencil("파란");
        Pencil orange = new Pencil("주황");
        Pencil yellow = new Pencil("노란");
        red.write();
        blue.write();
        orange.write();
        yellow.write();

        Eraser Dragonfly = new Eraser("잠자리");
        Eraser Morning = new Eraser("지우개");
        Dragonfly.erase();
        Morning.erase();


        // 클래스 안에 생성자 없이 호출
        Pen monami = new Pen();
        monami.kind = "모나미";
        monami.color = "검정색";
        monami.pen_product();

        Pen jetstream = new Pen();
        jetstream.kind = "제트스트림";
        jetstream.color = "초록";
        jetstream.pen_product();

        Pen waterman = new Pen();
        waterman.kind = "워터맨";
        waterman.color = "베이비블루";
        waterman.pen_product();

    }
}
