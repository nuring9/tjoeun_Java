package Day22;

import java.util.*;

public class MapTest1 {
    static void main() {
        Scanner p = new Scanner(System.in);
        System.out.println("가위, 바위, 보 게임 선택(1:가위, 2:바위, 3:보) : ");
        int user = p.nextInt() - 1;

        Random r = new Random();
        int com = r.nextInt(3);
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(0, "가위");
        hm.put(1, "바위");
        hm.put(2, "보");
        /*
   안됨. 아래와 같이하려면 List
   for(int i = 0; i<hm.size(); i++){
            hm.get(i);
        }
         */
        Set<Integer> key = hm.keySet();

        Iterator<Integer> i = key.iterator();
        while (i.hasNext()) {
            Integer temp = i.next();
            System.out.println(hm.get(temp));
        }

        String value1 = hm.get(user);
        System.out.println("당신은 " + value1 + "를 냈습니다.");
        String value2 = hm.get(com);
        System.out.println("컴퓨터는 " + value2 + "를 냈습니다.");
        System.out.println("=========================================");
        System.out.println("게임 결과 : ");

        if (user == com) {
            System.out.println("비겼습니다.");
            // 1 -> 가위 1-1= 0       2 -> 보 2+1= 3 %3=
            // 2 -> 바위 2-1= 1       0 -> 가위 0+1 = 1 %3=1
        } else if (user == (com+1)%3) {
            System.out.println("당신이 이겼습니다.");
        } else {
            System.out.println("컴퓨터가 이겼습니다.");
        }

    }
}
