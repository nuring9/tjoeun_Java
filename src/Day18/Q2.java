package Day18;
/*
포켓몬스터

지우
포켓몬 볼 -> 포켓몬
포켓몬 볼 객체에 비워있다가  오박사의 포켓폰의 1,2,3중에 지우가 골라서 객체에 들어옴.
이후 해당 인덱스의 오박사 포켓몬 볼이 null


오박사
포켓몬 볼 -> 포켓몬 랜덤
포켓몬 볼 -> 포켓몬 랜덤
포켓몬 볼 -> 포켓몬 랜덤
오박사도 태어났을때부터 포켓몬을 가지고 있으면 안됨.

오박사 포켓몬 볼에 랜덤으로 포켓몬, 색깔, 크기가 정해져서 3개의 포켓몬 볼에 들어가 있다.
지우가 오박사 한테 1,2,3번 중 하나를 선택해서 하나의 포켓몬 볼을 받는다
그 받은 포켓몬의 포켓몬 볼으ㅡㄹ 열어서 어떤 포켓몬인지 출력
예) 파란색 피카츄 이고 크기는 중입니다.

포켓몬
피카츄, 파이리, 꼬부기, 이상해씨
색깔
노란색, 빨간색, 파란색, 초록색
크기
대, 중, 소, 미니

 */

/*
포켓몬스터
지우
포켓몬 볼 -> 포켓몬

오박사
포켓몬 볼 -> 포켓몬
포켓몬 볼 -> 포켓몬
포켓몬 볼 -> 포켓몬

포켓몬      색깔                     크기
피카츄        노란색               대
파이리         빨간색               중
꼬부기         파란색                소
이상해씨      초록색                미니

태어났을때부터 정해져있는건 생성자로,
메소드로 만들면 추후에 변경이 가능함.

 */

import java.util.Random;
import java.util.Scanner;

class PM{
    String color;
    String type;
    String size;
    PM(){
        String[] colors = {"노란색","빨간색","파란색","초록색"};
        String[] types = {"피카츄","파이리","꼬부기","이상해씨"};
        String[] sizes = {"대","중","소","미니"};
        Random r = new Random();
        this.color = colors[r.nextInt(4)];
        this.type = types[r.nextInt(4)];
        this.size = sizes[r.nextInt(4)];
    }
    void talk(){
        System.out.println(color+type+" 이고 크기는"+size+"입니다.");
    }
}
class PB{
    PM pm;
}
class JiWoo{
    PB pb;
}
class Oh{
    PB[] pbs = new PB[3];
    Oh(){
        for(int i = 0;i< pbs.length;i++){
            pbs[i] = new PB();
        }
    }
    void recivePM(PM pm){
        for(int i =0;i< pbs.length;i++){
            if(pbs[i].pm == null){
                pbs[i].pm = pm;
                pbs[i].pm.talk();
                break;
            }
        }
    }
}
public class Q2 {
    static void main() {
        Oh oh = new Oh();
        JiWoo jiWoo = new JiWoo();
        for(int i = 0;i<3;i++){
            oh.recivePM(new PM());
        }
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("1, 2, 3 중 고르세요 : ");
            int num = sc.nextInt();
            if(num == 1 || num == 2 || num == 3){
                jiWoo.pb=oh.pbs[num-1];
                oh.pbs[num-1] = null;
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        jiWoo.pb.pm.talk();
    }
}
