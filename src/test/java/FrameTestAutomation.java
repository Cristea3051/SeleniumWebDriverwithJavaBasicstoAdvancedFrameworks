import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTestAutomation {


     public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

         WebElement frameTop = driver.findElement(By.cssSelector("*[name='frame-top']"));

         driver.switchTo().frame(frameTop);

         WebElement frameMidle = driver.findElement(By.cssSelector("*[name='frame-middle']"));

         driver.switchTo().frame(frameMidle);

         String text = driver.findElement(By.id("content")).getText();

         System.out.println(text);



     }
}
