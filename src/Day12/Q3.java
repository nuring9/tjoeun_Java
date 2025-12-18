package Day12;

import java.util.Random;
import java.util.Scanner;

public class Q3 {
// 숫자 야구 게임 1

    static int[] randomCom( Random r){
        int[] com = new int[3];
        for(int i = 0;i<3;i++){
            com[i] = r.nextInt(9)+1;
            for(int j =0;j<i;j++){
                if(com[i] == com[j]){ // 1 0
                    i--;
                    break;
                }
            }
        }
        System.out.println(com[0] + ", "+com[1] + ", "+com[2]);
        return com;
    }
    static int[] inputUser(Scanner sc){
        int[] user = new int[3];
        // 입력 부
        for(int i = 0;i<3;i++){
            System.out.print((i+1)+"번 숫자 : ");
            user[i] = sc.nextInt();
            // 범위를 벗어난 경우
            if(user[i] < 1 || user[i] > 9){
                i--;
                continue;
            }
            // 중복인 경우
            for(int j = 0;j<i;j++){
                if(user[i] == user[j]){
                    i--;
                    break;
                }
            }
        }
        return user;
    }

    static int[] checkSB(int[] user, int[] com){
        int[] result = new int[2];
        // strike ball 계산
        for(int i = 0;i<3;i++){ // user
            for(int j = 0;j<3;j++){ // com
                if(user[i] == com[j]){ // strike ball
                    if(i == j){
                        result[0]++;
                    }
                    else{
                        result[1]++;
                    }
                }
            }
        }
        return result;
    }

    static boolean printResult(int[] result){
        // 출력
        if(result[0] == 3){
            System.out.println("홈런입닌다.");
            return true;
        }
        else if(result[0] == 0 &&  result[1] == 0){
            System.out.println("Out 입니다.");
        }
        else{
            System.out.println("strike : "+result[0]+", ball : "+result[1]);
        }
        return false;
    }

    static void main() {
        // 컴퓨터 난수 만들기
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] com = randomCom(r);
        //유저 입력 받을 배열생성
        while(true){
            //int[] user = inputUser(sc);
            //int[] result =checkSB(user,com);
//            boolean check = printResult(result[0],result[1]);
//            if(check == false){
//                break;
//            }
            if(printResult(checkSB(inputUser(sc),com))){
                break;
            }
        }
    }
}