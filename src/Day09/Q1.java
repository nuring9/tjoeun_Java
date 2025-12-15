package Day09;

public class Q1 {
    static void main() {
        int[][] arr = new int[5][5];
        int count = 1;


        for (int i = 0; i<arr.length; i++){
            if(i%2 == 0){
            for (int j = 0; j<arr[i].length; j++) {
                    arr[i][j] = count++;
            }
            } else {
                for (int j =arr.length-1; j>-1; j--) {
                    arr[i][j] = count++;
                }
            }

        }

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }


//        for (int i = 0; i<arr.length; i++){
//            if (i % 2 == 0) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    System.out.print(arr[i][j] + "\t");
//                }
//            }
//            if (i % 2 == 1) {
//                for (int j = i*4; j < arr[i].length; j--) {
//                    System.out.print(arr[i][j] + "\t");
//                }
//            }
//            System.out.println();
//        }
//




     /*
      내가 푼것

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }



        for (int i = 0; i<arr.length; i++){
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            if (i % 2 == 1) {
                for (int j = i*4; j < arr[i].length; j--) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }

 */


    }
}
