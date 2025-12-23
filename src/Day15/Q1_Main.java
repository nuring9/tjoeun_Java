package Day15;

import java.util.Random;

public class Q1_Main {
    static void main() {
        //1. 난수 -> 1~6
        //2. 주사위 변수를 만들어서 빨깐, 파란
        //3. 먼저 50이 되는 주사위가 승리하는 프로그램
        Random r = new Random();
        int redDice = 0;
        int blueDice = 0;

        while(redDice < 50 && blueDice <50){
            redDice = redDice + r.nextInt(6)+1; // redDice += r.nextInt(6)+1
            blueDice = blueDice + r.nextInt(6)+1; // blueDice += r.nextInt(6)+1
            System.out.println("빨간 주사위 : "+ redDice);
            System.out.println("파란 주사위 : "+ blueDice);
        }

        if(redDice > blueDice){
            System.out.println("빨간 주사위 우승");
        }
        else if(blueDice > redDice){
            System.out.println("파란 주사위 우승");
        }
        else{
            System.out.println("무승부");
        }
    }
}
