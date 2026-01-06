package Day22;
/*
ArrayList를 이용한 전화번호부 만들기
1.추가 2.삭제 3.전체 출력 4.이름 검색 5.종료
 이름, 전화번호, 주소, 나이

 이름: 홍길동, 전화번호: 010-xxxx, 주소: 서울시 마포구, 나이: 20세   (출력)

 1. 추가
 이름:
 전화번호:
 주소:
 나이:

 2. 삭제
 이름:

 3. 전체출력

 4. 이름 검색
 이름:
 있으면 출력.
 */

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String name;
    String number;
    String address;
    int age;

    Book(String name, String number, String address, int age) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.age = age;
    }

    void print() {
        System.out.println("이름: " + name + "전화번호: " + number + "주소: " + address + "나이 : " + age);
    }

}


public class Q1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        String name;
        String number;
        String address;
        int age;
        ArrayList<Book> booklist = new ArrayList<Book>();


        while (true) {
            System.out.println("1.추가  2.삭제  3.전체 출력  4.이름 검색  5.종료");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("1.추가");
                System.out.println("이름 : ");
                name = sc.next();
                System.out.println("전화번호 : ");
                number = sc.next();
                System.out.println("주소 : ");
                address = sc.next();
                System.out.println("나이 : ");
                age = sc.nextInt();
                booklist.add(new Book(name, number, address, age));

//               booklist.set(new Book(name, number, address, age))   set은 변경

                for (int i = 0; i < booklist.size(); i++) {
                    booklist.get(i).print();
                }
                System.out.println();


            } else if (num == 2) {
                System.out.println("2.삭제");
                System.out.print("이름 : ");
                name = sc.next();
                String d = booklist.toString();

                System.out.println(d);

            } else if (num == 3) {
                System.out.println("3.전체출력");
                String a = booklist.toString();
                System.out.println(a);

            } else if (num == 4) {
                System.out.println("4.이름검색");
                name = sc.next();



            } else {
                System.out.println("종료 되었습니다.");
                break;
            }
            System.out.println("1.추가  2.삭제  3.전체 출력  4.이름 검색  5.종료");
            num = sc.nextInt();
        }

    }
}
