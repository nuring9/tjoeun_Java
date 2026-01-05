package Day21;
/*
마트 게임
매장에 컴퓨터, 에어컨, 냉장고, 공기청정기

랜덤으로 40대를 채움

0: 컴퓨터 -> 0: 삼성 / 1: LG
1: 에어컨 -> 0: 삼성 / 1: LG
2: 냉장고 -> 0: 삼성 / 1: LG
3: 공기청정기 -> 0: LG / 1: 다이슨

40개의 제품을 출력

제품 입력: 냉장고
제조사: LG

냉장고 LG 제품에 첫번째 인덱스를 출력 해주면 됨.
만약에 제품이 없으면, 제품이 없습니다 출력.
 */
import java.util.Random;
import java.util.Scanner;

class Product{
    String type;
    Product(String type){
        this.type = type;
    }
}
class Computer extends Product{
    Computer(String type){
        super(type);
    }
}
class AirCorn extends Product{
    AirCorn(String type){
        super(type);
    }
}
class Ref extends Product{
    Ref(String type){
        super(type);
    }
}
class AirCleaner extends Product{
    AirCleaner(String type){
        super(type);
    }
}
public class Q2 {
    static void main() {
        Product[] products = new Product[40];
        Random r = new Random();
        for(int i = 0;i< products.length;i++){
            int ran1 = r.nextInt(4);
            int ran2 = r.nextInt(2);
            if(ran1 == 0){
                System.out.print("컴퓨터 : ");
                if(ran2 == 0){
                    products[i] = new Computer("삼성");
                }
                else{
                    products[i] = new Computer("LG");
                }
            }
            else if(ran1 == 1){
                System.out.print("에어컨 : ");
                if(ran2 == 0){
                    products[i] = new AirCorn("삼성");
                }
                else{
                    products[i] = new AirCorn("LG");
                }
            }
            else if(ran1 == 2){
                System.out.print("냉장고 : ");
                if(ran2 == 0){
                    products[i] = new Ref("삼성");
                }
                else{
                    products[i] = new Ref("LG");
                }
            }
            else{
                System.out.print("공기청정기 : ");
                if(ran2 == 0){
                    products[i] = new AirCleaner("LG");
                }
                else{
                    products[i] = new AirCleaner("다이슨");
                }
            }
            System.out.println(products[i].type);
        }
        Scanner sc = new Scanner(System.in);//입력
        System.out.print("제품 입력 : ");
        String type = sc.next();
        System.out.print("제조사 : ");
        String maker = sc.next();
        int i;
        if(type.equals("컴퓨터") || type.equals("에어컨") || type.equals("냉장고") || type.equals("공기청정기")  )
        {
            if(maker.equals("삼성") || maker.equals("LG") || maker.equals("다이슨")){
                for(i = 0;i< products.length;i++){
                    if(type.equals("컴퓨터") && products[i] instanceof Computer && products[i].type.equals(maker)){
                        System.out.println("인덱스 : "+i);
                        break;
                    }
                    if(type.equals("에어컨") && products[i] instanceof AirCorn && products[i].type.equals(maker) ){
                        System.out.println("인덱스 : "+i);
                        break;
                    }
                    if(type.equals("냉장고") && products[i] instanceof Ref && products[i].type.equals(maker)){
                        System.out.println("인덱스 : "+i);
                        break;
                    }
                    if(type.equals("공기청정기") && products[i] instanceof AirCleaner){
                        if(maker.equals("삼성")){
                            System.out.println("잘못된 입력입니다.");
                        }
                        else{
                            if(products[i].type.equals(maker)){
                                System.out.println("인덱스 : "+i);
                            }
                        }
                        break;
                    }
                }
                if(i == products.length){
                    System.out.println("제품이 없습니다.");
                }
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
        else{
            System.out.println("잘못된 입력입니다.");
        }
    }
}
