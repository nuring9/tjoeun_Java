package Day09;

public class Q1_2 {
    static void main() {
        int count = 1;
        int sw = 1;
        int[][] arr = new int[5][5];
        for(int i =0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                if (sw == 1) {
                    arr[i][j] = count++;
                } else {
                    /*
                    5 - j(0) - 1  =  4
                    5 - j(1) - 1  =  3
                    5 - j(2) - 1  =  2
                    5 - j(3) - 1  =  1
                    5 - j(4) - 1  =  0
                     */
                    arr[i][arr[i].length-j-1] = count++;
                }
            }
            sw = sw * (-1);
            //  1 * -1 = -1
            // -1 * -1 =  1
        }

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
