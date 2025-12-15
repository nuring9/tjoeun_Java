package Day09;

import java.util.Scanner;

public class Q2 {
    static void main() {
        // 내가 푼 문제.

         /*
        좌석 총 18자리, 두 값을 입력 받음. 9행2열, 예약좌석이 0이되면 프로그램 종료
        아무도 예약을 하지않을 시 예약 완료 (배열이 비어있을 경우?)

        "예약하실  좌석을 입력해주세요 (총 18석) : "
        1 입력하면, "1행"
        1 입력하면, "1열"
        "[i]행, [j]열 예약이 완료되었습니다."


        "[i]행, [j]열 예약이 완료된 자리입니다. 다시 예약해주세요."
        "비어있는 좌석 : [i]행[j]열 "
        "예약하실  좌석을 입력해주세요 (총 18석) : "
        1 입력하면, "1행"
        1 입력하면, "1열"
        "[i]행, [j]열 예약이 완료되었습니다."


        "범위가 벗어 났습니다. "
        "프로그램 종료!!"
         */
        int[][] arr = new int[9][2];
        Scanner sc = new Scanner(System.in);
        int count = 0;
        boolean a = true;




        while (count == 0) {

            System.out.println("예약하실 좌석을 입력해주세요 (총 18석) : ");
            int row = sc.nextInt();
            System.out.println(row + "행");
            int col = sc.nextInt();
            System.out.println(col + "열");

            if (row >= 1 && row <= 9 && col >= 1 && col <= 2) {

                arr[row-1][col-1] = 1;

//                System.out.println(count);

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] == 1) {
                            System.out.println((i+1) +"행, "+ (j+1) +"열 예약이 완료되었습니다.");
                            count = count++;
                        }
                        if ( arr[i][j] > 1) {
                            System.out.println((i+1) +"행, "+ (j+1) +"열 예약이 완료된 자리입니다. 다시 예약해주세요.");
                            for (int k = 0; k < arr.length; k++) {
                                for (int l = 0; l < arr[j].length; j++) {
                                if (arr[k][l] == 0) {
                                    System.out.println((k+1) +"행, "+ (l+1) +"열");
                                }
                                }
                                System.out.println();
                            }
                        }

                    }
                }

            } else {
                System.out.println("범위가 벗어 났습니다.");
            }





//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    if (arr[row][col] == 1) {
//                        System.out.println("[i]행, [j]열 예약이 완료된 자리입니다. 다시 예약해주세요.");
//                    } else {
//
//                    }
//                }
//            }

        }


//        for (int i = 0; i<arr.length; i++){
//            for (int j = 0; j<arr[i].length; j++) {
//                System.out.print(arr[i][j]+"\t");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i<arr.length; i++){
//                for (int j = 0; j<arr[i].length; j++) {
//                    if (arr[row][col] == 1) {
//                        System.out.println("[i]행, [j]열 예약이 완료된 자리입니다. 다시 예약해주세요.");
//                    } else {
//
//                    }
//            }
//        }


    }
}
