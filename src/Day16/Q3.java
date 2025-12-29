package Day16;

import java.util.Random;
import java.util.Scanner;

class Mafia{
    //마피아인지 아닌지
    boolean check;
    Mafia(boolean check){
        this.check = check;
    }
    boolean talk(){
        if(check){ // 마피아
            System.out.println("네 제가 마피아입니다.");
            return false;
        }
        else{ // 마피아 X
            System.out.println("억울합니다. 저는 마피아가 아닙니다.");
            return true;
        }
    }
}
class Police{
    //마피아 확인을 가진다
    int checkTalk(){
        Scanner sc = new Scanner(System.in);
        System.out.print("마피아는 ?");
        int num = sc.nextInt();
        return num;
    }
}

public class Q3 {
    static void main() {
        Police p = new Police();
        Mafia[] mafias = new Mafia[5];
        Random r = new Random();
        int ran = r.nextInt(5);
        for(int i = 0;i<mafias.length;i++) {
            if(i == ran){
                mafias[i] = new Mafia(true);
            }
            else{
                mafias[i] = new Mafia(false);
            }
        }
        while(true){
            int select =p.checkTalk();
            if(select >0 && select <6){
                if(!mafias[select-1].talk()){
                    break;
                }
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
