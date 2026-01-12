package AutoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoTest1 {
    static void main() throws InterruptedException {
        String url = "https://www.daum.net/";
        //현재 pc에 있는 chromedriver를 가지고와서 setup
        WebDriverManager.chromedriver().setup();

        //selenium->
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //웹페이지 열기
        driver.get(url);
        //1초간 정지
        Thread.sleep(1000);
        //driver를 이용해서 관련된 태그 추출
        //findElement 메소드를 사용 매개변수 By. id /css /tag /
        WebElement input = driver.findElement(By.cssSelector("input.tf_keyword"));

        input.sendKeys("이");
        Thread.sleep(500);
        input.sendKeys("병");
        Thread.sleep(500);
        input.sendKeys("헌");
        Thread.sleep(500);
        input.sendKeys(" ");
        Thread.sleep(500);
        input.sendKeys("건");
        Thread.sleep(500);
        input.sendKeys("치");
        Thread.sleep(500);

        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> thumbs = driver.findElements(By.cssSelector("a.thumb_bf"));
        thumbs.get(0).click();

    }
}
