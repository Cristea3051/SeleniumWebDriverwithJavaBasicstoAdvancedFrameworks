import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ScrollPerform {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum =0;
        for (int i=0; i<values.size(); i++){
            // Aici scot valorile ca text stirng
            // Convertesc din string in integer
           System.out.println(Integer.parseInt(values.get(i).getText()));
        //    Adun intre ele pentru a suma
           sum = sum + Integer.parseInt(values.get(i).getText());

        }

        /* Extrag numarul prin split la text din momentul unde sunt ":" si fac trim la spatiul dinaintea numarului
         Transform in integer */
       int total =  Integer.parseInt(driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim());

       Assert.assertEquals(sum, total);
    }
}
