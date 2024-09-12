import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.time.Duration;


public class TestCRm {

    public static void main(String[] args) throws InterruptedException{
          WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("http://crm-dash/login");

        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("j8L3pc5hJ20Sjn10Lp!");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        driver.get("http://crm-dash/credit-cards");

        driver.findElement(By.className("phpdebugbar-close-btn")).click();

        // driver.findElement(By.cssSelector(".fa-plus-circle")).click();

        // driver.findElement(By.id("create_name")).sendKeys("21.226.116.124:4444");
        
        // driver.findElement(By.id("create_username")).sendKeys("ProxyAutoUsername");

        // driver.findElement(By.id("create_password")).sendKeys("ProxyAutoPass");

        // WebElement select = driver.findElement(By.cssSelector("label[for='create_proxy_types'] ~ select[name='proxy_type']"));
        // Select type = new Select(select);
        // type.selectByValue("Residential");

        // WebElement source = driver.findElement(By.cssSelector("input[data-modal-field-id='create_source_id']"));
        // Thread.sleep(4000);
        // source.sendKeys("ip");
        // driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
        // driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        // driver.findElement(By.id("create-accounts-proxy-button")).click();


        // driver.navigate().refresh();

        // driver.findElement(By.xpath("//td[text()='21.226.116.124:4444']//preceding-sibling::td//input[@class='form-check-input']")).click();

        // Thread.sleep(2000);

        // driver.findElement(By.cssSelector(".fa-trash-alt")).click();

        // driver.findElement(By.cssSelector(".swal2-confirm")).click();


driver.findElement(By.cssSelector(".fa-table")).click();

driver.findElement(By.id("setting-name")).sendKeys("ProxyAutoTableSetting");

SettingsHelper settingsHelper = new SettingsHelper(driver);

        // Selectează multiple valori
        String[] valuesToSelect = { "Owner", "Updated At", "Created At" };
        settingsHelper.selectMultipleValuesByValue(valuesToSelect);

        // Apasă pe butonul de navigare
        settingsHelper.clickNavigationButton("fa fa-arrow-circle-right");

        // Mută elementele
        settingsHelper.selectMultipleValuesByValue(new String[]{ "Mediabuyers" });
        settingsHelper.moveElements("fa fa-arrow-circle-up", 4);

        // Mută alte elemente
        settingsHelper.selectMultipleValuesByValue(new String[]{ "Source" });
        settingsHelper.moveElements("fa fa-arrow-circle-up", 4);

    }
}


