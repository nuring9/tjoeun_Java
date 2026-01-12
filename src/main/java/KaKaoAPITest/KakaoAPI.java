package KaKaoAPITest;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.net.URLEncoder;

import java.util.Properties;

public class KakaoAPI {

    public static double[] getAddressCoordinate(String address) throws IOException {
        // API 실행을 위한 URL
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        //주소를 utf- 인코딩
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        // 주소 + ?(파라미터)query = 입력한 주소 //최종 url
        // 예) https://dapi.kakao.com/v2/local/search/address.json?query=강남
        String requestUrl = apiUrl + "?query=" + encodedAddress;
        // Client에서 응답을 편하게 받기위해서 사용하는 HttpClients Apache 의존성 추가
        // HttpClients.createDefault 디폴트 객체를 생성 -> CloseableHttpClient httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // Httpget get Http 위에 requestUrl 매개변수로 객체를 생성
        HttpGet httpGet = new HttpGet(requestUrl);
        //Httpget header 추가 인증
        httpGet.setHeader("Authorization", "KakaoAK " + Config.get("KAKAO_API_KEY"));
        // httpClient ->execute(실행 -> httpGet) ======> kakao server
        // 응듭 - >CloseableHttpResponse response
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            //응답에서 Entity를 추출해서 EntityUtils를 이용해서 문자열로 변경 한 값을
            // responseBody
            String responseBody = EntityUtils.toString(response.getEntity());
            //Gson 객체 생성
            Gson gson = new Gson();
            // 결과 온 Body -> JSON 객체로 변경
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            // documents -> Array
            JsonArray documents = jsonObject.getAsJsonArray("documents");
            //documents 사이즈가 0보다 크면 실행
            if (documents.size() > 0) {
                // document에서 0번째 인덱스 객체를 추출
                JsonObject document = documents.get(0).getAsJsonObject();
                // 추출된 객체서 키가 'y' 인 값을 실수 변경해서 latitude 대입
                double latitude = document.get("y").getAsDouble();
                // 추출된 객체서 키가 'x' 인 값을 실수 변경해서 latitude 대입
                double longitude = document.get("x").getAsDouble();
                // 실수 배열을 생성해서 위에 있는 double 변수를 대입해서 return
                return new double[]{latitude, longitude};
            } else {
                // null 리턴
                return null;
            }
        }
    }
}

