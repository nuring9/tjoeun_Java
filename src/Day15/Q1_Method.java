package Day15;

import java.util.Random;

public class Q1_Method {
    static void runDice(int[] dice, Random r){
        dice[0] = dice[0] + r.nextInt(6)+1; // redDice += r.nextInt(6)+1
        dice[1] = dice[1] + r.nextInt(6)+1; // blueDice += r.nextInt(6)+1
    }
    static void dicePrint(int[] dice){
        System.out.println("빨간 주사위 : "+ dice[0]);
        System.out.println("파란 주사위 : "+ dice[1]);
    }
    static void finalResult(int[] dice){
        if(dice[0] > dice[1]){
            System.out.println("빨간 주사위 우승");
        }
        else if(dice[1] > dice[0]){
            System.out.println("파란 주사위 우승");
        }
        else{
            System.out.println("무승부");
        }
    }
    static void start(int[] dice,Random r){
        while(dice[0] < 50 && dice[1] <50){
            runDice(dice,r);
            dicePrint(dice);
        }
        finalResult(dice);
    }
    static void main() {
        //1. 난수 -> 1~6
        //2. 주사위 변수를 만들어서 빨깐, 파란
        //3. 먼저 50이 되는 주사위가 승리하는 프로그램
        Random r = new Random();
        int[] dice = new int[2];
        start(dice,r);
    }
}
