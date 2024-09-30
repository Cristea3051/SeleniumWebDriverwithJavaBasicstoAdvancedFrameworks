import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        WebDriver driver = new ChromeDriver();

        // Broken URL 
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Face print la statutul curent al paginii care este acesata
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();

        System.out.println(responseCode);
    }
}
