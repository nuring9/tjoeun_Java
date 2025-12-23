package Day15;

import java.util.Random;

class Dice{
    //1. 색깔
    String name;
    //2. 주사위 수
    int num;
    Dice(String name){
        this.name = name;
    }
    //3. 던지는 기능
    void throwDice(){
        Random r = new Random();
        num = r.nextInt(6)+1;
        System.out.println(name+"주사위 수 : " +num);
    }
    int getNum(){
        return num;
    }
    String getName(){
        return name;
    }
}

public class Q1_Class {
    static void main() {
        //1. 난수 -> 1~6
        //2. 주사위 변수를 만들어서 빨깐, 파란
        //3. 먼저 50이 되는 주사위가 승리하는 프로그램
        Random r = new Random();
        Dice red = new Dice("빨간색");
        Dice blue = new Dice("파란색");
        int redResult = 0;
        int blueResult = 0;
        while(redResult < 50 && blueResult <50){
            red.throwDice();
            blue.throwDice();
            redResult += red.getNum();
            blueResult += blue.getNum();
            System.out.println(red.getName()+"주사위 합: "+ redResult);
            System.out.println(blue.getName()+"주사위 합: "+ blueResult);
        }
        if(redResult > blueResult){
            System.out.println("빨간 주사위 우승");
        }
        else if(blueResult > redResult){
            System.out.println("파란 주사위 우승");
        }
        else{
            System.out.println("무승부");
        }
    }
}
