import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AutoSugestDropdownTheme {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("ro");
        Thread.sleep(4000);
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Romania")) {
                option.click();
                break;
            }

        }
    }
}
