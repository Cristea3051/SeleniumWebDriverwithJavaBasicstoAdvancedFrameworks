import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        Actions handle = new Actions(driver);

        handle.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();

    }
}
