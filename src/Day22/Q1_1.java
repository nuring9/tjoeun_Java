package Day22;


import java.util.ArrayList;
import java.util.Scanner;

// 이름, 전화번호, 주소, 나이
class PhoneData{
    String name;
    String tel;
    String address;
    int age;
    PhoneData(String name, String tel, String address, int age){
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.age = age;
    }
}
public class Q1_1 {
    static void main() {
        ArrayList<PhoneData> telBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("1.추가 2.삭제 3.전체출력 4.이름검색 5.종료 : ");
            int num = sc.nextInt();
            if(num == 1){
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("전화번호 : ");
                String tel = sc.next();
                System.out.print("주소 : ");
                String address = sc.next();
                System.out.print("나이 : ");
                int age = sc.nextInt();
                telBook.add(new PhoneData(name,tel,address,age));
                System.out.println(name+"님이 추가 되었습니다.");
            }
            else if(num == 2){
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for(i = 0;i<telBook.size();i++){
                    if(telBook.get(i).name.equals(name)){
                        telBook.remove(i);
                        System.out.println(name+"을 지웠습니다.");
                        break;
                    }
                }
                if(i == telBook.size()){
                    System.out.println(name+"이 전화번호부에 없습니다.");
                }
            }
            else if(num == 3){
                for(int i = 0;i<telBook.size();i++){
                    System.out.println("이름 : "+telBook.get(i).name+", 전화번호 :"+
                            telBook.get(i).tel+", 주소 : "+telBook.get(i).address+
                            ", 나이 : "+telBook.get(i).age+"세");
                }
            }
            else if(num == 4){
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for(i = 0;i<telBook.size();i++){
                    if(telBook.get(i).name.equals(name)){
                        System.out.println("이름 : "+telBook.get(i).name+", 전화번호 :"+
                                telBook.get(i).tel+", 주소 : "+telBook.get(i).address+
                                ", 나이 : "+telBook.get(i).age+"세");
                        break;
                    }
                }
                if(i == telBook.size()){
                    System.out.println(name+"이 전화번호부에 없습니다.");
                }
            }
            else if(num == 5){
                System.out.println("종료합니다.");
                break;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}