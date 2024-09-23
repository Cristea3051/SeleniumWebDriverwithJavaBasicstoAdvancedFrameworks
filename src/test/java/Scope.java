import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Print the links count on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); /* Limit webdriver to element footer */

        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // Count first column links

        WebElement columnFooterDriver =  footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        System.out.println(columnFooterDriver.findElements(By.tagName("a")).size());

          // Click on each link in the column and chech if pages are opening

          for (int i=1; i<columnFooterDriver.findElements(By.tagName("a")).size(); i++){

            String clickToOpenNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            
            columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickToOpenNewTab);
          }

    }
}
