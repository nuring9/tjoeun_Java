package Day04;

import java.util.Scanner;

public class Q1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫를 하나 입력 하세요 : ");
        int num = sc.nextInt();
        System.out.print(num + "의 약수는 ");

        // 입력받는 숫자의 약수를 출력
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.print(i + ",");
            }
        }
        System.out.print(num +" 입니다.");
    }

}

//    for (int i = 1; i<=num; i++) {
//     if (num % i == 0){
//         if(num == i){
//         System.out.print(i);
//         }
//         else {
//        System.out.print(i + ",");
//        }
//    }
//}
//        System.out.print(" 입니다.");
//}
