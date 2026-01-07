package Day23;

import java.util.Random;

class Unit{
    String name;
    int attack;
    int hp;
}
class Knight extends Unit{
    Knight(String name){
        this.name = name;
        attack = 50;
        hp = 2000;
    }
}
class Villain extends Unit{
    Villain(String name){
        super.name = name;
        attack = 80;
        hp = 1200;
    }
}
class Burf{
    Random r = new Random();
    void attackUp(Unit u){
        int ran = r.nextInt(101)+50;// 공부하세요
        u.attack += ran;
        System.out.println("버프 : "+u.name+"공격력이 "+ran+"만큼 증가하였다.");
    }
    void heal(Unit u){
        int ran = r.nextInt(301);// 공부하세요
        u.hp += ran;
        System.out.println("버프 : "+u.name+"체력이 "+ran+"만큼 증가하였다.");
    }
    void dBurf(Unit u){
        int ran = r.nextInt(201)+100;
        u.hp -= ran;
        System.out.println("디버프 : "+u.name+"체력이 "+ran+"만큼 감소하였다.");
    }
}
class Battle{
    Burf burf = new Burf();
    boolean attck(Unit au, Unit du){
        Random r = new Random();
        int ran = r.nextInt(3)+1;
        if(ran == 1){
            burf.attackUp(au);
        }
        else if(ran == 2){
            burf.heal(au);
            if(au.name.equals("기사") && au.hp >2000){
                au.hp = 2000;
                System.out.println("기사의 에너지 보정 됐습니다.");
            }
            if(au.name.equals("악당") && au.hp >1200){
                au.hp = 1200;
                System.out.println("악당이 에너지 보정 됐습니다.");
            }
        }
        else{
            burf.dBurf(au);
            if(au.hp <=0){
                return false;
            }
        }
        System.out.println(au.name+"의 공격!!!");
        du.hp-=au.attack;
        System.out.println(du.name+"의 체력이"+du.hp+"남았다");
        if(au.name.equals("기사")){
            au.attack = 50;
        }
        if(au.name.equals("악당")){
            au.attack = 80;
        }
        return true;
    }
    boolean gameOverCheck(Unit u1, Unit u2){
        if(u1.hp <=0 || u2.hp <=0){
            if(u1.hp > u2.hp){
                System.out.println("기사승");
            }
            else{
                System.out.println("악당승");
            }
            return false;
        }
        return true;
    }
}
public class Q1 {

    static void main() {
        Knight knight = new Knight("기사");
        Villain villain = new Villain("악당");
        Battle battle = new Battle();
        int turn = 0;
        boolean check = true;
        while (check){
            System.out.println((turn++)+"번째 경기가 시작 됩니다.");
            System.out.println("====================================================");
            check=battle.attck(knight,villain);
            if(check == false){
                System.out.println("악당 승");
                break;
            }
            if(!battle.gameOverCheck(knight,villain)){
                break;
            }
            System.out.println((turn++)+"번째 경기가 시작 됩니다.");
            System.out.println("====================================================");
            check=battle.attck(villain,knight);
            if(check == false){
                System.out.println("기사 승");
                break;
            }
            if(!battle.gameOverCheck(knight,villain)){
                check = false;
            }
        }
    }
}
