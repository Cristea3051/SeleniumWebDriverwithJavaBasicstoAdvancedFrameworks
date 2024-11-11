import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

    public static void main(String[] args) throws IOException {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Obține toate link-urile de testat
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert ass = new SoftAssert();

        for (WebElement link : links) {
            String urlString = link.getAttribute("href");
            
            try {
                // Creează un URI și apoi convertește-l în URL
                URI uri = URI.create(urlString);
                URL url = uri.toURL();

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code for URL: " + url + " ----- and name: " + link.getText() + " is " + responseCode);
                
                ass.assertTrue(responseCode < 400, "The link with URL " + url + " is broken with response code: " + responseCode);
                
            } catch (Exception e) {
                System.out.println("Error with URL: " + urlString + " - " + e.getMessage());
            }
        }

        // Test pentru un link specific cu atributul 'href' care conține 'brokenlink'
        String brokenLinkUrlString = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        try {
            URI brokenLinkUri = URI.create(brokenLinkUrlString);
            URL brokenLinkUrl = brokenLinkUri.toURL();

            HttpURLConnection conn = (HttpURLConnection) brokenLinkUrl.openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();

            System.out.println("Response code for broken link URL: " + brokenLinkUrl + " is " + responseCode);
            
        } catch (Exception e) {
            System.out.println("Error with broken link URL: " + brokenLinkUrlString + " - " + e.getMessage());
        }

        driver.quit(); // Oprește driverul după rulare
        ass.assertAll(); // Rapoartează toate aserțiile
    }
}