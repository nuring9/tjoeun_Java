import java.sql.Connection;      // DB 연결을 표현하는 객체 타입
import java.sql.DriverManager;   // DB에 실제로 접속하게 해주는 유틸 클래스

// DB 연결만 담당하는 유틸리티 클래스
public class DBUtil {

    // DB 접속에 사용할 공통 설정값들 (상수)
    private static final String URL =
            // 어떤 DB에 접속할지: DBMS(mysql) / 서버주소(localhost) / 포트(3306) / DB이름(dbtest)
            "jdbc:mysql://localhost:3306/dbtest" +
                    // 부가 옵션: SSL 사용X, 타임존 설정, 키 관련 옵션
                    "?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";

    private static final String USER = "root";   // DB 접속 계정
    private static final String PASSWORD = "1234"; // DB 접속 비밀번호

    // 다른 클래스에서 호출해서 DB Connection 객체를 얻는 메서드
    public static Connection getConnection() throws Exception {
        // DriverManager를 통해 URL, USER, PASSWORD 로 실제 DB 연결 생성
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
