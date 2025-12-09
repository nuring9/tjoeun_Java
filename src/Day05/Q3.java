package Day05;

import java.util.Scanner;

public class Q3 {
    static void main() {
        Scanner sc = new Scanner(System.in);

/*
        1. *****
           *****
           *****
           *****
*/

        System.out.println("1.");
        for (int i=1; i<5; i++) {
            for (int j=1; j<5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
 /*
        2. *
           **
           ***
           ****
           *****
           i = 0
           j = 0("*")
           i = 1
           j = 0("*") 1("*")
           i = 2
           j = 0("*") 1("*") 2("*")
           i = 3
           j = 0("*") 1("*") 2("*") 3("*")
           i = 4
           j = 0("*") 1("*") 2("*") 3("*") ("*")
  */

        System.out.println();
        System.out.println("2.");
        for (int i=0; i<5; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

 /*
         3.
                *
               **
              ***
             ****
            *****

*/
        System.out.println();
        System.out.println("3.");

        for (int i=0; i<5; i++) {
            for (int j=5; j>i+1; j--) {
                System.out.print("  ");
            }
            for (int k=0; k<i+1; k++) {
                 System.out.print("* ");
            }
            System.out.println();
        }

/*
          4.
                *
               ***
              *****
             *******
            *********
*/

        // 내가 푼거
        System.out.println();
        System.out.println("4.");

        for (int i=0; i<8; i++) {
            for (int j=8; j>i; j--) {
                System.out.print(" ");
            }
            for (int j=0; j<i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 정답.
        System.out.println();
        System.out.println("4-1.");

        for (int i=0; i<5; i++) {
            for (int j=0; j<5-1-i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k<= i*2; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

/*
        5.       *
                ***
               *****
                ***
                 *
*/


        // 내가 푼거
        System.out.println();
        System.out.println("5.");

        for (int i=0; i<3; i++) {
            for (int j=5; j>i+1; j--) {
                System.out.print("  ");
            }
            for (int k=0; k<i*2; k++) {
                System.out.print("* ");
            }
            System.out.print("* ");
            System.out.println();
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print("  ");
            }
            for (int k=3; k>i*2; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }


        // 정답.
        System.out.println();
        System.out.println("5-1.");

        for (int i=0; i<3; i++) {
            for (int j=0; j<3-1-i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k<= i*2; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=0; i<2; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print("  ");
            }
            for (int k = 3; k>i*2; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }


        }
    }


