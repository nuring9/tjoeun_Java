package APITest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

public class BookAPICall {
    static void main() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("책 제목을 입력 : ");
        String bname = sc.next();

        String query = URLEncoder.encode(bname); // 쿼리로 바꿈 -> 한글 인코딩 해줘야 함.
        String apiUrl = "https://dapi.kakao.com/v3/search/book?query=" + query; // book 뒤에 ?queery= 를 넣어줌. queery=자바

        URL url = new URL(apiUrl);  // URL 객체 생석, 웹에서 동작 시켜야 하니까.
        HttpURLConnection con = (HttpURLConnection) url.openConnection();  //  카카오 서버랑 커넥션
        con.setRequestMethod("GET"); // 통신 방식 설정, GET SET 등등
        con.setRequestProperty("Authorization", "KakaoAK " + "KAKAO_API_KEY"); // 인증 방법 설정 "KaKaoAK " 한칸 띄우기, 마지막에 REST API 키 넣기

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); // 받기
        // 라인별 읽을 수 있게 BufferedReader 사용.

        String inputLine;
        StringBuilder content = new StringBuilder(); // string에 null 오류 신경안씀

        while ((inputLine = in.readLine()) != null) { //  한줄 씩 데이터가 없을 때까지 반복, 한줄씩 끊어서 inputLine에 대입.
            content.append(inputLine);
        }  // StirngBuilder에 내용 추가

        in.close(); // 닫기. 통신은 closw 필수
        System.out.println(content.toString()); // toString 출력


        Gson gson = new Gson();
        //  { } 객체,  [] 배열
        // Gson을 이용하여 JsonObject 제이슨 객체로 바꿔 줌 -> 그래야 데이터 파싱할 수 있다.
        JsonObject jsonObject = gson.fromJson(content.toString(), JsonObject.class);
        System.out.println(jsonObject);

        JsonArray jsonArray = jsonObject.getAsJsonArray("documents");
        // documents안에 배열이 있으니까 ->  JsonArray로 빼준다.
        System.out.println(jsonArray);

        ArrayList<Book> books = new ArrayList<>();
        // JsonArray로 나온 데이터를 ArrayList <Book>에 담아주는 작업 시작.

        // 배열을 forEeach문으로 반복, 데이터가 없을 때까지.
        // {"authors":["김기수"],"contents":"이 책은 코딩... ,{"authors":["고현민"],"contents":"이 책은 코딩
        for (JsonElement je : jsonArray) {
            // JsonElement -> JsonObject로 변경
            JsonObject jo = je.getAsJsonObject();
            String title = "";
            String authors = "";
            String publisher = "";
            String thumbnail = "";
            int count = 0;  // for문이 새로 시작할때마다 0으로 초기화.
            if (jo.get("title") != null) {
                title = jo.get("title").getAsString();
                count++;
            }
            if (jo.get("authors") != null) {
                // 배열로 값 추출 -> ["김기수"]
                JsonArray jsonArray1 = jo.get("authors").getAsJsonArray();
                authors = "";
                // 값이 없을때까지 배열을 반복
                // ["김기수","고현민"] -> 김기수고현민
                for (JsonElement e : jsonArray1) {
                    authors += e.getAsString();
                }
                count++;
            }

            // publisher='길벗' 인데 publisher에 길벗이 들어감.

            if (jo.get("publisher") != null) {
                publisher = jo.get("publisher").getAsString();
                count++;
            }

            if (jo.get("thumbnail") != null) {
                // 썸네일 주소 그대로 thumbnail에 넣음.
                thumbnail = jo.get("thumbnail").getAsString();
                count++;
            }

            // count가 4면 데이터가 모두 들어가 있는 형태

            if (count == 4) {
                // 데이터가 모두 들어갔으면 Book 객체 생성 후
                Book b = new Book(title, authors, publisher, thumbnail);
                books.add(b); // ArrayList books에 추가
            }
        }

        // 출력
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
