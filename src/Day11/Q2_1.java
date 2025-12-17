package Day11;

import java.util.Scanner;

public class Q2_1 {
    //1. 세과목 점수 입력 받기(주고 안받고)
    static int[] input(){
        Scanner sc = new Scanner(System.in);
        int[] score = new int[3];
        System.out.print("국어 : ");
        score[0] = sc.nextInt();
        System.out.print("영어 : ");
        score[1] = sc.nextInt();
        System.out.print("수학 : ");
        score[2] = sc.nextInt();
        return score;
    }
    //2. 평균 학점 연산(주고 받고)
    static double hakjumOP(int kor, int eng, int math){
        double avg = (kor + eng + math) / 3.0;
        return avg;
    }
    //3. 학점을 가지고 A~F까지 주기 (주고 받고)
    static String grade(double avg){
        String hakjum;
        if(avg >= 95){
            hakjum = "A+";
        }
        else if(avg >= 90){
            hakjum = "A";
        }
        else if(avg >= 85){
            hakjum = "B+";
        }
        else if(avg >= 80){
            hakjum = "B";
        }
        else if(avg >= 75){
            hakjum = "C+";
        }
        else if(avg >= 70){
            hakjum = "C";
        }
        else if(avg >= 60){
            hakjum = "D";
        }
        else{
            hakjum = "F";
        }
        return hakjum;
    }

    //4. 잘못된 값 입력 확인(안주고 받고)
    static void wrongCheck(int[] score){
        if(score[0] >=0 && score[0] <=100 && score[1] >=0 && score[1] <=100
                && score[2] >=0 && score[2] <=100 ){
            double avg = hakjumOP(score[0],score[1],score[2]);
            String hakjum = grade(avg);
            resultPrint(avg,hakjum);
        }
        //2. 올바르지 않은 입력
        else{
            wrongPrint();
        }
    }
    //5. 잘못된 입력 출력(안주고 안받고)
    static void wrongPrint(){
        System.out.println("점수가 잘 못 입력 됐습니다.");
    }
    //6. 결과 값 출력(안주고 받고)
    static void resultPrint(double avg, String hakjum){
        System.out.printf("평균 %.1f점이고 학점은 %s 입니다.",avg,hakjum);
    }
    static void main() {
        //int[] score = input();
        //wrongCheck(score);
        wrongCheck(input());
    }
}