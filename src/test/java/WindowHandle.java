import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class WindowHandle {

    public static void main(String[] args) throws InterruptedException {
                WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); /*toate ide-urile ale taburilor sunt setate aici */
        
        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];

        System.out.println(email);

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(email);


    }
}
