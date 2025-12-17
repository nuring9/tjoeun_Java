package Day11;

import java.util.Scanner;



public class Q2 {
    /*
    1. 세과목의 점수 입력
    국어, 영어, 수학 정수로 입력 받음  = 주고 안받고

    2. 평균 학점 연산 = 주고 받고

    3. 평균의 학점을 출력 = 주고 받고
    A+ 95점 이상 / A 90점 이상
    B+ 85점 이상 / C 70점 이상
    D 60 점 이상 / F 60점 미만

    4. 각 점수마다 100점을 초과하는 점수를 입력하면,
    평균을 계산하지 않고, "입력된 과목과 함께 점수를 잘못 입력했습니다." 출력 후 프로그램 종료
    잘못된 입력값 확인 =  (입력값이 올바를수도 있고, 아닐 수도 있고, 메인화) = 안주고 받고.

    5. 잘못된 입력입니다. 출력 = 안주고 안받고

    6. 평균학점 출력 = 안주고 받고.
     */


    //  1. 세과목의 점수 입력  국어, 영어, 수학 정수로 입력 받음  = 주고 안받고
    static int[] input() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        System.out.print("국어 : ");
        nums[0] = sc.nextInt();
        System.out.print("영어 : ");
        nums[1] = sc.nextInt();
        System.out.print("수학 : ");
        nums[2] = sc.nextInt();
        return nums;

    }



    // 2. 평균 학점 연산 = 주고 받고
     static double Average(int[] nums) {
         input();
         double avgRe =  (nums[0] * nums[1] * nums[2]) / 3;
       // 국어, 영어, 수학 정수로 입력받고 연산
        return avgRe;
    }


  // 3. 평균의 학점을 출력 = 주고 받고
    static String[] Score(int result) {
        //  평균의 학점을 출력 = 주고 받고
        // 평균학점을 받아서 바로 출력
      String[] grade = {"A+", "A", "B+", "C", "D", "F"};
        return grade;
    }




 /*
 4. 각 점수마다 100점을 초과하는 점수를 입력하면, (함수안 함수)
    평균을 계산하지 않고, "입력된 과목과 함께 점수를 잘못 입력했습니다." 출력 후 프로그램 종료
    잘못된 입력값 확인 =  (입력값이 올바를수도 있고, 아닐 수도 있고, 메인화) = 안주고 받고.
  */
 static void check(int[] nums) {
     String[] Subject = {"국어", "영어", "수학"};
     if (nums[0] > 100 ){
    // 0이 국어, 1이 영어, 2가 수학
         System.out.println(Subject[0] + " : 점수를 잘못 입력하였습니다." );
     } else if(nums[1] > 100) {
         System.out.println(Subject[1] + " : 점수를 잘못 입력하였습니다." );
     } else {
         System.out.println(Subject[2] + " : 점수를 잘못 입력하였습니다." );
     }

 }

// 5. 잘못된 입력입니다. 출력 = 안주고 안받고
 static void Output() {
        // 잘못된 입력입니다. 출력
     // 안주고 받고 return 없음 매개변수만 있음
     System.out.println("잘못된 입력입니다.");
 }

    //  6. 평균학점 출력 = 안주고 받고.
 static void result(int avg) {
      Average(input());
     System.out.println(avg);
 }


    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : ");
        int korea = sc.nextInt();
        System.out.print("영어 : ");
        int english = sc.nextInt();
        System.out.print("수학 : ");
        int math = sc.nextInt();


        if (korea > 0 && korea <= 100 || english > 0 && english <= 100 || math > 0 && math <= 100) {
            //세과목의 점수 입력
            Average(input());
        } else if (korea > 100 && english > 100 && math > 100) {

        } else {
            int[] nums = new int[3];
            check(nums);
        }
        {
            Output();
            //"입력된 과목과 함께 점수를 잘못 입력했습니다."
        }

    }
}
