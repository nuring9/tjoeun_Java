package ExcelTest;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcelWriteTest {
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Member> list = new ArrayList<>();

        while (true) {
            System.out.println("이름 : ");
            String name = sc.next();

            if(name.equals("종료")) {
                break;
            }

            System.out.println("나이 : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("생년월일 : ");
            String birth = sc.next();
            System.out.println("전화번호 : ");
            String tel = sc.next();
            System.out.println("주소 : ");
            String address = sc.next();
            System.out.println("결혼 여부 : ");
            Boolean isMarred = sc.nextBoolean();

            Member m = new Member(name, age, birth, tel, address, isMarred);
            list.add(m);
        }
        for (Member m : list) {
            System.out.println(m);
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("멤버 정보");

        Row headRow = sheet.createRow(0);

        headRow.createCell(0).setCellValue("이름");
        headRow.createCell(1).setCellValue("나이");
        headRow.createCell(2).setCellValue("생년월일");
        headRow.createCell(3).setCellValue("전화번호");
        headRow.createCell(4).setCellValue("주소");
        headRow.createCell(5).setCellValue("결혼여부");


        for (int i = 0; i<list.size(); i++){
            Member m = list.get(i);
            Row r = sheet.createRow(i+1);

            r.createCell(0).setCellValue(m.getName());
            r.createCell(1).setCellValue(m.getAge());
            r.createCell(2).setCellValue(m.getBirthdate());
            r.createCell(3).setCellValue(m.getPhone());
            r.createCell(4).setCellValue(m.getAddress());
            r.createCell(5).setCellValue(m.isMarried());
        }
        String fileName = "member.xlsx";

        FileOutputStream outputStream = new FileOutputStream(new File(fileName));
        workbook.write(outputStream);
        workbook.close();
        System.out.println("엑셀 완성 : " + fileName);

    }
}
