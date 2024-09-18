import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        Actions handle = new Actions(driver);

        // Metoda pentru a deschide un dropdown on hover
        WebElement move = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        handle.moveToElement(move).build().perform();

        handle.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello kitty").build().perform();

    }
}
