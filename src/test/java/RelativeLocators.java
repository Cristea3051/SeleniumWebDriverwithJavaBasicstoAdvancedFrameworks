import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Locate with above
        WebElement nameEditbox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());

        // Locate with below
        WebElement dateBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateBirth)).click();

        // Locate with to left
        WebElement elecmentLeft = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(elecmentLeft)).click();
        
          // Locate with to right
          WebElement elecmentRight = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
          driver.findElement(with(By.tagName("input")).toRightOf(elecmentRight)).click();

        // driver.quit();

    }
}
