package Day21;

import java.util.Random;

//구조
//1. 원숭이
class Monkey1{
    //1.색깔
    String color;
    //2.박스
    Box1 b;
    Monkey1(String color){
        this.color = color;
    }
    //3.말하기
    void talk(){
        //상자가 있는지
        if(b != null){
            System.out.println(color+"원숭이가 상자를 가지고 있습니다.");
        }
        //상자가 없는지
        else{
            System.out.println(color+"원숭이가 상자를 가지고 있지 않습니다.");
        }
    }
}
//2. 박스
class Box1{}


public class Q1_1 {
    static void main() {
        //난수 -> 1,0 1(우) 0(좌)
        // 1~5까지 상자 이동 상자가 이동시마다 talk
        Random r = new Random();
        Monkey1[] monkeys = new Monkey1[5];
        String[] colors = {"빨간색","노랑색","파랑색","초록색","검정색"};
        for(int i = 0;i<monkeys.length;i++){
            monkeys[i] = new Monkey1(colors[i]);
            // 0번째 원숭이한테 박스 실체 객체 준다
            if(i == 0){
                monkeys[i].b = new Box1();
            }
        }

        int direction = r.nextInt(2); // 난수 출력 0 / 1
        int count = r.nextInt(5)+1; // 난수 출력 1~5
        System.out.println("direction : "+direction+", count : "+count); //출력
        // 처음 가지고 잇는 원숭이 한번 출력 해야 하니까
        for(int i = 0;i<monkeys.length;i++){
            monkeys[i].talk();
        }

        // 1나온경우 실행
        // 빨(기본) -> 노 -> 파 -> 초 -> 검 -> 빨
        // 노만 1
        // 노 파 2
        // 노 파 초 3
        // 노 파 초 검 4
        // 노 파 초 검 -> 빨 5
        if(direction == 1){
            // 횟수 위에 정의된 돈다.
            for(int i = 0;i<count;i++){ // 1~5 0~4
                if(i == 4){
                    monkeys[0].b = monkeys[4].b;
                    monkeys[4].b = null;
                }
                else{
                    //       1               0
                    //       2               1
                    //       3               2
                    monkeys[i+1].b = monkeys[i].b;
                    //      0   1  2
                    monkeys[i].b = null;
                }
                // 출력
                for(int j = 0;j<monkeys.length;j++){
                    monkeys[j].talk();
                }
            }
        }
        //0나온경우 실행
        // 빨(처음) -> 검 -> 초 -> -> 파 -> 노 -> 빨
        // 검만[4]
        // [4] [3]
        // 검 초
        // [4] [3] [2]
        // 검 초 파
        // [4] [3] [2] [1]
        // 검 초 파 노
        // [4] [3] [2] [1] [0]
        // 검 초 파 노 빨
        else{
            //무조건 1은 나오니까 검으로 한번보내구 실행
            monkeys[4].b = monkeys[0].b;
            monkeys[0].b = null;
            for(int j = 0;j<monkeys.length;j++){
                monkeys[j].talk();
            }
            /// ///////////////////////////////////
            // 3
            int temp = 4;
            // count - 1이미 위서 한번 실행을 했기 때문에
            // 예를 1이 나오면 0이 되기 때문에 반복은 없다
            // 5~1      5 4 3 2 1 -> 4 3 2 1
            for(int i = count-1;i>0;i--){
                //        3                  3 + 1
                //        2                  2 + 1
                //        1                  1 + 1
                //        0                  0 + 1
                monkeys[--temp].b = monkeys[temp+1].b;
                //       3 + 1
                //       2 + 1
                //       1 + 1
                //       0 + 1
                monkeys[temp + 1].b = null;
                //출력
                for(int j = 0;j<monkeys.length;j++){
                    monkeys[j].talk();
                }
            }
        }
    }
}
