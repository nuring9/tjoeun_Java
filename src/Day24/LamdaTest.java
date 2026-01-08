package Day24;

import java.util.ArrayList;
import java.util.List;

public class LamdaTest {
    static void main() {
        List<String> names = new ArrayList<>();
        names.add("김철수");
        names.add("홍길동");
        names.add("타이거");

        // 람다식을 사용한 간단한 예시
        // forEach for문 향상된 for문
        // List forEach 전체 반목을 한단.
        // 반복을 하는데 List 안에 있는 값을
        // name에게 줌. 변수
        // 메소드 정의
        names.forEach(name -> System.out.println("Helle, " + name));
    }
}
