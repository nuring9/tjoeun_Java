package Day16;

/*
  문방구 - 주황색연필, 초록색연필, 노랑색연필, 파란색연필 / 회색지우개, 빨간지우개
          주황펜, 초록펜, 노랑펜, 파란펜

  A학생 - 필통 - 색열필 2 , 지우개 1, 펜2
  B학생 - 필통 - 색연필 2 , 지우개 1, 펜2

  A학생과 B학생이 번갈아가면서 색연필 -> 지우개 -> 펜

  원하는 물건이 없을시 다시 고르게 한다.
  색이 없는것을 말하면 다시 고르게 한다.

  모든 사는게 끝나면 A학생 B학생 필통열어본다
 */

import java.util.Scanner;

class ColorPencil {
    // 색연필 클래스 만듦, 색연필은 색상을 가지고 있다.
    String color;

    ColorPencil(String color) {
        this.color = color;
    }
}

class Eraser {
    // 지우개 클래스 만듦, 지우개는 색상을 가지고 있다.
    String color;

    Eraser(String color) {
        this.color = color;
    }
}

class ColorPen {
    // 펜 클래스 만듦, 펜은 색상을 가지고 있다.
    String color;

    ColorPen(String color) {
        this.color = color;
    }
}

class Philtong {
    // 필통 안에는 색연필2개 지우개1개 펜2개가 있음. 객체전부를 가져옴.
    ColorPencil cpc1;
    ColorPencil cpc2;
    Eraser e;
    ColorPen cp1;
    ColorPen cp2;

    boolean checkColorPencil() {
        // 색연필 1,2이 null이 아니면 다 찼으므로 false를 반환하여 반복을 멈춤.
        if (cpc1 != null && cpc2 != null) {
            return false;
        }
        return true;
        // 색연필 1,2가 null 이면 true를 반환하여 반복
    }

    boolean checkEraser() {
        // 지우개 1이 null이 아니면 다 찼으므로 false를 반환하여 반복을 멈춤.
        if (e != null) {
            return false;
        }
        return true;
        // 지우개 1이 null 이면 true를 반환하여 반복
    }

    boolean checkColorPen() {
        // 펜 1,2이 null이 아니면 다 찼으므로 false를 반환하여 반복을 멈춤.
        if (cp1 != null && cp2 != null) {
            return false;
        }
        return true;
        // 펜 1,2가 null 이면 true를 반환하여 반복
    }

    void pPrint() {
        // 필통안에 전부 들어있기 때문에 ColorPencil, Eraser, ColorPen 객체들의 컬러를 가져와서 print 출력해줌.
        System.out.println(cpc1.color + "연필");
        System.out.println(cpc2.color + "연필");
        System.out.println(e.color + "지우개");
        System.out.println(cp1.color + "펜");
        System.out.println(cp2.color + "펜");
    }
}

class Student {
    // 학생 클래스를 만드는데, 학생은 본인 이름과, 필통을 가지고 있으므로 이름선언과 필통객체를 가져옴.
    String name;
    Philtong p;

    Student(String name) {
        // 학생 생성자로 생성하면 처음에 이름을 받아오고, 필통객체를 생성한다.
        this.name = name;
        p = new Philtong();
    }

    void print() {
        // 누구 소유의 필통, 어떤 컬러의 용품 출력
        System.out.println(name + "필통");
        p.pPrint();
    }
}

class MunbangGu {
    // 문방구 클래스안에는 색상을 가진 색연필과 지우개, 펜을 소유하고 있다.
    ColorPencil[] cpc = new ColorPencil[4];
    Eraser[] e = new Eraser[2];
    ColorPen[] cp = new ColorPen[4];
    // 총 색연필 4, 지우개 2, 펜 4자루를 가지고 있으므로, 배열을 사용.

    MunbangGu() {

        String[] color = {"주황색", "초록색", "노란색", "파란색"};
        String[] color1 = {"회색", "빨간색"};
        // 컬러별로 배열을 사용하기 위해 String[]로 색상 초기화함. 색연필과 펜의 색상은 동일, 지우개만 다름.
        
        // for문으로  각 색연필, 펜 객체 생성
        for (int i = 0; i < cpc.length; i++) {
            cpc[i] = new ColorPencil(color[i]);
            cp[i] = new ColorPen(color[i]);
        }
        // for문으로  지우개 객체 생성
        for (int i = 0; i < color1.length; i++) {
            e[i] = new Eraser(color1[i]);
        }
    }
}

public class Q1_King_1 {
    static void buyPencil(MunbangGu m, String color, Student a) {
        // 색연필 구매 메소드로 만듦.
        
        int i;
        for (i = 0; i < m.cpc.length; i++) {
            if (m.cpc[i] != null) {
                if (m.cpc[i].color.equals(color)) {
                    if (a.p.cpc1 == null) {
                        a.p.cpc1 = m.cpc[i];
                    } else {
                        a.p.cpc2 = m.cpc[i];
                    }
                    m.cpc[i] = null;
                    System.out.println(a.name + "학생이 샀습니다.");
                    break;
                }
            }
        }
        if (i == m.cpc.length) {
            System.out.println("팔렸습니다.");
        }
    }

    static void buyEraser(MunbangGu m, String color, Student a) {
        // 지우개 구매 메소드로 만듦.
        // 문방구 객체, 내가 입력한 컬러, 학생 객체 를 매개변수로 받아옴.

        int i;
        /*
        for문에서 i를 따로 뺀 이유,
        for문에서 i++로 증가한 값을 사용하기 위해. 즉, for문 내부에서 변화한 i의 최종 상태값을 for문 외부에서도 참조(사용)하기 위해서

        for문 안에서 break가 발생하지 않으면 i는 마지막 인덱스 값(m.e.length)까지 증가한 뒤 반복을 마침.
        반면에 중간에 break가 발생하면 i는 m.e.length보다 작을 때 반복이 종료.
        중간에 break가 발생하면 i가 m.e.length에 도달하기 전에 루프를 빠져나오므로, 최종 i 값은 m.e.length보다 작다 라고 이해

        즉, 루프 종료 후 i의 값을 이용해 구매 성공 여부를 판단하기 위해
         */

        for (i = 0; i < m.e.length; i++) {
            // 문방구 지우개의 갯수보다 작을 때
            if (m.e[i] != null) {
                // 문방구의 지우개가 null이 아니면,
                if (m.e[i].color.equals(color)) {
                    // 문방구의 지우개 컬러가 내가 입력한 컬러일 때
                    if (a.p.e == null) {
                        // A학생의 필통안의 지우개가 null일 때, 즉 지우개가 비어있을 때
                        a.p.e = m.e[i];
                        // A학생의 필통안의 지우개에 문방구 지우개를 넣어줌.
                    }
                    m.e[i] = null;
                    // 문방구 지우개를 null로 만듦으로써 지우개는 A학생의 필통에만 있음.
                    System.out.println(a.name + "학생이 샀습니다.");
                    // 지우개는 A학생한테 있으므로 샀다고 출력
                    break;
                    // 사고나서 for문을 종료.
                }
            }
        }
        if (i == m.e.length) {
            // 지우개가 0,1 를 가지고 있고, for문으로 break없이 다 돌면 추후 i는 ++ 로 i가 2가 되고  m.e.length가 2 이니까
            // i == arr.length 가 일치하므로 팔렸다고 출력.

        // i == m.e.length인 경우는 해당 색상의 지우개를 못 찾은 경우 or 모든 지우개가 null이라 살 수 없었던 경우 = 구매 실패
        // 즉, break 없이 루프가 끝가지 돈것을 감지하기 위한 용도

        // i == m.e.length라면 조건을 만족하는 지우개를 찾지 못하고 루프가 정상 종료되었음을 뜻하며, 이 경우 팔렸습니다 라는 메세지를 출력.
            System.out.println("팔렸습니다.");
        }
    }

    static void buyPen(MunbangGu m, String color, Student a) {
        // 펜 구매 메소드로 만듦.
        int i;
        for (i = 0; i < m.cp.length; i++) {
            if (m.cp[i] != null) {
                if (m.cp[i].color.equals(color)) {
                    if (a.p.cp1 == null) {
                        a.p.cp1 = m.cp[i];
                    } else {
                        a.p.cp2 = m.cp[i];
                    }
                    m.cp[i] = null;
                    System.out.println(a.name + "학생이 샀습니다.");
                    break;
                }
            }
        }
        if (i == m.cp.length) {
            System.out.println("팔렸습니다.");
        }
    }

    static void main() {
        //입력
        Scanner sc = new Scanner(System.in);
        //1. 학생
        Student a = new Student("A학생");
        Student b = new Student("B학생");
        //2. 문방구
        MunbangGu m = new MunbangGu();

        // 색연필 살때까지 반복
        while (true) {
            //1. A학생 고르기
            if (a.p.checkColorPencil()) {
                System.out.print(a.name + "색연필 색깔 골라 주세요 : ");
                String color = sc.next();
 //               String[] c = {"주황색", "초록색", "노란색", "파란색"};
//                int i;
//                for(i = 0;i<c.length;i++){
//                    if(c[i].equals(color)){
//                        buyPencil(m,color,a);
//                        break;
//                    }
//                }
//                if(i == c.length){
//                    System.out.println("잘못된 입력입니다.");
//                }
                if (color.equals("주황색") || color.equals("초록색")
                        || color.equals("노란색") || color.equals("파란색")) {
                    //올바른 입력
                    // 1. 실제 문방구에 있다.
                    // 1-1 문방구 -> 학생 객체를 주고 문방국 객체를 null 작업
                    // 1-2 A학생이 xxx연필을 샀습니다.
                    // 2. 실제 문방구에 없다. // 이미 다팔렸습니다.
                    buyPencil(m, color, a);
                    // 문방구객체, 내가입력한 컬러, a학생객체
                    // buyPencil메소드에서 샀으면 break문으로 for문이 빠져나오고,
                    // 메인문 코드는 다음 코드로 넘어가므로 아래 [2. B학생 고르기] 로 감.

                } else {
                    //else문은 범위 밖일경우만 해당하므로 이코드는 생략
                    System.out.println("잘못된 입력입니다.");
                }
            }
            //2. B학생 고르기
            if (b.p.checkColorPencil()) {
                System.out.print(b.name + "색연필 색깔 골라 주세요 : ");
                String color = sc.next();
                if (color.equals("주황색") || color.equals("초록색")
                        || color.equals("노란색") || color.equals("파란색")) {
                    //올바른 입력
                    buyPencil(m, color, b);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

            if (!a.p.checkColorPencil() && !b.p.checkColorPencil()) {
                // a학색, b학생 둘 다 null인지 체크해서 true면 break;
                break;
            }

        }

        //지우개 살때까지 반복
        while (true) {
            //1. A학생 고르기
            if (a.p.checkEraser()) {
                System.out.print(a.name + "지우개 색깔 골라 주세요 : ");
                String color = sc.next();
                if (color.equals("회색") || color.equals("빨간색")) {
                    // 회색과 빨간색이 있다면,

                    //올바른 입력
                    // 1. 실제 문방구에 있다.
                    // 1-1 문방구 -> 학생 객체를 주고 문방국 객체를 null 작업
                    // 1-2 A학생이 xxx연필을 샀습니다.
                    // 2. 실제 문방구에 없다. // 이미 다팔렸습니다.

                    buyEraser(m, color, a);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            //2. B학생 고르기
            if (b.p.checkEraser()) {
                System.out.print(b.name + "지우개 색깔 골라 주세요 : ");
                String color = sc.next();
                if (color.equals("회색") || color.equals("빨간색")) {
                    //올바른 입력
                    buyEraser(m, color, b);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            if (!a.p.checkEraser() && !b.p.checkEraser()) {
                break;
            }
        }

        // 펜 살때까지 반복.
        while (true) {
            //1. A학생 고르기
            if (a.p.checkColorPen()) {
                System.out.print(a.name + "펜 색깔 골라 주세요 : ");
                String color = sc.next();
                if (color.equals("주황색") || color.equals("초록색")
                        || color.equals("노란색") || color.equals("파란색")) {
                    //올바른 입력
                    // 1. 실제 문방구에 있다.
                    // 1-1 문방구 -> 학생 객체를 주고 문방국 객체를 null 작업
                    // 1-2 A학생이 xxx연필을 샀습니다.
                    // 2. 실제 문방구에 없다. // 이미 다팔렸습니다.
                    buyPen(m, color, a);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            //2. B학생 고르기
            if (b.p.checkColorPen()) {
                System.out.print(b.name + "펜 색깔 골라 주세요 : ");
                String color = sc.next();
                if (color.equals("주황색") || color.equals("초록색")
                        || color.equals("노란색") || color.equals("파란색")) {
                    //올바른 입력
                    buyPen(m, color, b);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            if (!a.p.checkColorPen() && !b.p.checkColorPen()) {
                break;
            }
        }
        a.print();
        b.print();
    }
}
