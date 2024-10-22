import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        WebDriver driver = new ChromeDriver();

        // Broken URL 
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert ass = new SoftAssert();

        for (WebElement link : links) {
            // Extrage URL-ul din atributul "href" al fiecărui link
            String url = link.getAttribute("href");
        
            // Creează o conexiune HTTP către acel URL
            HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
        
            // Obține codul de răspuns HTTP
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code for URL: " + url + " ----- and name: " +  link.getText()  +" is " + responseCode);
            // Verifică dacă răspunsul HTTP este de eroare (cod > 400)
            ass.assertTrue(responseCode < 400, "The link with URL " + url + " is broken with response code: " + responseCode);
        }

        // Face print la statutul curent al paginii care este acesata
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();

        System.out.println(responseCode);
    }
}
