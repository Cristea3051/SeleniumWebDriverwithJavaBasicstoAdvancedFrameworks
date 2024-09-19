import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class MultipleWindows {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles(); /*toate ide-urile ale taburilor sunt setate aici */
        
        Iterator<String> id = windows.iterator();
        String tab1 = id.next();
        String tab2 = id.next();
        driver.switchTo().window(tab2);

        String getTextTab2 = driver.findElement(By.cssSelector("h3")).getText();
        driver.switchTo().window(tab1);

        String getTextTab1 = driver.findElement(By.cssSelector("h3")).getText();

        System.out.println(getTextTab2 + " ---text from tab 2   " + getTextTab1 + " ---text from tab 1");

    }
}
