package Day09;

public class MultiArrayTest1 {
    static void main() {
        int[][] b = new int[5][5];
        int count = 1;

        for (int i = 0; i<b.length; i++){
            for (int j = 0; j<b[i].length; j++) {
                b[i][j] = count++;
            }
        }


        for (int i = 0; i<b.length; i++){
            for (int j = 0; j<b[i].length; j++) {
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println();

        int[][] arr = {{1,2,3}}; // [1][3] 00 01 02
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[0][0]);


    }
}
