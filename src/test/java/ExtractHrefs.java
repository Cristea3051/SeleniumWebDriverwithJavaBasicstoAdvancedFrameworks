import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ExtractHrefs {
    public static void main(String[] args)throws InterruptedException {
        // Inițializare WebDriver
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://crm-dash/login");

        Thread.sleep(2000);
        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");
        driver.findElement(By.id("login-password")).sendKeys("Morris22##");
        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        // Așteaptă ca pagina să se încarce (opțional, poți folosi WebDriverWait)
            Thread.sleep(5000); // Așteptare simplă; pentru aplicații reale, folosește WebDriverWait
            driver.findElement(By.cssSelector("i.fa-ellipsis-v")).click();
        // Găsește lista de elemente ancoră în ul.nav-main-item
        List<WebElement> anchorElements = driver.findElements(By.cssSelector("ul.nav-main a"));

        // Lista pentru a sa lva href-urile
        List<String> hrefList = new ArrayList<>();

        // Iterează prin fiecare element și extrage href-ul
        for (WebElement anchor : anchorElements) {
            String href = anchor.getAttribute("href");
            hrefList.add(href);
        }

        // Afișează href-urile extrase
        for (String href : hrefList) {
            System.out.println(href);
        }
    }
}

