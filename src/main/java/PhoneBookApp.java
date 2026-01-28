// 프로그램 시작점: 여기서 main으로 실행하면서 DAO 메서드들을 호출해봄
public class PhoneBookApp {
    public static void main(String[] args) throws Exception {

        // DAO 객체 생성 → 이 객체를 통해 DB 작업 수행
        PhoneBookDAO dao = new PhoneBookDAO();

        // ====== Create: 데이터 2건 추가 ======
        dao.insert("홍길동", "010-1111-2222");  // 홍길동 데이터 추가
        dao.insert("김철수", "010-2222-3333");  // 김철수 데이터 추가

        // ====== Read: 전체 조회 ======
        System.out.println("=== 전체 조회 ===");
        dao.selectAll();   // 지금까지 저장된 전체 데이터 출력

        // ====== Update: 홍길동 번호 변경 ======
        dao.update("홍길동", "010-9999-9999");  // 홍길동 전화번호 변경

        System.out.println("=== 수정 후 조회 ===");
        dao.selectAll();   // 수정 내용 반영됐는지 다시 조회

        // ====== Delete: 김철수 삭제 ======
        dao.delete("김철수");  // 김철수 데이터 삭제

        System.out.println("=== 삭제 후 조회 ===");
        dao.selectAll();   // 최종 데이터 상태 확인

        dao.insert("이순신", "010-4444-5555");  // 이순신 데이터 추가
        dao.selectAll();
    }
}
