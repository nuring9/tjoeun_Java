import java.sql.*;  // Connection, PreparedStatement, ResultSet 등 JDBC 관련 클래스 한 번에 import

// PhoneBook(전화번호부)에 대한 DB 작업만 모아 둔 클래스 (DAO = Data Access Object)
public class PhoneBookDAO {

    // ===================== Create (INSERT) =====================
    // 새 연락처를 phonebook 테이블에 추가하는 메서드
    public void insert(String name, String phone) throws Exception {
        // ?를 사용해서 나중에 값만 바인딩하는 SQL (PreparedStatement 사용)
        String sql = "INSERT INTO phonebook(name, phone) VALUES (?, ?)";

        // try-with-resources 문법: 괄호 안의 자원은 자동으로 close() 됨
        try (Connection conn = DBUtil.getConnection();      // DB 연결 얻기
             PreparedStatement ps = conn.prepareStatement(sql)) { // SQL 준비

            ps.setString(1, name);   // 첫 번째 ? 자리에 name 값 세팅
            ps.setString(2, phone);  // 두 번째 ? 자리에 phone 값 세팅
            ps.executeUpdate();      // INSERT, UPDATE, DELETE 같은 변경 쿼리 실행
        } // 여기 나오면 conn, ps 자동으로 닫힘
        catch (SQLIntegrityConstraintViolationException e) {
            //  UNIQUE 제약 위반: 이미 같은 이름이 DB에 존재하는 경우
            System.out.println("이미 존재하는 이름입니다: " + name);
        }  // 중복된 이름이면 여기 출력
    }

    // ===================== Read (SELECT) =====================
    // phonebook 테이블의 모든 데이터를 조회해서 콘솔에 출력하는 메서드
    public void selectAll() throws Exception {
        String sql = "SELECT id, name, phone FROM phonebook"; // 전체 조회 SQL

        // SELECT는 결과를 ResultSet으로 받기 때문에 ResultSet도 try-with-resources에 포함
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {  // SELECT 실행 → 결과 집합(ResultSet) 반환

            // rs.next() : 다음 행(row)이 있으면 true, 없으면 false
            while (rs.next()) {
                // 컬럼 이름으로 값 꺼내기: id(int), name(String), phone(String)
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("phone")
                );
            }
        } // conn, ps, rs 모두 자동 close
    }

    // ===================== Update (수정) =====================
    // name 기준으로 phone 번호를 수정하는 메서드
    public void update(String name, String phone) throws Exception {
        // 특정 사람(name)의 전화번호(phone)를 바꾸는 SQL
        String sql = "UPDATE phonebook SET phone=? WHERE name=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);  // 바꿀 전화번호
            ps.setString(2, name);   // 어떤 사람의 번호를 바꿀지 기준
            ps.executeUpdate();      // UPDATE 실행
        }
    }

    // ===================== Delete (삭제) =====================
    // name 기준으로 해당 사람의 데이터를 삭제하는 메서드
    public void delete(String name) throws Exception {
        String sql = "DELETE FROM phonebook WHERE name=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);   // 삭제할 대상 이름
            ps.executeUpdate();      // DELETE 실행
        }
    }
}
