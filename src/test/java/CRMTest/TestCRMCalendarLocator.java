package CRMTest;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCRMCalendarLocator {
    public static void main(String[] args) throws InterruptedException {

        // Declaram driverul
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("http://crm-dash/login");

        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("j8L3pc5hJ20Sjn10Lp!");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        System.out.println(driver.findElement(By.cssSelector("span.d-sm-inline-block")).getText());

        driver.get("http://crm-dash/google-accounts");

        Thread.sleep(5000);


        driver.findElement(By.cssSelector("button.btn-dual:nth-child(5)")).click();

        Thread.sleep(5000); 

        driver.findElement(By.cssSelector("input.form-control.js-maxlength[name='id_verification'][data-modal-field-id='create_id_verification']")).click();

        // List<WebElement> IdVerificationDateElements = driver.findElements(
        //         By.cssSelector("div.flatpickr-calendar:nth-child(29) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span"));

            
        driver.findElement(By.cssSelector("div.flatpickr-calendar:nth-child(29) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(7)")).click();
      
        driver.findElement(By.name("input.form-control.js-maxlength[name='2fa'][data-modal-field-id='create_2fa']")).click();

        driver.quit();

    }
}
