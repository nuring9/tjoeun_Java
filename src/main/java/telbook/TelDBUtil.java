package telbook; // 이 파일이 telbook 패키지 소속임을 선언

import java.sql.Connection;      // DB 연결 객체
import java.sql.DriverManager;   // 실제 DB 연결을 생성하는 클래스

// 새 전화번호부 전용 DB 연결 클래스
public class TelDBUtil {

    // 접속할 DB 주소 + 옵션
    private static final String URL =
            "jdbc:mysql://localhost:3306/telbook_db" + // 새 DB
                    "?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";

    private static final String USER = "root";     // DB 계정
    private static final String PASSWORD = "1234"; // DB 비밀번호

    // DAO에서 호출해서 Connection 객체를 얻는 메서드
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
