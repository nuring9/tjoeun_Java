package Day23;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// 이름, 전화번호, 주소, 나이
class PhoneData{
    String name;
    String tel;
    String address;
    PhoneData(String name, String tel, String address){
        this.name = name;
        this.tel = tel;
        this.address = address;
    }
    @Override
    public String toString() {
        return   "이름 : "+name+", 전화번호 :"+ tel+", 주소 : "+address;
    }
}
public class Q2_1 {
    //고민
    // Java <-> 파일
    // 1. 파일이 존재여부 확인 왜? 있다면 그 안에 있는 파일을 읽어와야 합니다.
    //    단, 없는 경우에는 파일을 생성해야 합니다.
    // 2.입력시 -> 파일에 넣어주기
    // 3.검색시 -> arrayList 왜? arrayList랑 파일랑 계속 싱크를 맞혀 놓을 꺼니까
    // 4.삭제시 -> arrayList -> 파일 내용 지워야 한다
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<PhoneData> telBooks = new ArrayList<>();

        File f = new File("D:\\PhoneTest\\phone.txt");  // "경로"
        if(f.exists()){
            //파일에 있는 값 읽어서 -> ArrayList
            FileReader fr = new FileReader("D:\\PhoneTest\\phone.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] splitLine = null;
            while((line = br.readLine()) != null){
                splitLine = line.split("\t\t");
                telBooks.add((new PhoneData(splitLine[0],splitLine[1],splitLine[2])));
            }
        }


        while(true){
            System.out.print("1.입력 2.검색 3.삭제 4.출력 5.종료");
            int num = sc.nextInt();
            // 1. 입력
            if(num == 1){
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("전화번호 : ");
                String tel = sc.next();
                System.out.print("주소 : ");
                String address = sc.next();
                FileWriter fw;
                //나 지금 arrayList 값이 없어
                if(telBooks.size() == 0){
                    //만들고 덮어쓰기
                    fw = new FileWriter("D:\\PhoneTest\\phone.txt",false);
                    //ArrayList
                    telBooks.add(new PhoneData("이름","전화번호","주소"));
                    telBooks.add(new PhoneData(name,tel,address));
                    //파일
                    String head = "이름"+"\t\t"+"전화번호"+"\t\t"+"주소"+"\r\n";
                    fw.write(head);
                    String str = name+"\t\t"+tel+"\t\t"+address+"\r\n";
                    fw.write(str);
                    fw.close();
                }
                else{
                    //이어쓰기
                    fw = new FileWriter("D:\\PhoneTest\\phone.txt",true);
                    telBooks.add(new PhoneData(name,tel,address));
                    String str = name+"\t\t"+tel+"\t\t"+address+"\r\n";
                    fw.write(str);
                    fw.close();
                }
            }
            // 2. 검색
            else if(num == 2){
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for(i = 1;i< telBooks.size();i++){
                    if(telBooks.get(i).name.equals(name)){
                        System.out.println(telBooks.get(i));
                    }
                }
                if((i + 1) == telBooks.size()){
                    System.out.println("찾는 이름이 없습니다.");
                }
            }
            // 3. 삭제
            else if(num == 3){
                // 대전제
                // 파일을 써진다음에는 다시 올릴 수 없어요.
                // 홍길동 010 인천시
                // 호랑이 020 서울시
                System.out.print("이름 : ");
                String name = sc.next();
                int i;
                for(i = 0;i< telBooks.size();i++){
                    if(telBooks.get(i).name.equals(name)){
                        telBooks.remove(i);
                    }
                }
                if((i+1) == telBooks.size()){
                    System.out.println("삭제할 이름이 없습니다.");
                }
                else{
                    FileWriter fw = new FileWriter("D:\\PhoneTest\\phone.txt",false);
                    for(int j = 0;j< telBooks.size();j++){
                        String str = telBooks.get(j).name+"\t\t"+telBooks.get(j).tel+"\t\t"+telBooks.get(j).address+"\r\n";
                        fw.write(str);
                    }
                    fw.close();
                }
            }
            // 4. 출력
            else if(num == 4){
                for(int i = 1;i< telBooks.size();i++){
                    System.out.println(telBooks.get(i));
                }
            }
            // 5. 종료
            else if(num == 5){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }

    }

}
