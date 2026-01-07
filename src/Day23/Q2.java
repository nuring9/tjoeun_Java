package Day23;

// 내가 푼것

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class PhoneBook {
    String name;
    String tel;
    String address;

    PhoneBook(String name, String tel, String address) {
        this.name = name;
        this.tel = tel;
        this.address = address;
    }
}

public class Q2 {
    static void main() throws IOException {
        ArrayList<PhoneBook> telBook1 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String source;
        String s;


        System.out.println("파일명을 입력하세요 : ");
        s = sc.next();  // a.txt라고 입력하면
        FileWriter fw = new FileWriter(s, true);  // a.txt 파일 생성
        // FileWriter 객체를 생성 파일명 -
        System.out.println(s + "파일이 생성되었습니다.");
        while (true) {
            System.out.print("1.추가 2.검색 3.삭제 4.출력 5.종료 : ");
            int num = sc.nextInt();
            if (num == 1) {
                // 입력
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("전화번호 : ");
                String tel = sc.next();
                System.out.print("주소 : ");
                String address = sc.next();
                telBook1.add(new PhoneBook(name, tel, address));
                System.out.println(name + "님이 추가 되었습니다.");
                source = name + ", " + tel + ", " + address;

                fw.write(source); // a.txt 파일 안에 source가 문자 배열로 된 input가 들어가있다.
                // 그 파일에 쓴다 char[] input 데이터를 쓴다
                fw.close(); // 파일 닫기
            } else if (num == 2) {
                // 검색
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for (i = 0; i < telBook1.size(); i++) {
                    if (telBook1.get(i).name.equals(name)) {
                        System.out.println("이름 : " + telBook1.get(i).name + ", 전화번호 :" +
                                telBook1.get(i).tel + ", 주소 : " + telBook1.get(i).address);
                    }
                }
            } else if (num == 3) {
                // 삭제
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for (i = 0; i < telBook1.size(); i++) {
                    if (telBook1.get(i).name.equals(name)) {
                        telBook1.remove(i);
                        System.out.println(name + "을 지웠습니다.");
                        break;
                    }
                }
                if (i == telBook1.size()) {
                    System.out.println(name + "이 전화번호부에 없습니다.");
                /*
                리스트의 모든 요소를 다 확인한 후, i가 telBook.size()와 같아지는 순간
                반복 조건(i < telBook.size())이 거짓이 되어 반복문이 자연스럽게 종료.
                 */
                }
            } else if (num == 4) {
                FileReader fr = new FileReader(s);
                BufferedReader br = new BufferedReader(fr);
                while ((source = br.readLine()) != null){
                    // 이름, 전화번호, 주소
                    // 홍길동, 010, 인천시
                    String[] array = source.split(",");
             for(int i = 0; i< array.length; i++ ){
                 System.out.println(array[i]);
             }
                }
            } else {
                break;
            }
        }


    }
}
