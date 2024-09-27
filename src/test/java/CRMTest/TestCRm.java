import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCRm {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("http://crm-dash/login");

        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("Morris22##");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        driver.get("http://crm-dash/google-accounts");

        SettingsHelper settingsHelper = new SettingsHelper(driver);

        int[] indicesToSelect = {3, 5, 6, 4, 7};
        settingsHelper.selectMultipleValuesByIndex(indicesToSelect);
        settingsHelper.clickNavigationButton("fa fa-arrow-circle-right");
        
        settingsHelper.selectMultipleValuesByIndex(new int[] {10, 11});
        settingsHelper.moveElements("fa fa-arrow-circle-up", 7);

    }
}

