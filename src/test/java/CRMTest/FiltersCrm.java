package CRMTest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiltersCrm {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

            driver.get("http://crm-dash/login");

            Thread.sleep(2000); 
            driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");
    
            driver.findElement(By.id("login-password")).sendKeys("Morris22##");
    
            driver.findElement(By.cssSelector("button.btn-alt-primary")).click();
            // Navighează la pagina cu filtrul
            driver.get("http://crm-dash/google-accounts");

            // Așteaptă ca filtrul să fie vizibil
            Thread.sleep(2000); 

            driver.findElement(By.cssSelector("div.google-accounts-list-filter-title")).click();
            Thread.sleep(2000); 
            driver.findElement(By.cssSelector("div[data-collapse='AccountOwner']")).click();
            Thread.sleep(2000); 
        

            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='users.name']"));
            Thread.sleep(2000); 

            System.out.println(checkboxes.size());
            Thread.sleep(2000); 
            // Iterează prin fiecare checkbox
            for (int i = 1; i <= checkboxes.size(); i++) {
                // Găsește label-ul asociat pentru fiecare checkbox
                WebElement label = driver.findElement(By.xpath("//input[@name='users.name']/following-sibling::label[\" + i + \"]"));
                label.click(); 
            }
        } 
            
    }
