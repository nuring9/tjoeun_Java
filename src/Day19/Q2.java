package Day19;

//상어 총 5마리
//먹이를 랜덤 8~14까지 먹을 수 있다.
//먹이는 main에 있다

import java.util.Random;

class FishFeed {
}

class FireShark {
    String name;
    FishFeed[] ff;

    FireShark(String name) {
        Random r = new Random();
        this.name = name;
        ff = new FishFeed[r.nextInt(7) + 8];
    }

    //먹는 기능
    void eat(FishFeed f) {
        for (int i = 0; i < ff.length; i++) {
            if (ff[i] == null) {
                ff[i] = f;
                break;
            }
        }
    }

    //    //다먹었는지 체크
//    boolean checkFeed(){
//        for(int i = 0;i<ff.length;i++){
//            if(ff[i] == null){
//                return true;
//            }
//        }
//        return false;
//    }
    // 출력
    void print() {
        System.out.println(this.name + "상어는 " + ff.length + "마리 만큼 잡아먹었습니다.");
    }
}

public class Q2 {
    static void main() {
        FishFeed[] ff = new FishFeed[100];
        FireShark[] fs = new FireShark[5];
        int count = 0;
        for (int i = 0; i < ff.length; i++) {
            ff[i] = new FishFeed();
        }
        for (int i = 0; i < fs.length; i++) {
            fs[i] = new FireShark((i + 1) + "");
        }
        for (int i = 0; i < fs.length; i++) {
            for (int j = 0; j < fs[i].ff.length; j++) {
                fs[i].ff[j] = ff[count];
                ff[count++] = null;
            }
        }
        for (int i = 0; i < fs.length; i++) {
            fs[i].print();
        }
    }
}
