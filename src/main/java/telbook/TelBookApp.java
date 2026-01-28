package telbook; // telbook 패키지

import java.util.Scanner; // 사용자 입력 받기

// 프로그램 시작 클래스
public class TelBookApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in); // 키보드 입력
        TelBookDAO dao = new TelBookDAO();    // DAO 객체 생성

        while (true) {
            System.out.print("1.추가 2.삭제 3.전체출력 4.이름검색 5.종료 : ");
            int num = Integer.parseInt(sc.nextLine()); // 메뉴 선택 , sc.nextLine()로 받은 문자열을 Integer.parseInt() 로 숫자로 변환.

            if (num == 1) { // 추가
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("전화번호 : ");
                String phone = sc.nextLine();
                System.out.print("주소 : ");  //sc.next(); 는 공백 전까지만 읽음.
                // "인천시 서구" address = "인천시" / " 서구"가 버퍼에 남음 이게 그대로 age로 들어가게되면 오류가 발생하므로 전부 sc.nextLine()로 입력받아야 함.
                String address = sc.nextLine();

                System.out.print("나이 : ");
                int age = Integer.parseInt(sc.nextLine());

                dao.insert(new TelBookDTO(name, phone, address, age));
                System.out.println(name + " 추가 완료");
            }
            else if (num == 2) { // 삭제
                System.out.print("이름 : ");
                dao.delete(sc.nextLine());
            }
            else if (num == 3) { // 전체 출력
                dao.findAll();
            }
            else if (num == 4) { // 이름 검색
                System.out.print("이름 : ");
                dao.findByName(sc.nextLine());
            }
            else if (num == 5) { // 종료
                System.out.println("종료합니다.");
                break;
            }
            else { // 잘못된 입력
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
