package ReferenceSource;

import java.util.Scanner;

class Computer {
    String menu, name;
    int price;

    Computer(String menu, String name, int price){
        this.menu = menu;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "제조사:"+menu+" 제품 명:"+ name +" 가격:"+price;
    }
}
class AirCon {
    String menu, kind;
    int price;

    AirCon(String menu, String kind, int price){
        this.menu = menu;
        this.kind = kind;
        this.price = price;
    }

    @Override
    public String toString(){
        return "제조사:"+menu+" 제품 분류:"+ kind +" 가격:"+price;
    }
}
class Fridge {
    String menu, kind;
    int size, price;

    Fridge(String menu, String kind, int size, int price){
        this.menu = menu;
        this.kind = kind;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString(){
        return "제조사:"+menu+" 제품 분류:"+kind+" 제품 크기:"+size+" 가격:"+price;
    }
}
class AirCleaner {
    String menu, kind;
    int price;

    AirCleaner(String menu, int price){
        this.menu = menu;
        this.price = price;
    }

    @Override
    public String toString(){
        return "제조사:"+menu+" 제품 분류:"+ kind +" 가격:"+price;
    }
}
class People{
    String name;
    int money;
    Computer[] computers = new Computer[10];
    AirCon[] airCons = new AirCon[10];
    Fridge[] fridges = new Fridge[10];
    AirCleaner[] airCleaners = new AirCleaner[10];

    People(String name, int money){
        this.name = name;
        this.money = money;
    }

    int getMoney(){return money;}
    String getName(){return name;}
    boolean payment(int price){
        if(money >= price){
            money -= price;
            return true;
        }else
            return false;
    }
}

class Mart{
    Computer[] computers;
    AirCon[] airCons;
    Fridge[] fridges;
    AirCleaner[] airCleaners;
    Scanner sc;
    int select;
    String product;

    Mart(int stockNum, Scanner sc){
        makeStock(stockNum);
        this.sc = sc;
    }

    void makeStock(int num){
        computers = new Computer[num *2];
        airCons = new AirCon[num *2];
        fridges = new Fridge[num *2];
        airCleaners = new AirCleaner[num *2];

        for(int i = 0; i < num; i++){
            computers[i] = new Computer("삼성", "CPU i7", 200);
            computers[num +i] = new Computer("LG", "CPU i5", 150);
            airCons[i] = new AirCon("삼성", "벽걸이", 100);
            airCons[num +i] = new AirCon("LG", "스탠드", 250);
            fridges[i] = new Fridge("삼성" ,"양문", 600, 200);
            fridges[num +i] = new Fridge("LG" ,"4도어", 800, 350);
            airCleaners[i] = new AirCleaner("LG", 80);
            airCleaners[num +i] = new AirCleaner("dyson", 60);
        }
    }
    void lookAtProduct(People people){
        printPleaseSelect(people.getName(), "1.컴퓨터 2.에어컨 3.냉장고 4.공기청정기");
        select = sc.nextInt();

        if(select == 1)
            lookAtCom(people);
        else if(select == 2)
            lookAtAircon(people);
        else if(select == 3)
            lookAtFridge(people);
        else if(select == 4)
            lookAtAirCleaner(people);
        else
            System.out.println("질못된 입력입니다.");
    }
    boolean lookAtCom(People people){
        printPleaseSelect(people.getName(), "1.삼성(i7):200 2.LG(i5):150");
        select = sc.nextInt();

        if(select == 1) product = "삼성";
        else if(select == 2) product = "LG";
        else{
            System.out.println("잘못된 입력입니다.");
            return false;
        }

        int computerIdx = -1;
        for(int i = 0; i < computers.length; i++) {
            if (computers[i] != null && computers[i].menu.equals(product)){
                computerIdx = i;
                break;
            }
        }
        if(computerIdx == -1){
            System.out.println("제품의 재고가 존재하지 않습니다.");
            return false;
        }

        int peopleEmptyIdx = -1;
        for(int i = 0; i < people.computers.length; i++){
            if(people.computers[i] == null) {
                peopleEmptyIdx = i;
                break;
            }
        }
        if(peopleEmptyIdx == -1){
            System.out.println(people.getName()+"님이 물건을 받을 공간이 없습니다.");
            return false;
        }

        if(people.payment(computers[computerIdx].price)){
            people.computers[peopleEmptyIdx] = computers[computerIdx];
            computers[computerIdx] = null;
            System.out.println("구매를 완료하였습니다.");
            return true;
        }else{
            printHaveNoMoney(computers[computerIdx].price, people.getMoney());
            return false;
        }
    }
    boolean lookAtAircon(People people){
        printPleaseSelect(people.getName(), "1.삼성(벽걸이):100 2.LG(스탠드):250");
        select = sc.nextInt();

        if(select == 1) product = "삼성";
        else if(select == 2) product = "LG";
        else{
            System.out.println("잘못된 입력입니다.");
            return false;
        }

        int airconIdx = -1;
        for(int i = 0; i < airCons.length; i++) {
            if (airCons[i] != null && airCons[i].menu.equals(product)){
                airconIdx = i;
                break;
            }
        }
        if(airconIdx == -1){
            System.out.println("제품의 재고가 존재하지 않습니다.");
            return false;
        }

        int peopleEmptyIdx = -1;
        for(int i = 0; i < people.airCons.length; i++){
            if(people.airCons[i] == null) {
                peopleEmptyIdx = i;
                break;
            }
        }
        if(peopleEmptyIdx == -1){
            System.out.println(people.getName()+"님이 물건을 받을 공간이 없습니다.");
            return false;
        }

        if(people.payment(airCons[airconIdx].price)){
            people.airCons[peopleEmptyIdx] = airCons[airconIdx];
            airCons[airconIdx] = null;
            System.out.println("구매를 완료하였습니다.");
            return true;
        }else{
            printHaveNoMoney(airCons[airconIdx].price, people.getMoney());
            return false;
        }
    }
    boolean lookAtFridge(People people){
        printPleaseSelect(people.getName(), "1.삼성(양문):200 2.LG(4도어):350");
        select = sc.nextInt();

        if(select == 1) product = "삼성";
        else if(select == 2) product = "LG";
        else{
            System.out.println("잘못된 입력입니다.");
            return false;
        }

        int fridgeIdx = -1;
        for(int i = 0; i < fridges.length; i++) {
            if (fridges[i] != null && fridges[i].menu.equals(product)){
                fridgeIdx = i;
                break;
            }
        }
        if(fridgeIdx == -1){
            System.out.println("제품의 재고가 존재하지 않습니다.");
            return false;
        }

        int peopleEmptyIdx = -1;
        for(int i = 0; i < people.fridges.length; i++){
            if(people.fridges[i] == null) {
                peopleEmptyIdx = i;
                break;
            }
        }
        if(peopleEmptyIdx == -1){
            System.out.println(people.getName()+"님이 물건을 받을 공간이 없습니다.");
            return false;
        }

        if(people.payment(fridges[fridgeIdx].price)){
            people.fridges[peopleEmptyIdx] = fridges[fridgeIdx];
            fridges[fridgeIdx] = null;
            System.out.println("구매를 완료하였습니다.");
            return true;
        }else{
            printHaveNoMoney(fridges[fridgeIdx].price, people.getMoney());
            return false;
        }
    }
    boolean lookAtAirCleaner(People people){
        printPleaseSelect(people.getName(), "1.LG:80 2.dyson:60");
        select = sc.nextInt();

        if(select == 1) product = "LG";
        else if(select == 2) product = "dyson";
        else{
            System.out.println("잘못된 입력입니다.");
            return false;
        }

        int airCleanerIdx = -1;
        for(int i = 0; i < airCleaners.length; i++) {
            if (airCleaners[i] != null && airCleaners[i].menu.equals(product)){
                airCleanerIdx = i;
                break;
            }
        }
        if(airCleanerIdx == -1){
            System.out.println("제품의 재고가 존재하지 않습니다.");
            return false;
        }

        int peopleEmptyIdx = -1;
        for(int i = 0; i < people.airCleaners.length; i++){
            if(people.airCleaners[i] == null) {
                peopleEmptyIdx = i;
                break;
            }
        }
        if(peopleEmptyIdx == -1){
            System.out.println(people.getName()+"님이 물건을 받을 공간이 없습니다.");
            return false;
        }

        if(people.payment(airCleaners[airCleanerIdx].price)){
            people.airCleaners[peopleEmptyIdx] = airCleaners[airCleanerIdx];
            airCleaners[airCleanerIdx] = null;
            System.out.println("구매를 완료하였습니다.");
            return true;
        }else{
            printHaveNoMoney(airCleaners[airCleanerIdx].price, people.getMoney());
            return false;
        }
    }
    void printPleaseSelect(String name, String list){
        System.out.println(name+"님 원하시는 제품을 선택해주세요.");
        System.out.println(list);
        System.out.print("입력:");
    }
    void printHaveNoMoney(int price, int money){
        System.out.println("돈이 부족합니다.");
        System.out.println("제품 가격:"+price);
        System.out.println("현재 소지금:"+money);
    }
}

public class Day17_Q1_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        People[] people = new People[3];
        Mart mart = new Mart(5, sc);
        int payableCustomer = people.length;

        for(int i = 0; i < people.length; i++){
            System.out.print((i +1)+"번 소비자의 소지금:");
            people[i] = new People((i +1) +"번 소비자", sc.nextInt());
        }

        while(payableCustomer > 0) {
            payableCustomer = people.length;
            for (People person : people) {
                if (person.getMoney() >= 60) {
                    System.out.println(person.getName() + "님 현재 소지금:" + person.getMoney());
                    mart.lookAtProduct(person);
                    System.out.println();
                }else
                    payableCustomer--;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
