package Day10;

public class Q2 {

    // 달팽이 알고리즘

    static void main() {
        int[][] arr = new int[5][5];
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = count++;
                    if ( j == 4) {
                    for (int k = arr.length-2; k >-1; k--) {
                        arr[k][i] = count++;
                    }
                    }
                }

            } else if (i == 4) {
                for (int j = 1; j < arr[i].length; j++) {
                    arr[j][i] = count++;
                }
                for (int j = arr.length - 2; j > -1; j--) {
                    arr[i][j] = count++;
                }

//            } else {
//                for (int j = arr.length-2; j>-1; j--) {
//                    arr[j][i] = count++;
//                }
            }
        }


//        for (int i = 0; i < arr.length; i++) {
//            for (int j = (arr.length-1); j<arr[i].length; j++) {
//                arr[j][i] = count++;
//            }
//        }

//        for (int i = 0; i < arr.length; i++) {
//                for (int j = (arr.length-1); j<arr[i].length; j++) {
//                    arr[i][j] = count++;
//                }
//        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
