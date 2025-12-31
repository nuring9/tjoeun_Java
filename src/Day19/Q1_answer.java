package Day19;

class Dino {
    int height;
    int kg;

    void talk() {
        System.out.println("나는 공룡이다.");
    }
}

class Tirano extends Dino {
    Tirano(int h, int k) {
        height = h;
        kg = k;
    }

    @Override
    void talk() {
        System.out.println("나는 키 " + height + "m 몸무게 " + kg + "톤인 티라노사우르스다.");
    }
}

class Tirik extends Dino {
    Tirik(int h, int k) {
        height = h;
        kg = k;
    }

    @Override
    void talk() {
        System.out.println("나는 키 " + height + "m 몸무게 " + kg + "톤인 티리케라톱스다.");
    }
}

class Bugung extends Dino {
    Bugung(int h, int k) {
        height = h;
        kg = k;
    }

    @Override
    void talk() {
        System.out.println("나는 키 " + height + "m 몸무게 " + kg + "톤인 부경사우르스다.");
    }
}

public class Q1_answer {
    static void shout(Dino d) {
        d.talk();
    }

    static void main() {
//        Tirano tirano = new Tirano(2,1);
//        Tirik tirik = new Tirik(3,2);
//        Bugung bugung = new Bugung(5,3);
//        shout(tirano);
//        shout(tirik);
//        shout(bugung);
        shout(new Tirano(2, 1));
        shout(new Tirik(3, 2));
        shout(new Bugung(5, 3));

        Dino[] dinos = new Dino[3];
        dinos[0] = new Tirano(2, 1);
        dinos[1] = new Tirik(3, 2);
        dinos[2] = new Bugung(5, 3);

        for(int i = 0;i<dinos.length;i++){
            shout(dinos[i]);
        }
    }
}
