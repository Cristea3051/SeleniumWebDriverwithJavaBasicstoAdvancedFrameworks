import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCRMCalendarLocator {
public static void main(String[] args) {

        // Declaram driverul
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("http://crm-dash/login");


        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("j8L3pc5hJ20Sjn10Lp!");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        System.out.println(driver.findElement(By.cssSelector("span.d-sm-inline-block")).getText() + " Te-ai logat crasiva!");

        driver.get("http://crm-dash/google-dashboard/sc-campaigns");

        driver.findElement(By.cssSelector("i.fa-calendar")).click();

       driver.findElement(By.xpath("(//li[@data-range-key='All Time'])[3]")).click();   

       driver.findElement(By.name("sc-campaigns-list_length")).click();

       WebElement activeElement = driver.switchTo().activeElement();
            
            int numberOfArrowUps = 8 - 1; 

            for (int i = 0; i < numberOfArrowUps; i++) {
                activeElement.sendKeys(Keys.ARROW_UP);
            }
            activeElement.sendKeys(Keys.ENTER);
}

}


