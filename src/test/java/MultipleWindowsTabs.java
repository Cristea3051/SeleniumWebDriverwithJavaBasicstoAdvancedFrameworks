import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTabs {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/");

        WebElement element = driver.findElement(By.id("elementId"));

        // Creează un obiect JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Derulează până la element
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        driver.get("https://rahulshettyacademy.com/angularpractice/");

    }
}
