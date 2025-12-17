package Day11;

import java.util.Scanner;

public class Q1_1 {
    // 주고 -> return
    // 받는 -> 매개변수
    // 안주고 -> return X void
    // 안받고 -> 매개변수 X
    //1. 사각형 넓이 함수 1번 (주고 받고)
    static int recResult(int w, int h){
        return w * h;
    }/*
    static int recResult(int[] nums){
        return nums[0] * nums[1];
    }
    */
    //2. 삼각형 넓이 함수 3번 (안주고 받고)
    static void triResult(int w, int h){
        System.out.println("결과 값 : "+(w * h / 2));
    }
    //    static void triResult(int[] nums){
//        System.out.println("결과 값 : "+(nums[0] * nums[1] / 2));
//    }
    //3. 입력 합수 2번(주고 안받고)
    static int[] input(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        System.out.print("1. 가로 : ");
        nums[0] = sc.nextInt();
        System.out.print("2. 세로 : ");
        nums[1] = sc.nextInt();
        return nums;
    }


    static void main() {
        //1. 입력 선언
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("1. 사각형 넓이 2. 삼각형 넓이 3. 종료 : ");
            int num = sc.nextInt();
            if(num == 1){
                int[] nums = input();
                //int result = recResult(width, height);
                //System.out.println("사각형 넓이 : "+result);
                //System.out.println("사각형 넓이 : "+recResult(nums));
                System.out.println("사각형 넓이 : "+recResult(nums[0],nums[1]));
                //System.out.println("사각형 넓이 : "+recResult(input()[0],input()[1]));
            }
            else if(num == 2){
                int[]nums = input();
                //System.out.println("삼각형 넓이 : "+(width * height / 2));
                //triResult(nums);
                triResult(nums[0],nums[1]);
                //triResult(input()[0],input()[1]);
            }
            else if(num == 3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}
