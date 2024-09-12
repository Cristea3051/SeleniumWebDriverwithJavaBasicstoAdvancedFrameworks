import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

    public static void main(String[] args) {
        
            // Declaram driverul
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i=0; i<products.size(); i++){
            String prodName = products.get(i).getText();

            if(prodName.contains("Cucumber")){
            
                // Click on add to cart 
                driver.findElement(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }

    }
}
