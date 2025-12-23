package Day15;

/*
파란주사위와 빨간주사위 중에 먼저 50이 되는 주사위를 출력

랜덤으로 나오는 값은 계속 더합니다.

두 주사위 중에 먼저 50이상이 되는 주사위를 출력 하시면 됩니다.

 배열로 클래스 만드는법 주말에  풀어보기

 */

import java.util.Random;

class Player {
    int num, dice;
    String dice_name;

    Player(int dice, String dice_name) {
        this.dice = dice;
        this.dice_name = dice_name;
    }

    void battle() {
        Random r = new Random();
            num += r.nextInt(6) + 1;
            System.out.println(this.dice_name + "주사위 " +  ": " + this.num);
    }

}


public class Q1 {
    static void main() {
        Random r = new Random();
        Player[] players = new Player[2];
        String[] dice_name = {"파란", "빨간"};
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i+1 , dice_name[i]);
        } // 객체 생성

        boolean circle = true;

        while (circle) {

            for (int i = 0; i < players.length; i++) {
                    players[i].battle();
            }

            for (int i = 0; i < players.length; i++) {

                 if (players[i].num >= 50) {
                     circle = false;
                     break;
                 }


            }
        }


        //            int max = players[0].num;
//
//            if(players[1].num > max ) {
//                max = players[1].num;
//            }

        for (int i = 0; i < players.length; i++) {
            for(int j = 0; j <players.length; j++) {
                if (players[i].num == players[j].num) {
                    continue;
                }}
            if (players[i].num >= 50) {
                System.out.println(players[i].dice_name + "주사위" +  " 우승");
            }
        }






    }
}
