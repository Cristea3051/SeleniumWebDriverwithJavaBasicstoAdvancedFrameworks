import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));

        driver.switchTo().frame(frame);
        driver.findElement(By.id("draggable"));

        Actions drag = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        drag.dragAndDrop(source, target).build().perform();
    }
}
