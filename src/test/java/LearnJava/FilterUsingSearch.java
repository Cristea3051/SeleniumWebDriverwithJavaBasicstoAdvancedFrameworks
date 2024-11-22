package LearnJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterUsingSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); 
        try {
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

            // Căutăm elementele și afișăm direct rezultatele
            driver.findElement(By.id("search-field")).sendKeys("b");

            // Așteptăm ca elementele să fie vizibile
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='products-wrapper']//table//tr//td[1]")))

                // Procesăm și afișăm textul din fiecare element găsit
                .forEach(s -> System.out.println(s.getText()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); 
        }
    }
}