package Day04;

import java.util.Scanner;

public class Q2_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("세 과목의 점수를 입력하세요.");

        System.out.println("국어 : ");
        int kor = sc.nextInt();
        System.out.println("영어 : ");
        int eng = sc.nextInt();
        System.out.println("수학 : ");
        int math = sc.nextInt();



if (kor >= 0 && kor <= 100 && eng >= 0 && eng <=100 & math >=0 && math <=100) {
    double avg = (kor + eng + math) / 3.0;
    String hakjum ="";

        if ( avg >= 95) {
            hakjum = "A+";
        } else if(avg >= 90) {
            hakjum = "A";
        } else if(avg >= 85) {
            hakjum = "B+";
        } else if(avg >= 80) {
            hakjum = "B";
        } else if(avg >= 75) {
            hakjum = "C+";
        } else if(avg >= 70) {
            hakjum = "C";
        } else if(avg >= 65) {
            hakjum = "D";
        } else {
                hakjum = "F";
            }

        System.out.printf("평균 %.1f점이고 학점은 %s 입니다.", avg, hakjum);

        }


        else {

        if(kor < 0 || kor > 100) {
            System.out.print("국어 ");
        }
        if(eng < 0 || eng > 100) {
            System.out.print("영어 ");
        }
        if(math < 0 || math > 100) {
             System.out.print("수학 ");
         }

          System.out.println("점수가 잘못 입력 되었습니다.");

        }
    }
}
