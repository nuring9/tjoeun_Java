package Day07;

public class MultiArrayTest1 {
    static void main() {

        int[][] a = new int[5][5];
        int[][][] b = new int[3][3][3];
        int[][][][] c = new int[2][2][2][2];

        a[0][0] = 10;
        b[0][0][0] = 20;
        c[0][0][0][0] = 30;
        b[0][0] = c[0][0][0];

        // 2차원 배열 접근법
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

            }
        }

        // 3차원 배열 접근법
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                for (int k = 0; k < b[i][j].length; k++) {

                }
            }
        }

        // 4차원 배열 접근법
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k < c[i][j].length; k++) {
                    for (int l = 0; l < c[i][j][k].length; l++) {

                    }
                }
            }
        }


    }
}
