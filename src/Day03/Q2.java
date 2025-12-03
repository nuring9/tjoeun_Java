package Day03;

import java.util.Scanner;

public class Q2 {
    static void main() {

        // 내가 푼 문제
        Scanner sc = new Scanner(System.in);

        System.out.println("월 입력 : ");
        int month = sc.nextInt();

        System.out.println("온도 입력 : ");
        int temperature = sc.nextInt();

        if (month < 1 || month >= 12 || temperature < -15 || temperature > 37) {
            System.out.println("잘못된 입력입니다.");
        } else {

            if (month >= 3 && month <= 5 && temperature >= 3 && temperature <= 15) {
                System.out.println("계절은 봄입니다. 온도는 " + temperature);
            } else if (month >= 6 && month <= 8 && temperature >= 18 && temperature <= 37) {
                System.out.println("계절은 여름입니다. 온도는 " + temperature);
            } else if (month >= 9 && month <= 11 && temperature >= 3 && temperature <= 15) {
                System.out.println("계절은 가을입니다. 온도는 " + temperature);
            } else if ((month == 12 || month == 1 || month == 2) && temperature >= -15 || temperature <= 2) {
                if (temperature >= 2) {
                    System.out.println("온도가 맞지 않습니다.");
                } else {
                    System.out.println("계절은 겨울입니다. 온도는 " + temperature);
                }
            } else {
                System.out.println("계절과 온도가 맞지 않습니다.");
            }

        }
    }
}

//        답.
//        //1. 입력
//        Scanner sc = new Scanner(System.in);// 입력준비
//        // 월 입력
//        System.out.print("월 입력 : ");
//        int month = sc.nextInt();
//        // 온도 입력
//        System.out.print("온도 입력 :");
//        int temp = sc.nextInt();
//        //잘못된 입력
//        // 1~12 월이 아니거나 -15~37가 아니면 잘못된 입력입니다.
//        if(month < 1 || month > 12 || temp < -15 || temp > 37){
//            System.out.println("잘못된 입력입니다.");
//        }
//        //잘 된 입력
//        else{
//            if(month >= 3 && month <=5 && temp >= 3 && temp <= 15){
//                System.out.println("계절은 봄 입니다. 온도는 "+temp+"도 입니다.");
//            }
//            else if(month >= 6 && month <= 8 && temp >= 18 && temp <= 37){
//                System.out.println("계절은 여름 입니다. 온도는 "+temp+"도 입니다.");
//            }
//            else if(month >= 9 && month <=11 && temp >= 3 && temp <= 15){
//                System.out.println("계절은 가을 입니다. 온도는 "+temp+"도 입니다.");
//            }
//            else if((month == 12 || month == 1 || month == 2) && temp >= -15 && temp <= 2){
//                System.out.println("계절은 겨울 입니다. 온도는 "+temp+"도 입니다.");
//            }
//            else{
//                System.out.println("계절과 온도가 맞지 않습니다.");
//            }
//        }


