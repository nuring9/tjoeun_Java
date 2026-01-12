package APITest;

import com.google.gson.Gson;

public class GsonToJson {
    static void main(String[] args) {
        Member mvc = new Member("홍길동", 30, "bit@empas.com");
        Gson gson = new Gson();  // 구글이 만든 gson 가져오기
        String json = gson.toJson(mvc);  // json 형식으로 바꿈.
        System.out.println(json);
        Member member = gson.fromJson(json, Member.class); // 다시 객체로 바꿈. 한번에 객체를 만듦
        System.out.println(member);
    }
}
