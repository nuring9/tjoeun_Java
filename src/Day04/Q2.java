package Day04;

import java.util.Scanner;

public class Q2 {
    static void main() {
        // 100점 초과하는 점수 ㅇ입력하면 평균을 계산하지않고 입력하면 평균을 계산하지않고 입력된 과목과 함ㄲㅔ 점수를 잘못입력했습니다. 과목별 출력

        // 세과목 점수를 입력 받음
        // 소수점 첫째자리까지 계산
        // 평균의 학점을 출력
        // 평균 XX점이고 학점은 XX입니다.

        Scanner sc = new Scanner(System.in);
        System.out.println("세 과목의 점수를 입력하세요.");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        double sum;


        if( num1 <= 100 && num2 <= 100 && num3 <= 100) {
            sum = (double) (num1+ num2 + num3)/3;

            if( sum >= 95) {
                System.out.printf("A+ %.1f", sum);
            } else if ( sum >= 90  ) {
                System.out.printf("A %.1f", sum);
            } else if ( sum >= 85 ) {
                System.out.printf("B+ %.1f", sum);
            } else if ( sum >= 80 ) {
            System.out.printf("B %.1f", sum);
            } else if ( sum >= 75 ) {
            System.out.printf("C+ %.1f", sum);
            } else if ( sum >= 70 ) {
                System.out.printf("C %.1f", sum);
            }  else if ( sum >= 60 ) {
                System.out.printf("D %.1f", sum);
            } else {
                System.out.printf("F %.1f", sum);
            }

        } else {

            if( num1 < 0 || num1 > 100  ) {
                System.out.print("국어 ");
            }
            if ( num2 < 0 ||num2 > 100  ) {
                System.out.print("영어 ");
            }
            if ( num3 <0 ||num3 > 100  ){
                System.out.print("수학 ");
            }
            System.out.print("점수가 잘못 입력 되었습니다.");


        }
    }
}
