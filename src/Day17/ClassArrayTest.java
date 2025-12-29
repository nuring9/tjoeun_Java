package Day17;

class D{

}


public class ClassArrayTest {
 static D[] sendD(D[][] d, int i, int j) {
     d[i][j] = new D();
     return d[i];
 }

    static void main() {
     D[][] d1 = new D[3][3];
     D[] d2 = sendD(d1, 0, 2);

     for(int i = 0; i<d1.length; i++){
         for(int j = 0; j<d1[i].length; j++){
             if(d1[i][j] != null) {
                 System.out.println("d1[" + i + "][" + j + "]");
             }
         }
     }
        for(int i = 0; i<d2.length; i++){
            if(d2[i] != null) {
                System.out.println("d2[" + i + "]");
            }
        }

    }
}
