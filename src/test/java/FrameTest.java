import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        /* Deci aici este mecanismul de drag and drop in frame.
         * 1. Localizam frameul si il stocam intr-o variabila
         * 2. Facem switch in acest frame. 
         * 3. Localizam id-ul cu elementul cu care vrem sa facem drag & drop
         * 4. Setam actionul 
         * 5. Stocam elementele cu care vreau sa fac drag si in care vreau sa fac drop
         * 6. Setez metoda prin care trebuie sa se faca drag & drop
         */

        WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));

        driver.switchTo().frame(frame);
        driver.findElement(By.id("draggable"));
        Actions drag = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        drag.dragAndDrop(source, target).build().perform();
    }
}
