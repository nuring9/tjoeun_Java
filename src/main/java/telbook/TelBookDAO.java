package telbook; // telbook 패키지

import java.sql.*; // Connection, PreparedStatement, ResultSet 등 JDBC 전부

// 전화번호부 DB 작업 전담 클래스 (DAO)
public class TelBookDAO {

    // ================== CREATE (추가) ==================
    public void insert(TelBookDTO dto) throws Exception {

        // ? 는 값이 들어갈 자리 (PreparedStatement 문법)
        String sql =
                "INSERT INTO telbook(name, phone, address, age) VALUES (?, ?, ?, ?)";

        // try-with-resources: 사용 후 자동 close
        try (Connection conn = TelDBUtil.getConnection();           // DB 연결
             PreparedStatement ps = conn.prepareStatement(sql)) {  // SQL 준비

            ps.setString(1, dto.name);     // 첫 번째 ? → 이름
            ps.setString(2, dto.phone);    // 두 번째 ? → 전화번호
            ps.setString(3, dto.address);  // 세 번째 ? → 주소
            ps.setInt(4, dto.age);         // 네 번째 ? → 나이

            ps.executeUpdate(); // INSERT 실행
        }
    }

    // ================== READ (전체 조회) ==================
    public void findAll() throws Exception {

        String sql = "SELECT name, phone, address, age FROM telbook";

        try (Connection conn = TelDBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { // SELECT 실행 결과

            // 결과 행이 있는 동안 반복
            while (rs.next()) {
                System.out.println(
                        "이름: " + rs.getString("name") +
                                ", 전화번호: " + rs.getString("phone") +
                                ", 주소: " + rs.getString("address") +
                                ", 나이: " + rs.getInt("age") + "세"
                );
            }
        }
    }

    // ================== READ (이름 검색) ==================
    public void findByName(String name) throws Exception {

        String sql =
                "SELECT name, phone, address, age FROM telbook WHERE name=?";

        try (Connection conn = TelDBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);      // WHERE name = ?
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // 데이터가 있으면
                System.out.println(
                        "이름: " + rs.getString("name") +
                                ", 전화번호: " + rs.getString("phone") +
                                ", 주소: " + rs.getString("address") +
                                ", 나이: " + rs.getInt("age") + "세"
                );
            } else { // 없으면
                System.out.println(name + " 은(는) 존재하지 않습니다.");
            }
        }
    }

    // ================== DELETE (삭제) ==================
    public void delete(String name) throws Exception {

        String sql = "DELETE FROM telbook WHERE name=?";

        try (Connection conn = TelDBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);           // 삭제할 이름
            int result = ps.executeUpdate(); // 삭제된 행 수

            if (result == 0)
                System.out.println(name + " 없음");
            else
                System.out.println(name + " 삭제 완료");
        }
    }
}
