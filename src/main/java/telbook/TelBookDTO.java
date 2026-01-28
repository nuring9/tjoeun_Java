package telbook; // telbook 패키지

// 전화번호 1건을 담는 객체 (DTO = Data Transfer Object)
public class TelBookDTO {

    public String name;     // 이름
    public String phone;    // 전화번호
    public String address;  // 주소
    public int age;         // 나이

    // 생성자: 입력받은 값들을 객체에 저장
    public TelBookDTO(String name, String phone, String address, int age) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }
}
