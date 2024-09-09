import java.time.Duration;

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

        driver.get("http://crm-dash/google-dashboard/sc-campaigns");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("i.fa-calendar:nth-of-type(1)")).click();

        driver.findElement(By.xpath("//div[@style='display: block; top: 222.594px; left: auto; right: 0px;'] //li[@data-range-key='All Time']")).click();   

       WebElement staticDropdown =  driver.findElement(By.xpath("//div[@id='sc-campaigns-list_length'] //select[@name='sc-campaigns-list_length']"));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByIndex(0);

            driver.findElement(By.xpath("(//button[@class='btn-block-option'] //i[@class='si si-arrow-up'])[4]")).click();
        }
       }



