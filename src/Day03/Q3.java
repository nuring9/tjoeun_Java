package Day03;

import java.util.Scanner;

public class Q3 {
    static void main() {
                //1. 입력
        Scanner sc = new Scanner(System.in);// 입력준비
        // 월 입력
        System.out.print("월 입력 : ");
        int month = sc.nextInt();
        // 온도 입력
        System.out.print("온도 입력 :");
        int temp = sc.nextInt();
        //잘못된 입력
        // 1~12 월이 아니거나 -15~37가 아니면 잘못된 입력입니다.
        if(month < 1 || month > 12 || temp < -15 || temp > 37){
            System.out.println("잘못된 입력입니다.");
        }
        else {
            switch (month) {
                case 3:
                case 4:
                case 5:
                    if(temp >= 3 && temp <= 15){
                        System.out.println("계절은 봄 입니다. 온도는 "+temp+"도 입니다.");
                    } else {
                        System.out.println("계절과 온도가 맞지 않습니다.");
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    if(temp >= 18 && temp <= 37){
                        System.out.println("계절은 여름 입니다. 온도는 "+temp+"도 입니다.");
                    } else {
                        System.out.println("계절과 온도가 맞지 않습니다.");
                    }
                    break;
                case 9:
                case 10:
                case 11:
                    if(temp >= 3 && temp <= 15){
                        System.out.println("계절은 가을 입니다. 온도는 "+temp+"도 입니다.");
                    } else {
                        System.out.println("계절과 온도가 맞지 않습니다.");
                    }
                    break;
                default:
                    if(temp >= -15 && temp <= 2){
                        System.out.println("계절은 겨울 입니다. 온도는 "+temp+"도 입니다.");
                    } else {
                        System.out.println("계절과 온도가 맞지 않습니다.");
                    }
                    break;
            }
        }

// 위 코드를 if문으로 ,,,
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
    }
}






