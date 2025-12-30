package Day18;
/*
오버로딩 문제
컨트롤 클래스를 만듦
컨트롤 클래스에는 더하기 곱하기 빼기 나눗셈 연산을 하는 함수를 만듦
실수와 정수의 연산이 될 수 있도록 오버로딩을 사용해서 만듦
입력과 출력도 컨트롤 클래스에 만들어 줌.
main 함수에서 연산이 되도록 구현.

1.정수연산 2.실수연산 3.종료 : 1(입력)
1.더하기 2.빼기 3.곱하기 4.나누기: 1(입력
숫자 1 입력 : 5
숫자 2 입력 : 5
결과 값 : 10
이렇게 출력 이후에 다시 첫화면으로 이동 해
모든 곳에 잘못된 입력 처리를 해주세요.


 */

import java.util.Scanner;

class Controller{
    int add(int a, int b){
        return a + b;
    }
    double add(double a, double b){
        return a + b;
    }
    int minus(int a, int b){
        return a - b;
    }
    double minus(double a, double b){
        return a - b;
    }
    int mul(int a, int b){
        return a * b;
    }
    double mul(double a, double b){
        return a * b;
    }
    int div(int a, int b){
        return a / b;
    }
    double div(double a, double b){
        return a / b;
    }
    void print(int result){
        System.out.println("결과 값 : "+result);
    }
    void print(double result){
        System.out.println("결과 값 : "+result);
    }
    int[] inputInteger(Scanner sc){
        int[] nums = new int[2];
        System.out.print("숫자 1 입력 ");
        nums[0] = sc.nextInt();
        System.out.print("숫자 2 입력 ");
        nums[1] = sc.nextInt();
        return nums;
    }
    double[] inputDouble(Scanner sc){
        double[] nums = new double[2];
        System.out.print("숫자 1 입력 ");
        nums[0] = sc.nextDouble();
        System.out.print("숫자 2 입력 ");
        nums[1] = sc.nextDouble();
        return nums;
    }
    int opInput(Scanner sc){
        System.out.print("1.더하기 2. 빼기 3.곱하기 4. 나누기 : ");
        int num = sc.nextInt();
        return num;
    }
}

public class Q1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Controller c = new Controller();
        while (true){
            System.out.print("1.정수연산 2.실수연산 3. 종료 :");
            int num = sc.nextInt();
            if(num == 1){
                int op = c.opInput(sc);
                if(op == 1){
                    int[] nums =c.inputInteger(sc);
                    c.print(c.add(nums[0],nums[1]));
                }
                else if(op == 2){
                    int[] nums =c.inputInteger(sc);
                    c.print(c.minus(nums[0],nums[1]));
                }
                else if(op == 3){
                    int[] nums =c.inputInteger(sc);
                    c.print(c.mul(nums[0],nums[1]));
                }
                else if(op == 4){
                    int[] nums =c.inputInteger(sc);
                    c.print(c.div(nums[0],nums[1]));
                }
                else{
                    System.out.println("잘못된 입력입니다.");
                }
            }
            else if(num == 2){
                int op = c.opInput(sc);

                if(op == 1){
                    double[] nums =c.inputDouble(sc);
                    c.print(c.add(nums[0],nums[1]));
                }
                else if(op == 2){
                    double[] nums =c.inputDouble(sc);
                    c.print(c.minus(nums[0],nums[1]));
                }
                else if(op == 3){
                    double[] nums =c.inputDouble(sc);
                    c.print(c.mul(nums[0],nums[1]));
                }
                else if(op == 4){
                    double[] nums =c.inputDouble(sc);
                    c.print(c.div(nums[0],nums[1]));
                }
                else{
                    System.out.println("잘못된 입력입니다.");
                }
            }
            else if(num == 3){
                System.out.println("프로그램 종료");
                break;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}