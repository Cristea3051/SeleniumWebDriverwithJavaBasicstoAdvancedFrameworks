import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginpagePractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("(//span[@class='radiotextsty'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-success")));

        driver.findElement(By.cssSelector("button.btn-success")).click();

        WebElement role = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(role);
        dropdown.selectByValue("consult");

        driver.findElement(By.cssSelector("span.termsText")).click();

        driver.findElement(By.name("signin")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-primary")));

        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

        for (int i = 0; i < products.size(); i++)

        {

            products.get(i).click();

        }
        driver.findElement(By.cssSelector("a.btn-primary")).click();
    }

}
