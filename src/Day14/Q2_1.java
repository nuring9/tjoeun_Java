package Day14;

import java.util.Random;

/* 정답
 * 올림픽 선수
 * (레인번호, 나라명, 전진거리, 돌발상황 체크)
 * 전진거리 최대 1~10M
 * 100M 먼저 도착하는 나라 우승
 */
class Player{
    int num; //레인번호
    String country;//나라
    int distance;

    Player(int num, String country){
        this.num = num;
        this.country = country;
    }

    void checkAndMove(boolean check){
        Random r = new Random();
        //check true : 돌발상황 발생
        //check false : 돌발상황 발생 X
        if(check){
            System.out.println(this.country+"돌발상황 입니다.");
        }
        else{
            distance += r.nextInt(10)+1;
            System.out.println(this.num+"레인"+this.country+" : "+this.distance+"M 입니다.");
        }
    }
}




public class Q2_1 {

    static void main() {
        //돌발상황 주기
        //우승국 출력
        Random r = new Random();
        Player korea = new Player(1,"한국");
        Player china = new Player(2,"중국");
        Player usa = new Player(3,"미국");
        Player russia = new Player(4,"러시아");

        while (true){
            int dolbal = r.nextInt(4)+1;
            if(korea.num == dolbal){
                korea.checkAndMove(true);
                china.checkAndMove(false);
                usa.checkAndMove(false);
                russia.checkAndMove(false);
            }
            else if(china.num == dolbal){
                korea.checkAndMove(false);
                china.checkAndMove(true);
                usa.checkAndMove(false);
                russia.checkAndMove(false);
            }
            else if(usa.num == dolbal){
                korea.checkAndMove(false);
                china.checkAndMove(false);
                usa.checkAndMove(true);
                russia.checkAndMove(false);
            }
            else{
                korea.checkAndMove(false);
                china.checkAndMove(false);
                usa.checkAndMove(false);
                russia.checkAndMove(true);
            }

            if(korea.distance >= 100 || china.distance >= 100
                    || usa.distance >=100 || russia.distance >= 100){
                break;
            }
        }

        int max = korea.distance;

        if(max < china.distance){
            max = china.distance;
        }
        if(max < usa.distance){
            max = usa.distance;
        }
        if(max < russia.distance){
            max = russia.distance;
        }

        if(max == korea.distance){
            System.out.print("한국 ");
        }
        if(max == china.distance){
            System.out.println("중국 ");
        }
        if(max == usa.distance){
            System.out.println("미국 ");
        }
        if(max == russia.distance){
            System.out.println("러시아 ");
        }
        System.out.println("우승입니다.");


//        if(korea.distance > china.distance && korea.distance > usa.distance
//                && korea.distance > russia.distance)
//        {
//            System.out.println("한국 우승");
//        }
//        if(china.distance > korea.distance && china.distance >usa.distance
//                && china.distance > russia.distance)
//        {
//            System.out.println("중국 우승");
//        }
//        if(usa.distance > korea.distance && usa.distance >china.distance
//                && usa.distance > russia.distance)
//        {
//            System.out.println("미국 우승");
//        }
//        if(russia.distance > korea.distance && russia.distance >usa.distance
//                && russia.distance > china.distance)
//        {
//            System.out.println("러시아 우승");
//        }

    }

}
