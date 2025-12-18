package Day12;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Q2_1 {
    static void wrongPrint(){
        System.out.println("잘못된 입력입니다.");
    }

    static void firstMenu(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. 구구단 출력");
            System.out.println("2. 별찍기 출력");
            System.out.println("3. 종료");
            int select = sc.nextInt();
            if(select == 1){
                gugu(sc);
            }
            else if(select == 2){
                star(sc);
            }
            else if(select == 3){
                System.out.println("프로그램 종료합니다.");
                break;
            }
            else{
                wrongPrint();
            }
        }
    }
    static void gugu(Scanner sc){
        System.out.println("1. 원하는 구구단 출력");
        System.out.println("2. 전체 구구단 출력");
        int select = sc.nextInt();
        if(select == 1){
            System.out.print("원하는 구구단 : ");
            int dan = sc.nextInt();
            if(dan >=2 && dan <=9){
                for(int times = 1;times<=9;times++){
                    System.out.println(dan + "X" +times+"="+(dan * times));
                }
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
        else if(select == 2){
            for(int dan = 2;dan<=9;dan++){
                for(int times = 1;times<=9;times++){
                    System.out.println(dan + "X" +times+"="+(dan * times));
                }
                System.out.println();
            }
        }
        else{
            wrongPrint();
        }
    }
    static void star(Scanner sc){
        System.out.println("1. 직사각형");
        System.out.println("2. 정직삼각형");
        System.out.println("3. 역직삼각형");
        System.out.println("4. 피라미드");
        System.out.println("5. 다이아몬드");
        int select = sc.nextInt();
        if(select == 1){
            System.out.print("숫자 입력 : ");
            int star = sc.nextInt();
            if(star < 1){
                System.out.println("올바른 숫자를 입력하세요.");
            }
            else{
                for(int i = 0;i<star;i++){
                    for(int j = 0;j<star;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        else if(select == 2){
            System.out.print("숫자 입력 : ");
            int star = sc.nextInt();
            if(star < 1){
                System.out.println("올바른 숫자를 입력하세요.");
            }
            else{
                for(int i = 0;i<star;i++){ // 0 1 2 3 4
                    for(int j = 0;j<=i;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        else if(select == 3){
            System.out.print("숫자 입력 : ");
            int star = sc.nextInt();
            if(star < 1){
                System.out.println("올바른 숫자를 입력하세요.");
            }
            else{
                for(int i = 0;i<star;i++){
                    //스페이스를 4 3 2 1 0
                    for(int j = 0;j<star-1-i;j++){
                        System.out.print(" ");
                    }
                    //별 1 2 3 4 5
                    for(int k = 0;k<=i;k++){ // 0 /0 1 2/ 0 1 2 3 4
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        else if(select == 4){
            System.out.print("숫자 입력 : ");
            int star = sc.nextInt();
            if(star < 1){
                System.out.println("올바른 숫자를 입력하세요.");
            }
            else{
                for(int i = 0;i<star;i++){
                    //스페이스를 4 3 2 1 0
                    for(int j = 0;j<star-1-i;j++){
                        System.out.print(" ");
                    }
                    //별 1 2 3 4 5
                    for(int k = 0;k<=i*2;k++){ // 0 // 2(0,1,2) // 4(0,1,2,3,4)  // 6(0,1,2,3,4,5,6) // 8(0,1,2,3,4,5,6,7,8)
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        else if(select == 5){
            System.out.print("숫자 입력");
            int star = sc.nextInt();
            if(star < 1){
                System.out.println("올바른 숫자를 입력하세요.");
            }
            else{
                for(int i = 0;i<star/2+1;i++){
                    //스페이스를 4 3 2 1 0
                    for(int j = 0;j<(star/2+1)-1-i;j++){
                        System.out.print(" ");
                    }
                    //별 1 2 3 4 5
                    for(int k = 0;k<=i*2;k++){ // 0 // 2(0,1,2) // 4(0,1,2,3,4)  // 6(0,1,2,3,4,5,6) // 8(0,1,2,3,4,5,6,7,8)
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for(int i = 0;i<star/2;i++){ // 4
                    for(int j = 0;j<=i;j++){ // 0 // 0 1
                        System.out.print(" ");
                    }
                    for(int k = 0;star-2*(i+1)>k;k++)//9   0  9 - 2*1 7 9 - 2*2 5
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        else{
            wrongPrint();
        }
    }
    static void main() {
        firstMenu();
    }
}
